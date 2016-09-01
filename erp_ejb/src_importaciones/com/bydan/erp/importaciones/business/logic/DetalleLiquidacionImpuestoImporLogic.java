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
import com.bydan.erp.importaciones.util.DetalleLiquidacionImpuestoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.DetalleLiquidacionImpuestoImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.DetalleLiquidacionImpuestoImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.DetalleLiquidacionImpuestoImpor;
import com.bydan.erp.importaciones.business.logic.DetalleLiquidacionImpuestoImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleLiquidacionImpuestoImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleLiquidacionImpuestoImporLogic.class);
	
	protected DetalleLiquidacionImpuestoImporDataAccess detalleliquidacionimpuestoimporDataAccess; 	
	protected DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor;
	protected List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors;
	protected Object detalleliquidacionimpuestoimporObject;	
	protected List<Object> detalleliquidacionimpuestoimporsObject;
	
	public static ClassValidator<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimporValidator = new ClassValidator<DetalleLiquidacionImpuestoImpor>(DetalleLiquidacionImpuestoImpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleLiquidacionImpuestoImporLogicAdditional detalleliquidacionimpuestoimporLogicAdditional=null;
	
	public DetalleLiquidacionImpuestoImporLogicAdditional getDetalleLiquidacionImpuestoImporLogicAdditional() {
		return this.detalleliquidacionimpuestoimporLogicAdditional;
	}
	
	public void setDetalleLiquidacionImpuestoImporLogicAdditional(DetalleLiquidacionImpuestoImporLogicAdditional detalleliquidacionimpuestoimporLogicAdditional) {
		try {
			this.detalleliquidacionimpuestoimporLogicAdditional=detalleliquidacionimpuestoimporLogicAdditional;
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
	
	
	
	
	public  DetalleLiquidacionImpuestoImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleliquidacionimpuestoimporDataAccess = new DetalleLiquidacionImpuestoImporDataAccess();
			
			this.detalleliquidacionimpuestoimpors= new ArrayList<DetalleLiquidacionImpuestoImpor>();
			this.detalleliquidacionimpuestoimpor= new DetalleLiquidacionImpuestoImpor();
			
			this.detalleliquidacionimpuestoimporObject=new Object();
			this.detalleliquidacionimpuestoimporsObject=new ArrayList<Object>();
				
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
			
			this.detalleliquidacionimpuestoimporDataAccess.setConnexionType(this.connexionType);
			this.detalleliquidacionimpuestoimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleLiquidacionImpuestoImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleliquidacionimpuestoimporDataAccess = new DetalleLiquidacionImpuestoImporDataAccess();
			this.detalleliquidacionimpuestoimpors= new ArrayList<DetalleLiquidacionImpuestoImpor>();
			this.detalleliquidacionimpuestoimpor= new DetalleLiquidacionImpuestoImpor();
			this.detalleliquidacionimpuestoimporObject=new Object();
			this.detalleliquidacionimpuestoimporsObject=new ArrayList<Object>();
			
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
			
			this.detalleliquidacionimpuestoimporDataAccess.setConnexionType(this.connexionType);
			this.detalleliquidacionimpuestoimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleLiquidacionImpuestoImpor getDetalleLiquidacionImpuestoImpor() throws Exception {	
		DetalleLiquidacionImpuestoImporLogicAdditional.checkDetalleLiquidacionImpuestoImporToGet(detalleliquidacionimpuestoimpor,this.datosCliente,this.arrDatoGeneral);
		DetalleLiquidacionImpuestoImporLogicAdditional.updateDetalleLiquidacionImpuestoImporToGet(detalleliquidacionimpuestoimpor,this.arrDatoGeneral);
		
		return detalleliquidacionimpuestoimpor;
	}
		
	public void setDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor newDetalleLiquidacionImpuestoImpor) {
		this.detalleliquidacionimpuestoimpor = newDetalleLiquidacionImpuestoImpor;
	}
	
	public DetalleLiquidacionImpuestoImporDataAccess getDetalleLiquidacionImpuestoImporDataAccess() {
		return detalleliquidacionimpuestoimporDataAccess;
	}
	
	public void setDetalleLiquidacionImpuestoImporDataAccess(DetalleLiquidacionImpuestoImporDataAccess newdetalleliquidacionimpuestoimporDataAccess) {
		this.detalleliquidacionimpuestoimporDataAccess = newdetalleliquidacionimpuestoimporDataAccess;
	}
	
	public List<DetalleLiquidacionImpuestoImpor> getDetalleLiquidacionImpuestoImpors() throws Exception {		
		this.quitarDetalleLiquidacionImpuestoImporsNulos();
		
		DetalleLiquidacionImpuestoImporLogicAdditional.checkDetalleLiquidacionImpuestoImporToGets(detalleliquidacionimpuestoimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporLocal: detalleliquidacionimpuestoimpors ) {
			DetalleLiquidacionImpuestoImporLogicAdditional.updateDetalleLiquidacionImpuestoImporToGet(detalleliquidacionimpuestoimporLocal,this.arrDatoGeneral);
		}
		
		return detalleliquidacionimpuestoimpors;
	}
	
	public void setDetalleLiquidacionImpuestoImpors(List<DetalleLiquidacionImpuestoImpor> newDetalleLiquidacionImpuestoImpors) {
		this.detalleliquidacionimpuestoimpors = newDetalleLiquidacionImpuestoImpors;
	}
	
	public Object getDetalleLiquidacionImpuestoImporObject() {	
		this.detalleliquidacionimpuestoimporObject=this.detalleliquidacionimpuestoimporDataAccess.getEntityObject();
		return this.detalleliquidacionimpuestoimporObject;
	}
		
	public void setDetalleLiquidacionImpuestoImporObject(Object newDetalleLiquidacionImpuestoImporObject) {
		this.detalleliquidacionimpuestoimporObject = newDetalleLiquidacionImpuestoImporObject;
	}
	
	public List<Object> getDetalleLiquidacionImpuestoImporsObject() {		
		this.detalleliquidacionimpuestoimporsObject=this.detalleliquidacionimpuestoimporDataAccess.getEntitiesObject();
		return this.detalleliquidacionimpuestoimporsObject;
	}
		
	public void setDetalleLiquidacionImpuestoImporsObject(List<Object> newDetalleLiquidacionImpuestoImporsObject) {
		this.detalleliquidacionimpuestoimporsObject = newDetalleLiquidacionImpuestoImporsObject;
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
		
		if(this.detalleliquidacionimpuestoimporDataAccess!=null) {
			this.detalleliquidacionimpuestoimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleliquidacionimpuestoimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleliquidacionimpuestoimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleliquidacionimpuestoimpor=detalleliquidacionimpuestoimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleliquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpor);
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
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		  		  
        try {
			
			detalleliquidacionimpuestoimpor=detalleliquidacionimpuestoimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleliquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleliquidacionimpuestoimpor=detalleliquidacionimpuestoimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleliquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpor);
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
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		  		  
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
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		  		  
        try {
			
			detalleliquidacionimpuestoimpor=detalleliquidacionimpuestoimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleliquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		  		  
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
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleliquidacionimpuestoimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleliquidacionimpuestoimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleliquidacionimpuestoimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleliquidacionimpuestoimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleliquidacionimpuestoimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleliquidacionimpuestoimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
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
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		  		  
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
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		  		  
        try {			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		  		  
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
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
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
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		  		  
        try {
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
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
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
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
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpor=detalleliquidacionimpuestoimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpor);
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
		detalleliquidacionimpuestoimpor = new  DetalleLiquidacionImpuestoImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpor=detalleliquidacionimpuestoimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
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
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		  		  
        try {
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleLiquidacionImpuestoImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getTodosDetalleLiquidacionImpuestoImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
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
	
	public  void  getTodosDetalleLiquidacionImpuestoImpors(String sFinalQuery,Pagination pagination)throws Exception {
		detalleliquidacionimpuestoimpors = new  ArrayList<DetalleLiquidacionImpuestoImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleliquidacionimpuestoimpor.getIsNew() || detalleliquidacionimpuestoimpor.getIsChanged()) { 
			this.invalidValues = detalleliquidacionimpuestoimporValidator.getInvalidValues(detalleliquidacionimpuestoimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleliquidacionimpuestoimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleLiquidacionImpuestoImpor(List<DetalleLiquidacionImpuestoImpor> DetalleLiquidacionImpuestoImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporLocal:detalleliquidacionimpuestoimpors) {				
			estaValidadoObjeto=this.validarGuardarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleLiquidacionImpuestoImpor(List<DetalleLiquidacionImpuestoImpor> DetalleLiquidacionImpuestoImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleLiquidacionImpuestoImpor(DetalleLiquidacionImpuestoImpor DetalleLiquidacionImpuestoImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleliquidacionimpuestoimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleLiquidacionImpuestoImporConstantesFunciones.getDetalleLiquidacionImpuestoImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleliquidacionimpuestoimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleLiquidacionImpuestoImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleLiquidacionImpuestoImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleLiquidacionImpuestoImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-saveDetalleLiquidacionImpuestoImporWithConnection");connexion.begin();			
			
			DetalleLiquidacionImpuestoImporLogicAdditional.checkDetalleLiquidacionImpuestoImporToSave(this.detalleliquidacionimpuestoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleLiquidacionImpuestoImporLogicAdditional.updateDetalleLiquidacionImpuestoImporToSave(this.detalleliquidacionimpuestoimpor,this.arrDatoGeneral);
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleliquidacionimpuestoimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleLiquidacionImpuestoImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpor)) {
				DetalleLiquidacionImpuestoImporDataAccess.save(this.detalleliquidacionimpuestoimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleliquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleLiquidacionImpuestoImporLogicAdditional.checkDetalleLiquidacionImpuestoImporToSaveAfter(this.detalleliquidacionimpuestoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleLiquidacionImpuestoImpor();
			
			connexion.commit();			
			
			if(this.detalleliquidacionimpuestoimpor.getIsDeleted()) {
				this.detalleliquidacionimpuestoimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleLiquidacionImpuestoImpor()throws Exception {	
		try {	
			
			DetalleLiquidacionImpuestoImporLogicAdditional.checkDetalleLiquidacionImpuestoImporToSave(this.detalleliquidacionimpuestoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleLiquidacionImpuestoImporLogicAdditional.updateDetalleLiquidacionImpuestoImporToSave(this.detalleliquidacionimpuestoimpor,this.arrDatoGeneral);
			
			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleliquidacionimpuestoimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpor)) {			
				DetalleLiquidacionImpuestoImporDataAccess.save(this.detalleliquidacionimpuestoimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleliquidacionimpuestoimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleLiquidacionImpuestoImporLogicAdditional.checkDetalleLiquidacionImpuestoImporToSaveAfter(this.detalleliquidacionimpuestoimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleliquidacionimpuestoimpor.getIsDeleted()) {
				this.detalleliquidacionimpuestoimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleLiquidacionImpuestoImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-saveDetalleLiquidacionImpuestoImporsWithConnection");connexion.begin();			
			
			DetalleLiquidacionImpuestoImporLogicAdditional.checkDetalleLiquidacionImpuestoImporToSaves(detalleliquidacionimpuestoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleLiquidacionImpuestoImpors();
			
			Boolean validadoTodosDetalleLiquidacionImpuestoImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporLocal:detalleliquidacionimpuestoimpors) {		
				if(detalleliquidacionimpuestoimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleLiquidacionImpuestoImporLogicAdditional.updateDetalleLiquidacionImpuestoImporToSave(detalleliquidacionimpuestoimporLocal,this.arrDatoGeneral);
	        	
				DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleliquidacionimpuestoimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporLocal)) {
					DetalleLiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimporLocal, connexion);				
				} else {
					validadoTodosDetalleLiquidacionImpuestoImpor=false;
				}
			}
			
			if(!validadoTodosDetalleLiquidacionImpuestoImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleLiquidacionImpuestoImporLogicAdditional.checkDetalleLiquidacionImpuestoImporToSavesAfter(detalleliquidacionimpuestoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleLiquidacionImpuestoImpors();
			
			connexion.commit();		
			
			this.quitarDetalleLiquidacionImpuestoImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleLiquidacionImpuestoImpors()throws Exception {				
		 try {	
			DetalleLiquidacionImpuestoImporLogicAdditional.checkDetalleLiquidacionImpuestoImporToSaves(detalleliquidacionimpuestoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleLiquidacionImpuestoImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporLocal:detalleliquidacionimpuestoimpors) {				
				if(detalleliquidacionimpuestoimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleLiquidacionImpuestoImporLogicAdditional.updateDetalleLiquidacionImpuestoImporToSave(detalleliquidacionimpuestoimporLocal,this.arrDatoGeneral);
	        	
				DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleliquidacionimpuestoimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporLocal)) {				
					DetalleLiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimporLocal, connexion);				
				} else {
					validadoTodosDetalleLiquidacionImpuestoImpor=false;
				}
			}
			
			if(!validadoTodosDetalleLiquidacionImpuestoImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleLiquidacionImpuestoImporLogicAdditional.checkDetalleLiquidacionImpuestoImporToSavesAfter(detalleliquidacionimpuestoimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleLiquidacionImpuestoImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleLiquidacionImpuestoImporParameterReturnGeneral procesarAccionDetalleLiquidacionImpuestoImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DetalleLiquidacionImpuestoImporParameterReturnGeneral detalleliquidacionimpuestoimporParameterGeneral)throws Exception {
		 try {	
			DetalleLiquidacionImpuestoImporParameterReturnGeneral detalleliquidacionimpuestoimporReturnGeneral=new DetalleLiquidacionImpuestoImporParameterReturnGeneral();
	
			DetalleLiquidacionImpuestoImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleliquidacionimpuestoimpors,detalleliquidacionimpuestoimporParameterGeneral,detalleliquidacionimpuestoimporReturnGeneral);
			
			return detalleliquidacionimpuestoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleLiquidacionImpuestoImporParameterReturnGeneral procesarAccionDetalleLiquidacionImpuestoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DetalleLiquidacionImpuestoImporParameterReturnGeneral detalleliquidacionimpuestoimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-procesarAccionDetalleLiquidacionImpuestoImporsWithConnection");connexion.begin();			
			
			DetalleLiquidacionImpuestoImporParameterReturnGeneral detalleliquidacionimpuestoimporReturnGeneral=new DetalleLiquidacionImpuestoImporParameterReturnGeneral();
	
			DetalleLiquidacionImpuestoImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleliquidacionimpuestoimpors,detalleliquidacionimpuestoimporParameterGeneral,detalleliquidacionimpuestoimporReturnGeneral);
			
			this.connexion.commit();
			
			return detalleliquidacionimpuestoimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleLiquidacionImpuestoImporParameterReturnGeneral procesarEventosDetalleLiquidacionImpuestoImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,DetalleLiquidacionImpuestoImporParameterReturnGeneral detalleliquidacionimpuestoimporParameterGeneral,Boolean isEsNuevoDetalleLiquidacionImpuestoImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleLiquidacionImpuestoImporParameterReturnGeneral detalleliquidacionimpuestoimporReturnGeneral=new DetalleLiquidacionImpuestoImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleliquidacionimpuestoimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleLiquidacionImpuestoImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleliquidacionimpuestoimpors,detalleliquidacionimpuestoimpor,detalleliquidacionimpuestoimporParameterGeneral,detalleliquidacionimpuestoimporReturnGeneral,isEsNuevoDetalleLiquidacionImpuestoImpor,clases);
			
			return detalleliquidacionimpuestoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleLiquidacionImpuestoImporParameterReturnGeneral procesarEventosDetalleLiquidacionImpuestoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,DetalleLiquidacionImpuestoImporParameterReturnGeneral detalleliquidacionimpuestoimporParameterGeneral,Boolean isEsNuevoDetalleLiquidacionImpuestoImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-procesarEventosDetalleLiquidacionImpuestoImporsWithConnection");connexion.begin();			
			
			DetalleLiquidacionImpuestoImporParameterReturnGeneral detalleliquidacionimpuestoimporReturnGeneral=new DetalleLiquidacionImpuestoImporParameterReturnGeneral();
	
			detalleliquidacionimpuestoimporReturnGeneral.setDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleliquidacionimpuestoimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleLiquidacionImpuestoImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleliquidacionimpuestoimpors,detalleliquidacionimpuestoimpor,detalleliquidacionimpuestoimporParameterGeneral,detalleliquidacionimpuestoimporReturnGeneral,isEsNuevoDetalleLiquidacionImpuestoImpor,clases);
			
			this.connexion.commit();
			
			return detalleliquidacionimpuestoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleLiquidacionImpuestoImporParameterReturnGeneral procesarImportacionDetalleLiquidacionImpuestoImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleLiquidacionImpuestoImporParameterReturnGeneral detalleliquidacionimpuestoimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-procesarImportacionDetalleLiquidacionImpuestoImporsWithConnection");connexion.begin();			
			
			DetalleLiquidacionImpuestoImporParameterReturnGeneral detalleliquidacionimpuestoimporReturnGeneral=new DetalleLiquidacionImpuestoImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleliquidacionimpuestoimpors=new ArrayList<DetalleLiquidacionImpuestoImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleliquidacionimpuestoimpor=new DetalleLiquidacionImpuestoImpor();
				
				
				if(conColumnasBase) {this.detalleliquidacionimpuestoimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleliquidacionimpuestoimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleliquidacionimpuestoimpor.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setfob(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setporcentaje_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setporcentaje_arancel(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setporcentaje_aplicar(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setseguro(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setbase_imponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setvalor_arancel(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setvalor_fodi(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setvalor_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setnumero_comprobante(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setporcentaje_fodi(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleliquidacionimpuestoimpor.setvalor_imponible(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detalleliquidacionimpuestoimpors.add(this.detalleliquidacionimpuestoimpor);
			}
			
			this.saveDetalleLiquidacionImpuestoImpors();
			
			this.connexion.commit();
			
			detalleliquidacionimpuestoimporReturnGeneral.setConRetornoEstaProcesado(true);
			detalleliquidacionimpuestoimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleliquidacionimpuestoimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleLiquidacionImpuestoImporsEliminados() throws Exception {				
		
		List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimporsAux= new ArrayList<DetalleLiquidacionImpuestoImpor>();
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:detalleliquidacionimpuestoimpors) {
			if(!detalleliquidacionimpuestoimpor.getIsDeleted()) {
				detalleliquidacionimpuestoimporsAux.add(detalleliquidacionimpuestoimpor);
			}
		}
		
		detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporsAux;
	}
	
	public void quitarDetalleLiquidacionImpuestoImporsNulos() throws Exception {				
		
		List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimporsAux= new ArrayList<DetalleLiquidacionImpuestoImpor>();
		
		for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor : this.detalleliquidacionimpuestoimpors) {
			if(detalleliquidacionimpuestoimpor==null) {
				detalleliquidacionimpuestoimporsAux.add(detalleliquidacionimpuestoimpor);
			}
		}
		
		//this.detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporsAux;
		
		this.detalleliquidacionimpuestoimpors.removeAll(detalleliquidacionimpuestoimporsAux);
	}
	
	public void getSetVersionRowDetalleLiquidacionImpuestoImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleliquidacionimpuestoimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleliquidacionimpuestoimpor.getIsDeleted() || (detalleliquidacionimpuestoimpor.getIsChanged()&&!detalleliquidacionimpuestoimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleliquidacionimpuestoimporDataAccess.getSetVersionRowDetalleLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor.getId());
				
				if(!detalleliquidacionimpuestoimpor.getVersionRow().equals(timestamp)) {	
					detalleliquidacionimpuestoimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleliquidacionimpuestoimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleLiquidacionImpuestoImpor()throws Exception {	
		
		if(detalleliquidacionimpuestoimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleliquidacionimpuestoimpor.getIsDeleted() || (detalleliquidacionimpuestoimpor.getIsChanged()&&!detalleliquidacionimpuestoimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleliquidacionimpuestoimporDataAccess.getSetVersionRowDetalleLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor.getId());
			
			try {							
				if(!detalleliquidacionimpuestoimpor.getVersionRow().equals(timestamp)) {	
					detalleliquidacionimpuestoimpor.setVersionRow(timestamp);
				}
				
				detalleliquidacionimpuestoimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleLiquidacionImpuestoImporsWithConnection()throws Exception {	
		if(detalleliquidacionimpuestoimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporAux:detalleliquidacionimpuestoimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleliquidacionimpuestoimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleliquidacionimpuestoimporAux.getIsDeleted() || (detalleliquidacionimpuestoimporAux.getIsChanged()&&!detalleliquidacionimpuestoimporAux.getIsNew())) {
						
						timestamp=detalleliquidacionimpuestoimporDataAccess.getSetVersionRowDetalleLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimporAux.getId());
						
						if(!detalleliquidacionimpuestoimpor.getVersionRow().equals(timestamp)) {	
							detalleliquidacionimpuestoimporAux.setVersionRow(timestamp);
						}
								
						detalleliquidacionimpuestoimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleLiquidacionImpuestoImpors()throws Exception {	
		if(detalleliquidacionimpuestoimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporAux:detalleliquidacionimpuestoimpors) {
					if(detalleliquidacionimpuestoimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleliquidacionimpuestoimporAux.getIsDeleted() || (detalleliquidacionimpuestoimporAux.getIsChanged()&&!detalleliquidacionimpuestoimporAux.getIsNew())) {
						
						timestamp=detalleliquidacionimpuestoimporDataAccess.getSetVersionRowDetalleLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimporAux.getId());
						
						if(!detalleliquidacionimpuestoimporAux.getVersionRow().equals(timestamp)) {	
							detalleliquidacionimpuestoimporAux.setVersionRow(timestamp);
						}
						
													
						detalleliquidacionimpuestoimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleLiquidacionImpuestoImporParameterReturnGeneral cargarCombosLoteForeignKeyDetalleLiquidacionImpuestoImporWithConnection(String finalQueryGlobalLiquidacionImpuestoImpor,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal) throws Exception {
		DetalleLiquidacionImpuestoImporParameterReturnGeneral  detalleliquidacionimpuestoimporReturnGeneral =new DetalleLiquidacionImpuestoImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleLiquidacionImpuestoImporWithConnection");connexion.begin();
			
			detalleliquidacionimpuestoimporReturnGeneral =new DetalleLiquidacionImpuestoImporParameterReturnGeneral();
			
			

			List<LiquidacionImpuestoImpor> liquidacionimpuestoimporsForeignKey=new ArrayList<LiquidacionImpuestoImpor>();
			LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic=new LiquidacionImpuestoImporLogic();
			liquidacionimpuestoimporLogic.setConnexion(this.connexion);
			liquidacionimpuestoimporLogic.getLiquidacionImpuestoImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLiquidacionImpuestoImpor.equals("NONE")) {
				liquidacionimpuestoimporLogic.getTodosLiquidacionImpuestoImpors(finalQueryGlobalLiquidacionImpuestoImpor,new Pagination());
				liquidacionimpuestoimporsForeignKey=liquidacionimpuestoimporLogic.getLiquidacionImpuestoImpors();
			}

			detalleliquidacionimpuestoimporReturnGeneral.setliquidacionimpuestoimporsForeignKey(liquidacionimpuestoimporsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleliquidacionimpuestoimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleliquidacionimpuestoimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleliquidacionimpuestoimporReturnGeneral;
	}
	
	public DetalleLiquidacionImpuestoImporParameterReturnGeneral cargarCombosLoteForeignKeyDetalleLiquidacionImpuestoImpor(String finalQueryGlobalLiquidacionImpuestoImpor,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal) throws Exception {
		DetalleLiquidacionImpuestoImporParameterReturnGeneral  detalleliquidacionimpuestoimporReturnGeneral =new DetalleLiquidacionImpuestoImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleliquidacionimpuestoimporReturnGeneral =new DetalleLiquidacionImpuestoImporParameterReturnGeneral();
			
			

			List<LiquidacionImpuestoImpor> liquidacionimpuestoimporsForeignKey=new ArrayList<LiquidacionImpuestoImpor>();
			LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic=new LiquidacionImpuestoImporLogic();
			liquidacionimpuestoimporLogic.setConnexion(this.connexion);
			liquidacionimpuestoimporLogic.getLiquidacionImpuestoImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLiquidacionImpuestoImpor.equals("NONE")) {
				liquidacionimpuestoimporLogic.getTodosLiquidacionImpuestoImpors(finalQueryGlobalLiquidacionImpuestoImpor,new Pagination());
				liquidacionimpuestoimporsForeignKey=liquidacionimpuestoimporLogic.getLiquidacionImpuestoImpors();
			}

			detalleliquidacionimpuestoimporReturnGeneral.setliquidacionimpuestoimporsForeignKey(liquidacionimpuestoimporsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleliquidacionimpuestoimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleliquidacionimpuestoimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleliquidacionimpuestoimporReturnGeneral;
	}
	
	
	public void deepLoad(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleLiquidacionImpuestoImporLogicAdditional.updateDetalleLiquidacionImpuestoImporToGet(detalleliquidacionimpuestoimpor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleliquidacionimpuestoimpor.setLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporDataAccess.getLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor));
		detalleliquidacionimpuestoimpor.setEmpresa(detalleliquidacionimpuestoimporDataAccess.getEmpresa(connexion,detalleliquidacionimpuestoimpor));
		detalleliquidacionimpuestoimpor.setSucursal(detalleliquidacionimpuestoimporDataAccess.getSucursal(connexion,detalleliquidacionimpuestoimpor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpuestoImpor.class)) {
				detalleliquidacionimpuestoimpor.setLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporDataAccess.getLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleliquidacionimpuestoimpor.setEmpresa(detalleliquidacionimpuestoimporDataAccess.getEmpresa(connexion,detalleliquidacionimpuestoimpor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleliquidacionimpuestoimpor.setSucursal(detalleliquidacionimpuestoimporDataAccess.getSucursal(connexion,detalleliquidacionimpuestoimpor));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpuestoImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpuestoimpor.setLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporDataAccess.getLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpuestoimpor.setEmpresa(detalleliquidacionimpuestoimporDataAccess.getEmpresa(connexion,detalleliquidacionimpuestoimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpuestoimpor.setSucursal(detalleliquidacionimpuestoimporDataAccess.getSucursal(connexion,detalleliquidacionimpuestoimpor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleliquidacionimpuestoimpor.setLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporDataAccess.getLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor));
		LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(connexion);
		liquidacionimpuestoimporLogic.deepLoad(detalleliquidacionimpuestoimpor.getLiquidacionImpuestoImpor(),isDeep,deepLoadType,clases);
				
		detalleliquidacionimpuestoimpor.setEmpresa(detalleliquidacionimpuestoimporDataAccess.getEmpresa(connexion,detalleliquidacionimpuestoimpor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleliquidacionimpuestoimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleliquidacionimpuestoimpor.setSucursal(detalleliquidacionimpuestoimporDataAccess.getSucursal(connexion,detalleliquidacionimpuestoimpor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleliquidacionimpuestoimpor.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpuestoImpor.class)) {
				detalleliquidacionimpuestoimpor.setLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporDataAccess.getLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor));
				LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(connexion);
				liquidacionimpuestoimporLogic.deepLoad(detalleliquidacionimpuestoimpor.getLiquidacionImpuestoImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleliquidacionimpuestoimpor.setEmpresa(detalleliquidacionimpuestoimporDataAccess.getEmpresa(connexion,detalleliquidacionimpuestoimpor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleliquidacionimpuestoimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleliquidacionimpuestoimpor.setSucursal(detalleliquidacionimpuestoimporDataAccess.getSucursal(connexion,detalleliquidacionimpuestoimpor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleliquidacionimpuestoimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpuestoImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpuestoimpor.setLiquidacionImpuestoImpor(detalleliquidacionimpuestoimporDataAccess.getLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor));
			LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(connexion);
			liquidacionimpuestoimporLogic.deepLoad(detalleliquidacionimpuestoimpor.getLiquidacionImpuestoImpor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpuestoimpor.setEmpresa(detalleliquidacionimpuestoimporDataAccess.getEmpresa(connexion,detalleliquidacionimpuestoimpor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleliquidacionimpuestoimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleliquidacionimpuestoimpor.setSucursal(detalleliquidacionimpuestoimporDataAccess.getSucursal(connexion,detalleliquidacionimpuestoimpor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleliquidacionimpuestoimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleLiquidacionImpuestoImporLogicAdditional.updateDetalleLiquidacionImpuestoImporToSave(detalleliquidacionimpuestoimpor,this.arrDatoGeneral);
			
DetalleLiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimpor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		LiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimpor.getLiquidacionImpuestoImpor(),connexion);

		EmpresaDataAccess.save(detalleliquidacionimpuestoimpor.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleliquidacionimpuestoimpor.getSucursal(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpuestoImpor.class)) {
				LiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimpor.getLiquidacionImpuestoImpor(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleliquidacionimpuestoimpor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleliquidacionimpuestoimpor.getSucursal(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		LiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimpor.getLiquidacionImpuestoImpor(),connexion);
		LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(connexion);
		liquidacionimpuestoimporLogic.deepLoad(detalleliquidacionimpuestoimpor.getLiquidacionImpuestoImpor(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detalleliquidacionimpuestoimpor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleliquidacionimpuestoimpor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleliquidacionimpuestoimpor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleliquidacionimpuestoimpor.getSucursal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpuestoImpor.class)) {
				LiquidacionImpuestoImporDataAccess.save(detalleliquidacionimpuestoimpor.getLiquidacionImpuestoImpor(),connexion);
				LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(connexion);
				liquidacionimpuestoimporLogic.deepSave(detalleliquidacionimpuestoimpor.getLiquidacionImpuestoImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleliquidacionimpuestoimpor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleliquidacionimpuestoimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleliquidacionimpuestoimpor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleliquidacionimpuestoimpor.getSucursal(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpor);
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
			this.deepLoad(this.detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleliquidacionimpuestoimpors!=null) {
				for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:detalleliquidacionimpuestoimpors) {
					this.deepLoad(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
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
			if(detalleliquidacionimpuestoimpors!=null) {
				for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:detalleliquidacionimpuestoimpors) {
					this.deepLoad(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpors);
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
			this.getNewConnexionToDeep(DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleliquidacionimpuestoimpors!=null) {
				for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:detalleliquidacionimpuestoimpors) {
					this.deepSave(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);
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
			if(detalleliquidacionimpuestoimpors!=null) {
				for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor:detalleliquidacionimpuestoimpors) {
					this.deepSave(detalleliquidacionimpuestoimpor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleLiquidacionImpuestoImporsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleLiquidacionImpuestoImporsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleLiquidacionImpuestoImporsFK_IdLiquidacionImpuestoImporWithConnection(String sFinalQuery,Pagination pagination,Long id_liquidacion_impuesto_impor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLiquidacionImpuestoImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLiquidacionImpuestoImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_liquidacion_impuesto_impor,DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLiquidacionImpuestoImpor);

			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLiquidacionImpuestoImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleLiquidacionImpuestoImporsFK_IdLiquidacionImpuestoImpor(String sFinalQuery,Pagination pagination,Long id_liquidacion_impuesto_impor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLiquidacionImpuestoImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLiquidacionImpuestoImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_liquidacion_impuesto_impor,DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLiquidacionImpuestoImpor);

			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLiquidacionImpuestoImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleLiquidacionImpuestoImporsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleLiquidacionImpuestoImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleLiquidacionImpuestoImporsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleLiquidacionImpuestoImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleLiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpuestoImpor(this.detalleliquidacionimpuestoimpors);
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
			if(DetalleLiquidacionImpuestoImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleLiquidacionImpuestoImporConstantesFunciones.ISCONAUDITORIA) {
				if(detalleliquidacionimpuestoimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME, detalleliquidacionimpuestoimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleLiquidacionImpuestoImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleLiquidacionImpuestoImporLogic.registrarAuditoriaDetallesDetalleLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleliquidacionimpuestoimpor.getIsDeleted()) {
					/*if(!detalleliquidacionimpuestoimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME, detalleliquidacionimpuestoimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleLiquidacionImpuestoImporLogic.registrarAuditoriaDetallesDetalleLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME, detalleliquidacionimpuestoimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleliquidacionimpuestoimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleLiquidacionImpuestoImporDataAccess.TABLENAME, detalleliquidacionimpuestoimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleLiquidacionImpuestoImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleLiquidacionImpuestoImporLogic.registrarAuditoriaDetallesDetalleLiquidacionImpuestoImpor(connexion,detalleliquidacionimpuestoimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleLiquidacionImpuestoImpor(Connexion connexion,DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getid_liquidacion_impuesto_impor().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getid_liquidacion_impuesto_impor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getid_liquidacion_impuesto_impor()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getid_liquidacion_impuesto_impor().toString();
				}
				if(detalleliquidacionimpuestoimpor.getid_liquidacion_impuesto_impor()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getid_liquidacion_impuesto_impor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.IDLIQUIDACIONIMPUESTOIMPOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getid_empresa().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getid_empresa().toString();
				}
				if(detalleliquidacionimpuestoimpor.getid_empresa()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getid_sucursal().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getid_sucursal().toString();
				}
				if(detalleliquidacionimpuestoimpor.getid_sucursal()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getcantidad().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getcantidad()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getcantidad().toString();
				}
				if(detalleliquidacionimpuestoimpor.getcantidad()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getvalor().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor().toString();
				}
				if(detalleliquidacionimpuestoimpor.getvalor()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getfob().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getfob()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getfob()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getfob().toString();
				}
				if(detalleliquidacionimpuestoimpor.getfob()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getfob().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.FOB,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getporcentaje_iva().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_iva()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_iva().toString();
				}
				if(detalleliquidacionimpuestoimpor.getporcentaje_iva()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getporcentaje_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEIVA,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getporcentaje_arancel().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_arancel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_arancel()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_arancel().toString();
				}
				if(detalleliquidacionimpuestoimpor.getporcentaje_arancel()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getporcentaje_arancel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEARANCEL,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getporcentaje_aplicar().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_aplicar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_aplicar()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_aplicar().toString();
				}
				if(detalleliquidacionimpuestoimpor.getporcentaje_aplicar()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getporcentaje_aplicar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEAPLICAR,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getflete().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getflete()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getflete().toString();
				}
				if(detalleliquidacionimpuestoimpor.getflete()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getseguro().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getseguro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getseguro()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getseguro().toString();
				}
				if(detalleliquidacionimpuestoimpor.getseguro()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getseguro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.SEGURO,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getbase_imponible().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getbase_imponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getbase_imponible()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getbase_imponible().toString();
				}
				if(detalleliquidacionimpuestoimpor.getbase_imponible()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getbase_imponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.BASEIMPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getvalor_arancel().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_arancel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_arancel()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_arancel().toString();
				}
				if(detalleliquidacionimpuestoimpor.getvalor_arancel()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getvalor_arancel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.VALORARANCEL,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getvalor_fodi().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_fodi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_fodi()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_fodi().toString();
				}
				if(detalleliquidacionimpuestoimpor.getvalor_fodi()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getvalor_fodi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.VALORFODI,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getvalor_iva().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_iva()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_iva().toString();
				}
				if(detalleliquidacionimpuestoimpor.getvalor_iva()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getvalor_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIVA,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getnumero_comprobante().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getnumero_comprobante().toString();
				}
				if(detalleliquidacionimpuestoimpor.getnumero_comprobante()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getnumero_comprobante().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getporcentaje_fodi().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_fodi()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_fodi()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getporcentaje_fodi().toString();
				}
				if(detalleliquidacionimpuestoimpor.getporcentaje_fodi()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getporcentaje_fodi().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.PORCENTAJEFODI,strValorActual,strValorNuevo);
			}	
			
			if(detalleliquidacionimpuestoimpor.getIsNew()||!detalleliquidacionimpuestoimpor.getvalor_imponible().equals(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_imponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_imponible()!=null)
				{
					strValorActual=detalleliquidacionimpuestoimpor.getDetalleLiquidacionImpuestoImporOriginal().getvalor_imponible().toString();
				}
				if(detalleliquidacionimpuestoimpor.getvalor_imponible()!=null)
				{
					strValorNuevo=detalleliquidacionimpuestoimpor.getvalor_imponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleLiquidacionImpuestoImporConstantesFunciones.VALORIMPONIBLE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleLiquidacionImpuestoImporRelacionesWithConnection(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor) throws Exception {

		if(!detalleliquidacionimpuestoimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleLiquidacionImpuestoImporRelacionesBase(detalleliquidacionimpuestoimpor,true);
		}
	}

	public void saveDetalleLiquidacionImpuestoImporRelaciones(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor)throws Exception {

		if(!detalleliquidacionimpuestoimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleLiquidacionImpuestoImporRelacionesBase(detalleliquidacionimpuestoimpor,false);
		}
	}

	public void saveDetalleLiquidacionImpuestoImporRelacionesBase(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleLiquidacionImpuestoImpor-saveRelacionesWithConnection");}
	

			this.setDetalleLiquidacionImpuestoImpor(detalleliquidacionimpuestoimpor);

			if(DetalleLiquidacionImpuestoImporLogicAdditional.validarSaveRelaciones(detalleliquidacionimpuestoimpor,this)) {

				DetalleLiquidacionImpuestoImporLogicAdditional.updateRelacionesToSave(detalleliquidacionimpuestoimpor,this);

				if((detalleliquidacionimpuestoimpor.getIsNew()||detalleliquidacionimpuestoimpor.getIsChanged())&&!detalleliquidacionimpuestoimpor.getIsDeleted()) {
					this.saveDetalleLiquidacionImpuestoImpor();
					this.saveDetalleLiquidacionImpuestoImporRelacionesDetalles();

				} else if(detalleliquidacionimpuestoimpor.getIsDeleted()) {
					this.saveDetalleLiquidacionImpuestoImporRelacionesDetalles();
					this.saveDetalleLiquidacionImpuestoImpor();
				}

				DetalleLiquidacionImpuestoImporLogicAdditional.updateRelacionesToSaveAfter(detalleliquidacionimpuestoimpor,this);

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
	
	
	private void saveDetalleLiquidacionImpuestoImporRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleLiquidacionImpuestoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleLiquidacionImpuestoImporConstantesFunciones.getClassesForeignKeysOfDetalleLiquidacionImpuestoImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleLiquidacionImpuestoImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleLiquidacionImpuestoImporConstantesFunciones.getClassesRelationshipsOfDetalleLiquidacionImpuestoImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
