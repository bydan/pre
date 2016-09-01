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
import com.bydan.erp.facturacion.util.TipoGrupoFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoGrupoFormaPagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoGrupoFormaPagoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoGrupoFormaPago;
import com.bydan.erp.facturacion.business.logic.TipoGrupoFormaPagoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoGrupoFormaPagoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoGrupoFormaPagoLogic.class);
	
	protected TipoGrupoFormaPagoDataAccess tipogrupoformapagoDataAccess; 	
	protected TipoGrupoFormaPago tipogrupoformapago;
	protected List<TipoGrupoFormaPago> tipogrupoformapagos;
	protected Object tipogrupoformapagoObject;	
	protected List<Object> tipogrupoformapagosObject;
	
	public static ClassValidator<TipoGrupoFormaPago> tipogrupoformapagoValidator = new ClassValidator<TipoGrupoFormaPago>(TipoGrupoFormaPago.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoGrupoFormaPagoLogicAdditional tipogrupoformapagoLogicAdditional=null;
	
	public TipoGrupoFormaPagoLogicAdditional getTipoGrupoFormaPagoLogicAdditional() {
		return this.tipogrupoformapagoLogicAdditional;
	}
	
	public void setTipoGrupoFormaPagoLogicAdditional(TipoGrupoFormaPagoLogicAdditional tipogrupoformapagoLogicAdditional) {
		try {
			this.tipogrupoformapagoLogicAdditional=tipogrupoformapagoLogicAdditional;
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
	
	
	
	
	public  TipoGrupoFormaPagoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipogrupoformapagoDataAccess = new TipoGrupoFormaPagoDataAccess();
			
			this.tipogrupoformapagos= new ArrayList<TipoGrupoFormaPago>();
			this.tipogrupoformapago= new TipoGrupoFormaPago();
			
			this.tipogrupoformapagoObject=new Object();
			this.tipogrupoformapagosObject=new ArrayList<Object>();
				
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
			
			this.tipogrupoformapagoDataAccess.setConnexionType(this.connexionType);
			this.tipogrupoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoGrupoFormaPagoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipogrupoformapagoDataAccess = new TipoGrupoFormaPagoDataAccess();
			this.tipogrupoformapagos= new ArrayList<TipoGrupoFormaPago>();
			this.tipogrupoformapago= new TipoGrupoFormaPago();
			this.tipogrupoformapagoObject=new Object();
			this.tipogrupoformapagosObject=new ArrayList<Object>();
			
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
			
			this.tipogrupoformapagoDataAccess.setConnexionType(this.connexionType);
			this.tipogrupoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoGrupoFormaPago getTipoGrupoFormaPago() throws Exception {	
		TipoGrupoFormaPagoLogicAdditional.checkTipoGrupoFormaPagoToGet(tipogrupoformapago,this.datosCliente,this.arrDatoGeneral);
		TipoGrupoFormaPagoLogicAdditional.updateTipoGrupoFormaPagoToGet(tipogrupoformapago,this.arrDatoGeneral);
		
		return tipogrupoformapago;
	}
		
	public void setTipoGrupoFormaPago(TipoGrupoFormaPago newTipoGrupoFormaPago) {
		this.tipogrupoformapago = newTipoGrupoFormaPago;
	}
	
	public TipoGrupoFormaPagoDataAccess getTipoGrupoFormaPagoDataAccess() {
		return tipogrupoformapagoDataAccess;
	}
	
	public void setTipoGrupoFormaPagoDataAccess(TipoGrupoFormaPagoDataAccess newtipogrupoformapagoDataAccess) {
		this.tipogrupoformapagoDataAccess = newtipogrupoformapagoDataAccess;
	}
	
	public List<TipoGrupoFormaPago> getTipoGrupoFormaPagos() throws Exception {		
		this.quitarTipoGrupoFormaPagosNulos();
		
		TipoGrupoFormaPagoLogicAdditional.checkTipoGrupoFormaPagoToGets(tipogrupoformapagos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoGrupoFormaPago tipogrupoformapagoLocal: tipogrupoformapagos ) {
			TipoGrupoFormaPagoLogicAdditional.updateTipoGrupoFormaPagoToGet(tipogrupoformapagoLocal,this.arrDatoGeneral);
		}
		
		return tipogrupoformapagos;
	}
	
	public void setTipoGrupoFormaPagos(List<TipoGrupoFormaPago> newTipoGrupoFormaPagos) {
		this.tipogrupoformapagos = newTipoGrupoFormaPagos;
	}
	
	public Object getTipoGrupoFormaPagoObject() {	
		this.tipogrupoformapagoObject=this.tipogrupoformapagoDataAccess.getEntityObject();
		return this.tipogrupoformapagoObject;
	}
		
	public void setTipoGrupoFormaPagoObject(Object newTipoGrupoFormaPagoObject) {
		this.tipogrupoformapagoObject = newTipoGrupoFormaPagoObject;
	}
	
	public List<Object> getTipoGrupoFormaPagosObject() {		
		this.tipogrupoformapagosObject=this.tipogrupoformapagoDataAccess.getEntitiesObject();
		return this.tipogrupoformapagosObject;
	}
		
	public void setTipoGrupoFormaPagosObject(List<Object> newTipoGrupoFormaPagosObject) {
		this.tipogrupoformapagosObject = newTipoGrupoFormaPagosObject;
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
		
		if(this.tipogrupoformapagoDataAccess!=null) {
			this.tipogrupoformapagoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipogrupoformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipogrupoformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipogrupoformapago = new  TipoGrupoFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapago);
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
		tipogrupoformapago = new  TipoGrupoFormaPago();
		  		  
        try {
			
			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipogrupoformapago = new  TipoGrupoFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapago);
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
		tipogrupoformapago = new  TipoGrupoFormaPago();
		  		  
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
		tipogrupoformapago = new  TipoGrupoFormaPago();
		  		  
        try {
			
			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipogrupoformapago = new  TipoGrupoFormaPago();
		  		  
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
		tipogrupoformapago = new  TipoGrupoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipogrupoformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogrupoformapago = new  TipoGrupoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipogrupoformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogrupoformapago = new  TipoGrupoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipogrupoformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogrupoformapago = new  TipoGrupoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipogrupoformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogrupoformapago = new  TipoGrupoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipogrupoformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogrupoformapago = new  TipoGrupoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipogrupoformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
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
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		  		  
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
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		  		  
        try {			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		  		  
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
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
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
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		  		  
        try {
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
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
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
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
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipogrupoformapago = new  TipoGrupoFormaPago();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapago);
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
		tipogrupoformapago = new  TipoGrupoFormaPago();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
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
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		  		  
        try {
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoGrupoFormaPagosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getTodosTipoGrupoFormaPagosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
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
	
	public  void  getTodosTipoGrupoFormaPagos(String sFinalQuery,Pagination pagination)throws Exception {
		tipogrupoformapagos = new  ArrayList<TipoGrupoFormaPago>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGrupoFormaPago(tipogrupoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapago) throws Exception {
		Boolean estaValidado=false;
		
		if(tipogrupoformapago.getIsNew() || tipogrupoformapago.getIsChanged()) { 
			this.invalidValues = tipogrupoformapagoValidator.getInvalidValues(tipogrupoformapago);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipogrupoformapago);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoGrupoFormaPago(List<TipoGrupoFormaPago> TipoGrupoFormaPagos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoGrupoFormaPago tipogrupoformapagoLocal:tipogrupoformapagos) {				
			estaValidadoObjeto=this.validarGuardarTipoGrupoFormaPago(tipogrupoformapagoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoGrupoFormaPago(List<TipoGrupoFormaPago> TipoGrupoFormaPagos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGrupoFormaPago(tipogrupoformapagos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoGrupoFormaPago(TipoGrupoFormaPago TipoGrupoFormaPago) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGrupoFormaPago(tipogrupoformapago)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoGrupoFormaPago tipogrupoformapago) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipogrupoformapago.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipogrupoformapago","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoGrupoFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoGrupoFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoGrupoFormaPagoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-saveTipoGrupoFormaPagoWithConnection");connexion.begin();			
			
			TipoGrupoFormaPagoLogicAdditional.checkTipoGrupoFormaPagoToSave(this.tipogrupoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoGrupoFormaPagoLogicAdditional.updateTipoGrupoFormaPagoToSave(this.tipogrupoformapago,this.arrDatoGeneral);
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogrupoformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoGrupoFormaPago();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGrupoFormaPago(this.tipogrupoformapago)) {
				TipoGrupoFormaPagoDataAccess.save(this.tipogrupoformapago, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipogrupoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoGrupoFormaPagoLogicAdditional.checkTipoGrupoFormaPagoToSaveAfter(this.tipogrupoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGrupoFormaPago();
			
			connexion.commit();			
			
			if(this.tipogrupoformapago.getIsDeleted()) {
				this.tipogrupoformapago=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoGrupoFormaPago()throws Exception {	
		try {	
			
			TipoGrupoFormaPagoLogicAdditional.checkTipoGrupoFormaPagoToSave(this.tipogrupoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoGrupoFormaPagoLogicAdditional.updateTipoGrupoFormaPagoToSave(this.tipogrupoformapago,this.arrDatoGeneral);
			
			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogrupoformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGrupoFormaPago(this.tipogrupoformapago)) {			
				TipoGrupoFormaPagoDataAccess.save(this.tipogrupoformapago, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipogrupoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoGrupoFormaPagoLogicAdditional.checkTipoGrupoFormaPagoToSaveAfter(this.tipogrupoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipogrupoformapago.getIsDeleted()) {
				this.tipogrupoformapago=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoGrupoFormaPagosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-saveTipoGrupoFormaPagosWithConnection");connexion.begin();			
			
			TipoGrupoFormaPagoLogicAdditional.checkTipoGrupoFormaPagoToSaves(tipogrupoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoGrupoFormaPagos();
			
			Boolean validadoTodosTipoGrupoFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGrupoFormaPago tipogrupoformapagoLocal:tipogrupoformapagos) {		
				if(tipogrupoformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoGrupoFormaPagoLogicAdditional.updateTipoGrupoFormaPagoToSave(tipogrupoformapagoLocal,this.arrDatoGeneral);
	        	
				TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogrupoformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGrupoFormaPago(tipogrupoformapagoLocal)) {
					TipoGrupoFormaPagoDataAccess.save(tipogrupoformapagoLocal, connexion);				
				} else {
					validadoTodosTipoGrupoFormaPago=false;
				}
			}
			
			if(!validadoTodosTipoGrupoFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoGrupoFormaPagoLogicAdditional.checkTipoGrupoFormaPagoToSavesAfter(tipogrupoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGrupoFormaPagos();
			
			connexion.commit();		
			
			this.quitarTipoGrupoFormaPagosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoGrupoFormaPagos()throws Exception {				
		 try {	
			TipoGrupoFormaPagoLogicAdditional.checkTipoGrupoFormaPagoToSaves(tipogrupoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoGrupoFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGrupoFormaPago tipogrupoformapagoLocal:tipogrupoformapagos) {				
				if(tipogrupoformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoGrupoFormaPagoLogicAdditional.updateTipoGrupoFormaPagoToSave(tipogrupoformapagoLocal,this.arrDatoGeneral);
	        	
				TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogrupoformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGrupoFormaPago(tipogrupoformapagoLocal)) {				
					TipoGrupoFormaPagoDataAccess.save(tipogrupoformapagoLocal, connexion);				
				} else {
					validadoTodosTipoGrupoFormaPago=false;
				}
			}
			
			if(!validadoTodosTipoGrupoFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoGrupoFormaPagoLogicAdditional.checkTipoGrupoFormaPagoToSavesAfter(tipogrupoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoGrupoFormaPagosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGrupoFormaPagoParameterReturnGeneral procesarAccionTipoGrupoFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGrupoFormaPago> tipogrupoformapagos,TipoGrupoFormaPagoParameterReturnGeneral tipogrupoformapagoParameterGeneral)throws Exception {
		 try {	
			TipoGrupoFormaPagoParameterReturnGeneral tipogrupoformapagoReturnGeneral=new TipoGrupoFormaPagoParameterReturnGeneral();
	
			TipoGrupoFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipogrupoformapagos,tipogrupoformapagoParameterGeneral,tipogrupoformapagoReturnGeneral);
			
			return tipogrupoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGrupoFormaPagoParameterReturnGeneral procesarAccionTipoGrupoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGrupoFormaPago> tipogrupoformapagos,TipoGrupoFormaPagoParameterReturnGeneral tipogrupoformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-procesarAccionTipoGrupoFormaPagosWithConnection");connexion.begin();			
			
			TipoGrupoFormaPagoParameterReturnGeneral tipogrupoformapagoReturnGeneral=new TipoGrupoFormaPagoParameterReturnGeneral();
	
			TipoGrupoFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipogrupoformapagos,tipogrupoformapagoParameterGeneral,tipogrupoformapagoReturnGeneral);
			
			this.connexion.commit();
			
			return tipogrupoformapagoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGrupoFormaPagoParameterReturnGeneral procesarEventosTipoGrupoFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGrupoFormaPago> tipogrupoformapagos,TipoGrupoFormaPago tipogrupoformapago,TipoGrupoFormaPagoParameterReturnGeneral tipogrupoformapagoParameterGeneral,Boolean isEsNuevoTipoGrupoFormaPago,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoGrupoFormaPagoParameterReturnGeneral tipogrupoformapagoReturnGeneral=new TipoGrupoFormaPagoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogrupoformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoGrupoFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipogrupoformapagos,tipogrupoformapago,tipogrupoformapagoParameterGeneral,tipogrupoformapagoReturnGeneral,isEsNuevoTipoGrupoFormaPago,clases);
			
			return tipogrupoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoGrupoFormaPagoParameterReturnGeneral procesarEventosTipoGrupoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGrupoFormaPago> tipogrupoformapagos,TipoGrupoFormaPago tipogrupoformapago,TipoGrupoFormaPagoParameterReturnGeneral tipogrupoformapagoParameterGeneral,Boolean isEsNuevoTipoGrupoFormaPago,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-procesarEventosTipoGrupoFormaPagosWithConnection");connexion.begin();			
			
			TipoGrupoFormaPagoParameterReturnGeneral tipogrupoformapagoReturnGeneral=new TipoGrupoFormaPagoParameterReturnGeneral();
	
			tipogrupoformapagoReturnGeneral.setTipoGrupoFormaPago(tipogrupoformapago);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogrupoformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoGrupoFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipogrupoformapagos,tipogrupoformapago,tipogrupoformapagoParameterGeneral,tipogrupoformapagoReturnGeneral,isEsNuevoTipoGrupoFormaPago,clases);
			
			this.connexion.commit();
			
			return tipogrupoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGrupoFormaPagoParameterReturnGeneral procesarImportacionTipoGrupoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoGrupoFormaPagoParameterReturnGeneral tipogrupoformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-procesarImportacionTipoGrupoFormaPagosWithConnection");connexion.begin();			
			
			TipoGrupoFormaPagoParameterReturnGeneral tipogrupoformapagoReturnGeneral=new TipoGrupoFormaPagoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipogrupoformapagos=new ArrayList<TipoGrupoFormaPago>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipogrupoformapago=new TipoGrupoFormaPago();
				
				
				if(conColumnasBase) {this.tipogrupoformapago.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipogrupoformapago.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipogrupoformapago.setnombre(arrColumnas[iColumn++]);
				
				this.tipogrupoformapagos.add(this.tipogrupoformapago);
			}
			
			this.saveTipoGrupoFormaPagos();
			
			this.connexion.commit();
			
			tipogrupoformapagoReturnGeneral.setConRetornoEstaProcesado(true);
			tipogrupoformapagoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipogrupoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoGrupoFormaPagosEliminados() throws Exception {				
		
		List<TipoGrupoFormaPago> tipogrupoformapagosAux= new ArrayList<TipoGrupoFormaPago>();
		
		for(TipoGrupoFormaPago tipogrupoformapago:tipogrupoformapagos) {
			if(!tipogrupoformapago.getIsDeleted()) {
				tipogrupoformapagosAux.add(tipogrupoformapago);
			}
		}
		
		tipogrupoformapagos=tipogrupoformapagosAux;
	}
	
	public void quitarTipoGrupoFormaPagosNulos() throws Exception {				
		
		List<TipoGrupoFormaPago> tipogrupoformapagosAux= new ArrayList<TipoGrupoFormaPago>();
		
		for(TipoGrupoFormaPago tipogrupoformapago : this.tipogrupoformapagos) {
			if(tipogrupoformapago==null) {
				tipogrupoformapagosAux.add(tipogrupoformapago);
			}
		}
		
		//this.tipogrupoformapagos=tipogrupoformapagosAux;
		
		this.tipogrupoformapagos.removeAll(tipogrupoformapagosAux);
	}
	
	public void getSetVersionRowTipoGrupoFormaPagoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipogrupoformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipogrupoformapago.getIsDeleted() || (tipogrupoformapago.getIsChanged()&&!tipogrupoformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipogrupoformapagoDataAccess.getSetVersionRowTipoGrupoFormaPago(connexion,tipogrupoformapago.getId());
				
				if(!tipogrupoformapago.getVersionRow().equals(timestamp)) {	
					tipogrupoformapago.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipogrupoformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoGrupoFormaPago()throws Exception {	
		
		if(tipogrupoformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipogrupoformapago.getIsDeleted() || (tipogrupoformapago.getIsChanged()&&!tipogrupoformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipogrupoformapagoDataAccess.getSetVersionRowTipoGrupoFormaPago(connexion,tipogrupoformapago.getId());
			
			try {							
				if(!tipogrupoformapago.getVersionRow().equals(timestamp)) {	
					tipogrupoformapago.setVersionRow(timestamp);
				}
				
				tipogrupoformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoGrupoFormaPagosWithConnection()throws Exception {	
		if(tipogrupoformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoGrupoFormaPago tipogrupoformapagoAux:tipogrupoformapagos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipogrupoformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogrupoformapagoAux.getIsDeleted() || (tipogrupoformapagoAux.getIsChanged()&&!tipogrupoformapagoAux.getIsNew())) {
						
						timestamp=tipogrupoformapagoDataAccess.getSetVersionRowTipoGrupoFormaPago(connexion,tipogrupoformapagoAux.getId());
						
						if(!tipogrupoformapago.getVersionRow().equals(timestamp)) {	
							tipogrupoformapagoAux.setVersionRow(timestamp);
						}
								
						tipogrupoformapagoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoGrupoFormaPagos()throws Exception {	
		if(tipogrupoformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoGrupoFormaPago tipogrupoformapagoAux:tipogrupoformapagos) {
					if(tipogrupoformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogrupoformapagoAux.getIsDeleted() || (tipogrupoformapagoAux.getIsChanged()&&!tipogrupoformapagoAux.getIsNew())) {
						
						timestamp=tipogrupoformapagoDataAccess.getSetVersionRowTipoGrupoFormaPago(connexion,tipogrupoformapagoAux.getId());
						
						if(!tipogrupoformapagoAux.getVersionRow().equals(timestamp)) {	
							tipogrupoformapagoAux.setVersionRow(timestamp);
						}
						
													
						tipogrupoformapagoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoGrupoFormaPagoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic=new DatoGeneralEmpleadoLogic();
			AnticipoClienteLogic anticipoclienteLogic=new AnticipoClienteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoGrupoFormaPagoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TipoFormaPago.class));
			classes.add(new Classe(DatoGeneralEmpleado.class));
			classes.add(new Classe(AnticipoCliente.class));
											
			

			tipoformapagoLogic.setConnexion(this.getConnexion());
			tipoformapagoLogic.setDatosCliente(this.datosCliente);
			tipoformapagoLogic.setIsConRefrescarForeignKeys(true);

			datogeneralempleadoLogic.setConnexion(this.getConnexion());
			datogeneralempleadoLogic.setDatosCliente(this.datosCliente);
			datogeneralempleadoLogic.setIsConRefrescarForeignKeys(true);

			anticipoclienteLogic.setConnexion(this.getConnexion());
			anticipoclienteLogic.setDatosCliente(this.datosCliente);
			anticipoclienteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoGrupoFormaPago tipogrupoformapago:this.tipogrupoformapagos) {
				

				classes=new ArrayList<Classe>();
				classes=TipoFormaPagoConstantesFunciones.getClassesForeignKeysOfTipoFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				tipoformapagoLogic.setTipoFormaPagos(tipogrupoformapago.tipoformapagos);
				tipoformapagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				datogeneralempleadoLogic.setDatoGeneralEmpleados(tipogrupoformapago.datogeneralempleados);
				datogeneralempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AnticipoClienteConstantesFunciones.getClassesForeignKeysOfAnticipoCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				anticipoclienteLogic.setAnticipoClientes(tipogrupoformapago.anticipoclientes);
				anticipoclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoGrupoFormaPago tipogrupoformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoGrupoFormaPagoLogicAdditional.updateTipoGrupoFormaPagoToGet(tipogrupoformapago,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogrupoformapago.setTipoFormaPagos(tipogrupoformapagoDataAccess.getTipoFormaPagos(connexion,tipogrupoformapago));
		tipogrupoformapago.setDatoGeneralEmpleados(tipogrupoformapagoDataAccess.getDatoGeneralEmpleados(connexion,tipogrupoformapago));
		tipogrupoformapago.setAnticipoClientes(tipogrupoformapagoDataAccess.getAnticipoClientes(connexion,tipogrupoformapago));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogrupoformapago.setTipoFormaPagos(tipogrupoformapagoDataAccess.getTipoFormaPagos(connexion,tipogrupoformapago));

				if(this.isConDeep) {
					TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(this.connexion);
					tipoformapagoLogic.setTipoFormaPagos(tipogrupoformapago.getTipoFormaPagos());
					ArrayList<Classe> classesLocal=TipoFormaPagoConstantesFunciones.getClassesForeignKeysOfTipoFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					tipoformapagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(tipoformapagoLogic.getTipoFormaPagos());
					tipogrupoformapago.setTipoFormaPagos(tipoformapagoLogic.getTipoFormaPagos());
				}

				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogrupoformapago.setDatoGeneralEmpleados(tipogrupoformapagoDataAccess.getDatoGeneralEmpleados(connexion,tipogrupoformapago));

				if(this.isConDeep) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(this.connexion);
					datogeneralempleadoLogic.setDatoGeneralEmpleados(tipogrupoformapago.getDatoGeneralEmpleados());
					ArrayList<Classe> classesLocal=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					datogeneralempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleadoLogic.getDatoGeneralEmpleados());
					tipogrupoformapago.setDatoGeneralEmpleados(datogeneralempleadoLogic.getDatoGeneralEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogrupoformapago.setAnticipoClientes(tipogrupoformapagoDataAccess.getAnticipoClientes(connexion,tipogrupoformapago));

				if(this.isConDeep) {
					AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(this.connexion);
					anticipoclienteLogic.setAnticipoClientes(tipogrupoformapago.getAnticipoClientes());
					ArrayList<Classe> classesLocal=AnticipoClienteConstantesFunciones.getClassesForeignKeysOfAnticipoCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					anticipoclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AnticipoClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnticipoCliente(anticipoclienteLogic.getAnticipoClientes());
					tipogrupoformapago.setAnticipoClientes(anticipoclienteLogic.getAnticipoClientes());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoFormaPago.class));
			tipogrupoformapago.setTipoFormaPagos(tipogrupoformapagoDataAccess.getTipoFormaPagos(connexion,tipogrupoformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			tipogrupoformapago.setDatoGeneralEmpleados(tipogrupoformapagoDataAccess.getDatoGeneralEmpleados(connexion,tipogrupoformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AnticipoCliente.class));
			tipogrupoformapago.setAnticipoClientes(tipogrupoformapagoDataAccess.getAnticipoClientes(connexion,tipogrupoformapago));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipogrupoformapago.setTipoFormaPagos(tipogrupoformapagoDataAccess.getTipoFormaPagos(connexion,tipogrupoformapago));

		for(TipoFormaPago tipoformapago:tipogrupoformapago.getTipoFormaPagos()) {
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapagoLogic.deepLoad(tipoformapago,isDeep,deepLoadType,clases);
		}

		tipogrupoformapago.setDatoGeneralEmpleados(tipogrupoformapagoDataAccess.getDatoGeneralEmpleados(connexion,tipogrupoformapago));

		for(DatoGeneralEmpleado datogeneralempleado:tipogrupoformapago.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
		}

		tipogrupoformapago.setAnticipoClientes(tipogrupoformapagoDataAccess.getAnticipoClientes(connexion,tipogrupoformapago));

		for(AnticipoCliente anticipocliente:tipogrupoformapago.getAnticipoClientes()) {
			AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(connexion);
			anticipoclienteLogic.deepLoad(anticipocliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogrupoformapago.setTipoFormaPagos(tipogrupoformapagoDataAccess.getTipoFormaPagos(connexion,tipogrupoformapago));

				for(TipoFormaPago tipoformapago:tipogrupoformapago.getTipoFormaPagos()) {
					TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
					tipoformapagoLogic.deepLoad(tipoformapago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogrupoformapago.setDatoGeneralEmpleados(tipogrupoformapagoDataAccess.getDatoGeneralEmpleados(connexion,tipogrupoformapago));

				for(DatoGeneralEmpleado datogeneralempleado:tipogrupoformapago.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipogrupoformapago.setAnticipoClientes(tipogrupoformapagoDataAccess.getAnticipoClientes(connexion,tipogrupoformapago));

				for(AnticipoCliente anticipocliente:tipogrupoformapago.getAnticipoClientes()) {
					AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(connexion);
					anticipoclienteLogic.deepLoad(anticipocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoFormaPago.class));
			tipogrupoformapago.setTipoFormaPagos(tipogrupoformapagoDataAccess.getTipoFormaPagos(connexion,tipogrupoformapago));

			for(TipoFormaPago tipoformapago:tipogrupoformapago.getTipoFormaPagos()) {
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepLoad(tipoformapago,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			tipogrupoformapago.setDatoGeneralEmpleados(tipogrupoformapagoDataAccess.getDatoGeneralEmpleados(connexion,tipogrupoformapago));

			for(DatoGeneralEmpleado datogeneralempleado:tipogrupoformapago.getDatoGeneralEmpleados()) {
				DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
				datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AnticipoCliente.class));
			tipogrupoformapago.setAnticipoClientes(tipogrupoformapagoDataAccess.getAnticipoClientes(connexion,tipogrupoformapago));

			for(AnticipoCliente anticipocliente:tipogrupoformapago.getAnticipoClientes()) {
				AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(connexion);
				anticipoclienteLogic.deepLoad(anticipocliente,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoGrupoFormaPago tipogrupoformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoGrupoFormaPagoLogicAdditional.updateTipoGrupoFormaPagoToSave(tipogrupoformapago,this.arrDatoGeneral);
			
TipoGrupoFormaPagoDataAccess.save(tipogrupoformapago, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(TipoFormaPago tipoformapago:tipogrupoformapago.getTipoFormaPagos()) {
			tipoformapago.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
			TipoFormaPagoDataAccess.save(tipoformapago,connexion);
		}

		for(DatoGeneralEmpleado datogeneralempleado:tipogrupoformapago.getDatoGeneralEmpleados()) {
			datogeneralempleado.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
		}

		for(AnticipoCliente anticipocliente:tipogrupoformapago.getAnticipoClientes()) {
			anticipocliente.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
			AnticipoClienteDataAccess.save(anticipocliente,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(TipoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoFormaPago tipoformapago:tipogrupoformapago.getTipoFormaPagos()) {
					tipoformapago.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
					TipoFormaPagoDataAccess.save(tipoformapago,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:tipogrupoformapago.getDatoGeneralEmpleados()) {
					datogeneralempleado.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AnticipoCliente anticipocliente:tipogrupoformapago.getAnticipoClientes()) {
					anticipocliente.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
					AnticipoClienteDataAccess.save(anticipocliente,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(TipoFormaPago tipoformapago:tipogrupoformapago.getTipoFormaPagos()) {
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapago.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
			TipoFormaPagoDataAccess.save(tipoformapago,connexion);
			tipoformapagoLogic.deepSave(tipoformapago,isDeep,deepLoadType,clases);
		}

		for(DatoGeneralEmpleado datogeneralempleado:tipogrupoformapago.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleado.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
			datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
		}

		for(AnticipoCliente anticipocliente:tipogrupoformapago.getAnticipoClientes()) {
			AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(connexion);
			anticipocliente.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
			AnticipoClienteDataAccess.save(anticipocliente,connexion);
			anticipoclienteLogic.deepSave(anticipocliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(TipoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoFormaPago tipoformapago:tipogrupoformapago.getTipoFormaPagos()) {
					TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
					tipoformapago.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
					TipoFormaPagoDataAccess.save(tipoformapago,connexion);
					tipoformapagoLogic.deepSave(tipoformapago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:tipogrupoformapago.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleado.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
					datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AnticipoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AnticipoCliente anticipocliente:tipogrupoformapago.getAnticipoClientes()) {
					AnticipoClienteLogic anticipoclienteLogic= new AnticipoClienteLogic(connexion);
					anticipocliente.setid_tipo_grupo_forma_pago(tipogrupoformapago.getId());
					AnticipoClienteDataAccess.save(anticipocliente,connexion);
					anticipoclienteLogic.deepSave(anticipocliente,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoGrupoFormaPago.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipogrupoformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(tipogrupoformapago);
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
			this.deepLoad(this.tipogrupoformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGrupoFormaPago.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipogrupoformapagos!=null) {
				for(TipoGrupoFormaPago tipogrupoformapago:tipogrupoformapagos) {
					this.deepLoad(tipogrupoformapago,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(tipogrupoformapagos);
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
			if(tipogrupoformapagos!=null) {
				for(TipoGrupoFormaPago tipogrupoformapago:tipogrupoformapagos) {
					this.deepLoad(tipogrupoformapago,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(tipogrupoformapagos);
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
			this.getNewConnexionToDeep(TipoGrupoFormaPago.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipogrupoformapago,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoGrupoFormaPago.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipogrupoformapagos!=null) {
				for(TipoGrupoFormaPago tipogrupoformapago:tipogrupoformapagos) {
					this.deepSave(tipogrupoformapago,isDeep,deepLoadType,clases);
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
			if(tipogrupoformapagos!=null) {
				for(TipoGrupoFormaPago tipogrupoformapago:tipogrupoformapagos) {
					this.deepSave(tipogrupoformapago,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoGrupoFormaPagosBusquedaPorIdWithConnection(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoGrupoFormaPagoConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGrupoFormaPagosBusquedaPorId(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoGrupoFormaPagoConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGrupoFormaPagosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoGrupoFormaPagoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGrupoFormaPagosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoGrupoFormaPagoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoGrupoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogrupoformapagos=tipogrupoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGrupoFormaPagoPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoGrupoFormaPagoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapago);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGrupoFormaPagoPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoGrupoFormaPagoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoGrupoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoFormaPago(this.tipogrupoformapago);
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
			if(TipoGrupoFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoFormaPagoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoGrupoFormaPago tipogrupoformapago,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGrupoFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				if(tipogrupoformapago.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoFormaPagoDataAccess.TABLENAME, tipogrupoformapago.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGrupoFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGrupoFormaPagoLogic.registrarAuditoriaDetallesTipoGrupoFormaPago(connexion,tipogrupoformapago,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipogrupoformapago.getIsDeleted()) {
					/*if(!tipogrupoformapago.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoGrupoFormaPagoDataAccess.TABLENAME, tipogrupoformapago.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoGrupoFormaPagoLogic.registrarAuditoriaDetallesTipoGrupoFormaPago(connexion,tipogrupoformapago,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoFormaPagoDataAccess.TABLENAME, tipogrupoformapago.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipogrupoformapago.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoFormaPagoDataAccess.TABLENAME, tipogrupoformapago.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGrupoFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGrupoFormaPagoLogic.registrarAuditoriaDetallesTipoGrupoFormaPago(connexion,tipogrupoformapago,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoGrupoFormaPago(Connexion connexion,TipoGrupoFormaPago tipogrupoformapago)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipogrupoformapago.getIsNew()||!tipogrupoformapago.getnombre().equals(tipogrupoformapago.getTipoGrupoFormaPagoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogrupoformapago.getTipoGrupoFormaPagoOriginal().getnombre()!=null)
				{
					strValorActual=tipogrupoformapago.getTipoGrupoFormaPagoOriginal().getnombre();
				}
				if(tipogrupoformapago.getnombre()!=null)
				{
					strValorNuevo=tipogrupoformapago.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGrupoFormaPagoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoGrupoFormaPagoRelacionesWithConnection(TipoGrupoFormaPago tipogrupoformapago,List<TipoFormaPago> tipoformapagos,List<DatoGeneralEmpleado> datogeneralempleados,List<AnticipoCliente> anticipoclientes) throws Exception {

		if(!tipogrupoformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoGrupoFormaPagoRelacionesBase(tipogrupoformapago,tipoformapagos,datogeneralempleados,anticipoclientes,true);
		}
	}

	public void saveTipoGrupoFormaPagoRelaciones(TipoGrupoFormaPago tipogrupoformapago,List<TipoFormaPago> tipoformapagos,List<DatoGeneralEmpleado> datogeneralempleados,List<AnticipoCliente> anticipoclientes)throws Exception {

		if(!tipogrupoformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoGrupoFormaPagoRelacionesBase(tipogrupoformapago,tipoformapagos,datogeneralempleados,anticipoclientes,false);
		}
	}

	public void saveTipoGrupoFormaPagoRelacionesBase(TipoGrupoFormaPago tipogrupoformapago,List<TipoFormaPago> tipoformapagos,List<DatoGeneralEmpleado> datogeneralempleados,List<AnticipoCliente> anticipoclientes,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoGrupoFormaPago-saveRelacionesWithConnection");}
	
			tipogrupoformapago.setTipoFormaPagos(tipoformapagos);
			tipogrupoformapago.setDatoGeneralEmpleados(datogeneralempleados);
			tipogrupoformapago.setAnticipoClientes(anticipoclientes);

			this.setTipoGrupoFormaPago(tipogrupoformapago);

				if((tipogrupoformapago.getIsNew()||tipogrupoformapago.getIsChanged())&&!tipogrupoformapago.getIsDeleted()) {
					this.saveTipoGrupoFormaPago();
					this.saveTipoGrupoFormaPagoRelacionesDetalles(tipoformapagos,datogeneralempleados,anticipoclientes);

				} else if(tipogrupoformapago.getIsDeleted()) {
					this.saveTipoGrupoFormaPagoRelacionesDetalles(tipoformapagos,datogeneralempleados,anticipoclientes);
					this.saveTipoGrupoFormaPago();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TipoFormaPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresTipoFormaPagos(tipoformapagos,true,true);
			DatoGeneralEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoGeneralEmpleados(datogeneralempleados,true,true);
			AnticipoClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresAnticipoClientes(anticipoclientes,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoGrupoFormaPagoRelacionesDetalles(List<TipoFormaPago> tipoformapagos,List<DatoGeneralEmpleado> datogeneralempleados,List<AnticipoCliente> anticipoclientes)throws Exception {
		try {
	

			Long idTipoGrupoFormaPagoActual=this.getTipoGrupoFormaPago().getId();

			TipoFormaPagoLogic tipoformapagoLogic_Desde_TipoGrupoFormaPago=new TipoFormaPagoLogic();
			tipoformapagoLogic_Desde_TipoGrupoFormaPago.setTipoFormaPagos(tipoformapagos);

			tipoformapagoLogic_Desde_TipoGrupoFormaPago.setConnexion(this.getConnexion());
			tipoformapagoLogic_Desde_TipoGrupoFormaPago.setDatosCliente(this.datosCliente);

			for(TipoFormaPago tipoformapago_Desde_TipoGrupoFormaPago:tipoformapagoLogic_Desde_TipoGrupoFormaPago.getTipoFormaPagos()) {
				tipoformapago_Desde_TipoGrupoFormaPago.setid_tipo_grupo_forma_pago(idTipoGrupoFormaPagoActual);

				tipoformapagoLogic_Desde_TipoGrupoFormaPago.setTipoFormaPago(tipoformapago_Desde_TipoGrupoFormaPago);
				tipoformapagoLogic_Desde_TipoGrupoFormaPago.saveTipoFormaPago();
			}


			DatoGeneralEmpleadoLogic datogeneralempleadoLogic_Desde_TipoGrupoFormaPago=new DatoGeneralEmpleadoLogic();
			datogeneralempleadoLogic_Desde_TipoGrupoFormaPago.setDatoGeneralEmpleados(datogeneralempleados);

			datogeneralempleadoLogic_Desde_TipoGrupoFormaPago.setConnexion(this.getConnexion());
			datogeneralempleadoLogic_Desde_TipoGrupoFormaPago.setDatosCliente(this.datosCliente);

			for(DatoGeneralEmpleado datogeneralempleado_Desde_TipoGrupoFormaPago:datogeneralempleadoLogic_Desde_TipoGrupoFormaPago.getDatoGeneralEmpleados()) {
				datogeneralempleado_Desde_TipoGrupoFormaPago.setid_tipo_grupo_forma_pago(idTipoGrupoFormaPagoActual);
			}

			datogeneralempleadoLogic_Desde_TipoGrupoFormaPago.saveDatoGeneralEmpleados();

			AnticipoClienteLogic anticipoclienteLogic_Desde_TipoGrupoFormaPago=new AnticipoClienteLogic();
			anticipoclienteLogic_Desde_TipoGrupoFormaPago.setAnticipoClientes(anticipoclientes);

			anticipoclienteLogic_Desde_TipoGrupoFormaPago.setConnexion(this.getConnexion());
			anticipoclienteLogic_Desde_TipoGrupoFormaPago.setDatosCliente(this.datosCliente);

			for(AnticipoCliente anticipocliente_Desde_TipoGrupoFormaPago:anticipoclienteLogic_Desde_TipoGrupoFormaPago.getAnticipoClientes()) {
				anticipocliente_Desde_TipoGrupoFormaPago.setid_tipo_grupo_forma_pago(idTipoGrupoFormaPagoActual);
			}

			anticipoclienteLogic_Desde_TipoGrupoFormaPago.saveAnticipoClientes();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGrupoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGrupoFormaPagoConstantesFunciones.getClassesForeignKeysOfTipoGrupoFormaPago(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGrupoFormaPagoConstantesFunciones.getClassesRelationshipsOfTipoGrupoFormaPago(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
