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
import com.bydan.erp.facturacion.util.DetaFormaPagoFactuConstantesFunciones;
import com.bydan.erp.facturacion.util.DetaFormaPagoFactuParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetaFormaPagoFactuParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetaFormaPagoFactu;
import com.bydan.erp.facturacion.business.logic.DetaFormaPagoFactuLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetaFormaPagoFactuLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetaFormaPagoFactuLogic.class);
	
	protected DetaFormaPagoFactuDataAccess detaformapagofactuDataAccess; 	
	protected DetaFormaPagoFactu detaformapagofactu;
	protected List<DetaFormaPagoFactu> detaformapagofactus;
	protected Object detaformapagofactuObject;	
	protected List<Object> detaformapagofactusObject;
	
	public static ClassValidator<DetaFormaPagoFactu> detaformapagofactuValidator = new ClassValidator<DetaFormaPagoFactu>(DetaFormaPagoFactu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetaFormaPagoFactuLogicAdditional detaformapagofactuLogicAdditional=null;
	
	public DetaFormaPagoFactuLogicAdditional getDetaFormaPagoFactuLogicAdditional() {
		return this.detaformapagofactuLogicAdditional;
	}
	
	public void setDetaFormaPagoFactuLogicAdditional(DetaFormaPagoFactuLogicAdditional detaformapagofactuLogicAdditional) {
		try {
			this.detaformapagofactuLogicAdditional=detaformapagofactuLogicAdditional;
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
	
	
	
	
	public  DetaFormaPagoFactuLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detaformapagofactuDataAccess = new DetaFormaPagoFactuDataAccess();
			
			this.detaformapagofactus= new ArrayList<DetaFormaPagoFactu>();
			this.detaformapagofactu= new DetaFormaPagoFactu();
			
			this.detaformapagofactuObject=new Object();
			this.detaformapagofactusObject=new ArrayList<Object>();
				
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
			
			this.detaformapagofactuDataAccess.setConnexionType(this.connexionType);
			this.detaformapagofactuDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetaFormaPagoFactuLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detaformapagofactuDataAccess = new DetaFormaPagoFactuDataAccess();
			this.detaformapagofactus= new ArrayList<DetaFormaPagoFactu>();
			this.detaformapagofactu= new DetaFormaPagoFactu();
			this.detaformapagofactuObject=new Object();
			this.detaformapagofactusObject=new ArrayList<Object>();
			
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
			
			this.detaformapagofactuDataAccess.setConnexionType(this.connexionType);
			this.detaformapagofactuDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetaFormaPagoFactu getDetaFormaPagoFactu() throws Exception {	
		DetaFormaPagoFactuLogicAdditional.checkDetaFormaPagoFactuToGet(detaformapagofactu,this.datosCliente,this.arrDatoGeneral);
		DetaFormaPagoFactuLogicAdditional.updateDetaFormaPagoFactuToGet(detaformapagofactu,this.arrDatoGeneral);
		
		return detaformapagofactu;
	}
		
	public void setDetaFormaPagoFactu(DetaFormaPagoFactu newDetaFormaPagoFactu) {
		this.detaformapagofactu = newDetaFormaPagoFactu;
	}
	
	public DetaFormaPagoFactuDataAccess getDetaFormaPagoFactuDataAccess() {
		return detaformapagofactuDataAccess;
	}
	
	public void setDetaFormaPagoFactuDataAccess(DetaFormaPagoFactuDataAccess newdetaformapagofactuDataAccess) {
		this.detaformapagofactuDataAccess = newdetaformapagofactuDataAccess;
	}
	
	public List<DetaFormaPagoFactu> getDetaFormaPagoFactus() throws Exception {		
		this.quitarDetaFormaPagoFactusNulos();
		
		DetaFormaPagoFactuLogicAdditional.checkDetaFormaPagoFactuToGets(detaformapagofactus,this.datosCliente,this.arrDatoGeneral);
		
		for (DetaFormaPagoFactu detaformapagofactuLocal: detaformapagofactus ) {
			DetaFormaPagoFactuLogicAdditional.updateDetaFormaPagoFactuToGet(detaformapagofactuLocal,this.arrDatoGeneral);
		}
		
		return detaformapagofactus;
	}
	
	public void setDetaFormaPagoFactus(List<DetaFormaPagoFactu> newDetaFormaPagoFactus) {
		this.detaformapagofactus = newDetaFormaPagoFactus;
	}
	
	public Object getDetaFormaPagoFactuObject() {	
		this.detaformapagofactuObject=this.detaformapagofactuDataAccess.getEntityObject();
		return this.detaformapagofactuObject;
	}
		
	public void setDetaFormaPagoFactuObject(Object newDetaFormaPagoFactuObject) {
		this.detaformapagofactuObject = newDetaFormaPagoFactuObject;
	}
	
	public List<Object> getDetaFormaPagoFactusObject() {		
		this.detaformapagofactusObject=this.detaformapagofactuDataAccess.getEntitiesObject();
		return this.detaformapagofactusObject;
	}
		
	public void setDetaFormaPagoFactusObject(List<Object> newDetaFormaPagoFactusObject) {
		this.detaformapagofactusObject = newDetaFormaPagoFactusObject;
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
		
		if(this.detaformapagofactuDataAccess!=null) {
			this.detaformapagofactuDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detaformapagofactuDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detaformapagofactuDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detaformapagofactu = new  DetaFormaPagoFactu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detaformapagofactu=detaformapagofactuDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detaformapagofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactu);
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
		detaformapagofactu = new  DetaFormaPagoFactu();
		  		  
        try {
			
			detaformapagofactu=detaformapagofactuDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detaformapagofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detaformapagofactu = new  DetaFormaPagoFactu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detaformapagofactu=detaformapagofactuDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detaformapagofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactu);
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
		detaformapagofactu = new  DetaFormaPagoFactu();
		  		  
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
		detaformapagofactu = new  DetaFormaPagoFactu();
		  		  
        try {
			
			detaformapagofactu=detaformapagofactuDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detaformapagofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detaformapagofactu = new  DetaFormaPagoFactu();
		  		  
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
		detaformapagofactu = new  DetaFormaPagoFactu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detaformapagofactuDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detaformapagofactu = new  DetaFormaPagoFactu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detaformapagofactuDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detaformapagofactu = new  DetaFormaPagoFactu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detaformapagofactuDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detaformapagofactu = new  DetaFormaPagoFactu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detaformapagofactuDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detaformapagofactu = new  DetaFormaPagoFactu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detaformapagofactuDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detaformapagofactu = new  DetaFormaPagoFactu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detaformapagofactuDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
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
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		  		  
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
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		  		  
        try {			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		  		  
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
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
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
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		  		  
        try {
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
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
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
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
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detaformapagofactu = new  DetaFormaPagoFactu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactu=detaformapagofactuDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactu);
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
		detaformapagofactu = new  DetaFormaPagoFactu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactu=detaformapagofactuDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactus=detaformapagofactuDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
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
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		  		  
        try {
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactus=detaformapagofactuDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetaFormaPagoFactusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getTodosDetaFormaPagoFactusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
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
	
	public  void  getTodosDetaFormaPagoFactus(String sFinalQuery,Pagination pagination)throws Exception {
		detaformapagofactus = new  ArrayList<DetaFormaPagoFactu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetaFormaPagoFactu(detaformapagofactus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetaFormaPagoFactu(DetaFormaPagoFactu detaformapagofactu) throws Exception {
		Boolean estaValidado=false;
		
		if(detaformapagofactu.getIsNew() || detaformapagofactu.getIsChanged()) { 
			this.invalidValues = detaformapagofactuValidator.getInvalidValues(detaformapagofactu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detaformapagofactu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetaFormaPagoFactu(List<DetaFormaPagoFactu> DetaFormaPagoFactus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetaFormaPagoFactu detaformapagofactuLocal:detaformapagofactus) {				
			estaValidadoObjeto=this.validarGuardarDetaFormaPagoFactu(detaformapagofactuLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetaFormaPagoFactu(List<DetaFormaPagoFactu> DetaFormaPagoFactus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetaFormaPagoFactu(detaformapagofactus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetaFormaPagoFactu(DetaFormaPagoFactu DetaFormaPagoFactu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetaFormaPagoFactu(detaformapagofactu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetaFormaPagoFactu detaformapagofactu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detaformapagofactu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetaFormaPagoFactuConstantesFunciones.getDetaFormaPagoFactuLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detaformapagofactu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetaFormaPagoFactuConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetaFormaPagoFactuConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetaFormaPagoFactuWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-saveDetaFormaPagoFactuWithConnection");connexion.begin();			
			
			DetaFormaPagoFactuLogicAdditional.checkDetaFormaPagoFactuToSave(this.detaformapagofactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetaFormaPagoFactuLogicAdditional.updateDetaFormaPagoFactuToSave(this.detaformapagofactu,this.arrDatoGeneral);
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detaformapagofactu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetaFormaPagoFactu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetaFormaPagoFactu(this.detaformapagofactu)) {
				DetaFormaPagoFactuDataAccess.save(this.detaformapagofactu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detaformapagofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetaFormaPagoFactuLogicAdditional.checkDetaFormaPagoFactuToSaveAfter(this.detaformapagofactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetaFormaPagoFactu();
			
			connexion.commit();			
			
			if(this.detaformapagofactu.getIsDeleted()) {
				this.detaformapagofactu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetaFormaPagoFactu()throws Exception {	
		try {	
			
			DetaFormaPagoFactuLogicAdditional.checkDetaFormaPagoFactuToSave(this.detaformapagofactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetaFormaPagoFactuLogicAdditional.updateDetaFormaPagoFactuToSave(this.detaformapagofactu,this.arrDatoGeneral);
			
			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detaformapagofactu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetaFormaPagoFactu(this.detaformapagofactu)) {			
				DetaFormaPagoFactuDataAccess.save(this.detaformapagofactu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detaformapagofactu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetaFormaPagoFactuLogicAdditional.checkDetaFormaPagoFactuToSaveAfter(this.detaformapagofactu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detaformapagofactu.getIsDeleted()) {
				this.detaformapagofactu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetaFormaPagoFactusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-saveDetaFormaPagoFactusWithConnection");connexion.begin();			
			
			DetaFormaPagoFactuLogicAdditional.checkDetaFormaPagoFactuToSaves(detaformapagofactus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetaFormaPagoFactus();
			
			Boolean validadoTodosDetaFormaPagoFactu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetaFormaPagoFactu detaformapagofactuLocal:detaformapagofactus) {		
				if(detaformapagofactuLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetaFormaPagoFactuLogicAdditional.updateDetaFormaPagoFactuToSave(detaformapagofactuLocal,this.arrDatoGeneral);
	        	
				DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detaformapagofactuLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetaFormaPagoFactu(detaformapagofactuLocal)) {
					DetaFormaPagoFactuDataAccess.save(detaformapagofactuLocal, connexion);				
				} else {
					validadoTodosDetaFormaPagoFactu=false;
				}
			}
			
			if(!validadoTodosDetaFormaPagoFactu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetaFormaPagoFactuLogicAdditional.checkDetaFormaPagoFactuToSavesAfter(detaformapagofactus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetaFormaPagoFactus();
			
			connexion.commit();		
			
			this.quitarDetaFormaPagoFactusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetaFormaPagoFactus()throws Exception {				
		 try {	
			DetaFormaPagoFactuLogicAdditional.checkDetaFormaPagoFactuToSaves(detaformapagofactus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetaFormaPagoFactu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetaFormaPagoFactu detaformapagofactuLocal:detaformapagofactus) {				
				if(detaformapagofactuLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetaFormaPagoFactuLogicAdditional.updateDetaFormaPagoFactuToSave(detaformapagofactuLocal,this.arrDatoGeneral);
	        	
				DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detaformapagofactuLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetaFormaPagoFactu(detaformapagofactuLocal)) {				
					DetaFormaPagoFactuDataAccess.save(detaformapagofactuLocal, connexion);				
				} else {
					validadoTodosDetaFormaPagoFactu=false;
				}
			}
			
			if(!validadoTodosDetaFormaPagoFactu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetaFormaPagoFactuLogicAdditional.checkDetaFormaPagoFactuToSavesAfter(detaformapagofactus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetaFormaPagoFactusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetaFormaPagoFactuParameterReturnGeneral procesarAccionDetaFormaPagoFactus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetaFormaPagoFactu> detaformapagofactus,DetaFormaPagoFactuParameterReturnGeneral detaformapagofactuParameterGeneral)throws Exception {
		 try {	
			DetaFormaPagoFactuParameterReturnGeneral detaformapagofactuReturnGeneral=new DetaFormaPagoFactuParameterReturnGeneral();
	
			DetaFormaPagoFactuLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detaformapagofactus,detaformapagofactuParameterGeneral,detaformapagofactuReturnGeneral);
			
			return detaformapagofactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetaFormaPagoFactuParameterReturnGeneral procesarAccionDetaFormaPagoFactusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetaFormaPagoFactu> detaformapagofactus,DetaFormaPagoFactuParameterReturnGeneral detaformapagofactuParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-procesarAccionDetaFormaPagoFactusWithConnection");connexion.begin();			
			
			DetaFormaPagoFactuParameterReturnGeneral detaformapagofactuReturnGeneral=new DetaFormaPagoFactuParameterReturnGeneral();
	
			DetaFormaPagoFactuLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detaformapagofactus,detaformapagofactuParameterGeneral,detaformapagofactuReturnGeneral);
			
			this.connexion.commit();
			
			return detaformapagofactuReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetaFormaPagoFactuParameterReturnGeneral procesarEventosDetaFormaPagoFactus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetaFormaPagoFactu> detaformapagofactus,DetaFormaPagoFactu detaformapagofactu,DetaFormaPagoFactuParameterReturnGeneral detaformapagofactuParameterGeneral,Boolean isEsNuevoDetaFormaPagoFactu,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetaFormaPagoFactuParameterReturnGeneral detaformapagofactuReturnGeneral=new DetaFormaPagoFactuParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detaformapagofactuReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetaFormaPagoFactuLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detaformapagofactus,detaformapagofactu,detaformapagofactuParameterGeneral,detaformapagofactuReturnGeneral,isEsNuevoDetaFormaPagoFactu,clases);
			
			return detaformapagofactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetaFormaPagoFactuParameterReturnGeneral procesarEventosDetaFormaPagoFactusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetaFormaPagoFactu> detaformapagofactus,DetaFormaPagoFactu detaformapagofactu,DetaFormaPagoFactuParameterReturnGeneral detaformapagofactuParameterGeneral,Boolean isEsNuevoDetaFormaPagoFactu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-procesarEventosDetaFormaPagoFactusWithConnection");connexion.begin();			
			
			DetaFormaPagoFactuParameterReturnGeneral detaformapagofactuReturnGeneral=new DetaFormaPagoFactuParameterReturnGeneral();
	
			detaformapagofactuReturnGeneral.setDetaFormaPagoFactu(detaformapagofactu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detaformapagofactuReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetaFormaPagoFactuLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detaformapagofactus,detaformapagofactu,detaformapagofactuParameterGeneral,detaformapagofactuReturnGeneral,isEsNuevoDetaFormaPagoFactu,clases);
			
			this.connexion.commit();
			
			return detaformapagofactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetaFormaPagoFactuParameterReturnGeneral procesarImportacionDetaFormaPagoFactusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetaFormaPagoFactuParameterReturnGeneral detaformapagofactuParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-procesarImportacionDetaFormaPagoFactusWithConnection");connexion.begin();			
			
			DetaFormaPagoFactuParameterReturnGeneral detaformapagofactuReturnGeneral=new DetaFormaPagoFactuParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detaformapagofactus=new ArrayList<DetaFormaPagoFactu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detaformapagofactu=new DetaFormaPagoFactu();
				
				
				if(conColumnasBase) {this.detaformapagofactu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detaformapagofactu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detaformapagofactu.setnombre(arrColumnas[iColumn++]);
				this.detaformapagofactu.setdescripcion(arrColumnas[iColumn++]);
				
				this.detaformapagofactus.add(this.detaformapagofactu);
			}
			
			this.saveDetaFormaPagoFactus();
			
			this.connexion.commit();
			
			detaformapagofactuReturnGeneral.setConRetornoEstaProcesado(true);
			detaformapagofactuReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detaformapagofactuReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetaFormaPagoFactusEliminados() throws Exception {				
		
		List<DetaFormaPagoFactu> detaformapagofactusAux= new ArrayList<DetaFormaPagoFactu>();
		
		for(DetaFormaPagoFactu detaformapagofactu:detaformapagofactus) {
			if(!detaformapagofactu.getIsDeleted()) {
				detaformapagofactusAux.add(detaformapagofactu);
			}
		}
		
		detaformapagofactus=detaformapagofactusAux;
	}
	
	public void quitarDetaFormaPagoFactusNulos() throws Exception {				
		
		List<DetaFormaPagoFactu> detaformapagofactusAux= new ArrayList<DetaFormaPagoFactu>();
		
		for(DetaFormaPagoFactu detaformapagofactu : this.detaformapagofactus) {
			if(detaformapagofactu==null) {
				detaformapagofactusAux.add(detaformapagofactu);
			}
		}
		
		//this.detaformapagofactus=detaformapagofactusAux;
		
		this.detaformapagofactus.removeAll(detaformapagofactusAux);
	}
	
	public void getSetVersionRowDetaFormaPagoFactuWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detaformapagofactu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detaformapagofactu.getIsDeleted() || (detaformapagofactu.getIsChanged()&&!detaformapagofactu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detaformapagofactuDataAccess.getSetVersionRowDetaFormaPagoFactu(connexion,detaformapagofactu.getId());
				
				if(!detaformapagofactu.getVersionRow().equals(timestamp)) {	
					detaformapagofactu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detaformapagofactu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetaFormaPagoFactu()throws Exception {	
		
		if(detaformapagofactu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detaformapagofactu.getIsDeleted() || (detaformapagofactu.getIsChanged()&&!detaformapagofactu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detaformapagofactuDataAccess.getSetVersionRowDetaFormaPagoFactu(connexion,detaformapagofactu.getId());
			
			try {							
				if(!detaformapagofactu.getVersionRow().equals(timestamp)) {	
					detaformapagofactu.setVersionRow(timestamp);
				}
				
				detaformapagofactu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetaFormaPagoFactusWithConnection()throws Exception {	
		if(detaformapagofactus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetaFormaPagoFactu detaformapagofactuAux:detaformapagofactus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detaformapagofactuAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detaformapagofactuAux.getIsDeleted() || (detaformapagofactuAux.getIsChanged()&&!detaformapagofactuAux.getIsNew())) {
						
						timestamp=detaformapagofactuDataAccess.getSetVersionRowDetaFormaPagoFactu(connexion,detaformapagofactuAux.getId());
						
						if(!detaformapagofactu.getVersionRow().equals(timestamp)) {	
							detaformapagofactuAux.setVersionRow(timestamp);
						}
								
						detaformapagofactuAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetaFormaPagoFactus()throws Exception {	
		if(detaformapagofactus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetaFormaPagoFactu detaformapagofactuAux:detaformapagofactus) {
					if(detaformapagofactuAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detaformapagofactuAux.getIsDeleted() || (detaformapagofactuAux.getIsChanged()&&!detaformapagofactuAux.getIsNew())) {
						
						timestamp=detaformapagofactuDataAccess.getSetVersionRowDetaFormaPagoFactu(connexion,detaformapagofactuAux.getId());
						
						if(!detaformapagofactuAux.getVersionRow().equals(timestamp)) {	
							detaformapagofactuAux.setVersionRow(timestamp);
						}
						
													
						detaformapagofactuAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetaFormaPagoFactuParameterReturnGeneral cargarCombosLoteForeignKeyDetaFormaPagoFactuWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoFormaPago) throws Exception {
		DetaFormaPagoFactuParameterReturnGeneral  detaformapagofactuReturnGeneral =new DetaFormaPagoFactuParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetaFormaPagoFactuWithConnection");connexion.begin();
			
			detaformapagofactuReturnGeneral =new DetaFormaPagoFactuParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detaformapagofactuReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			detaformapagofactuReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detaformapagofactuReturnGeneral;
	}
	
	public DetaFormaPagoFactuParameterReturnGeneral cargarCombosLoteForeignKeyDetaFormaPagoFactu(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoFormaPago) throws Exception {
		DetaFormaPagoFactuParameterReturnGeneral  detaformapagofactuReturnGeneral =new DetaFormaPagoFactuParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detaformapagofactuReturnGeneral =new DetaFormaPagoFactuParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detaformapagofactuReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			detaformapagofactuReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detaformapagofactuReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyDetaFormaPagoFactuWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetaFormaPagoLogic detaformapagoLogic=new DetaFormaPagoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyDetaFormaPagoFactuWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetaFormaPago.class));
											
			

			detaformapagoLogic.setConnexion(this.getConnexion());
			detaformapagoLogic.setDatosCliente(this.datosCliente);
			detaformapagoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(DetaFormaPagoFactu detaformapagofactu:this.detaformapagofactus) {
				

				classes=new ArrayList<Classe>();
				classes=DetaFormaPagoConstantesFunciones.getClassesForeignKeysOfDetaFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				detaformapagoLogic.setDetaFormaPagos(detaformapagofactu.detaformapagos);
				detaformapagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(DetaFormaPagoFactu detaformapagofactu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetaFormaPagoFactuLogicAdditional.updateDetaFormaPagoFactuToGet(detaformapagofactu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detaformapagofactu.setEmpresa(detaformapagofactuDataAccess.getEmpresa(connexion,detaformapagofactu));
		detaformapagofactu.setTipoFormaPago(detaformapagofactuDataAccess.getTipoFormaPago(connexion,detaformapagofactu));
		detaformapagofactu.setDetaFormaPagos(detaformapagofactuDataAccess.getDetaFormaPagos(connexion,detaformapagofactu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detaformapagofactu.setEmpresa(detaformapagofactuDataAccess.getEmpresa(connexion,detaformapagofactu));
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				detaformapagofactu.setTipoFormaPago(detaformapagofactuDataAccess.getTipoFormaPago(connexion,detaformapagofactu));
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detaformapagofactu.setDetaFormaPagos(detaformapagofactuDataAccess.getDetaFormaPagos(connexion,detaformapagofactu));

				if(this.isConDeep) {
					DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(this.connexion);
					detaformapagoLogic.setDetaFormaPagos(detaformapagofactu.getDetaFormaPagos());
					ArrayList<Classe> classesLocal=DetaFormaPagoConstantesFunciones.getClassesForeignKeysOfDetaFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					detaformapagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(detaformapagoLogic.getDetaFormaPagos());
					detaformapagofactu.setDetaFormaPagos(detaformapagoLogic.getDetaFormaPagos());
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
			detaformapagofactu.setEmpresa(detaformapagofactuDataAccess.getEmpresa(connexion,detaformapagofactu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapagofactu.setTipoFormaPago(detaformapagofactuDataAccess.getTipoFormaPago(connexion,detaformapagofactu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaFormaPago.class));
			detaformapagofactu.setDetaFormaPagos(detaformapagofactuDataAccess.getDetaFormaPagos(connexion,detaformapagofactu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detaformapagofactu.setEmpresa(detaformapagofactuDataAccess.getEmpresa(connexion,detaformapagofactu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detaformapagofactu.getEmpresa(),isDeep,deepLoadType,clases);
				
		detaformapagofactu.setTipoFormaPago(detaformapagofactuDataAccess.getTipoFormaPago(connexion,detaformapagofactu));
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(detaformapagofactu.getTipoFormaPago(),isDeep,deepLoadType,clases);
				

		detaformapagofactu.setDetaFormaPagos(detaformapagofactuDataAccess.getDetaFormaPagos(connexion,detaformapagofactu));

		for(DetaFormaPago detaformapago:detaformapagofactu.getDetaFormaPagos()) {
			DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
			detaformapagoLogic.deepLoad(detaformapago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detaformapagofactu.setEmpresa(detaformapagofactuDataAccess.getEmpresa(connexion,detaformapagofactu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detaformapagofactu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				detaformapagofactu.setTipoFormaPago(detaformapagofactuDataAccess.getTipoFormaPago(connexion,detaformapagofactu));
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepLoad(detaformapagofactu.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detaformapagofactu.setDetaFormaPagos(detaformapagofactuDataAccess.getDetaFormaPagos(connexion,detaformapagofactu));

				for(DetaFormaPago detaformapago:detaformapagofactu.getDetaFormaPagos()) {
					DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
					detaformapagoLogic.deepLoad(detaformapago,isDeep,deepLoadType,clases);
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
			detaformapagofactu.setEmpresa(detaformapagofactuDataAccess.getEmpresa(connexion,detaformapagofactu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detaformapagofactu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapagofactu.setTipoFormaPago(detaformapagofactuDataAccess.getTipoFormaPago(connexion,detaformapagofactu));
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapagoLogic.deepLoad(detaformapagofactu.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaFormaPago.class));
			detaformapagofactu.setDetaFormaPagos(detaformapagofactuDataAccess.getDetaFormaPagos(connexion,detaformapagofactu));

			for(DetaFormaPago detaformapago:detaformapagofactu.getDetaFormaPagos()) {
				DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
				detaformapagoLogic.deepLoad(detaformapago,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetaFormaPagoFactu detaformapagofactu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetaFormaPagoFactuLogicAdditional.updateDetaFormaPagoFactuToSave(detaformapagofactu,this.arrDatoGeneral);
			
DetaFormaPagoFactuDataAccess.save(detaformapagofactu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detaformapagofactu.getEmpresa(),connexion);

		TipoFormaPagoDataAccess.save(detaformapagofactu.getTipoFormaPago(),connexion);

		for(DetaFormaPago detaformapago:detaformapagofactu.getDetaFormaPagos()) {
			detaformapago.setid_deta_forma_pago_factu(detaformapagofactu.getId());
			DetaFormaPagoDataAccess.save(detaformapago,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detaformapagofactu.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(detaformapagofactu.getTipoFormaPago(),connexion);
				continue;
			}


			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaFormaPago detaformapago:detaformapagofactu.getDetaFormaPagos()) {
					detaformapago.setid_deta_forma_pago_factu(detaformapagofactu.getId());
					DetaFormaPagoDataAccess.save(detaformapago,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detaformapagofactu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detaformapagofactu.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoFormaPagoDataAccess.save(detaformapagofactu.getTipoFormaPago(),connexion);
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(detaformapagofactu.getTipoFormaPago(),isDeep,deepLoadType,clases);
				

		for(DetaFormaPago detaformapago:detaformapagofactu.getDetaFormaPagos()) {
			DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
			detaformapago.setid_deta_forma_pago_factu(detaformapagofactu.getId());
			DetaFormaPagoDataAccess.save(detaformapago,connexion);
			detaformapagoLogic.deepSave(detaformapago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detaformapagofactu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detaformapagofactu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(detaformapagofactu.getTipoFormaPago(),connexion);
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepSave(detaformapagofactu.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaFormaPago detaformapago:detaformapagofactu.getDetaFormaPagos()) {
					DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
					detaformapago.setid_deta_forma_pago_factu(detaformapagofactu.getId());
					DetaFormaPagoDataAccess.save(detaformapago,connexion);
					detaformapagoLogic.deepSave(detaformapago,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(DetaFormaPagoFactu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detaformapagofactu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(detaformapagofactu);
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
			this.deepLoad(this.detaformapagofactu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetaFormaPagoFactu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detaformapagofactus!=null) {
				for(DetaFormaPagoFactu detaformapagofactu:detaformapagofactus) {
					this.deepLoad(detaformapagofactu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(detaformapagofactus);
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
			if(detaformapagofactus!=null) {
				for(DetaFormaPagoFactu detaformapagofactu:detaformapagofactus) {
					this.deepLoad(detaformapagofactu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(detaformapagofactus);
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
			this.getNewConnexionToDeep(DetaFormaPagoFactu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detaformapagofactu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetaFormaPagoFactu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detaformapagofactus!=null) {
				for(DetaFormaPagoFactu detaformapagofactu:detaformapagofactus) {
					this.deepSave(detaformapagofactu,isDeep,deepLoadType,clases);
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
			if(detaformapagofactus!=null) {
				for(DetaFormaPagoFactu detaformapagofactu:detaformapagofactus) {
					this.deepSave(detaformapagofactu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetaFormaPagoFactusBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",DetaFormaPagoFactuConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagoFactusBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",DetaFormaPagoFactuConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagoFactusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetaFormaPagoFactuConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagoFactusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetaFormaPagoFactuConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagoFactusFK_IdTipoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPagoFactu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagoFactusFK_IdTipoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			DetaFormaPagoFactuLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(this.detaformapagofactus);
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
			if(DetaFormaPagoFactuConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaFormaPagoFactuDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetaFormaPagoFactu detaformapagofactu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetaFormaPagoFactuConstantesFunciones.ISCONAUDITORIA) {
				if(detaformapagofactu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaFormaPagoFactuDataAccess.TABLENAME, detaformapagofactu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetaFormaPagoFactuConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetaFormaPagoFactuLogic.registrarAuditoriaDetallesDetaFormaPagoFactu(connexion,detaformapagofactu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detaformapagofactu.getIsDeleted()) {
					/*if(!detaformapagofactu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetaFormaPagoFactuDataAccess.TABLENAME, detaformapagofactu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetaFormaPagoFactuLogic.registrarAuditoriaDetallesDetaFormaPagoFactu(connexion,detaformapagofactu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaFormaPagoFactuDataAccess.TABLENAME, detaformapagofactu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detaformapagofactu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaFormaPagoFactuDataAccess.TABLENAME, detaformapagofactu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetaFormaPagoFactuConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetaFormaPagoFactuLogic.registrarAuditoriaDetallesDetaFormaPagoFactu(connexion,detaformapagofactu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetaFormaPagoFactu(Connexion connexion,DetaFormaPagoFactu detaformapagofactu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detaformapagofactu.getIsNew()||!detaformapagofactu.getid_empresa().equals(detaformapagofactu.getDetaFormaPagoFactuOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapagofactu.getDetaFormaPagoFactuOriginal().getid_empresa()!=null)
				{
					strValorActual=detaformapagofactu.getDetaFormaPagoFactuOriginal().getid_empresa().toString();
				}
				if(detaformapagofactu.getid_empresa()!=null)
				{
					strValorNuevo=detaformapagofactu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoFactuConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detaformapagofactu.getIsNew()||!detaformapagofactu.getid_tipo_forma_pago().equals(detaformapagofactu.getDetaFormaPagoFactuOriginal().getid_tipo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapagofactu.getDetaFormaPagoFactuOriginal().getid_tipo_forma_pago()!=null)
				{
					strValorActual=detaformapagofactu.getDetaFormaPagoFactuOriginal().getid_tipo_forma_pago().toString();
				}
				if(detaformapagofactu.getid_tipo_forma_pago()!=null)
				{
					strValorNuevo=detaformapagofactu.getid_tipo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoFactuConstantesFunciones.IDTIPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(detaformapagofactu.getIsNew()||!detaformapagofactu.getnombre().equals(detaformapagofactu.getDetaFormaPagoFactuOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapagofactu.getDetaFormaPagoFactuOriginal().getnombre()!=null)
				{
					strValorActual=detaformapagofactu.getDetaFormaPagoFactuOriginal().getnombre();
				}
				if(detaformapagofactu.getnombre()!=null)
				{
					strValorNuevo=detaformapagofactu.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoFactuConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(detaformapagofactu.getIsNew()||!detaformapagofactu.getdescripcion().equals(detaformapagofactu.getDetaFormaPagoFactuOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapagofactu.getDetaFormaPagoFactuOriginal().getdescripcion()!=null)
				{
					strValorActual=detaformapagofactu.getDetaFormaPagoFactuOriginal().getdescripcion();
				}
				if(detaformapagofactu.getdescripcion()!=null)
				{
					strValorNuevo=detaformapagofactu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoFactuConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetaFormaPagoFactuRelacionesWithConnection(DetaFormaPagoFactu detaformapagofactu,List<DetaFormaPago> detaformapagos) throws Exception {

		if(!detaformapagofactu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetaFormaPagoFactuRelacionesBase(detaformapagofactu,detaformapagos,true);
		}
	}

	public void saveDetaFormaPagoFactuRelaciones(DetaFormaPagoFactu detaformapagofactu,List<DetaFormaPago> detaformapagos)throws Exception {

		if(!detaformapagofactu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetaFormaPagoFactuRelacionesBase(detaformapagofactu,detaformapagos,false);
		}
	}

	public void saveDetaFormaPagoFactuRelacionesBase(DetaFormaPagoFactu detaformapagofactu,List<DetaFormaPago> detaformapagos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetaFormaPagoFactu-saveRelacionesWithConnection");}
	
			detaformapagofactu.setDetaFormaPagos(detaformapagos);

			this.setDetaFormaPagoFactu(detaformapagofactu);

			if(DetaFormaPagoFactuLogicAdditional.validarSaveRelaciones(detaformapagofactu,this)) {

				DetaFormaPagoFactuLogicAdditional.updateRelacionesToSave(detaformapagofactu,this);

				if((detaformapagofactu.getIsNew()||detaformapagofactu.getIsChanged())&&!detaformapagofactu.getIsDeleted()) {
					this.saveDetaFormaPagoFactu();
					this.saveDetaFormaPagoFactuRelacionesDetalles(detaformapagos);

				} else if(detaformapagofactu.getIsDeleted()) {
					this.saveDetaFormaPagoFactuRelacionesDetalles(detaformapagos);
					this.saveDetaFormaPagoFactu();
				}

				DetaFormaPagoFactuLogicAdditional.updateRelacionesToSaveAfter(detaformapagofactu,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetaFormaPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetaFormaPagos(detaformapagos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDetaFormaPagoFactuRelacionesDetalles(List<DetaFormaPago> detaformapagos)throws Exception {
		try {
	

			Long idDetaFormaPagoFactuActual=this.getDetaFormaPagoFactu().getId();

			DetaFormaPagoLogic detaformapagoLogic_Desde_DetaFormaPagoFactu=new DetaFormaPagoLogic();
			detaformapagoLogic_Desde_DetaFormaPagoFactu.setDetaFormaPagos(detaformapagos);

			detaformapagoLogic_Desde_DetaFormaPagoFactu.setConnexion(this.getConnexion());
			detaformapagoLogic_Desde_DetaFormaPagoFactu.setDatosCliente(this.datosCliente);

			for(DetaFormaPago detaformapago_Desde_DetaFormaPagoFactu:detaformapagoLogic_Desde_DetaFormaPagoFactu.getDetaFormaPagos()) {
				detaformapago_Desde_DetaFormaPagoFactu.setid_deta_forma_pago_factu(idDetaFormaPagoFactuActual);

				detaformapagoLogic_Desde_DetaFormaPagoFactu.setDetaFormaPago(detaformapago_Desde_DetaFormaPagoFactu);
				detaformapagoLogic_Desde_DetaFormaPagoFactu.saveDetaFormaPago();

				Long idDetaFormaPagoActual=detaformapago_Desde_DetaFormaPagoFactu.getId();

				BancoFormaPagoLogic bancoformapagoLogic_Desde_DetaFormaPago=new BancoFormaPagoLogic();

				if(detaformapago_Desde_DetaFormaPagoFactu.getBancoFormaPagos()==null){
					detaformapago_Desde_DetaFormaPagoFactu.setBancoFormaPagos(new ArrayList<BancoFormaPago>());
				}

				bancoformapagoLogic_Desde_DetaFormaPago.setBancoFormaPagos(detaformapago_Desde_DetaFormaPagoFactu.getBancoFormaPagos());

				bancoformapagoLogic_Desde_DetaFormaPago.setConnexion(this.getConnexion());
				bancoformapagoLogic_Desde_DetaFormaPago.setDatosCliente(this.datosCliente);

				for(BancoFormaPago bancoformapago_Desde_DetaFormaPago:bancoformapagoLogic_Desde_DetaFormaPago.getBancoFormaPagos()) {
					bancoformapago_Desde_DetaFormaPago.setid_deta_forma_pago(idDetaFormaPagoActual);
				}

				bancoformapagoLogic_Desde_DetaFormaPago.saveBancoFormaPagos();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetaFormaPagoFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetaFormaPagoFactuConstantesFunciones.getClassesForeignKeysOfDetaFormaPagoFactu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaFormaPagoFactu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetaFormaPagoFactuConstantesFunciones.getClassesRelationshipsOfDetaFormaPagoFactu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
