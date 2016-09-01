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
import com.bydan.erp.inventario.util.GrupoBodegaConstantesFunciones;
import com.bydan.erp.inventario.util.GrupoBodegaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.GrupoBodegaParameterGeneral;
import com.bydan.erp.inventario.business.entity.GrupoBodega;
import com.bydan.erp.inventario.business.logic.GrupoBodegaLogicAdditional;
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
public class GrupoBodegaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GrupoBodegaLogic.class);
	
	protected GrupoBodegaDataAccess grupobodegaDataAccess; 	
	protected GrupoBodega grupobodega;
	protected List<GrupoBodega> grupobodegas;
	protected Object grupobodegaObject;	
	protected List<Object> grupobodegasObject;
	
	public static ClassValidator<GrupoBodega> grupobodegaValidator = new ClassValidator<GrupoBodega>(GrupoBodega.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected GrupoBodegaLogicAdditional grupobodegaLogicAdditional=null;
	
	public GrupoBodegaLogicAdditional getGrupoBodegaLogicAdditional() {
		return this.grupobodegaLogicAdditional;
	}
	
	public void setGrupoBodegaLogicAdditional(GrupoBodegaLogicAdditional grupobodegaLogicAdditional) {
		try {
			this.grupobodegaLogicAdditional=grupobodegaLogicAdditional;
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
	
	
	
	
	public  GrupoBodegaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.grupobodegaDataAccess = new GrupoBodegaDataAccess();
			
			this.grupobodegas= new ArrayList<GrupoBodega>();
			this.grupobodega= new GrupoBodega();
			
			this.grupobodegaObject=new Object();
			this.grupobodegasObject=new ArrayList<Object>();
				
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
			
			this.grupobodegaDataAccess.setConnexionType(this.connexionType);
			this.grupobodegaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GrupoBodegaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.grupobodegaDataAccess = new GrupoBodegaDataAccess();
			this.grupobodegas= new ArrayList<GrupoBodega>();
			this.grupobodega= new GrupoBodega();
			this.grupobodegaObject=new Object();
			this.grupobodegasObject=new ArrayList<Object>();
			
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
			
			this.grupobodegaDataAccess.setConnexionType(this.connexionType);
			this.grupobodegaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GrupoBodega getGrupoBodega() throws Exception {	
		GrupoBodegaLogicAdditional.checkGrupoBodegaToGet(grupobodega,this.datosCliente,this.arrDatoGeneral);
		GrupoBodegaLogicAdditional.updateGrupoBodegaToGet(grupobodega,this.arrDatoGeneral);
		
		return grupobodega;
	}
		
	public void setGrupoBodega(GrupoBodega newGrupoBodega) {
		this.grupobodega = newGrupoBodega;
	}
	
	public GrupoBodegaDataAccess getGrupoBodegaDataAccess() {
		return grupobodegaDataAccess;
	}
	
	public void setGrupoBodegaDataAccess(GrupoBodegaDataAccess newgrupobodegaDataAccess) {
		this.grupobodegaDataAccess = newgrupobodegaDataAccess;
	}
	
	public List<GrupoBodega> getGrupoBodegas() throws Exception {		
		this.quitarGrupoBodegasNulos();
		
		GrupoBodegaLogicAdditional.checkGrupoBodegaToGets(grupobodegas,this.datosCliente,this.arrDatoGeneral);
		
		for (GrupoBodega grupobodegaLocal: grupobodegas ) {
			GrupoBodegaLogicAdditional.updateGrupoBodegaToGet(grupobodegaLocal,this.arrDatoGeneral);
		}
		
		return grupobodegas;
	}
	
	public void setGrupoBodegas(List<GrupoBodega> newGrupoBodegas) {
		this.grupobodegas = newGrupoBodegas;
	}
	
	public Object getGrupoBodegaObject() {	
		this.grupobodegaObject=this.grupobodegaDataAccess.getEntityObject();
		return this.grupobodegaObject;
	}
		
	public void setGrupoBodegaObject(Object newGrupoBodegaObject) {
		this.grupobodegaObject = newGrupoBodegaObject;
	}
	
	public List<Object> getGrupoBodegasObject() {		
		this.grupobodegasObject=this.grupobodegaDataAccess.getEntitiesObject();
		return this.grupobodegasObject;
	}
		
	public void setGrupoBodegasObject(List<Object> newGrupoBodegasObject) {
		this.grupobodegasObject = newGrupoBodegasObject;
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
		
		if(this.grupobodegaDataAccess!=null) {
			this.grupobodegaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			grupobodegaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			grupobodegaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		grupobodega = new  GrupoBodega();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupobodega=grupobodegaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupobodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodega);
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
		grupobodega = new  GrupoBodega();
		  		  
        try {
			
			grupobodega=grupobodegaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupobodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodega);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		grupobodega = new  GrupoBodega();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupobodega=grupobodegaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupobodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodega);
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
		grupobodega = new  GrupoBodega();
		  		  
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
		grupobodega = new  GrupoBodega();
		  		  
        try {
			
			grupobodega=grupobodegaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupobodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodega);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		grupobodega = new  GrupoBodega();
		  		  
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
		grupobodega = new  GrupoBodega();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =grupobodegaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupobodega = new  GrupoBodega();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=grupobodegaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupobodega = new  GrupoBodega();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =grupobodegaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupobodega = new  GrupoBodega();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=grupobodegaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupobodega = new  GrupoBodega();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =grupobodegaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupobodega = new  GrupoBodega();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=grupobodegaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupobodegas = new  ArrayList<GrupoBodega>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodegas=grupobodegaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoBodega(grupobodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
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
		grupobodegas = new  ArrayList<GrupoBodega>();
		  		  
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
		grupobodegas = new  ArrayList<GrupoBodega>();
		  		  
        try {			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodegas=grupobodegaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGrupoBodega(grupobodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		grupobodegas = new  ArrayList<GrupoBodega>();
		  		  
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
		grupobodegas = new  ArrayList<GrupoBodega>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodegas=grupobodegaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoBodega(grupobodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
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
		grupobodegas = new  ArrayList<GrupoBodega>();
		  		  
        try {
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodegas=grupobodegaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoBodega(grupobodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
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
		grupobodegas = new  ArrayList<GrupoBodega>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodegas=grupobodegaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoBodega(grupobodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
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
		grupobodegas = new  ArrayList<GrupoBodega>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodegas=grupobodegaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoBodega(grupobodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		grupobodega = new  GrupoBodega();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodega=grupobodegaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoBodega(grupobodega);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodega);
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
		grupobodega = new  GrupoBodega();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodega=grupobodegaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoBodega(grupobodega);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodega);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupobodegas = new  ArrayList<GrupoBodega>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodegas=grupobodegaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoBodega(grupobodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
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
		grupobodegas = new  ArrayList<GrupoBodega>();
		  		  
        try {
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodegas=grupobodegaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoBodega(grupobodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosGrupoBodegasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		grupobodegas = new  ArrayList<GrupoBodega>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getTodosGrupoBodegasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoBodega(grupobodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
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
	
	public  void  getTodosGrupoBodegas(String sFinalQuery,Pagination pagination)throws Exception {
		grupobodegas = new  ArrayList<GrupoBodega>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoBodega(grupobodegas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGrupoBodega(GrupoBodega grupobodega) throws Exception {
		Boolean estaValidado=false;
		
		if(grupobodega.getIsNew() || grupobodega.getIsChanged()) { 
			this.invalidValues = grupobodegaValidator.getInvalidValues(grupobodega);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(grupobodega);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGrupoBodega(List<GrupoBodega> GrupoBodegas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GrupoBodega grupobodegaLocal:grupobodegas) {				
			estaValidadoObjeto=this.validarGuardarGrupoBodega(grupobodegaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGrupoBodega(List<GrupoBodega> GrupoBodegas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoBodega(grupobodegas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGrupoBodega(GrupoBodega GrupoBodega) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoBodega(grupobodega)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GrupoBodega grupobodega) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+grupobodega.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GrupoBodegaConstantesFunciones.getGrupoBodegaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"grupobodega","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GrupoBodegaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GrupoBodegaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGrupoBodegaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-saveGrupoBodegaWithConnection");connexion.begin();			
			
			GrupoBodegaLogicAdditional.checkGrupoBodegaToSave(this.grupobodega,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GrupoBodegaLogicAdditional.updateGrupoBodegaToSave(this.grupobodega,this.arrDatoGeneral);
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupobodega,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGrupoBodega();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoBodega(this.grupobodega)) {
				GrupoBodegaDataAccess.save(this.grupobodega, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.grupobodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GrupoBodegaLogicAdditional.checkGrupoBodegaToSaveAfter(this.grupobodega,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoBodega();
			
			connexion.commit();			
			
			if(this.grupobodega.getIsDeleted()) {
				this.grupobodega=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGrupoBodega()throws Exception {	
		try {	
			
			GrupoBodegaLogicAdditional.checkGrupoBodegaToSave(this.grupobodega,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GrupoBodegaLogicAdditional.updateGrupoBodegaToSave(this.grupobodega,this.arrDatoGeneral);
			
			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupobodega,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoBodega(this.grupobodega)) {			
				GrupoBodegaDataAccess.save(this.grupobodega, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.grupobodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GrupoBodegaLogicAdditional.checkGrupoBodegaToSaveAfter(this.grupobodega,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.grupobodega.getIsDeleted()) {
				this.grupobodega=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGrupoBodegasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-saveGrupoBodegasWithConnection");connexion.begin();			
			
			GrupoBodegaLogicAdditional.checkGrupoBodegaToSaves(grupobodegas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGrupoBodegas();
			
			Boolean validadoTodosGrupoBodega=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoBodega grupobodegaLocal:grupobodegas) {		
				if(grupobodegaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GrupoBodegaLogicAdditional.updateGrupoBodegaToSave(grupobodegaLocal,this.arrDatoGeneral);
	        	
				GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupobodegaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoBodega(grupobodegaLocal)) {
					GrupoBodegaDataAccess.save(grupobodegaLocal, connexion);				
				} else {
					validadoTodosGrupoBodega=false;
				}
			}
			
			if(!validadoTodosGrupoBodega) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GrupoBodegaLogicAdditional.checkGrupoBodegaToSavesAfter(grupobodegas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoBodegas();
			
			connexion.commit();		
			
			this.quitarGrupoBodegasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGrupoBodegas()throws Exception {				
		 try {	
			GrupoBodegaLogicAdditional.checkGrupoBodegaToSaves(grupobodegas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGrupoBodega=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoBodega grupobodegaLocal:grupobodegas) {				
				if(grupobodegaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GrupoBodegaLogicAdditional.updateGrupoBodegaToSave(grupobodegaLocal,this.arrDatoGeneral);
	        	
				GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupobodegaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoBodega(grupobodegaLocal)) {				
					GrupoBodegaDataAccess.save(grupobodegaLocal, connexion);				
				} else {
					validadoTodosGrupoBodega=false;
				}
			}
			
			if(!validadoTodosGrupoBodega) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GrupoBodegaLogicAdditional.checkGrupoBodegaToSavesAfter(grupobodegas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGrupoBodegasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoBodegaParameterReturnGeneral procesarAccionGrupoBodegas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoBodega> grupobodegas,GrupoBodegaParameterReturnGeneral grupobodegaParameterGeneral)throws Exception {
		 try {	
			GrupoBodegaParameterReturnGeneral grupobodegaReturnGeneral=new GrupoBodegaParameterReturnGeneral();
	
			GrupoBodegaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,grupobodegas,grupobodegaParameterGeneral,grupobodegaReturnGeneral);
			
			return grupobodegaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoBodegaParameterReturnGeneral procesarAccionGrupoBodegasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoBodega> grupobodegas,GrupoBodegaParameterReturnGeneral grupobodegaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-procesarAccionGrupoBodegasWithConnection");connexion.begin();			
			
			GrupoBodegaParameterReturnGeneral grupobodegaReturnGeneral=new GrupoBodegaParameterReturnGeneral();
	
			GrupoBodegaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,grupobodegas,grupobodegaParameterGeneral,grupobodegaReturnGeneral);
			
			this.connexion.commit();
			
			return grupobodegaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoBodegaParameterReturnGeneral procesarEventosGrupoBodegas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoBodega> grupobodegas,GrupoBodega grupobodega,GrupoBodegaParameterReturnGeneral grupobodegaParameterGeneral,Boolean isEsNuevoGrupoBodega,ArrayList<Classe> clases)throws Exception {
		 try {	
			GrupoBodegaParameterReturnGeneral grupobodegaReturnGeneral=new GrupoBodegaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupobodegaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GrupoBodegaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,grupobodegas,grupobodega,grupobodegaParameterGeneral,grupobodegaReturnGeneral,isEsNuevoGrupoBodega,clases);
			
			return grupobodegaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GrupoBodegaParameterReturnGeneral procesarEventosGrupoBodegasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoBodega> grupobodegas,GrupoBodega grupobodega,GrupoBodegaParameterReturnGeneral grupobodegaParameterGeneral,Boolean isEsNuevoGrupoBodega,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-procesarEventosGrupoBodegasWithConnection");connexion.begin();			
			
			GrupoBodegaParameterReturnGeneral grupobodegaReturnGeneral=new GrupoBodegaParameterReturnGeneral();
	
			grupobodegaReturnGeneral.setGrupoBodega(grupobodega);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupobodegaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GrupoBodegaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,grupobodegas,grupobodega,grupobodegaParameterGeneral,grupobodegaReturnGeneral,isEsNuevoGrupoBodega,clases);
			
			this.connexion.commit();
			
			return grupobodegaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoBodegaParameterReturnGeneral procesarImportacionGrupoBodegasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GrupoBodegaParameterReturnGeneral grupobodegaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-procesarImportacionGrupoBodegasWithConnection");connexion.begin();			
			
			GrupoBodegaParameterReturnGeneral grupobodegaReturnGeneral=new GrupoBodegaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.grupobodegas=new ArrayList<GrupoBodega>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.grupobodega=new GrupoBodega();
				
				
				if(conColumnasBase) {this.grupobodega.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.grupobodega.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.grupobodega.setcodigo(arrColumnas[iColumn++]);
				this.grupobodega.setnombre(arrColumnas[iColumn++]);
				this.grupobodega.setruc(arrColumnas[iColumn++]);
			this.grupobodega.setdireccion(arrColumnas[iColumn++]);
				this.grupobodega.settelefono(arrColumnas[iColumn++]);
			this.grupobodega.setdescripcion(arrColumnas[iColumn++]);
				
				this.grupobodegas.add(this.grupobodega);
			}
			
			this.saveGrupoBodegas();
			
			this.connexion.commit();
			
			grupobodegaReturnGeneral.setConRetornoEstaProcesado(true);
			grupobodegaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return grupobodegaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGrupoBodegasEliminados() throws Exception {				
		
		List<GrupoBodega> grupobodegasAux= new ArrayList<GrupoBodega>();
		
		for(GrupoBodega grupobodega:grupobodegas) {
			if(!grupobodega.getIsDeleted()) {
				grupobodegasAux.add(grupobodega);
			}
		}
		
		grupobodegas=grupobodegasAux;
	}
	
	public void quitarGrupoBodegasNulos() throws Exception {				
		
		List<GrupoBodega> grupobodegasAux= new ArrayList<GrupoBodega>();
		
		for(GrupoBodega grupobodega : this.grupobodegas) {
			if(grupobodega==null) {
				grupobodegasAux.add(grupobodega);
			}
		}
		
		//this.grupobodegas=grupobodegasAux;
		
		this.grupobodegas.removeAll(grupobodegasAux);
	}
	
	public void getSetVersionRowGrupoBodegaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(grupobodega.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((grupobodega.getIsDeleted() || (grupobodega.getIsChanged()&&!grupobodega.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=grupobodegaDataAccess.getSetVersionRowGrupoBodega(connexion,grupobodega.getId());
				
				if(!grupobodega.getVersionRow().equals(timestamp)) {	
					grupobodega.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				grupobodega.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGrupoBodega()throws Exception {	
		
		if(grupobodega.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((grupobodega.getIsDeleted() || (grupobodega.getIsChanged()&&!grupobodega.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=grupobodegaDataAccess.getSetVersionRowGrupoBodega(connexion,grupobodega.getId());
			
			try {							
				if(!grupobodega.getVersionRow().equals(timestamp)) {	
					grupobodega.setVersionRow(timestamp);
				}
				
				grupobodega.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGrupoBodegasWithConnection()throws Exception {	
		if(grupobodegas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GrupoBodega grupobodegaAux:grupobodegas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(grupobodegaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupobodegaAux.getIsDeleted() || (grupobodegaAux.getIsChanged()&&!grupobodegaAux.getIsNew())) {
						
						timestamp=grupobodegaDataAccess.getSetVersionRowGrupoBodega(connexion,grupobodegaAux.getId());
						
						if(!grupobodega.getVersionRow().equals(timestamp)) {	
							grupobodegaAux.setVersionRow(timestamp);
						}
								
						grupobodegaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGrupoBodegas()throws Exception {	
		if(grupobodegas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GrupoBodega grupobodegaAux:grupobodegas) {
					if(grupobodegaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupobodegaAux.getIsDeleted() || (grupobodegaAux.getIsChanged()&&!grupobodegaAux.getIsNew())) {
						
						timestamp=grupobodegaDataAccess.getSetVersionRowGrupoBodega(connexion,grupobodegaAux.getId());
						
						if(!grupobodegaAux.getVersionRow().equals(timestamp)) {	
							grupobodegaAux.setVersionRow(timestamp);
						}
						
													
						grupobodegaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GrupoBodegaParameterReturnGeneral cargarCombosLoteForeignKeyGrupoBodegaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalCentroCosto,String finalQueryGlobalEmpleado,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableCosto,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalCuentaContableProduccion,String finalQueryGlobalCuentaContableBonifica,String finalQueryGlobalCuentaContableCostoBonifica) throws Exception {
		GrupoBodegaParameterReturnGeneral  grupobodegaReturnGeneral =new GrupoBodegaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-cargarCombosLoteForeignKeyGrupoBodegaWithConnection");connexion.begin();
			
			grupobodegaReturnGeneral =new GrupoBodegaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			grupobodegaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			grupobodegaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			grupobodegaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			grupobodegaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			grupobodegaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<CuentaContable> cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableproduccionLogic=new CuentaContableLogic();
			cuentacontableproduccionLogic.setConnexion(this.connexion);
			cuentacontableproduccionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableProduccion.equals("NONE")) {
				cuentacontableproduccionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableProduccion,new Pagination());
				cuentacontableproduccionsForeignKey=cuentacontableproduccionLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontableproduccionsForeignKey(cuentacontableproduccionsForeignKey);


			List<CuentaContable> cuentacontablebonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablebonificaLogic=new CuentaContableLogic();
			cuentacontablebonificaLogic.setConnexion(this.connexion);
			cuentacontablebonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableBonifica.equals("NONE")) {
				cuentacontablebonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableBonifica,new Pagination());
				cuentacontablebonificasForeignKey=cuentacontablebonificaLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontablebonificasForeignKey(cuentacontablebonificasForeignKey);


			List<CuentaContable> cuentacontablecostobonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostobonificaLogic=new CuentaContableLogic();
			cuentacontablecostobonificaLogic.setConnexion(this.connexion);
			cuentacontablecostobonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoBonifica.equals("NONE")) {
				cuentacontablecostobonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoBonifica,new Pagination());
				cuentacontablecostobonificasForeignKey=cuentacontablecostobonificaLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontablecostobonificasForeignKey(cuentacontablecostobonificasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return grupobodegaReturnGeneral;
	}
	
	public GrupoBodegaParameterReturnGeneral cargarCombosLoteForeignKeyGrupoBodega(String finalQueryGlobalEmpresa,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalCentroCosto,String finalQueryGlobalEmpleado,String finalQueryGlobalCuentaContableInventario,String finalQueryGlobalCuentaContableCosto,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito,String finalQueryGlobalCuentaContableProduccion,String finalQueryGlobalCuentaContableBonifica,String finalQueryGlobalCuentaContableCostoBonifica) throws Exception {
		GrupoBodegaParameterReturnGeneral  grupobodegaReturnGeneral =new GrupoBodegaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			grupobodegaReturnGeneral =new GrupoBodegaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			grupobodegaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			grupobodegaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			grupobodegaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			grupobodegaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			grupobodegaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<CuentaContable> cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableinventarioLogic=new CuentaContableLogic();
			cuentacontableinventarioLogic.setConnexion(this.connexion);
			cuentacontableinventarioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableInventario.equals("NONE")) {
				cuentacontableinventarioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableInventario,new Pagination());
				cuentacontableinventariosForeignKey=cuentacontableinventarioLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontableinventariosForeignKey(cuentacontableinventariosForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);


			List<CuentaContable> cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableproduccionLogic=new CuentaContableLogic();
			cuentacontableproduccionLogic.setConnexion(this.connexion);
			cuentacontableproduccionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableProduccion.equals("NONE")) {
				cuentacontableproduccionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableProduccion,new Pagination());
				cuentacontableproduccionsForeignKey=cuentacontableproduccionLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontableproduccionsForeignKey(cuentacontableproduccionsForeignKey);


			List<CuentaContable> cuentacontablebonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablebonificaLogic=new CuentaContableLogic();
			cuentacontablebonificaLogic.setConnexion(this.connexion);
			cuentacontablebonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableBonifica.equals("NONE")) {
				cuentacontablebonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableBonifica,new Pagination());
				cuentacontablebonificasForeignKey=cuentacontablebonificaLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontablebonificasForeignKey(cuentacontablebonificasForeignKey);


			List<CuentaContable> cuentacontablecostobonificasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostobonificaLogic=new CuentaContableLogic();
			cuentacontablecostobonificaLogic.setConnexion(this.connexion);
			cuentacontablecostobonificaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCostoBonifica.equals("NONE")) {
				cuentacontablecostobonificaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCostoBonifica,new Pagination());
				cuentacontablecostobonificasForeignKey=cuentacontablecostobonificaLogic.getCuentaContables();
			}

			grupobodegaReturnGeneral.setcuentacontablecostobonificasForeignKey(cuentacontablecostobonificasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return grupobodegaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyGrupoBodegaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			BodegaLogic bodegaLogic=new BodegaLogic();
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic=new ParametroInventarioDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyGrupoBodegaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Bodega.class));
			classes.add(new Classe(ParametroInventarioDefecto.class));
											
			

			bodegaLogic.setConnexion(this.getConnexion());
			bodegaLogic.setDatosCliente(this.datosCliente);
			bodegaLogic.setIsConRefrescarForeignKeys(true);

			parametroinventariodefectoLogic.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic.setDatosCliente(this.datosCliente);
			parametroinventariodefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(GrupoBodega grupobodega:this.grupobodegas) {
				

				classes=new ArrayList<Classe>();
				classes=BodegaConstantesFunciones.getClassesForeignKeysOfBodega(new ArrayList<Classe>(),DeepLoadType.NONE);

				bodegaLogic.setBodegas(grupobodega.bodegas);
				bodegaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroinventariodefectoLogic.setParametroInventarioDefectos(grupobodega.parametroinventariodefectos);
				parametroinventariodefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(GrupoBodega grupobodega,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GrupoBodegaLogicAdditional.updateGrupoBodegaToGet(grupobodega,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupobodega.setEmpresa(grupobodegaDataAccess.getEmpresa(connexion,grupobodega));
		grupobodega.setPais(grupobodegaDataAccess.getPais(connexion,grupobodega));
		grupobodega.setCiudad(grupobodegaDataAccess.getCiudad(connexion,grupobodega));
		grupobodega.setCentroCosto(grupobodegaDataAccess.getCentroCosto(connexion,grupobodega));
		grupobodega.setEmpleado(grupobodegaDataAccess.getEmpleado(connexion,grupobodega));
		grupobodega.setCuentaContableInventario(grupobodegaDataAccess.getCuentaContableInventario(connexion,grupobodega));
		grupobodega.setCuentaContableCosto(grupobodegaDataAccess.getCuentaContableCosto(connexion,grupobodega));
		grupobodega.setCuentaContableVenta(grupobodegaDataAccess.getCuentaContableVenta(connexion,grupobodega));
		grupobodega.setCuentaContableDescuento(grupobodegaDataAccess.getCuentaContableDescuento(connexion,grupobodega));
		grupobodega.setCuentaContableDevolucion(grupobodegaDataAccess.getCuentaContableDevolucion(connexion,grupobodega));
		grupobodega.setCuentaContableDebito(grupobodegaDataAccess.getCuentaContableDebito(connexion,grupobodega));
		grupobodega.setCuentaContableCredito(grupobodegaDataAccess.getCuentaContableCredito(connexion,grupobodega));
		grupobodega.setCuentaContableProduccion(grupobodegaDataAccess.getCuentaContableProduccion(connexion,grupobodega));
		grupobodega.setCuentaContableBonifica(grupobodegaDataAccess.getCuentaContableBonifica(connexion,grupobodega));
		grupobodega.setCuentaContableCostoBonifica(grupobodegaDataAccess.getCuentaContableCostoBonifica(connexion,grupobodega));
		grupobodega.setBodegas(grupobodegaDataAccess.getBodegas(connexion,grupobodega));
		grupobodega.setParametroInventarioDefectos(grupobodegaDataAccess.getParametroInventarioDefectos(connexion,grupobodega));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				grupobodega.setEmpresa(grupobodegaDataAccess.getEmpresa(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				grupobodega.setPais(grupobodegaDataAccess.getPais(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				grupobodega.setCiudad(grupobodegaDataAccess.getCiudad(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				grupobodega.setCentroCosto(grupobodegaDataAccess.getCentroCosto(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				grupobodega.setEmpleado(grupobodegaDataAccess.getEmpleado(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableInventario(grupobodegaDataAccess.getCuentaContableInventario(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableCosto(grupobodegaDataAccess.getCuentaContableCosto(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableVenta(grupobodegaDataAccess.getCuentaContableVenta(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableDescuento(grupobodegaDataAccess.getCuentaContableDescuento(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableDevolucion(grupobodegaDataAccess.getCuentaContableDevolucion(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableDebito(grupobodegaDataAccess.getCuentaContableDebito(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableCredito(grupobodegaDataAccess.getCuentaContableCredito(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableProduccion(grupobodegaDataAccess.getCuentaContableProduccion(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableBonifica(grupobodegaDataAccess.getCuentaContableBonifica(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableCostoBonifica(grupobodegaDataAccess.getCuentaContableCostoBonifica(connexion,grupobodega));
				continue;
			}

			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupobodega.setBodegas(grupobodegaDataAccess.getBodegas(connexion,grupobodega));

				if(this.isConDeep) {
					BodegaLogic bodegaLogic= new BodegaLogic(this.connexion);
					bodegaLogic.setBodegas(grupobodega.getBodegas());
					ArrayList<Classe> classesLocal=BodegaConstantesFunciones.getClassesForeignKeysOfBodega(new ArrayList<Classe>(),DeepLoadType.NONE);
					bodegaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					BodegaConstantesFunciones.refrescarForeignKeysDescripcionesBodega(bodegaLogic.getBodegas());
					grupobodega.setBodegas(bodegaLogic.getBodegas());
				}

				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupobodega.setParametroInventarioDefectos(grupobodegaDataAccess.getParametroInventarioDefectos(connexion,grupobodega));

				if(this.isConDeep) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(this.connexion);
					parametroinventariodefectoLogic.setParametroInventarioDefectos(grupobodega.getParametroInventarioDefectos());
					ArrayList<Classe> classesLocal=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroinventariodefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectoLogic.getParametroInventarioDefectos());
					grupobodega.setParametroInventarioDefectos(parametroinventariodefectoLogic.getParametroInventarioDefectos());
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
			grupobodega.setEmpresa(grupobodegaDataAccess.getEmpresa(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setPais(grupobodegaDataAccess.getPais(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCiudad(grupobodegaDataAccess.getCiudad(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCentroCosto(grupobodegaDataAccess.getCentroCosto(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setEmpleado(grupobodegaDataAccess.getEmpleado(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableInventario(grupobodegaDataAccess.getCuentaContableInventario(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableCosto(grupobodegaDataAccess.getCuentaContableCosto(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableVenta(grupobodegaDataAccess.getCuentaContableVenta(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableDescuento(grupobodegaDataAccess.getCuentaContableDescuento(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableDevolucion(grupobodegaDataAccess.getCuentaContableDevolucion(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableDebito(grupobodegaDataAccess.getCuentaContableDebito(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableCredito(grupobodegaDataAccess.getCuentaContableCredito(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableProduccion(grupobodegaDataAccess.getCuentaContableProduccion(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableBonifica(grupobodegaDataAccess.getCuentaContableBonifica(connexion,grupobodega));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableCostoBonifica(grupobodegaDataAccess.getCuentaContableCostoBonifica(connexion,grupobodega));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Bodega.class));
			grupobodega.setBodegas(grupobodegaDataAccess.getBodegas(connexion,grupobodega));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			grupobodega.setParametroInventarioDefectos(grupobodegaDataAccess.getParametroInventarioDefectos(connexion,grupobodega));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupobodega.setEmpresa(grupobodegaDataAccess.getEmpresa(connexion,grupobodega));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(grupobodega.getEmpresa(),isDeep,deepLoadType,clases);
				
		grupobodega.setPais(grupobodegaDataAccess.getPais(connexion,grupobodega));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(grupobodega.getPais(),isDeep,deepLoadType,clases);
				
		grupobodega.setCiudad(grupobodegaDataAccess.getCiudad(connexion,grupobodega));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(grupobodega.getCiudad(),isDeep,deepLoadType,clases);
				
		grupobodega.setCentroCosto(grupobodegaDataAccess.getCentroCosto(connexion,grupobodega));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(grupobodega.getCentroCosto(),isDeep,deepLoadType,clases);
				
		grupobodega.setEmpleado(grupobodegaDataAccess.getEmpleado(connexion,grupobodega));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(grupobodega.getEmpleado(),isDeep,deepLoadType,clases);
				
		grupobodega.setCuentaContableInventario(grupobodegaDataAccess.getCuentaContableInventario(connexion,grupobodega));
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(grupobodega.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		grupobodega.setCuentaContableCosto(grupobodegaDataAccess.getCuentaContableCosto(connexion,grupobodega));
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(grupobodega.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		grupobodega.setCuentaContableVenta(grupobodegaDataAccess.getCuentaContableVenta(connexion,grupobodega));
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(grupobodega.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		grupobodega.setCuentaContableDescuento(grupobodegaDataAccess.getCuentaContableDescuento(connexion,grupobodega));
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(grupobodega.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		grupobodega.setCuentaContableDevolucion(grupobodegaDataAccess.getCuentaContableDevolucion(connexion,grupobodega));
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(grupobodega.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		grupobodega.setCuentaContableDebito(grupobodegaDataAccess.getCuentaContableDebito(connexion,grupobodega));
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(grupobodega.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		grupobodega.setCuentaContableCredito(grupobodegaDataAccess.getCuentaContableCredito(connexion,grupobodega));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(grupobodega.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		grupobodega.setCuentaContableProduccion(grupobodegaDataAccess.getCuentaContableProduccion(connexion,grupobodega));
		CuentaContableLogic cuentacontableproduccionLogic= new CuentaContableLogic(connexion);
		cuentacontableproduccionLogic.deepLoad(grupobodega.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				
		grupobodega.setCuentaContableBonifica(grupobodegaDataAccess.getCuentaContableBonifica(connexion,grupobodega));
		CuentaContableLogic cuentacontablebonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablebonificaLogic.deepLoad(grupobodega.getCuentaContableBonifica(),isDeep,deepLoadType,clases);
				
		grupobodega.setCuentaContableCostoBonifica(grupobodegaDataAccess.getCuentaContableCostoBonifica(connexion,grupobodega));
		CuentaContableLogic cuentacontablecostobonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostobonificaLogic.deepLoad(grupobodega.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);
				

		grupobodega.setBodegas(grupobodegaDataAccess.getBodegas(connexion,grupobodega));

		for(Bodega bodega:grupobodega.getBodegas()) {
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(bodega,isDeep,deepLoadType,clases);
		}

		grupobodega.setParametroInventarioDefectos(grupobodegaDataAccess.getParametroInventarioDefectos(connexion,grupobodega));

		for(ParametroInventarioDefecto parametroinventariodefecto:grupobodega.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				grupobodega.setEmpresa(grupobodegaDataAccess.getEmpresa(connexion,grupobodega));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(grupobodega.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				grupobodega.setPais(grupobodegaDataAccess.getPais(connexion,grupobodega));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(grupobodega.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				grupobodega.setCiudad(grupobodegaDataAccess.getCiudad(connexion,grupobodega));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(grupobodega.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				grupobodega.setCentroCosto(grupobodegaDataAccess.getCentroCosto(connexion,grupobodega));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(grupobodega.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				grupobodega.setEmpleado(grupobodegaDataAccess.getEmpleado(connexion,grupobodega));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(grupobodega.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableInventario(grupobodegaDataAccess.getCuentaContableInventario(connexion,grupobodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupobodega.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableCosto(grupobodegaDataAccess.getCuentaContableCosto(connexion,grupobodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupobodega.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableVenta(grupobodegaDataAccess.getCuentaContableVenta(connexion,grupobodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupobodega.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableDescuento(grupobodegaDataAccess.getCuentaContableDescuento(connexion,grupobodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupobodega.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableDevolucion(grupobodegaDataAccess.getCuentaContableDevolucion(connexion,grupobodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupobodega.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableDebito(grupobodegaDataAccess.getCuentaContableDebito(connexion,grupobodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupobodega.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableCredito(grupobodegaDataAccess.getCuentaContableCredito(connexion,grupobodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupobodega.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableProduccion(grupobodegaDataAccess.getCuentaContableProduccion(connexion,grupobodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupobodega.getCuentaContableProduccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableBonifica(grupobodegaDataAccess.getCuentaContableBonifica(connexion,grupobodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupobodega.getCuentaContableBonifica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				grupobodega.setCuentaContableCostoBonifica(grupobodegaDataAccess.getCuentaContableCostoBonifica(connexion,grupobodega));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(grupobodega.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupobodega.setBodegas(grupobodegaDataAccess.getBodegas(connexion,grupobodega));

				for(Bodega bodega:grupobodega.getBodegas()) {
					BodegaLogic bodegaLogic= new BodegaLogic(connexion);
					bodegaLogic.deepLoad(bodega,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupobodega.setParametroInventarioDefectos(grupobodegaDataAccess.getParametroInventarioDefectos(connexion,grupobodega));

				for(ParametroInventarioDefecto parametroinventariodefecto:grupobodega.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
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
			grupobodega.setEmpresa(grupobodegaDataAccess.getEmpresa(connexion,grupobodega));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(grupobodega.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setPais(grupobodegaDataAccess.getPais(connexion,grupobodega));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(grupobodega.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCiudad(grupobodegaDataAccess.getCiudad(connexion,grupobodega));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(grupobodega.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCentroCosto(grupobodegaDataAccess.getCentroCosto(connexion,grupobodega));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(grupobodega.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setEmpleado(grupobodegaDataAccess.getEmpleado(connexion,grupobodega));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(grupobodega.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableInventario(grupobodegaDataAccess.getCuentaContableInventario(connexion,grupobodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupobodega.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableCosto(grupobodegaDataAccess.getCuentaContableCosto(connexion,grupobodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupobodega.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableVenta(grupobodegaDataAccess.getCuentaContableVenta(connexion,grupobodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupobodega.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableDescuento(grupobodegaDataAccess.getCuentaContableDescuento(connexion,grupobodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupobodega.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableDevolucion(grupobodegaDataAccess.getCuentaContableDevolucion(connexion,grupobodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupobodega.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableDebito(grupobodegaDataAccess.getCuentaContableDebito(connexion,grupobodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupobodega.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableCredito(grupobodegaDataAccess.getCuentaContableCredito(connexion,grupobodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupobodega.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableProduccion(grupobodegaDataAccess.getCuentaContableProduccion(connexion,grupobodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupobodega.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableBonifica(grupobodegaDataAccess.getCuentaContableBonifica(connexion,grupobodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupobodega.getCuentaContableBonifica(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupobodega.setCuentaContableCostoBonifica(grupobodegaDataAccess.getCuentaContableCostoBonifica(connexion,grupobodega));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(grupobodega.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Bodega.class));
			grupobodega.setBodegas(grupobodegaDataAccess.getBodegas(connexion,grupobodega));

			for(Bodega bodega:grupobodega.getBodegas()) {
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(bodega,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			grupobodega.setParametroInventarioDefectos(grupobodegaDataAccess.getParametroInventarioDefectos(connexion,grupobodega));

			for(ParametroInventarioDefecto parametroinventariodefecto:grupobodega.getParametroInventarioDefectos()) {
				ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
				parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(GrupoBodega grupobodega,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			GrupoBodegaLogicAdditional.updateGrupoBodegaToSave(grupobodega,this.arrDatoGeneral);
			
GrupoBodegaDataAccess.save(grupobodega, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(grupobodega.getEmpresa(),connexion);

		PaisDataAccess.save(grupobodega.getPais(),connexion);

		CiudadDataAccess.save(grupobodega.getCiudad(),connexion);

		CentroCostoDataAccess.save(grupobodega.getCentroCosto(),connexion);

		EmpleadoDataAccess.save(grupobodega.getEmpleado(),connexion);

		CuentaContableDataAccess.save(grupobodega.getCuentaContableInventario(),connexion);

		CuentaContableDataAccess.save(grupobodega.getCuentaContableCosto(),connexion);

		CuentaContableDataAccess.save(grupobodega.getCuentaContableVenta(),connexion);

		CuentaContableDataAccess.save(grupobodega.getCuentaContableDescuento(),connexion);

		CuentaContableDataAccess.save(grupobodega.getCuentaContableDevolucion(),connexion);

		CuentaContableDataAccess.save(grupobodega.getCuentaContableDebito(),connexion);

		CuentaContableDataAccess.save(grupobodega.getCuentaContableCredito(),connexion);

		CuentaContableDataAccess.save(grupobodega.getCuentaContableProduccion(),connexion);

		CuentaContableDataAccess.save(grupobodega.getCuentaContableBonifica(),connexion);

		CuentaContableDataAccess.save(grupobodega.getCuentaContableCostoBonifica(),connexion);

		for(Bodega bodega:grupobodega.getBodegas()) {
			bodega.setid_grupo_bodega(grupobodega.getId());
			BodegaDataAccess.save(bodega,connexion);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:grupobodega.getParametroInventarioDefectos()) {
			parametroinventariodefecto.setid_grupo_bodega(grupobodega.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(grupobodega.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(grupobodega.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(grupobodega.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(grupobodega.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(grupobodega.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableInventario(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableDescuento(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableDevolucion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableProduccion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableBonifica(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableCostoBonifica(),connexion);
				continue;
			}


			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Bodega bodega:grupobodega.getBodegas()) {
					bodega.setid_grupo_bodega(grupobodega.getId());
					BodegaDataAccess.save(bodega,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:grupobodega.getParametroInventarioDefectos()) {
					parametroinventariodefecto.setid_grupo_bodega(grupobodega.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(grupobodega.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(grupobodega.getEmpresa(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(grupobodega.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(grupobodega.getPais(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(grupobodega.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(grupobodega.getCiudad(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(grupobodega.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(grupobodega.getCentroCosto(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(grupobodega.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(grupobodega.getEmpleado(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupobodega.getCuentaContableInventario(),connexion);
		CuentaContableLogic cuentacontableinventarioLogic= new CuentaContableLogic(connexion);
		cuentacontableinventarioLogic.deepLoad(grupobodega.getCuentaContableInventario(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupobodega.getCuentaContableCosto(),connexion);
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(grupobodega.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupobodega.getCuentaContableVenta(),connexion);
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(grupobodega.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupobodega.getCuentaContableDescuento(),connexion);
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(grupobodega.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupobodega.getCuentaContableDevolucion(),connexion);
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(grupobodega.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupobodega.getCuentaContableDebito(),connexion);
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(grupobodega.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupobodega.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(grupobodega.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupobodega.getCuentaContableProduccion(),connexion);
		CuentaContableLogic cuentacontableproduccionLogic= new CuentaContableLogic(connexion);
		cuentacontableproduccionLogic.deepLoad(grupobodega.getCuentaContableProduccion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupobodega.getCuentaContableBonifica(),connexion);
		CuentaContableLogic cuentacontablebonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablebonificaLogic.deepLoad(grupobodega.getCuentaContableBonifica(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(grupobodega.getCuentaContableCostoBonifica(),connexion);
		CuentaContableLogic cuentacontablecostobonificaLogic= new CuentaContableLogic(connexion);
		cuentacontablecostobonificaLogic.deepLoad(grupobodega.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);
				

		for(Bodega bodega:grupobodega.getBodegas()) {
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodega.setid_grupo_bodega(grupobodega.getId());
			BodegaDataAccess.save(bodega,connexion);
			bodegaLogic.deepSave(bodega,isDeep,deepLoadType,clases);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:grupobodega.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefecto.setid_grupo_bodega(grupobodega.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
			parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(grupobodega.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(grupobodega.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(grupobodega.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(grupobodega.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(grupobodega.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(grupobodega.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(grupobodega.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(grupobodega.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(grupobodega.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(grupobodega.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableInventario(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupobodega.getCuentaContableInventario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableCosto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupobodega.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupobodega.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableDescuento(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupobodega.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableDevolucion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupobodega.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupobodega.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupobodega.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableProduccion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupobodega.getCuentaContableProduccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableBonifica(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupobodega.getCuentaContableBonifica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(grupobodega.getCuentaContableCostoBonifica(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(grupobodega.getCuentaContableCostoBonifica(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Bodega.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Bodega bodega:grupobodega.getBodegas()) {
					BodegaLogic bodegaLogic= new BodegaLogic(connexion);
					bodega.setid_grupo_bodega(grupobodega.getId());
					BodegaDataAccess.save(bodega,connexion);
					bodegaLogic.deepSave(bodega,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:grupobodega.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefecto.setid_grupo_bodega(grupobodega.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
					parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(GrupoBodega.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(grupobodega,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(grupobodega);
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
			this.deepLoad(this.grupobodega,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodega);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GrupoBodega.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(grupobodegas!=null) {
				for(GrupoBodega grupobodega:grupobodegas) {
					this.deepLoad(grupobodega,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(grupobodegas);
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
			if(grupobodegas!=null) {
				for(GrupoBodega grupobodega:grupobodegas) {
					this.deepLoad(grupobodega,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(grupobodegas);
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
			this.getNewConnexionToDeep(GrupoBodega.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(grupobodega,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(GrupoBodega.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(grupobodegas!=null) {
				for(GrupoBodega grupobodega:grupobodegas) {
					this.deepSave(grupobodega,isDeep,deepLoadType,clases);
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
			if(grupobodegas!=null) {
				for(GrupoBodega grupobodega:grupobodegas) {
					this.deepSave(grupobodega,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getGrupoBodegasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",GrupoBodegaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",GrupoBodegaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",GrupoBodegaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",GrupoBodegaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasBusquedaPorRucWithConnection(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",GrupoBodegaConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasBusquedaPorRuc(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRuc= new ParameterSelectionGeneral();
			parameterSelectionGeneralRuc.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",GrupoBodegaConstantesFunciones.RUC,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRuc);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRuc","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasBusquedaPorTelefonoWithConnection(String sFinalQuery,Pagination pagination,String telefono)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefono= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefono.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono+"%",GrupoBodegaConstantesFunciones.TELEFONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefono);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefono","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasBusquedaPorTelefono(String sFinalQuery,Pagination pagination,String telefono)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralTelefono= new ParameterSelectionGeneral();
			parameterSelectionGeneralTelefono.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+telefono+"%",GrupoBodegaConstantesFunciones.TELEFONO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralTelefono);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTelefono","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,GrupoBodegaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,GrupoBodegaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,GrupoBodegaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,GrupoBodegaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableBonificaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_bonifica)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_bonifica,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableBonifica);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableBonifica(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_bonifica)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_bonifica,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableBonifica);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableCosto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableCostoBonificaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_bonifica)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_bonifica,GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoBonifica);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableCostoBonifica(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo_bonifica)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCostoBonifica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCostoBonifica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo_bonifica,GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCostoBonifica);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCostoBonifica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableDescuentoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableDescuento(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableDevolucionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableDevolucion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableInventarioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableInventario(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_inventario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableInventario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableInventario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_inventario,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableInventario);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableInventario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableProduccionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_produccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableProduccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableProduccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_produccion,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableProduccion);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableProduccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableProduccion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_produccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableProduccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableProduccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_produccion,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableProduccion);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableProduccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdCuentaContableVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,GrupoBodegaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,GrupoBodegaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoBodegaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoBodegaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,GrupoBodegaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,GrupoBodegaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			GrupoBodegaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodegas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoBodegaPorIdEmpresaPorNombreWithConnection(Long id_empresa,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoBodega.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoBodegaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,GrupoBodegaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			grupobodega=grupobodegaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.grupobodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodega);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoBodegaPorIdEmpresaPorNombre(Long id_empresa,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoBodegaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,GrupoBodegaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			grupobodega=grupobodegaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.grupobodega,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				GrupoBodegaConstantesFunciones.refrescarForeignKeysDescripcionesGrupoBodega(this.grupobodega);
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
			if(GrupoBodegaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoBodegaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GrupoBodega grupobodega,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GrupoBodegaConstantesFunciones.ISCONAUDITORIA) {
				if(grupobodega.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoBodegaDataAccess.TABLENAME, grupobodega.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoBodegaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GrupoBodegaLogic.registrarAuditoriaDetallesGrupoBodega(connexion,grupobodega,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(grupobodega.getIsDeleted()) {
					/*if(!grupobodega.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GrupoBodegaDataAccess.TABLENAME, grupobodega.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////GrupoBodegaLogic.registrarAuditoriaDetallesGrupoBodega(connexion,grupobodega,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoBodegaDataAccess.TABLENAME, grupobodega.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(grupobodega.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoBodegaDataAccess.TABLENAME, grupobodega.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoBodegaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GrupoBodegaLogic.registrarAuditoriaDetallesGrupoBodega(connexion,grupobodega,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGrupoBodega(Connexion connexion,GrupoBodega grupobodega)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(grupobodega.getIsNew()||!grupobodega.getid_empresa().equals(grupobodega.getGrupoBodegaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_empresa()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_empresa().toString();
				}
				if(grupobodega.getid_empresa()!=null)
				{
					strValorNuevo=grupobodega.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getcodigo().equals(grupobodega.getGrupoBodegaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getcodigo()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getcodigo();
				}
				if(grupobodega.getcodigo()!=null)
				{
					strValorNuevo=grupobodega.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getnombre().equals(grupobodega.getGrupoBodegaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getnombre()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getnombre();
				}
				if(grupobodega.getnombre()!=null)
				{
					strValorNuevo=grupobodega.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getruc().equals(grupobodega.getGrupoBodegaOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getruc()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getruc();
				}
				if(grupobodega.getruc()!=null)
				{
					strValorNuevo=grupobodega.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getdireccion().equals(grupobodega.getGrupoBodegaOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getdireccion()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getdireccion();
				}
				if(grupobodega.getdireccion()!=null)
				{
					strValorNuevo=grupobodega.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.gettelefono().equals(grupobodega.getGrupoBodegaOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().gettelefono()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().gettelefono();
				}
				if(grupobodega.gettelefono()!=null)
				{
					strValorNuevo=grupobodega.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_pais().equals(grupobodega.getGrupoBodegaOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_pais()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_pais().toString();
				}
				if(grupobodega.getid_pais()!=null)
				{
					strValorNuevo=grupobodega.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_ciudad().equals(grupobodega.getGrupoBodegaOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_ciudad()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_ciudad().toString();
				}
				if(grupobodega.getid_ciudad()!=null)
				{
					strValorNuevo=grupobodega.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_centro_costo().equals(grupobodega.getGrupoBodegaOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_centro_costo()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_centro_costo().toString();
				}
				if(grupobodega.getid_centro_costo()!=null)
				{
					strValorNuevo=grupobodega.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_empleado().equals(grupobodega.getGrupoBodegaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_empleado()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_empleado().toString();
				}
				if(grupobodega.getid_empleado()!=null)
				{
					strValorNuevo=grupobodega.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getdescripcion().equals(grupobodega.getGrupoBodegaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getdescripcion()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getdescripcion();
				}
				if(grupobodega.getdescripcion()!=null)
				{
					strValorNuevo=grupobodega.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_cuenta_contable_inventario().equals(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_inventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_inventario()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_inventario().toString();
				}
				if(grupobodega.getid_cuenta_contable_inventario()!=null)
				{
					strValorNuevo=grupobodega.getid_cuenta_contable_inventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_cuenta_contable_costo().equals(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_costo()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_costo().toString();
				}
				if(grupobodega.getid_cuenta_contable_costo()!=null)
				{
					strValorNuevo=grupobodega.getid_cuenta_contable_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_cuenta_contable_venta().equals(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_venta()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_venta().toString();
				}
				if(grupobodega.getid_cuenta_contable_venta()!=null)
				{
					strValorNuevo=grupobodega.getid_cuenta_contable_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_cuenta_contable_descuento().equals(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_descuento()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_descuento().toString();
				}
				if(grupobodega.getid_cuenta_contable_descuento()!=null)
				{
					strValorNuevo=grupobodega.getid_cuenta_contable_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_cuenta_contable_devolucion().equals(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_devolucion()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_devolucion().toString();
				}
				if(grupobodega.getid_cuenta_contable_devolucion()!=null)
				{
					strValorNuevo=grupobodega.getid_cuenta_contable_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_cuenta_contable_debito().equals(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_debito()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_debito().toString();
				}
				if(grupobodega.getid_cuenta_contable_debito()!=null)
				{
					strValorNuevo=grupobodega.getid_cuenta_contable_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_cuenta_contable_credito().equals(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_credito().toString();
				}
				if(grupobodega.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=grupobodega.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_cuenta_contable_produccion().equals(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_produccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_produccion()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_produccion().toString();
				}
				if(grupobodega.getid_cuenta_contable_produccion()!=null)
				{
					strValorNuevo=grupobodega.getid_cuenta_contable_produccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_cuenta_contable_bonifica().equals(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_bonifica()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_bonifica()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_bonifica().toString();
				}
				if(grupobodega.getid_cuenta_contable_bonifica()!=null)
				{
					strValorNuevo=grupobodega.getid_cuenta_contable_bonifica().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA,strValorActual,strValorNuevo);
			}	
			
			if(grupobodega.getIsNew()||!grupobodega.getid_cuenta_contable_costo_bonifica().equals(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_costo_bonifica()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_costo_bonifica()!=null)
				{
					strValorActual=grupobodega.getGrupoBodegaOriginal().getid_cuenta_contable_costo_bonifica().toString();
				}
				if(grupobodega.getid_cuenta_contable_costo_bonifica()!=null)
				{
					strValorNuevo=grupobodega.getid_cuenta_contable_costo_bonifica().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveGrupoBodegaRelacionesWithConnection(GrupoBodega grupobodega,List<Bodega> bodegas,List<ParametroInventarioDefecto> parametroinventariodefectos) throws Exception {

		if(!grupobodega.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGrupoBodegaRelacionesBase(grupobodega,bodegas,parametroinventariodefectos,true);
		}
	}

	public void saveGrupoBodegaRelaciones(GrupoBodega grupobodega,List<Bodega> bodegas,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {

		if(!grupobodega.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGrupoBodegaRelacionesBase(grupobodega,bodegas,parametroinventariodefectos,false);
		}
	}

	public void saveGrupoBodegaRelacionesBase(GrupoBodega grupobodega,List<Bodega> bodegas,List<ParametroInventarioDefecto> parametroinventariodefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("GrupoBodega-saveRelacionesWithConnection");}
	
			grupobodega.setBodegas(bodegas);
			grupobodega.setParametroInventarioDefectos(parametroinventariodefectos);

			this.setGrupoBodega(grupobodega);

			if(GrupoBodegaLogicAdditional.validarSaveRelaciones(grupobodega,this)) {

				GrupoBodegaLogicAdditional.updateRelacionesToSave(grupobodega,this);

				if((grupobodega.getIsNew()||grupobodega.getIsChanged())&&!grupobodega.getIsDeleted()) {
					this.saveGrupoBodega();
					this.saveGrupoBodegaRelacionesDetalles(bodegas,parametroinventariodefectos);

				} else if(grupobodega.getIsDeleted()) {
					this.saveGrupoBodegaRelacionesDetalles(bodegas,parametroinventariodefectos);
					this.saveGrupoBodega();
				}

				GrupoBodegaLogicAdditional.updateRelacionesToSaveAfter(grupobodega,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			BodegaConstantesFunciones.InicializarGeneralEntityAuxiliaresBodegas(bodegas,true,true);
			ParametroInventarioDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroInventarioDefectos(parametroinventariodefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveGrupoBodegaRelacionesDetalles(List<Bodega> bodegas,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {
		try {
	

			Long idGrupoBodegaActual=this.getGrupoBodega().getId();

			BodegaLogic bodegaLogic_Desde_GrupoBodega=new BodegaLogic();
			bodegaLogic_Desde_GrupoBodega.setBodegas(bodegas);

			bodegaLogic_Desde_GrupoBodega.setConnexion(this.getConnexion());
			bodegaLogic_Desde_GrupoBodega.setDatosCliente(this.datosCliente);

			for(Bodega bodega_Desde_GrupoBodega:bodegaLogic_Desde_GrupoBodega.getBodegas()) {
				bodega_Desde_GrupoBodega.setid_grupo_bodega(idGrupoBodegaActual);
			}

			bodegaLogic_Desde_GrupoBodega.saveBodegas();

			ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_GrupoBodega=new ParametroInventarioDefectoLogic();
			parametroinventariodefectoLogic_Desde_GrupoBodega.setParametroInventarioDefectos(parametroinventariodefectos);

			parametroinventariodefectoLogic_Desde_GrupoBodega.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic_Desde_GrupoBodega.setDatosCliente(this.datosCliente);

			for(ParametroInventarioDefecto parametroinventariodefecto_Desde_GrupoBodega:parametroinventariodefectoLogic_Desde_GrupoBodega.getParametroInventarioDefectos()) {
				parametroinventariodefecto_Desde_GrupoBodega.setid_grupo_bodega(idGrupoBodegaActual);
			}

			parametroinventariodefectoLogic_Desde_GrupoBodega.saveParametroInventarioDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoBodega(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoBodegaConstantesFunciones.getClassesForeignKeysOfGrupoBodega(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoBodega(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoBodegaConstantesFunciones.getClassesRelationshipsOfGrupoBodega(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
