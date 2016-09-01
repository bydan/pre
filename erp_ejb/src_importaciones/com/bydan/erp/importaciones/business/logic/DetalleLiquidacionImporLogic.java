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
import com.bydan.erp.importaciones.util.DetalleLiquidacionImporConstantesFunciones;
import com.bydan.erp.importaciones.util.DetalleLiquidacionImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.DetalleLiquidacionImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.DetalleLiquidacionImpor;
import com.bydan.erp.importaciones.business.logic.DetalleLiquidacionImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

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
public class DetalleLiquidacionImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleLiquidacionImporLogic.class);
	
	protected DetalleLiquidacionImporDataAccess detalleliquidacionimporDataAccess; 	
	protected DetalleLiquidacionImpor detalleliquidacionimpor;
	protected List<DetalleLiquidacionImpor> detalleliquidacionimpors;
	protected Object detalleliquidacionimporObject;	
	protected List<Object> detalleliquidacionimporsObject;
	
	public static ClassValidator<DetalleLiquidacionImpor> detalleliquidacionimporValidator = new ClassValidator<DetalleLiquidacionImpor>(DetalleLiquidacionImpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleLiquidacionImporLogicAdditional detalleliquidacionimporLogicAdditional=null;
	
	public DetalleLiquidacionImporLogicAdditional getDetalleLiquidacionImporLogicAdditional() {
		return this.detalleliquidacionimporLogicAdditional;
	}
	
	public void setDetalleLiquidacionImporLogicAdditional(DetalleLiquidacionImporLogicAdditional detalleliquidacionimporLogicAdditional) {
		try {
			this.detalleliquidacionimporLogicAdditional=detalleliquidacionimporLogicAdditional;
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
	
	
	
	
	public  DetalleLiquidacionImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleliquidacionimporDataAccess = new DetalleLiquidacionImporDataAccess();
			
			this.detalleliquidacionimpors= new ArrayList<DetalleLiquidacionImpor>();
			this.detalleliquidacionimpor= new DetalleLiquidacionImpor();
			
			this.detalleliquidacionimporObject=new Object();
			this.detalleliquidacionimporsObject=new ArrayList<Object>();
				
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
			
			this.detalleliquidacionimporDataAccess.setConnexionType(this.connexionType);
			this.detalleliquidacionimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleLiquidacionImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleliquidacionimporDataAccess = new DetalleLiquidacionImporDataAccess();
			this.detalleliquidacionimpors= new ArrayList<DetalleLiquidacionImpor>();
			this.detalleliquidacionimpor= new DetalleLiquidacionImpor();
			this.detalleliquidacionimporObject=new Object();
			this.detalleliquidacionimporsObject=new ArrayList<Object>();
			
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
			
			this.detalleliquidacionimporDataAccess.setConnexionType(this.connexionType);
			this.detalleliquidacionimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleLiquidacionImpor getDetalleLiquidacionImpor() throws Exception {	
		DetalleLiquidacionImporLogicAdditional.checkDetalleLiquidacionImporToGet(detalleliquidacionimpor,this.datosCliente,this.arrDatoGeneral);
		DetalleLiquidacionImporLogicAdditional.updateDetalleLiquidacionImporToGet(detalleliquidacionimpor,this.arrDatoGeneral);
		
		return detalleliquidacionimpor;
	}
		
	public void setDetalleLiquidacionImpor(DetalleLiquidacionImpor newDetalleLiquidacionImpor) {
		this.detalleliquidacionimpor = newDetalleLiquidacionImpor;
	}
	
	public DetalleLiquidacionImporDataAccess getDetalleLiquidacionImporDataAccess() {
		return detalleliquidacionimporDataAccess;
	}
	
	public void setDetalleLiquidacionImporDataAccess(DetalleLiquidacionImporDataAccess newdetalleliquidacionimporDataAccess) {
		this.detalleliquidacionimporDataAccess = newdetalleliquidacionimporDataAccess;
	}
	
	public List<DetalleLiquidacionImpor> getDetalleLiquidacionImpors() throws Exception {		
		this.quitarDetalleLiquidacionImporsNulos();
		
		DetalleLiquidacionImporLogicAdditional.checkDetalleLiquidacionImporToGets(detalleliquidacionimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleLiquidacionImpor detalleliquidacionimporLocal: detalleliquidacionimpors ) {
			DetalleLiquidacionImporLogicAdditional.updateDetalleLiquidacionImporToGet(detalleliquidacionimporLocal,this.arrDatoGeneral);
		}
		
		return detalleliquidacionimpors;
	}
	
	public void setDetalleLiquidacionImpors(List<DetalleLiquidacionImpor> newDetalleLiquidacionImpors) {
		this.detalleliquidacionimpors = newDetalleLiquidacionImpors;
	}
	
	public Object getDetalleLiquidacionImporObject() {	
		this.detalleliquidacionimporObject=this.detalleliquidacionimporDataAccess.getEntityObject();
		return this.detalleliquidacionimporObject;
	}
		
	public void setDetalleLiquidacionImporObject(Object newDetalleLiquidacionImporObject) {
		this.detalleliquidacionimporObject = newDetalleLiquidacionImporObject;
	}
	
	public List<Object> getDetalleLiquidacionImporsObject() {		
		this.detalleliquidacionimporsObject=this.detalleliquidacionimporDataAccess.getEntitiesObject();
		return this.detalleliquidacionimporsObject;
	}
		
	public void setDetalleLiquidacionImporsObject(List<Object> newDetalleLiquidacionImporsObject) {
		this.detalleliquidacionimporsObject = newDetalleLiquidacionImporsObject;
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
		
		if(this.detalleliquidacionimporDataAccess!=null) {
			this.detalleliquidacionimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleliquidacionimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleliquidacionimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleliquidacionimpor=detalleliquidacionimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleliquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpor);
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
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		  		  
        try {
			
			detalleliquidacionimpor=detalleliquidacionimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleliquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleliquidacionimpor=detalleliquidacionimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleliquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpor);
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
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		  		  
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
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		  		  
        try {
			
			detalleliquidacionimpor=detalleliquidacionimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleliquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		  		  
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
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleliquidacionimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleliquidacionimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleliquidacionimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleliquidacionimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleliquidacionimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleliquidacionimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
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
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		  		  
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
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		  		  
        try {			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		  		  
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
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
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
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		  		  
        try {
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
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
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
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
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpor=detalleliquidacionimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpor);
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
		detalleliquidacionimpor = new  DetalleLiquidacionImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpor=detalleliquidacionimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
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
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		  		  
        try {
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleLiquidacionImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getTodosDetalleLiquidacionImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
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
	
	public  void  getTodosDetalleLiquidacionImpors(String sFinalQuery,Pagination pagination)throws Exception {
		detalleliquidacionimpors = new  ArrayList<DetalleLiquidacionImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleLiquidacionImpor(detalleliquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleLiquidacionImpor(DetalleLiquidacionImpor detalleliquidacionimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleliquidacionimpor.getIsNew() || detalleliquidacionimpor.getIsChanged()) { 
			this.invalidValues = detalleliquidacionimporValidator.getInvalidValues(detalleliquidacionimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleliquidacionimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleLiquidacionImpor(List<DetalleLiquidacionImpor> DetalleLiquidacionImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleLiquidacionImpor detalleliquidacionimporLocal:detalleliquidacionimpors) {				
			estaValidadoObjeto=this.validarGuardarDetalleLiquidacionImpor(detalleliquidacionimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleLiquidacionImpor(List<DetalleLiquidacionImpor> DetalleLiquidacionImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleLiquidacionImpor(detalleliquidacionimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleLiquidacionImpor(DetalleLiquidacionImpor DetalleLiquidacionImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleLiquidacionImpor(detalleliquidacionimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleLiquidacionImpor detalleliquidacionimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleliquidacionimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleLiquidacionImporConstantesFunciones.getDetalleLiquidacionImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleliquidacionimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleLiquidacionImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleLiquidacionImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleLiquidacionImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-saveDetalleLiquidacionImporWithConnection");connexion.begin();			
			
			DetalleLiquidacionImporLogicAdditional.checkDetalleLiquidacionImporToSave(this.detalleliquidacionimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleLiquidacionImporLogicAdditional.updateDetalleLiquidacionImporToSave(this.detalleliquidacionimpor,this.arrDatoGeneral);
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleliquidacionimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleLiquidacionImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleLiquidacionImpor(this.detalleliquidacionimpor)) {
				DetalleLiquidacionImporDataAccess.save(this.detalleliquidacionimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleliquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleLiquidacionImporLogicAdditional.checkDetalleLiquidacionImporToSaveAfter(this.detalleliquidacionimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleLiquidacionImpor();
			
			connexion.commit();			
			
			if(this.detalleliquidacionimpor.getIsDeleted()) {
				this.detalleliquidacionimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleLiquidacionImpor()throws Exception {	
		try {	
			
			DetalleLiquidacionImporLogicAdditional.checkDetalleLiquidacionImporToSave(this.detalleliquidacionimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleLiquidacionImporLogicAdditional.updateDetalleLiquidacionImporToSave(this.detalleliquidacionimpor,this.arrDatoGeneral);
			
			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleliquidacionimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleLiquidacionImpor(this.detalleliquidacionimpor)) {			
				DetalleLiquidacionImporDataAccess.save(this.detalleliquidacionimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleliquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleLiquidacionImporLogicAdditional.checkDetalleLiquidacionImporToSaveAfter(this.detalleliquidacionimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleliquidacionimpor.getIsDeleted()) {
				this.detalleliquidacionimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleLiquidacionImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-saveDetalleLiquidacionImporsWithConnection");connexion.begin();			
			
			DetalleLiquidacionImporLogicAdditional.checkDetalleLiquidacionImporToSaves(detalleliquidacionimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleLiquidacionImpors();
			
			Boolean validadoTodosDetalleLiquidacionImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleLiquidacionImpor detalleliquidacionimporLocal:detalleliquidacionimpors) {		
				if(detalleliquidacionimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleLiquidacionImporLogicAdditional.updateDetalleLiquidacionImporToSave(detalleliquidacionimporLocal,this.arrDatoGeneral);
	        	
				DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleliquidacionimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleLiquidacionImpor(detalleliquidacionimporLocal)) {
					DetalleLiquidacionImporDataAccess.save(detalleliquidacionimporLocal, connexion);				
				} else {
					validadoTodosDetalleLiquidacionImpor=false;
				}
			}
			
			if(!validadoTodosDetalleLiquidacionImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleLiquidacionImporLogicAdditional.checkDetalleLiquidacionImporToSavesAfter(detalleliquidacionimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleLiquidacionImpors();
			
			connexion.commit();		
			
			this.quitarDetalleLiquidacionImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleLiquidacionImpors()throws Exception {				
		 try {	
			DetalleLiquidacionImporLogicAdditional.checkDetalleLiquidacionImporToSaves(detalleliquidacionimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleLiquidacionImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleLiquidacionImpor detalleliquidacionimporLocal:detalleliquidacionimpors) {				
				if(detalleliquidacionimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleLiquidacionImporLogicAdditional.updateDetalleLiquidacionImporToSave(detalleliquidacionimporLocal,this.arrDatoGeneral);
	        	
				DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleliquidacionimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleLiquidacionImpor(detalleliquidacionimporLocal)) {				
					DetalleLiquidacionImporDataAccess.save(detalleliquidacionimporLocal, connexion);				
				} else {
					validadoTodosDetalleLiquidacionImpor=false;
				}
			}
			
			if(!validadoTodosDetalleLiquidacionImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleLiquidacionImporLogicAdditional.checkDetalleLiquidacionImporToSavesAfter(detalleliquidacionimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleLiquidacionImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleLiquidacionImporParameterReturnGeneral procesarAccionDetalleLiquidacionImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleLiquidacionImpor> detalleliquidacionimpors,DetalleLiquidacionImporParameterReturnGeneral detalleliquidacionimporParameterGeneral)throws Exception {
		 try {	
			DetalleLiquidacionImporParameterReturnGeneral detalleliquidacionimporReturnGeneral=new DetalleLiquidacionImporParameterReturnGeneral();
	
			DetalleLiquidacionImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleliquidacionimpors,detalleliquidacionimporParameterGeneral,detalleliquidacionimporReturnGeneral);
			
			return detalleliquidacionimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleLiquidacionImporParameterReturnGeneral procesarAccionDetalleLiquidacionImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleLiquidacionImpor> detalleliquidacionimpors,DetalleLiquidacionImporParameterReturnGeneral detalleliquidacionimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-procesarAccionDetalleLiquidacionImporsWithConnection");connexion.begin();			
			
			DetalleLiquidacionImporParameterReturnGeneral detalleliquidacionimporReturnGeneral=new DetalleLiquidacionImporParameterReturnGeneral();
	
			DetalleLiquidacionImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleliquidacionimpors,detalleliquidacionimporParameterGeneral,detalleliquidacionimporReturnGeneral);
			
			this.connexion.commit();
			
			return detalleliquidacionimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleLiquidacionImporParameterReturnGeneral procesarEventosDetalleLiquidacionImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleLiquidacionImpor> detalleliquidacionimpors,DetalleLiquidacionImpor detalleliquidacionimpor,DetalleLiquidacionImporParameterReturnGeneral detalleliquidacionimporParameterGeneral,Boolean isEsNuevoDetalleLiquidacionImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleLiquidacionImporParameterReturnGeneral detalleliquidacionimporReturnGeneral=new DetalleLiquidacionImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleliquidacionimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleLiquidacionImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleliquidacionimpors,detalleliquidacionimpor,detalleliquidacionimporParameterGeneral,detalleliquidacionimporReturnGeneral,isEsNuevoDetalleLiquidacionImpor,clases);
			
			return detalleliquidacionimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleLiquidacionImporParameterReturnGeneral procesarEventosDetalleLiquidacionImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleLiquidacionImpor> detalleliquidacionimpors,DetalleLiquidacionImpor detalleliquidacionimpor,DetalleLiquidacionImporParameterReturnGeneral detalleliquidacionimporParameterGeneral,Boolean isEsNuevoDetalleLiquidacionImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-procesarEventosDetalleLiquidacionImporsWithConnection");connexion.begin();			
			
			DetalleLiquidacionImporParameterReturnGeneral detalleliquidacionimporReturnGeneral=new DetalleLiquidacionImporParameterReturnGeneral();
	
			detalleliquidacionimporReturnGeneral.setDetalleLiquidacionImpor(detalleliquidacionimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleliquidacionimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleLiquidacionImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleliquidacionimpors,detalleliquidacionimpor,detalleliquidacionimporParameterGeneral,detalleliquidacionimporReturnGeneral,isEsNuevoDetalleLiquidacionImpor,clases);
			
			this.connexion.commit();
			
			return detalleliquidacionimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleLiquidacionImporParameterReturnGeneral procesarImportacionDetalleLiquidacionImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleLiquidacionImporParameterReturnGeneral detalleliquidacionimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-procesarImportacionDetalleLiquidacionImporsWithConnection");connexion.begin();			
			
			DetalleLiquidacionImporParameterReturnGeneral detalleliquidacionimporReturnGeneral=new DetalleLiquidacionImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleliquidacionimpors=new ArrayList<DetalleLiquidacionImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleliquidacionimpor=new DetalleLiquidacionImpor();
				
				
				if(conColumnasBase) {this.detalleliquidacionimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleliquidacionimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleliquidacionimpor.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpor.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleliquidacionimpor.setreferencia(arrColumnas[iColumn++]);
				this.detalleliquidacionimpor.setimpuesto(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpor.setimpuesto2(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpor.setimpuesto3(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpor.setimpuesto4(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpor.setimpuesto5(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detalleliquidacionimpors.add(this.detalleliquidacionimpor);
			}
			
			this.saveDetalleLiquidacionImpors();
			
			this.connexion.commit();
			
			detalleliquidacionimporReturnGeneral.setConRetornoEstaProcesado(true);
			detalleliquidacionimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleliquidacionimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleLiquidacionImporsEliminados() throws Exception {				
		
		List<DetalleLiquidacionImpor> detalleliquidacionimporsAux= new ArrayList<DetalleLiquidacionImpor>();
		
		for(DetalleLiquidacionImpor detalleliquidacionimpor:detalleliquidacionimpors) {
			if(!detalleliquidacionimpor.getIsDeleted()) {
				detalleliquidacionimporsAux.add(detalleliquidacionimpor);
			}
		}
		
		detalleliquidacionimpors=detalleliquidacionimporsAux;
	}
	
	public void quitarDetalleLiquidacionImporsNulos() throws Exception {				
		
		List<DetalleLiquidacionImpor> detalleliquidacionimporsAux= new ArrayList<DetalleLiquidacionImpor>();
		
		for(DetalleLiquidacionImpor detalleliquidacionimpor : this.detalleliquidacionimpors) {
			if(detalleliquidacionimpor==null) {
				detalleliquidacionimporsAux.add(detalleliquidacionimpor);
			}
		}
		
		//this.detalleliquidacionimpors=detalleliquidacionimporsAux;
		
		this.detalleliquidacionimpors.removeAll(detalleliquidacionimporsAux);
	}
	
	public void getSetVersionRowDetalleLiquidacionImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleliquidacionimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleliquidacionimpor.getIsDeleted() || (detalleliquidacionimpor.getIsChanged()&&!detalleliquidacionimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleliquidacionimporDataAccess.getSetVersionRowDetalleLiquidacionImpor(connexion,detalleliquidacionimpor.getId());
				
				if(!detalleliquidacionimpor.getVersionRow().equals(timestamp)) {	
					detalleliquidacionimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleliquidacionimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleLiquidacionImpor()throws Exception {	
		
		if(detalleliquidacionimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleliquidacionimpor.getIsDeleted() || (detalleliquidacionimpor.getIsChanged()&&!detalleliquidacionimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleliquidacionimporDataAccess.getSetVersionRowDetalleLiquidacionImpor(connexion,detalleliquidacionimpor.getId());
			
			try {							
				if(!detalleliquidacionimpor.getVersionRow().equals(timestamp)) {	
					detalleliquidacionimpor.setVersionRow(timestamp);
				}
				
				detalleliquidacionimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleLiquidacionImporsWithConnection()throws Exception {	
		if(detalleliquidacionimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleLiquidacionImpor detalleliquidacionimporAux:detalleliquidacionimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleliquidacionimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleliquidacionimporAux.getIsDeleted() || (detalleliquidacionimporAux.getIsChanged()&&!detalleliquidacionimporAux.getIsNew())) {
						
						timestamp=detalleliquidacionimporDataAccess.getSetVersionRowDetalleLiquidacionImpor(connexion,detalleliquidacionimporAux.getId());
						
						if(!detalleliquidacionimpor.getVersionRow().equals(timestamp)) {	
							detalleliquidacionimporAux.setVersionRow(timestamp);
						}
								
						detalleliquidacionimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleLiquidacionImpors()throws Exception {	
		if(detalleliquidacionimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleLiquidacionImpor detalleliquidacionimporAux:detalleliquidacionimpors) {
					if(detalleliquidacionimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleliquidacionimporAux.getIsDeleted() || (detalleliquidacionimporAux.getIsChanged()&&!detalleliquidacionimporAux.getIsNew())) {
						
						timestamp=detalleliquidacionimporDataAccess.getSetVersionRowDetalleLiquidacionImpor(connexion,detalleliquidacionimporAux.getId());
						
						if(!detalleliquidacionimporAux.getVersionRow().equals(timestamp)) {	
							detalleliquidacionimporAux.setVersionRow(timestamp);
						}
						
													
						detalleliquidacionimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleLiquidacionImporParameterReturnGeneral cargarCombosLoteForeignKeyDetalleLiquidacionImporWithConnection(String finalQueryGlobalLiquidacionImpor,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalCentroCosto,String finalQueryGlobalCostoGastoImpor) throws Exception {
		DetalleLiquidacionImporParameterReturnGeneral  detalleliquidacionimporReturnGeneral =new DetalleLiquidacionImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleLiquidacionImporWithConnection");connexion.begin();
			
			detalleliquidacionimporReturnGeneral =new DetalleLiquidacionImporParameterReturnGeneral();
			
			

			List<LiquidacionImpor> liquidacionimporsForeignKey=new ArrayList<LiquidacionImpor>();
			LiquidacionImporLogic liquidacionimporLogic=new LiquidacionImporLogic();
			liquidacionimporLogic.setConnexion(this.connexion);
			liquidacionimporLogic.getLiquidacionImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLiquidacionImpor.equals("NONE")) {
				liquidacionimporLogic.getTodosLiquidacionImpors(finalQueryGlobalLiquidacionImpor,new Pagination());
				liquidacionimporsForeignKey=liquidacionimporLogic.getLiquidacionImpors();
			}

			detalleliquidacionimporReturnGeneral.setliquidacionimporsForeignKey(liquidacionimporsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleliquidacionimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleliquidacionimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			detalleliquidacionimporReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleliquidacionimporReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CostoGastoImpor> costogastoimporsForeignKey=new ArrayList<CostoGastoImpor>();
			CostoGastoImporLogic costogastoimporLogic=new CostoGastoImporLogic();
			costogastoimporLogic.setConnexion(this.connexion);
			costogastoimporLogic.getCostoGastoImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCostoGastoImpor.equals("NONE")) {
				costogastoimporLogic.getTodosCostoGastoImpors(finalQueryGlobalCostoGastoImpor,new Pagination());
				costogastoimporsForeignKey=costogastoimporLogic.getCostoGastoImpors();
			}

			detalleliquidacionimporReturnGeneral.setcostogastoimporsForeignKey(costogastoimporsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleliquidacionimporReturnGeneral;
	}
	
	public DetalleLiquidacionImporParameterReturnGeneral cargarCombosLoteForeignKeyDetalleLiquidacionImpor(String finalQueryGlobalLiquidacionImpor,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalCentroCosto,String finalQueryGlobalCostoGastoImpor) throws Exception {
		DetalleLiquidacionImporParameterReturnGeneral  detalleliquidacionimporReturnGeneral =new DetalleLiquidacionImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleliquidacionimporReturnGeneral =new DetalleLiquidacionImporParameterReturnGeneral();
			
			

			List<LiquidacionImpor> liquidacionimporsForeignKey=new ArrayList<LiquidacionImpor>();
			LiquidacionImporLogic liquidacionimporLogic=new LiquidacionImporLogic();
			liquidacionimporLogic.setConnexion(this.connexion);
			liquidacionimporLogic.getLiquidacionImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLiquidacionImpor.equals("NONE")) {
				liquidacionimporLogic.getTodosLiquidacionImpors(finalQueryGlobalLiquidacionImpor,new Pagination());
				liquidacionimporsForeignKey=liquidacionimporLogic.getLiquidacionImpors();
			}

			detalleliquidacionimporReturnGeneral.setliquidacionimporsForeignKey(liquidacionimporsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleliquidacionimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleliquidacionimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			detalleliquidacionimporReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleliquidacionimporReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CostoGastoImpor> costogastoimporsForeignKey=new ArrayList<CostoGastoImpor>();
			CostoGastoImporLogic costogastoimporLogic=new CostoGastoImporLogic();
			costogastoimporLogic.setConnexion(this.connexion);
			costogastoimporLogic.getCostoGastoImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCostoGastoImpor.equals("NONE")) {
				costogastoimporLogic.getTodosCostoGastoImpors(finalQueryGlobalCostoGastoImpor,new Pagination());
				costogastoimporsForeignKey=costogastoimporLogic.getCostoGastoImpors();
			}

			detalleliquidacionimporReturnGeneral.setcostogastoimporsForeignKey(costogastoimporsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleliquidacionimporReturnGeneral;
	}
	
	
	public void deepLoad(DetalleLiquidacionImpor detalleliquidacionimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleLiquidacionImporLogicAdditional.updateDetalleLiquidacionImporToGet(detalleliquidacionimpor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleliquidacionimpor.setLiquidacionImpor(detalleliquidacionimporDataAccess.getLiquidacionImpor(connexion,detalleliquidacionimpor));
		detalleliquidacionimpor.setEmpresa(detalleliquidacionimporDataAccess.getEmpresa(connexion,detalleliquidacionimpor));
		detalleliquidacionimpor.setSucursal(detalleliquidacionimporDataAccess.getSucursal(connexion,detalleliquidacionimpor));
		detalleliquidacionimpor.setUsuario(detalleliquidacionimporDataAccess.getUsuario(connexion,detalleliquidacionimpor));
		detalleliquidacionimpor.setCentroCosto(detalleliquidacionimporDataAccess.getCentroCosto(connexion,detalleliquidacionimpor));
		detalleliquidacionimpor.setCostoGastoImpor(detalleliquidacionimporDataAccess.getCostoGastoImpor(connexion,detalleliquidacionimpor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpor.class)) {
				detalleliquidacionimpor.setLiquidacionImpor(detalleliquidacionimporDataAccess.getLiquidacionImpor(connexion,detalleliquidacionimpor));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleliquidacionimpor.setEmpresa(detalleliquidacionimporDataAccess.getEmpresa(connexion,detalleliquidacionimpor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleliquidacionimpor.setSucursal(detalleliquidacionimporDataAccess.getSucursal(connexion,detalleliquidacionimpor));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				detalleliquidacionimpor.setUsuario(detalleliquidacionimporDataAccess.getUsuario(connexion,detalleliquidacionimpor));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleliquidacionimpor.setCentroCosto(detalleliquidacionimporDataAccess.getCentroCosto(connexion,detalleliquidacionimpor));
				continue;
			}

			if(clas.clas.equals(CostoGastoImpor.class)) {
				detalleliquidacionimpor.setCostoGastoImpor(detalleliquidacionimporDataAccess.getCostoGastoImpor(connexion,detalleliquidacionimpor));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setLiquidacionImpor(detalleliquidacionimporDataAccess.getLiquidacionImpor(connexion,detalleliquidacionimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setEmpresa(detalleliquidacionimporDataAccess.getEmpresa(connexion,detalleliquidacionimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setSucursal(detalleliquidacionimporDataAccess.getSucursal(connexion,detalleliquidacionimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setUsuario(detalleliquidacionimporDataAccess.getUsuario(connexion,detalleliquidacionimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setCentroCosto(detalleliquidacionimporDataAccess.getCentroCosto(connexion,detalleliquidacionimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CostoGastoImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setCostoGastoImpor(detalleliquidacionimporDataAccess.getCostoGastoImpor(connexion,detalleliquidacionimpor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleliquidacionimpor.setLiquidacionImpor(detalleliquidacionimporDataAccess.getLiquidacionImpor(connexion,detalleliquidacionimpor));
		LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(connexion);
		liquidacionimporLogic.deepLoad(detalleliquidacionimpor.getLiquidacionImpor(),isDeep,deepLoadType,clases);
				
		detalleliquidacionimpor.setEmpresa(detalleliquidacionimporDataAccess.getEmpresa(connexion,detalleliquidacionimpor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleliquidacionimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleliquidacionimpor.setSucursal(detalleliquidacionimporDataAccess.getSucursal(connexion,detalleliquidacionimpor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleliquidacionimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleliquidacionimpor.setUsuario(detalleliquidacionimporDataAccess.getUsuario(connexion,detalleliquidacionimpor));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(detalleliquidacionimpor.getUsuario(),isDeep,deepLoadType,clases);
				
		detalleliquidacionimpor.setCentroCosto(detalleliquidacionimporDataAccess.getCentroCosto(connexion,detalleliquidacionimpor));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleliquidacionimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		detalleliquidacionimpor.setCostoGastoImpor(detalleliquidacionimporDataAccess.getCostoGastoImpor(connexion,detalleliquidacionimpor));
		CostoGastoImporLogic costogastoimporLogic= new CostoGastoImporLogic(connexion);
		costogastoimporLogic.deepLoad(detalleliquidacionimpor.getCostoGastoImpor(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpor.class)) {
				detalleliquidacionimpor.setLiquidacionImpor(detalleliquidacionimporDataAccess.getLiquidacionImpor(connexion,detalleliquidacionimpor));
				LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(connexion);
				liquidacionimporLogic.deepLoad(detalleliquidacionimpor.getLiquidacionImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleliquidacionimpor.setEmpresa(detalleliquidacionimporDataAccess.getEmpresa(connexion,detalleliquidacionimpor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleliquidacionimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleliquidacionimpor.setSucursal(detalleliquidacionimporDataAccess.getSucursal(connexion,detalleliquidacionimpor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleliquidacionimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				detalleliquidacionimpor.setUsuario(detalleliquidacionimporDataAccess.getUsuario(connexion,detalleliquidacionimpor));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(detalleliquidacionimpor.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleliquidacionimpor.setCentroCosto(detalleliquidacionimporDataAccess.getCentroCosto(connexion,detalleliquidacionimpor));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detalleliquidacionimpor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CostoGastoImpor.class)) {
				detalleliquidacionimpor.setCostoGastoImpor(detalleliquidacionimporDataAccess.getCostoGastoImpor(connexion,detalleliquidacionimpor));
				CostoGastoImporLogic costogastoimporLogic= new CostoGastoImporLogic(connexion);
				costogastoimporLogic.deepLoad(detalleliquidacionimpor.getCostoGastoImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setLiquidacionImpor(detalleliquidacionimporDataAccess.getLiquidacionImpor(connexion,detalleliquidacionimpor));
			LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(connexion);
			liquidacionimporLogic.deepLoad(detalleliquidacionimpor.getLiquidacionImpor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setEmpresa(detalleliquidacionimporDataAccess.getEmpresa(connexion,detalleliquidacionimpor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleliquidacionimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setSucursal(detalleliquidacionimporDataAccess.getSucursal(connexion,detalleliquidacionimpor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleliquidacionimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setUsuario(detalleliquidacionimporDataAccess.getUsuario(connexion,detalleliquidacionimpor));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(detalleliquidacionimpor.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setCentroCosto(detalleliquidacionimporDataAccess.getCentroCosto(connexion,detalleliquidacionimpor));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detalleliquidacionimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CostoGastoImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpor.setCostoGastoImpor(detalleliquidacionimporDataAccess.getCostoGastoImpor(connexion,detalleliquidacionimpor));
			CostoGastoImporLogic costogastoimporLogic= new CostoGastoImporLogic(connexion);
			costogastoimporLogic.deepLoad(detalleliquidacionimpor.getCostoGastoImpor(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleLiquidacionImpor detalleliquidacionimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleLiquidacionImporLogicAdditional.updateDetalleLiquidacionImporToSave(detalleliquidacionimpor,this.arrDatoGeneral);
			
DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		LiquidacionImporDataAccess.save(detalleliquidacionimpor.getLiquidacionImpor(),connexion);

		EmpresaDataAccess.save(detalleliquidacionimpor.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleliquidacionimpor.getSucursal(),connexion);

		UsuarioDataAccess.save(detalleliquidacionimpor.getUsuario(),connexion);

		CentroCostoDataAccess.save(detalleliquidacionimpor.getCentroCosto(),connexion);

		CostoGastoImporDataAccess.save(detalleliquidacionimpor.getCostoGastoImpor(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpor.class)) {
				LiquidacionImporDataAccess.save(detalleliquidacionimpor.getLiquidacionImpor(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleliquidacionimpor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleliquidacionimpor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(detalleliquidacionimpor.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleliquidacionimpor.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CostoGastoImpor.class)) {
				CostoGastoImporDataAccess.save(detalleliquidacionimpor.getCostoGastoImpor(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		LiquidacionImporDataAccess.save(detalleliquidacionimpor.getLiquidacionImpor(),connexion);
		LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(connexion);
		liquidacionimporLogic.deepLoad(detalleliquidacionimpor.getLiquidacionImpor(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detalleliquidacionimpor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleliquidacionimpor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleliquidacionimpor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleliquidacionimpor.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(detalleliquidacionimpor.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(detalleliquidacionimpor.getUsuario(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detalleliquidacionimpor.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleliquidacionimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				

		CostoGastoImporDataAccess.save(detalleliquidacionimpor.getCostoGastoImpor(),connexion);
		CostoGastoImporLogic costogastoimporLogic= new CostoGastoImporLogic(connexion);
		costogastoimporLogic.deepLoad(detalleliquidacionimpor.getCostoGastoImpor(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpor.class)) {
				LiquidacionImporDataAccess.save(detalleliquidacionimpor.getLiquidacionImpor(),connexion);
				LiquidacionImporLogic liquidacionimporLogic= new LiquidacionImporLogic(connexion);
				liquidacionimporLogic.deepSave(detalleliquidacionimpor.getLiquidacionImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleliquidacionimpor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleliquidacionimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleliquidacionimpor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleliquidacionimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(detalleliquidacionimpor.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(detalleliquidacionimpor.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleliquidacionimpor.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detalleliquidacionimpor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CostoGastoImpor.class)) {
				CostoGastoImporDataAccess.save(detalleliquidacionimpor.getCostoGastoImpor(),connexion);
				CostoGastoImporLogic costogastoimporLogic= new CostoGastoImporLogic(connexion);
				costogastoimporLogic.deepSave(detalleliquidacionimpor.getCostoGastoImpor(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleLiquidacionImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(detalleliquidacionimpor);
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
			this.deepLoad(this.detalleliquidacionimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleLiquidacionImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleliquidacionimpors!=null) {
				for(DetalleLiquidacionImpor detalleliquidacionimpor:detalleliquidacionimpors) {
					this.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(detalleliquidacionimpors);
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
			if(detalleliquidacionimpors!=null) {
				for(DetalleLiquidacionImpor detalleliquidacionimpor:detalleliquidacionimpors) {
					this.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(detalleliquidacionimpors);
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
			this.getNewConnexionToDeep(DetalleLiquidacionImpor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleliquidacionimpor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleLiquidacionImpor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleliquidacionimpors!=null) {
				for(DetalleLiquidacionImpor detalleliquidacionimpor:detalleliquidacionimpors) {
					this.deepSave(detalleliquidacionimpor,isDeep,deepLoadType,clases);
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
			if(detalleliquidacionimpors!=null) {
				for(DetalleLiquidacionImpor detalleliquidacionimpor:detalleliquidacionimpors) {
					this.deepSave(detalleliquidacionimpor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleLiquidacionImporsFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleLiquidacionImporsFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleLiquidacionImporsFK_IdCostoGastoImporWithConnection(String sFinalQuery,Pagination pagination,Long id_costo_gasto_impor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCostoGastoImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCostoGastoImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_costo_gasto_impor,DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCostoGastoImpor);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCostoGastoImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleLiquidacionImporsFK_IdCostoGastoImpor(String sFinalQuery,Pagination pagination,Long id_costo_gasto_impor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCostoGastoImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCostoGastoImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_costo_gasto_impor,DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCostoGastoImpor);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCostoGastoImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleLiquidacionImporsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleLiquidacionImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleLiquidacionImporsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleLiquidacionImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleLiquidacionImporsFK_IdLiquidacionImporWithConnection(String sFinalQuery,Pagination pagination,Long id_liquidacion_impor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLiquidacionImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLiquidacionImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_liquidacion_impor,DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLiquidacionImpor);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLiquidacionImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleLiquidacionImporsFK_IdLiquidacionImpor(String sFinalQuery,Pagination pagination,Long id_liquidacion_impor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLiquidacionImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLiquidacionImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_liquidacion_impor,DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLiquidacionImpor);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLiquidacionImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleLiquidacionImporsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleLiquidacionImporsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleLiquidacionImporsFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,DetalleLiquidacionImporConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleLiquidacionImporsFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,DetalleLiquidacionImporConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			DetalleLiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(this.detalleliquidacionimpors);
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
			if(DetalleLiquidacionImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleLiquidacionImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleLiquidacionImpor detalleliquidacionimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleLiquidacionImporConstantesFunciones.ISCONAUDITORIA) {
				if(detalleliquidacionimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleLiquidacionImporDataAccess.TABLENAME, detalleliquidacionimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleLiquidacionImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleLiquidacionImporLogic.registrarAuditoriaDetallesDetalleLiquidacionImpor(connexion,detalleliquidacionimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleliquidacionimpor.getIsDeleted()) {
					/*if(!detalleliquidacionimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleLiquidacionImporDataAccess.TABLENAME, detalleliquidacionimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleLiquidacionImporLogic.registrarAuditoriaDetallesDetalleLiquidacionImpor(connexion,detalleliquidacionimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleLiquidacionImporDataAccess.TABLENAME, detalleliquidacionimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleliquidacionimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleLiquidacionImporDataAccess.TABLENAME, detalleliquidacionimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleLiquidacionImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleLiquidacionImporLogic.registrarAuditoriaDetallesDetalleLiquidacionImpor(connexion,detalleliquidacionimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleLiquidacionImpor(Connexion connexion,DetalleLiquidacionImpor detalleliquidacionimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getid_liquidacion_impor().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_liquidacion_impor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_liquidacion_impor()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_liquidacion_impor().toString();
				}
				if(detalleliquidacionimpor.getid_liquidacion_impor()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getid_liquidacion_impor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IDLIQUIDACIONIMPOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getid_empresa().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_empresa().toString();
				}
				if(detalleliquidacionimpor.getid_empresa()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getid_sucursal().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_sucursal().toString();
				}
				if(detalleliquidacionimpor.getid_sucursal()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getid_usuario().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_usuario()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_usuario().toString();
				}
				if(detalleliquidacionimpor.getid_usuario()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getid_centro_costo().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_centro_costo().toString();
				}
				if(detalleliquidacionimpor.getid_centro_costo()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getid_costo_gasto_impor().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_costo_gasto_impor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_costo_gasto_impor()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getid_costo_gasto_impor().toString();
				}
				if(detalleliquidacionimpor.getid_costo_gasto_impor()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getid_costo_gasto_impor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IDCOSTOGASTOIMPOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getvalor().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getvalor()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getvalor().toString();
				}
				if(detalleliquidacionimpor.getvalor()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getfecha().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getfecha()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getfecha().toString();
				}
				if(detalleliquidacionimpor.getfecha()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getreferencia().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getreferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getreferencia()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getreferencia();
				}
				if(detalleliquidacionimpor.getreferencia()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getreferencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.REFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getimpuesto().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto().toString();
				}
				if(detalleliquidacionimpor.getimpuesto()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getimpuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getimpuesto2().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto2()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto2().toString();
				}
				if(detalleliquidacionimpor.getimpuesto2()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getimpuesto2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IMPUESTO2,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getimpuesto3().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto3()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto3().toString();
				}
				if(detalleliquidacionimpor.getimpuesto3()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getimpuesto3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IMPUESTO3,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getimpuesto4().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto4()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto4().toString();
				}
				if(detalleliquidacionimpor.getimpuesto4()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getimpuesto4().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IMPUESTO4,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpor.getIsNew()||!detalleliquidacionimpor.getimpuesto5().equals(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto5()!=null)
				{
					strValorActual=detalleliquidacionimpor.getDetalleLiquidacionImporOriginal().getimpuesto5().toString();
				}
				if(detalleliquidacionimpor.getimpuesto5()!=null)
				{
					strValorNuevo=detalleliquidacionimpor.getimpuesto5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImporConstantesFunciones.IMPUESTO5,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleLiquidacionImporRelacionesWithConnection(DetalleLiquidacionImpor detalleliquidacionimpor) throws Exception {

		if(!detalleliquidacionimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleLiquidacionImporRelacionesBase(detalleliquidacionimpor,true);
		}
	}

	public void saveDetalleLiquidacionImporRelaciones(DetalleLiquidacionImpor detalleliquidacionimpor)throws Exception {

		if(!detalleliquidacionimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleLiquidacionImporRelacionesBase(detalleliquidacionimpor,false);
		}
	}

	public void saveDetalleLiquidacionImporRelacionesBase(DetalleLiquidacionImpor detalleliquidacionimpor,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleLiquidacionImpor-saveRelacionesWithConnection");}
	

			this.setDetalleLiquidacionImpor(detalleliquidacionimpor);

			if(DetalleLiquidacionImporLogicAdditional.validarSaveRelaciones(detalleliquidacionimpor,this)) {

				DetalleLiquidacionImporLogicAdditional.updateRelacionesToSave(detalleliquidacionimpor,this);

				if((detalleliquidacionimpor.getIsNew()||detalleliquidacionimpor.getIsChanged())&&!detalleliquidacionimpor.getIsDeleted()) {
					this.saveDetalleLiquidacionImpor();
					this.saveDetalleLiquidacionImporRelacionesDetalles();

				} else if(detalleliquidacionimpor.getIsDeleted()) {
					this.saveDetalleLiquidacionImporRelacionesDetalles();
					this.saveDetalleLiquidacionImpor();
				}

				DetalleLiquidacionImporLogicAdditional.updateRelacionesToSaveAfter(detalleliquidacionimpor,this);

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
	
	
	private void saveDetalleLiquidacionImporRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleLiquidacionImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleLiquidacionImporConstantesFunciones.getClassesForeignKeysOfDetalleLiquidacionImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleLiquidacionImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleLiquidacionImporConstantesFunciones.getClassesRelationshipsOfDetalleLiquidacionImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
