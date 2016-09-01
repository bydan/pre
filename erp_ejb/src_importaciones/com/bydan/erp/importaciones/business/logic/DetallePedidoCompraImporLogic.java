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
import com.bydan.erp.importaciones.util.DetallePedidoCompraImporConstantesFunciones;
import com.bydan.erp.importaciones.util.DetallePedidoCompraImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.DetallePedidoCompraImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.DetallePedidoCompraImpor;
import com.bydan.erp.importaciones.business.logic.DetallePedidoCompraImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetallePedidoCompraImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetallePedidoCompraImporLogic.class);
	
	protected DetallePedidoCompraImporDataAccess detallepedidocompraimporDataAccess; 	
	protected DetallePedidoCompraImpor detallepedidocompraimpor;
	protected List<DetallePedidoCompraImpor> detallepedidocompraimpors;
	protected Object detallepedidocompraimporObject;	
	protected List<Object> detallepedidocompraimporsObject;
	
	public static ClassValidator<DetallePedidoCompraImpor> detallepedidocompraimporValidator = new ClassValidator<DetallePedidoCompraImpor>(DetallePedidoCompraImpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetallePedidoCompraImporLogicAdditional detallepedidocompraimporLogicAdditional=null;
	
	public DetallePedidoCompraImporLogicAdditional getDetallePedidoCompraImporLogicAdditional() {
		return this.detallepedidocompraimporLogicAdditional;
	}
	
	public void setDetallePedidoCompraImporLogicAdditional(DetallePedidoCompraImporLogicAdditional detallepedidocompraimporLogicAdditional) {
		try {
			this.detallepedidocompraimporLogicAdditional=detallepedidocompraimporLogicAdditional;
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
	
	
	
	
	public  DetallePedidoCompraImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detallepedidocompraimporDataAccess = new DetallePedidoCompraImporDataAccess();
			
			this.detallepedidocompraimpors= new ArrayList<DetallePedidoCompraImpor>();
			this.detallepedidocompraimpor= new DetallePedidoCompraImpor();
			
			this.detallepedidocompraimporObject=new Object();
			this.detallepedidocompraimporsObject=new ArrayList<Object>();
				
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
			
			this.detallepedidocompraimporDataAccess.setConnexionType(this.connexionType);
			this.detallepedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetallePedidoCompraImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detallepedidocompraimporDataAccess = new DetallePedidoCompraImporDataAccess();
			this.detallepedidocompraimpors= new ArrayList<DetallePedidoCompraImpor>();
			this.detallepedidocompraimpor= new DetallePedidoCompraImpor();
			this.detallepedidocompraimporObject=new Object();
			this.detallepedidocompraimporsObject=new ArrayList<Object>();
			
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
			
			this.detallepedidocompraimporDataAccess.setConnexionType(this.connexionType);
			this.detallepedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetallePedidoCompraImpor getDetallePedidoCompraImpor() throws Exception {	
		DetallePedidoCompraImporLogicAdditional.checkDetallePedidoCompraImporToGet(detallepedidocompraimpor,this.datosCliente,this.arrDatoGeneral);
		DetallePedidoCompraImporLogicAdditional.updateDetallePedidoCompraImporToGet(detallepedidocompraimpor,this.arrDatoGeneral);
		
		return detallepedidocompraimpor;
	}
		
	public void setDetallePedidoCompraImpor(DetallePedidoCompraImpor newDetallePedidoCompraImpor) {
		this.detallepedidocompraimpor = newDetallePedidoCompraImpor;
	}
	
	public DetallePedidoCompraImporDataAccess getDetallePedidoCompraImporDataAccess() {
		return detallepedidocompraimporDataAccess;
	}
	
	public void setDetallePedidoCompraImporDataAccess(DetallePedidoCompraImporDataAccess newdetallepedidocompraimporDataAccess) {
		this.detallepedidocompraimporDataAccess = newdetallepedidocompraimporDataAccess;
	}
	
	public List<DetallePedidoCompraImpor> getDetallePedidoCompraImpors() throws Exception {		
		this.quitarDetallePedidoCompraImporsNulos();
		
		DetallePedidoCompraImporLogicAdditional.checkDetallePedidoCompraImporToGets(detallepedidocompraimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (DetallePedidoCompraImpor detallepedidocompraimporLocal: detallepedidocompraimpors ) {
			DetallePedidoCompraImporLogicAdditional.updateDetallePedidoCompraImporToGet(detallepedidocompraimporLocal,this.arrDatoGeneral);
		}
		
		return detallepedidocompraimpors;
	}
	
	public void setDetallePedidoCompraImpors(List<DetallePedidoCompraImpor> newDetallePedidoCompraImpors) {
		this.detallepedidocompraimpors = newDetallePedidoCompraImpors;
	}
	
	public Object getDetallePedidoCompraImporObject() {	
		this.detallepedidocompraimporObject=this.detallepedidocompraimporDataAccess.getEntityObject();
		return this.detallepedidocompraimporObject;
	}
		
	public void setDetallePedidoCompraImporObject(Object newDetallePedidoCompraImporObject) {
		this.detallepedidocompraimporObject = newDetallePedidoCompraImporObject;
	}
	
	public List<Object> getDetallePedidoCompraImporsObject() {		
		this.detallepedidocompraimporsObject=this.detallepedidocompraimporDataAccess.getEntitiesObject();
		return this.detallepedidocompraimporsObject;
	}
		
	public void setDetallePedidoCompraImporsObject(List<Object> newDetallePedidoCompraImporsObject) {
		this.detallepedidocompraimporsObject = newDetallePedidoCompraImporsObject;
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
		
		if(this.detallepedidocompraimporDataAccess!=null) {
			this.detallepedidocompraimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detallepedidocompraimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detallepedidocompraimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallepedidocompraimpor=detallepedidocompraimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpor);
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
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		  		  
        try {
			
			detallepedidocompraimpor=detallepedidocompraimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallepedidocompraimpor=detallepedidocompraimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpor);
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
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		  		  
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
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		  		  
        try {
			
			detallepedidocompraimpor=detallepedidocompraimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallepedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		  		  
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
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detallepedidocompraimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detallepedidocompraimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detallepedidocompraimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detallepedidocompraimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detallepedidocompraimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detallepedidocompraimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
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
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		  		  
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
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		  		  
        try {			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		  		  
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
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
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
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		  		  
        try {
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
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
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
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
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpor=detallepedidocompraimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpor);
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
		detallepedidocompraimpor = new  DetallePedidoCompraImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpor=detallepedidocompraimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
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
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		  		  
        try {
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetallePedidoCompraImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getTodosDetallePedidoCompraImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
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
	
	public  void  getTodosDetallePedidoCompraImpors(String sFinalQuery,Pagination pagination)throws Exception {
		detallepedidocompraimpors = new  ArrayList<DetallePedidoCompraImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetallePedidoCompraImpor(detallepedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetallePedidoCompraImpor(DetallePedidoCompraImpor detallepedidocompraimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(detallepedidocompraimpor.getIsNew() || detallepedidocompraimpor.getIsChanged()) { 
			this.invalidValues = detallepedidocompraimporValidator.getInvalidValues(detallepedidocompraimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallepedidocompraimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetallePedidoCompraImpor(List<DetallePedidoCompraImpor> DetallePedidoCompraImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetallePedidoCompraImpor detallepedidocompraimporLocal:detallepedidocompraimpors) {				
			estaValidadoObjeto=this.validarGuardarDetallePedidoCompraImpor(detallepedidocompraimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetallePedidoCompraImpor(List<DetallePedidoCompraImpor> DetallePedidoCompraImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePedidoCompraImpor(detallepedidocompraimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetallePedidoCompraImpor(DetallePedidoCompraImpor DetallePedidoCompraImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetallePedidoCompraImpor(detallepedidocompraimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetallePedidoCompraImpor detallepedidocompraimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallepedidocompraimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetallePedidoCompraImporConstantesFunciones.getDetallePedidoCompraImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallepedidocompraimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetallePedidoCompraImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetallePedidoCompraImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetallePedidoCompraImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-saveDetallePedidoCompraImporWithConnection");connexion.begin();			
			
			DetallePedidoCompraImporLogicAdditional.checkDetallePedidoCompraImporToSave(this.detallepedidocompraimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePedidoCompraImporLogicAdditional.updateDetallePedidoCompraImporToSave(this.detallepedidocompraimpor,this.arrDatoGeneral);
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallepedidocompraimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetallePedidoCompraImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePedidoCompraImpor(this.detallepedidocompraimpor)) {
				DetallePedidoCompraImporDataAccess.save(this.detallepedidocompraimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallepedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePedidoCompraImporLogicAdditional.checkDetallePedidoCompraImporToSaveAfter(this.detallepedidocompraimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePedidoCompraImpor();
			
			connexion.commit();			
			
			if(this.detallepedidocompraimpor.getIsDeleted()) {
				this.detallepedidocompraimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetallePedidoCompraImpor()throws Exception {	
		try {	
			
			DetallePedidoCompraImporLogicAdditional.checkDetallePedidoCompraImporToSave(this.detallepedidocompraimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetallePedidoCompraImporLogicAdditional.updateDetallePedidoCompraImporToSave(this.detallepedidocompraimpor,this.arrDatoGeneral);
			
			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallepedidocompraimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetallePedidoCompraImpor(this.detallepedidocompraimpor)) {			
				DetallePedidoCompraImporDataAccess.save(this.detallepedidocompraimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallepedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetallePedidoCompraImporLogicAdditional.checkDetallePedidoCompraImporToSaveAfter(this.detallepedidocompraimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallepedidocompraimpor.getIsDeleted()) {
				this.detallepedidocompraimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetallePedidoCompraImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-saveDetallePedidoCompraImporsWithConnection");connexion.begin();			
			
			DetallePedidoCompraImporLogicAdditional.checkDetallePedidoCompraImporToSaves(detallepedidocompraimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetallePedidoCompraImpors();
			
			Boolean validadoTodosDetallePedidoCompraImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePedidoCompraImpor detallepedidocompraimporLocal:detallepedidocompraimpors) {		
				if(detallepedidocompraimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePedidoCompraImporLogicAdditional.updateDetallePedidoCompraImporToSave(detallepedidocompraimporLocal,this.arrDatoGeneral);
	        	
				DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallepedidocompraimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePedidoCompraImpor(detallepedidocompraimporLocal)) {
					DetallePedidoCompraImporDataAccess.save(detallepedidocompraimporLocal, connexion);				
				} else {
					validadoTodosDetallePedidoCompraImpor=false;
				}
			}
			
			if(!validadoTodosDetallePedidoCompraImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePedidoCompraImporLogicAdditional.checkDetallePedidoCompraImporToSavesAfter(detallepedidocompraimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetallePedidoCompraImpors();
			
			connexion.commit();		
			
			this.quitarDetallePedidoCompraImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetallePedidoCompraImpors()throws Exception {				
		 try {	
			DetallePedidoCompraImporLogicAdditional.checkDetallePedidoCompraImporToSaves(detallepedidocompraimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetallePedidoCompraImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetallePedidoCompraImpor detallepedidocompraimporLocal:detallepedidocompraimpors) {				
				if(detallepedidocompraimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetallePedidoCompraImporLogicAdditional.updateDetallePedidoCompraImporToSave(detallepedidocompraimporLocal,this.arrDatoGeneral);
	        	
				DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detallepedidocompraimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetallePedidoCompraImpor(detallepedidocompraimporLocal)) {				
					DetallePedidoCompraImporDataAccess.save(detallepedidocompraimporLocal, connexion);				
				} else {
					validadoTodosDetallePedidoCompraImpor=false;
				}
			}
			
			if(!validadoTodosDetallePedidoCompraImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetallePedidoCompraImporLogicAdditional.checkDetallePedidoCompraImporToSavesAfter(detallepedidocompraimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetallePedidoCompraImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePedidoCompraImporParameterReturnGeneral procesarAccionDetallePedidoCompraImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePedidoCompraImpor> detallepedidocompraimpors,DetallePedidoCompraImporParameterReturnGeneral detallepedidocompraimporParameterGeneral)throws Exception {
		 try {	
			DetallePedidoCompraImporParameterReturnGeneral detallepedidocompraimporReturnGeneral=new DetallePedidoCompraImporParameterReturnGeneral();
	
			DetallePedidoCompraImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallepedidocompraimpors,detallepedidocompraimporParameterGeneral,detallepedidocompraimporReturnGeneral);
			
			return detallepedidocompraimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetallePedidoCompraImporParameterReturnGeneral procesarAccionDetallePedidoCompraImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetallePedidoCompraImpor> detallepedidocompraimpors,DetallePedidoCompraImporParameterReturnGeneral detallepedidocompraimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-procesarAccionDetallePedidoCompraImporsWithConnection");connexion.begin();			
			
			DetallePedidoCompraImporParameterReturnGeneral detallepedidocompraimporReturnGeneral=new DetallePedidoCompraImporParameterReturnGeneral();
	
			DetallePedidoCompraImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detallepedidocompraimpors,detallepedidocompraimporParameterGeneral,detallepedidocompraimporReturnGeneral);
			
			this.connexion.commit();
			
			return detallepedidocompraimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePedidoCompraImporParameterReturnGeneral procesarEventosDetallePedidoCompraImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePedidoCompraImpor> detallepedidocompraimpors,DetallePedidoCompraImpor detallepedidocompraimpor,DetallePedidoCompraImporParameterReturnGeneral detallepedidocompraimporParameterGeneral,Boolean isEsNuevoDetallePedidoCompraImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetallePedidoCompraImporParameterReturnGeneral detallepedidocompraimporReturnGeneral=new DetallePedidoCompraImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallepedidocompraimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePedidoCompraImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallepedidocompraimpors,detallepedidocompraimpor,detallepedidocompraimporParameterGeneral,detallepedidocompraimporReturnGeneral,isEsNuevoDetallePedidoCompraImpor,clases);
			
			return detallepedidocompraimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetallePedidoCompraImporParameterReturnGeneral procesarEventosDetallePedidoCompraImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetallePedidoCompraImpor> detallepedidocompraimpors,DetallePedidoCompraImpor detallepedidocompraimpor,DetallePedidoCompraImporParameterReturnGeneral detallepedidocompraimporParameterGeneral,Boolean isEsNuevoDetallePedidoCompraImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-procesarEventosDetallePedidoCompraImporsWithConnection");connexion.begin();			
			
			DetallePedidoCompraImporParameterReturnGeneral detallepedidocompraimporReturnGeneral=new DetallePedidoCompraImporParameterReturnGeneral();
	
			detallepedidocompraimporReturnGeneral.setDetallePedidoCompraImpor(detallepedidocompraimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detallepedidocompraimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetallePedidoCompraImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detallepedidocompraimpors,detallepedidocompraimpor,detallepedidocompraimporParameterGeneral,detallepedidocompraimporReturnGeneral,isEsNuevoDetallePedidoCompraImpor,clases);
			
			this.connexion.commit();
			
			return detallepedidocompraimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetallePedidoCompraImporParameterReturnGeneral procesarImportacionDetallePedidoCompraImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetallePedidoCompraImporParameterReturnGeneral detallepedidocompraimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-procesarImportacionDetallePedidoCompraImporsWithConnection");connexion.begin();			
			
			DetallePedidoCompraImporParameterReturnGeneral detallepedidocompraimporReturnGeneral=new DetallePedidoCompraImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detallepedidocompraimpors=new ArrayList<DetallePedidoCompraImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallepedidocompraimpor=new DetallePedidoCompraImpor();
				
				
				if(conColumnasBase) {this.detallepedidocompraimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallepedidocompraimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallepedidocompraimpor.setcantidad_pedido(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setcantidad_entra(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setcantidad_pendiente(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setpeso(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setlote(arrColumnas[iColumn++]);
				this.detallepedidocompraimpor.setporcentaje_arancel(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setcantidad_unidad_auxiliar(Integer.parseInt(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setprecio_unidad_auxiliar(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setfob(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setfob_exw(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallepedidocompraimpor.setdescripcion(arrColumnas[iColumn++]);
				
				this.detallepedidocompraimpors.add(this.detallepedidocompraimpor);
			}
			
			this.saveDetallePedidoCompraImpors();
			
			this.connexion.commit();
			
			detallepedidocompraimporReturnGeneral.setConRetornoEstaProcesado(true);
			detallepedidocompraimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detallepedidocompraimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetallePedidoCompraImporsEliminados() throws Exception {				
		
		List<DetallePedidoCompraImpor> detallepedidocompraimporsAux= new ArrayList<DetallePedidoCompraImpor>();
		
		for(DetallePedidoCompraImpor detallepedidocompraimpor:detallepedidocompraimpors) {
			if(!detallepedidocompraimpor.getIsDeleted()) {
				detallepedidocompraimporsAux.add(detallepedidocompraimpor);
			}
		}
		
		detallepedidocompraimpors=detallepedidocompraimporsAux;
	}
	
	public void quitarDetallePedidoCompraImporsNulos() throws Exception {				
		
		List<DetallePedidoCompraImpor> detallepedidocompraimporsAux= new ArrayList<DetallePedidoCompraImpor>();
		
		for(DetallePedidoCompraImpor detallepedidocompraimpor : this.detallepedidocompraimpors) {
			if(detallepedidocompraimpor==null) {
				detallepedidocompraimporsAux.add(detallepedidocompraimpor);
			}
		}
		
		//this.detallepedidocompraimpors=detallepedidocompraimporsAux;
		
		this.detallepedidocompraimpors.removeAll(detallepedidocompraimporsAux);
	}
	
	public void getSetVersionRowDetallePedidoCompraImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallepedidocompraimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallepedidocompraimpor.getIsDeleted() || (detallepedidocompraimpor.getIsChanged()&&!detallepedidocompraimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detallepedidocompraimporDataAccess.getSetVersionRowDetallePedidoCompraImpor(connexion,detallepedidocompraimpor.getId());
				
				if(!detallepedidocompraimpor.getVersionRow().equals(timestamp)) {	
					detallepedidocompraimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallepedidocompraimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetallePedidoCompraImpor()throws Exception {	
		
		if(detallepedidocompraimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallepedidocompraimpor.getIsDeleted() || (detallepedidocompraimpor.getIsChanged()&&!detallepedidocompraimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detallepedidocompraimporDataAccess.getSetVersionRowDetallePedidoCompraImpor(connexion,detallepedidocompraimpor.getId());
			
			try {							
				if(!detallepedidocompraimpor.getVersionRow().equals(timestamp)) {	
					detallepedidocompraimpor.setVersionRow(timestamp);
				}
				
				detallepedidocompraimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetallePedidoCompraImporsWithConnection()throws Exception {	
		if(detallepedidocompraimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetallePedidoCompraImpor detallepedidocompraimporAux:detallepedidocompraimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detallepedidocompraimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallepedidocompraimporAux.getIsDeleted() || (detallepedidocompraimporAux.getIsChanged()&&!detallepedidocompraimporAux.getIsNew())) {
						
						timestamp=detallepedidocompraimporDataAccess.getSetVersionRowDetallePedidoCompraImpor(connexion,detallepedidocompraimporAux.getId());
						
						if(!detallepedidocompraimpor.getVersionRow().equals(timestamp)) {	
							detallepedidocompraimporAux.setVersionRow(timestamp);
						}
								
						detallepedidocompraimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetallePedidoCompraImpors()throws Exception {	
		if(detallepedidocompraimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetallePedidoCompraImpor detallepedidocompraimporAux:detallepedidocompraimpors) {
					if(detallepedidocompraimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detallepedidocompraimporAux.getIsDeleted() || (detallepedidocompraimporAux.getIsChanged()&&!detallepedidocompraimporAux.getIsNew())) {
						
						timestamp=detallepedidocompraimporDataAccess.getSetVersionRowDetallePedidoCompraImpor(connexion,detallepedidocompraimporAux.getId());
						
						if(!detallepedidocompraimporAux.getVersionRow().equals(timestamp)) {	
							detallepedidocompraimporAux.setVersionRow(timestamp);
						}
						
													
						detallepedidocompraimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetallePedidoCompraImporParameterReturnGeneral cargarCombosLoteForeignKeyDetallePedidoCompraImporWithConnection(String finalQueryGlobalPedidoCompraImpor,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalArancel,String finalQueryGlobalCentroCosto,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetallePedidoCompraImporParameterReturnGeneral  detallepedidocompraimporReturnGeneral =new DetallePedidoCompraImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetallePedidoCompraImporWithConnection");connexion.begin();
			
			detallepedidocompraimporReturnGeneral =new DetallePedidoCompraImporParameterReturnGeneral();
			
			

			List<PedidoCompraImpor> pedidocompraimporsForeignKey=new ArrayList<PedidoCompraImpor>();
			PedidoCompraImporLogic pedidocompraimporLogic=new PedidoCompraImporLogic();
			pedidocompraimporLogic.setConnexion(this.connexion);
			pedidocompraimporLogic.getPedidoCompraImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoCompraImpor.equals("NONE")) {
				pedidocompraimporLogic.getTodosPedidoCompraImpors(finalQueryGlobalPedidoCompraImpor,new Pagination());
				pedidocompraimporsForeignKey=pedidocompraimporLogic.getPedidoCompraImpors();
			}

			detallepedidocompraimporReturnGeneral.setpedidocompraimporsForeignKey(pedidocompraimporsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallepedidocompraimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallepedidocompraimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallepedidocompraimporReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallepedidocompraimporReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallepedidocompraimporReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallepedidocompraimporReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallepedidocompraimporReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Arancel> arancelsForeignKey=new ArrayList<Arancel>();
			ArancelLogic arancelLogic=new ArancelLogic();
			arancelLogic.setConnexion(this.connexion);
			arancelLogic.getArancelDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalArancel.equals("NONE")) {
				arancelLogic.getTodosArancels(finalQueryGlobalArancel,new Pagination());
				arancelsForeignKey=arancelLogic.getArancels();
			}

			detallepedidocompraimporReturnGeneral.setarancelsForeignKey(arancelsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallepedidocompraimporReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallepedidocompraimporReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallepedidocompraimporReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detallepedidocompraimporReturnGeneral;
	}
	
	public DetallePedidoCompraImporParameterReturnGeneral cargarCombosLoteForeignKeyDetallePedidoCompraImpor(String finalQueryGlobalPedidoCompraImpor,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalArancel,String finalQueryGlobalCentroCosto,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetallePedidoCompraImporParameterReturnGeneral  detallepedidocompraimporReturnGeneral =new DetallePedidoCompraImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detallepedidocompraimporReturnGeneral =new DetallePedidoCompraImporParameterReturnGeneral();
			
			

			List<PedidoCompraImpor> pedidocompraimporsForeignKey=new ArrayList<PedidoCompraImpor>();
			PedidoCompraImporLogic pedidocompraimporLogic=new PedidoCompraImporLogic();
			pedidocompraimporLogic.setConnexion(this.connexion);
			pedidocompraimporLogic.getPedidoCompraImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoCompraImpor.equals("NONE")) {
				pedidocompraimporLogic.getTodosPedidoCompraImpors(finalQueryGlobalPedidoCompraImpor,new Pagination());
				pedidocompraimporsForeignKey=pedidocompraimporLogic.getPedidoCompraImpors();
			}

			detallepedidocompraimporReturnGeneral.setpedidocompraimporsForeignKey(pedidocompraimporsForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detallepedidocompraimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detallepedidocompraimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detallepedidocompraimporReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detallepedidocompraimporReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detallepedidocompraimporReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detallepedidocompraimporReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detallepedidocompraimporReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Arancel> arancelsForeignKey=new ArrayList<Arancel>();
			ArancelLogic arancelLogic=new ArancelLogic();
			arancelLogic.setConnexion(this.connexion);
			arancelLogic.getArancelDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalArancel.equals("NONE")) {
				arancelLogic.getTodosArancels(finalQueryGlobalArancel,new Pagination());
				arancelsForeignKey=arancelLogic.getArancels();
			}

			detallepedidocompraimporReturnGeneral.setarancelsForeignKey(arancelsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detallepedidocompraimporReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detallepedidocompraimporReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detallepedidocompraimporReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detallepedidocompraimporReturnGeneral;
	}
	
	
	public void deepLoad(DetallePedidoCompraImpor detallepedidocompraimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetallePedidoCompraImporLogicAdditional.updateDetallePedidoCompraImporToGet(detallepedidocompraimpor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallepedidocompraimpor.setPedidoCompraImpor(detallepedidocompraimporDataAccess.getPedidoCompraImpor(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setEmpresa(detallepedidocompraimporDataAccess.getEmpresa(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setSucursal(detallepedidocompraimporDataAccess.getSucursal(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setBodega(detallepedidocompraimporDataAccess.getBodega(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setProducto(detallepedidocompraimporDataAccess.getProducto(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setUnidad(detallepedidocompraimporDataAccess.getUnidad(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setEjercicio(detallepedidocompraimporDataAccess.getEjercicio(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setPeriodo(detallepedidocompraimporDataAccess.getPeriodo(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setArancel(detallepedidocompraimporDataAccess.getArancel(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setCentroCosto(detallepedidocompraimporDataAccess.getCentroCosto(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setAnio(detallepedidocompraimporDataAccess.getAnio(connexion,detallepedidocompraimpor));
		detallepedidocompraimpor.setMes(detallepedidocompraimporDataAccess.getMes(connexion,detallepedidocompraimpor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				detallepedidocompraimpor.setPedidoCompraImpor(detallepedidocompraimporDataAccess.getPedidoCompraImpor(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallepedidocompraimpor.setEmpresa(detallepedidocompraimporDataAccess.getEmpresa(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallepedidocompraimpor.setSucursal(detallepedidocompraimporDataAccess.getSucursal(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallepedidocompraimpor.setBodega(detallepedidocompraimporDataAccess.getBodega(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallepedidocompraimpor.setProducto(detallepedidocompraimporDataAccess.getProducto(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallepedidocompraimpor.setUnidad(detallepedidocompraimporDataAccess.getUnidad(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallepedidocompraimpor.setEjercicio(detallepedidocompraimporDataAccess.getEjercicio(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallepedidocompraimpor.setPeriodo(detallepedidocompraimporDataAccess.getPeriodo(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Arancel.class)) {
				detallepedidocompraimpor.setArancel(detallepedidocompraimporDataAccess.getArancel(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallepedidocompraimpor.setCentroCosto(detallepedidocompraimporDataAccess.getCentroCosto(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallepedidocompraimpor.setAnio(detallepedidocompraimporDataAccess.getAnio(connexion,detallepedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallepedidocompraimpor.setMes(detallepedidocompraimporDataAccess.getMes(connexion,detallepedidocompraimpor));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setPedidoCompraImpor(detallepedidocompraimporDataAccess.getPedidoCompraImpor(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setEmpresa(detallepedidocompraimporDataAccess.getEmpresa(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setSucursal(detallepedidocompraimporDataAccess.getSucursal(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setBodega(detallepedidocompraimporDataAccess.getBodega(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setProducto(detallepedidocompraimporDataAccess.getProducto(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setUnidad(detallepedidocompraimporDataAccess.getUnidad(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setEjercicio(detallepedidocompraimporDataAccess.getEjercicio(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setPeriodo(detallepedidocompraimporDataAccess.getPeriodo(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Arancel.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setArancel(detallepedidocompraimporDataAccess.getArancel(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setCentroCosto(detallepedidocompraimporDataAccess.getCentroCosto(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setAnio(detallepedidocompraimporDataAccess.getAnio(connexion,detallepedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setMes(detallepedidocompraimporDataAccess.getMes(connexion,detallepedidocompraimpor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallepedidocompraimpor.setPedidoCompraImpor(detallepedidocompraimporDataAccess.getPedidoCompraImpor(connexion,detallepedidocompraimpor));
		PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
		pedidocompraimporLogic.deepLoad(detallepedidocompraimpor.getPedidoCompraImpor(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setEmpresa(detallepedidocompraimporDataAccess.getEmpresa(connexion,detallepedidocompraimpor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallepedidocompraimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setSucursal(detallepedidocompraimporDataAccess.getSucursal(connexion,detallepedidocompraimpor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallepedidocompraimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setBodega(detallepedidocompraimporDataAccess.getBodega(connexion,detallepedidocompraimpor));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallepedidocompraimpor.getBodega(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setProducto(detallepedidocompraimporDataAccess.getProducto(connexion,detallepedidocompraimpor));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallepedidocompraimpor.getProducto(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setUnidad(detallepedidocompraimporDataAccess.getUnidad(connexion,detallepedidocompraimpor));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallepedidocompraimpor.getUnidad(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setEjercicio(detallepedidocompraimporDataAccess.getEjercicio(connexion,detallepedidocompraimpor));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallepedidocompraimpor.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setPeriodo(detallepedidocompraimporDataAccess.getPeriodo(connexion,detallepedidocompraimpor));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallepedidocompraimpor.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setArancel(detallepedidocompraimporDataAccess.getArancel(connexion,detallepedidocompraimpor));
		ArancelLogic arancelLogic= new ArancelLogic(connexion);
		arancelLogic.deepLoad(detallepedidocompraimpor.getArancel(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setCentroCosto(detallepedidocompraimporDataAccess.getCentroCosto(connexion,detallepedidocompraimpor));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallepedidocompraimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setAnio(detallepedidocompraimporDataAccess.getAnio(connexion,detallepedidocompraimpor));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallepedidocompraimpor.getAnio(),isDeep,deepLoadType,clases);
				
		detallepedidocompraimpor.setMes(detallepedidocompraimporDataAccess.getMes(connexion,detallepedidocompraimpor));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallepedidocompraimpor.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				detallepedidocompraimpor.setPedidoCompraImpor(detallepedidocompraimporDataAccess.getPedidoCompraImpor(connexion,detallepedidocompraimpor));
				PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
				pedidocompraimporLogic.deepLoad(detallepedidocompraimpor.getPedidoCompraImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detallepedidocompraimpor.setEmpresa(detallepedidocompraimporDataAccess.getEmpresa(connexion,detallepedidocompraimpor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallepedidocompraimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallepedidocompraimpor.setSucursal(detallepedidocompraimporDataAccess.getSucursal(connexion,detallepedidocompraimpor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallepedidocompraimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detallepedidocompraimpor.setBodega(detallepedidocompraimporDataAccess.getBodega(connexion,detallepedidocompraimpor));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detallepedidocompraimpor.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detallepedidocompraimpor.setProducto(detallepedidocompraimporDataAccess.getProducto(connexion,detallepedidocompraimpor));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detallepedidocompraimpor.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detallepedidocompraimpor.setUnidad(detallepedidocompraimporDataAccess.getUnidad(connexion,detallepedidocompraimpor));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detallepedidocompraimpor.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallepedidocompraimpor.setEjercicio(detallepedidocompraimporDataAccess.getEjercicio(connexion,detallepedidocompraimpor));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallepedidocompraimpor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallepedidocompraimpor.setPeriodo(detallepedidocompraimporDataAccess.getPeriodo(connexion,detallepedidocompraimpor));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallepedidocompraimpor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Arancel.class)) {
				detallepedidocompraimpor.setArancel(detallepedidocompraimporDataAccess.getArancel(connexion,detallepedidocompraimpor));
				ArancelLogic arancelLogic= new ArancelLogic(connexion);
				arancelLogic.deepLoad(detallepedidocompraimpor.getArancel(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detallepedidocompraimpor.setCentroCosto(detallepedidocompraimporDataAccess.getCentroCosto(connexion,detallepedidocompraimpor));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detallepedidocompraimpor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallepedidocompraimpor.setAnio(detallepedidocompraimporDataAccess.getAnio(connexion,detallepedidocompraimpor));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallepedidocompraimpor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallepedidocompraimpor.setMes(detallepedidocompraimporDataAccess.getMes(connexion,detallepedidocompraimpor));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallepedidocompraimpor.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setPedidoCompraImpor(detallepedidocompraimporDataAccess.getPedidoCompraImpor(connexion,detallepedidocompraimpor));
			PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
			pedidocompraimporLogic.deepLoad(detallepedidocompraimpor.getPedidoCompraImpor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setEmpresa(detallepedidocompraimporDataAccess.getEmpresa(connexion,detallepedidocompraimpor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallepedidocompraimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setSucursal(detallepedidocompraimporDataAccess.getSucursal(connexion,detallepedidocompraimpor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallepedidocompraimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setBodega(detallepedidocompraimporDataAccess.getBodega(connexion,detallepedidocompraimpor));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detallepedidocompraimpor.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setProducto(detallepedidocompraimporDataAccess.getProducto(connexion,detallepedidocompraimpor));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detallepedidocompraimpor.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setUnidad(detallepedidocompraimporDataAccess.getUnidad(connexion,detallepedidocompraimpor));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detallepedidocompraimpor.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setEjercicio(detallepedidocompraimporDataAccess.getEjercicio(connexion,detallepedidocompraimpor));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallepedidocompraimpor.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setPeriodo(detallepedidocompraimporDataAccess.getPeriodo(connexion,detallepedidocompraimpor));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallepedidocompraimpor.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Arancel.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setArancel(detallepedidocompraimporDataAccess.getArancel(connexion,detallepedidocompraimpor));
			ArancelLogic arancelLogic= new ArancelLogic(connexion);
			arancelLogic.deepLoad(detallepedidocompraimpor.getArancel(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setCentroCosto(detallepedidocompraimporDataAccess.getCentroCosto(connexion,detallepedidocompraimpor));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detallepedidocompraimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setAnio(detallepedidocompraimporDataAccess.getAnio(connexion,detallepedidocompraimpor));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallepedidocompraimpor.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallepedidocompraimpor.setMes(detallepedidocompraimporDataAccess.getMes(connexion,detallepedidocompraimpor));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallepedidocompraimpor.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetallePedidoCompraImpor detallepedidocompraimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetallePedidoCompraImporLogicAdditional.updateDetallePedidoCompraImporToSave(detallepedidocompraimpor,this.arrDatoGeneral);
			
DetallePedidoCompraImporDataAccess.save(detallepedidocompraimpor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PedidoCompraImporDataAccess.save(detallepedidocompraimpor.getPedidoCompraImpor(),connexion);

		EmpresaDataAccess.save(detallepedidocompraimpor.getEmpresa(),connexion);

		SucursalDataAccess.save(detallepedidocompraimpor.getSucursal(),connexion);

		BodegaDataAccess.save(detallepedidocompraimpor.getBodega(),connexion);

		ProductoDataAccess.save(detallepedidocompraimpor.getProducto(),connexion);

		UnidadDataAccess.save(detallepedidocompraimpor.getUnidad(),connexion);

		EjercicioDataAccess.save(detallepedidocompraimpor.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallepedidocompraimpor.getPeriodo(),connexion);

		ArancelDataAccess.save(detallepedidocompraimpor.getArancel(),connexion);

		CentroCostoDataAccess.save(detallepedidocompraimpor.getCentroCosto(),connexion);

		AnioDataAccess.save(detallepedidocompraimpor.getAnio(),connexion);

		MesDataAccess.save(detallepedidocompraimpor.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				PedidoCompraImporDataAccess.save(detallepedidocompraimpor.getPedidoCompraImpor(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallepedidocompraimpor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallepedidocompraimpor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallepedidocompraimpor.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallepedidocompraimpor.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallepedidocompraimpor.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallepedidocompraimpor.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallepedidocompraimpor.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Arancel.class)) {
				ArancelDataAccess.save(detallepedidocompraimpor.getArancel(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallepedidocompraimpor.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallepedidocompraimpor.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallepedidocompraimpor.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PedidoCompraImporDataAccess.save(detallepedidocompraimpor.getPedidoCompraImpor(),connexion);
		PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
		pedidocompraimporLogic.deepLoad(detallepedidocompraimpor.getPedidoCompraImpor(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detallepedidocompraimpor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallepedidocompraimpor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallepedidocompraimpor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallepedidocompraimpor.getSucursal(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detallepedidocompraimpor.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detallepedidocompraimpor.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detallepedidocompraimpor.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detallepedidocompraimpor.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detallepedidocompraimpor.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detallepedidocompraimpor.getUnidad(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallepedidocompraimpor.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallepedidocompraimpor.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallepedidocompraimpor.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallepedidocompraimpor.getPeriodo(),isDeep,deepLoadType,clases);
				

		ArancelDataAccess.save(detallepedidocompraimpor.getArancel(),connexion);
		ArancelLogic arancelLogic= new ArancelLogic(connexion);
		arancelLogic.deepLoad(detallepedidocompraimpor.getArancel(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detallepedidocompraimpor.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detallepedidocompraimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallepedidocompraimpor.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallepedidocompraimpor.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallepedidocompraimpor.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallepedidocompraimpor.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoCompraImpor.class)) {
				PedidoCompraImporDataAccess.save(detallepedidocompraimpor.getPedidoCompraImpor(),connexion);
				PedidoCompraImporLogic pedidocompraimporLogic= new PedidoCompraImporLogic(connexion);
				pedidocompraimporLogic.deepSave(detallepedidocompraimpor.getPedidoCompraImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallepedidocompraimpor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallepedidocompraimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallepedidocompraimpor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallepedidocompraimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detallepedidocompraimpor.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detallepedidocompraimpor.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detallepedidocompraimpor.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detallepedidocompraimpor.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detallepedidocompraimpor.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detallepedidocompraimpor.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallepedidocompraimpor.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallepedidocompraimpor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallepedidocompraimpor.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallepedidocompraimpor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Arancel.class)) {
				ArancelDataAccess.save(detallepedidocompraimpor.getArancel(),connexion);
				ArancelLogic arancelLogic= new ArancelLogic(connexion);
				arancelLogic.deepSave(detallepedidocompraimpor.getArancel(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detallepedidocompraimpor.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detallepedidocompraimpor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallepedidocompraimpor.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallepedidocompraimpor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallepedidocompraimpor.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallepedidocompraimpor.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetallePedidoCompraImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallepedidocompraimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(detallepedidocompraimpor);
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
			this.deepLoad(this.detallepedidocompraimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetallePedidoCompraImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detallepedidocompraimpors!=null) {
				for(DetallePedidoCompraImpor detallepedidocompraimpor:detallepedidocompraimpors) {
					this.deepLoad(detallepedidocompraimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(detallepedidocompraimpors);
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
			if(detallepedidocompraimpors!=null) {
				for(DetallePedidoCompraImpor detallepedidocompraimpor:detallepedidocompraimpors) {
					this.deepLoad(detallepedidocompraimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(detallepedidocompraimpors);
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
			this.getNewConnexionToDeep(DetallePedidoCompraImpor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallepedidocompraimpor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetallePedidoCompraImpor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detallepedidocompraimpors!=null) {
				for(DetallePedidoCompraImpor detallepedidocompraimpor:detallepedidocompraimpors) {
					this.deepSave(detallepedidocompraimpor,isDeep,deepLoadType,clases);
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
			if(detallepedidocompraimpors!=null) {
				for(DetallePedidoCompraImpor detallepedidocompraimpor:detallepedidocompraimpors) {
					this.deepSave(detallepedidocompraimpor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetallePedidoCompraImporsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetallePedidoCompraImporConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetallePedidoCompraImporConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdArancelWithConnection(String sFinalQuery,Pagination pagination,Long id_arancel)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidArancel= new ParameterSelectionGeneral();
			parameterSelectionGeneralidArancel.setParameterSelectionGeneralEqual(ParameterType.LONG,id_arancel,DetallePedidoCompraImporConstantesFunciones.IDARANCEL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidArancel);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdArancel","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdArancel(String sFinalQuery,Pagination pagination,Long id_arancel)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidArancel= new ParameterSelectionGeneral();
			parameterSelectionGeneralidArancel.setParameterSelectionGeneralEqual(ParameterType.LONG,id_arancel,DetallePedidoCompraImporConstantesFunciones.IDARANCEL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidArancel);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdArancel","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetallePedidoCompraImporConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetallePedidoCompraImporConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePedidoCompraImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetallePedidoCompraImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetallePedidoCompraImporConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetallePedidoCompraImporConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdPedidoCompraImporWithConnection(String sFinalQuery,Pagination pagination,Long id_pedido_compra_impor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoCompraImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoCompraImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_compra_impor,DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoCompraImpor);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoCompraImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdPedidoCompraImpor(String sFinalQuery,Pagination pagination,Long id_pedido_compra_impor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoCompraImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoCompraImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_compra_impor,DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoCompraImpor);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoCompraImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetallePedidoCompraImporConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetallePedidoCompraImporConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetallePedidoCompraImporsFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetallePedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePedidoCompraImporConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetallePedidoCompraImporsFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetallePedidoCompraImporConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetallePedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(this.detallepedidocompraimpors);
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
			if(DetallePedidoCompraImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoCompraImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetallePedidoCompraImpor detallepedidocompraimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetallePedidoCompraImporConstantesFunciones.ISCONAUDITORIA) {
				if(detallepedidocompraimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoCompraImporDataAccess.TABLENAME, detallepedidocompraimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePedidoCompraImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePedidoCompraImporLogic.registrarAuditoriaDetallesDetallePedidoCompraImpor(connexion,detallepedidocompraimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallepedidocompraimpor.getIsDeleted()) {
					/*if(!detallepedidocompraimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetallePedidoCompraImporDataAccess.TABLENAME, detallepedidocompraimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetallePedidoCompraImporLogic.registrarAuditoriaDetallesDetallePedidoCompraImpor(connexion,detallepedidocompraimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoCompraImporDataAccess.TABLENAME, detallepedidocompraimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallepedidocompraimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetallePedidoCompraImporDataAccess.TABLENAME, detallepedidocompraimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetallePedidoCompraImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetallePedidoCompraImporLogic.registrarAuditoriaDetallesDetallePedidoCompraImpor(connexion,detallepedidocompraimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetallePedidoCompraImpor(Connexion connexion,DetallePedidoCompraImpor detallepedidocompraimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_pedido_compra_impor().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_pedido_compra_impor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_pedido_compra_impor()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_pedido_compra_impor().toString();
				}
				if(detallepedidocompraimpor.getid_pedido_compra_impor()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_pedido_compra_impor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_empresa().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_empresa()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_empresa().toString();
				}
				if(detallepedidocompraimpor.getid_empresa()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_sucursal().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_sucursal().toString();
				}
				if(detallepedidocompraimpor.getid_sucursal()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_bodega().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_bodega()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_bodega().toString();
				}
				if(detallepedidocompraimpor.getid_bodega()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_producto().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_producto()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_producto().toString();
				}
				if(detallepedidocompraimpor.getid_producto()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_unidad().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_unidad()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_unidad().toString();
				}
				if(detallepedidocompraimpor.getid_unidad()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_ejercicio().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_ejercicio().toString();
				}
				if(detallepedidocompraimpor.getid_ejercicio()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_periodo().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_periodo()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_periodo().toString();
				}
				if(detallepedidocompraimpor.getid_periodo()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_arancel().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_arancel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_arancel()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_arancel().toString();
				}
				if(detallepedidocompraimpor.getid_arancel()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_arancel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDARANCEL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getcantidad_pedido().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_pedido()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_pedido().toString();
				}
				if(detallepedidocompraimpor.getcantidad_pedido()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getcantidad_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.CANTIDADPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getcantidad_entra().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_entra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_entra()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_entra().toString();
				}
				if(detallepedidocompraimpor.getcantidad_entra()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getcantidad_entra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.CANTIDADENTRA,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getcantidad_pendiente().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_pendiente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_pendiente()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_pendiente().toString();
				}
				if(detallepedidocompraimpor.getcantidad_pendiente()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getcantidad_pendiente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.CANTIDADPENDIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getporcentaje().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getporcentaje()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getporcentaje().toString();
				}
				if(detallepedidocompraimpor.getporcentaje()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getpeso().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getpeso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getpeso()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getpeso().toString();
				}
				if(detallepedidocompraimpor.getpeso()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getpeso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.PESO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getprecio().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getprecio()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getprecio().toString();
				}
				if(detallepedidocompraimpor.getprecio()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getlote().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getlote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getlote()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getlote();
				}
				if(detallepedidocompraimpor.getlote()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getlote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.LOTE,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getporcentaje_arancel().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getporcentaje_arancel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getporcentaje_arancel()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getporcentaje_arancel().toString();
				}
				if(detallepedidocompraimpor.getporcentaje_arancel()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getporcentaje_arancel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getcantidad_unidad_auxiliar().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_unidad_auxiliar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_unidad_auxiliar()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getcantidad_unidad_auxiliar().toString();
				}
				if(detallepedidocompraimpor.getcantidad_unidad_auxiliar()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getcantidad_unidad_auxiliar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.CANTIDADUNIDADAUXILIAR,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getprecio_unidad_auxiliar().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getprecio_unidad_auxiliar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getprecio_unidad_auxiliar()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getprecio_unidad_auxiliar().toString();
				}
				if(detallepedidocompraimpor.getprecio_unidad_auxiliar()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getprecio_unidad_auxiliar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getfob().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getfob()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getfob()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getfob().toString();
				}
				if(detallepedidocompraimpor.getfob()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getfob().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.FOB,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getfob_exw().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getfob_exw()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getfob_exw()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getfob_exw().toString();
				}
				if(detallepedidocompraimpor.getfob_exw()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getfob_exw().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.FOBEXW,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.gettotal().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().gettotal()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().gettotal().toString();
				}
				if(detallepedidocompraimpor.gettotal()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getdescripcion().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getdescripcion()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getdescripcion();
				}
				if(detallepedidocompraimpor.getdescripcion()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_centro_costo().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_centro_costo().toString();
				}
				if(detallepedidocompraimpor.getid_centro_costo()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_anio().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_anio()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_anio().toString();
				}
				if(detallepedidocompraimpor.getid_anio()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallepedidocompraimpor.getIsNew()||!detallepedidocompraimpor.getid_mes().equals(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_mes()!=null)
				{
					strValorActual=detallepedidocompraimpor.getDetallePedidoCompraImporOriginal().getid_mes().toString();
				}
				if(detallepedidocompraimpor.getid_mes()!=null)
				{
					strValorNuevo=detallepedidocompraimpor.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetallePedidoCompraImporConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetallePedidoCompraImporRelacionesWithConnection(DetallePedidoCompraImpor detallepedidocompraimpor) throws Exception {

		if(!detallepedidocompraimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePedidoCompraImporRelacionesBase(detallepedidocompraimpor,true);
		}
	}

	public void saveDetallePedidoCompraImporRelaciones(DetallePedidoCompraImpor detallepedidocompraimpor)throws Exception {

		if(!detallepedidocompraimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetallePedidoCompraImporRelacionesBase(detallepedidocompraimpor,false);
		}
	}

	public void saveDetallePedidoCompraImporRelacionesBase(DetallePedidoCompraImpor detallepedidocompraimpor,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetallePedidoCompraImpor-saveRelacionesWithConnection");}
	

			this.setDetallePedidoCompraImpor(detallepedidocompraimpor);

			if(DetallePedidoCompraImporLogicAdditional.validarSaveRelaciones(detallepedidocompraimpor,this)) {

				DetallePedidoCompraImporLogicAdditional.updateRelacionesToSave(detallepedidocompraimpor,this);

				if((detallepedidocompraimpor.getIsNew()||detallepedidocompraimpor.getIsChanged())&&!detallepedidocompraimpor.getIsDeleted()) {
					this.saveDetallePedidoCompraImpor();
					this.saveDetallePedidoCompraImporRelacionesDetalles();

				} else if(detallepedidocompraimpor.getIsDeleted()) {
					this.saveDetallePedidoCompraImporRelacionesDetalles();
					this.saveDetallePedidoCompraImpor();
				}

				DetallePedidoCompraImporLogicAdditional.updateRelacionesToSaveAfter(detallepedidocompraimpor,this);

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
	
	
	private void saveDetallePedidoCompraImporRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePedidoCompraImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePedidoCompraImporConstantesFunciones.getClassesForeignKeysOfDetallePedidoCompraImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoCompraImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetallePedidoCompraImporConstantesFunciones.getClassesRelationshipsOfDetallePedidoCompraImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
