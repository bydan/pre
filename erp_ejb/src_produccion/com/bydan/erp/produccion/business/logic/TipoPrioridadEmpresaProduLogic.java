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
package com.bydan.erp.produccion.business.logic;

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
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.produccion.util.TipoPrioridadEmpresaProduConstantesFunciones;
import com.bydan.erp.produccion.util.TipoPrioridadEmpresaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoPrioridadEmpresaProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.TipoPrioridadEmpresaProdu;
import com.bydan.erp.produccion.business.logic.TipoPrioridadEmpresaProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoPrioridadEmpresaProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoPrioridadEmpresaProduLogic.class);
	
	protected TipoPrioridadEmpresaProduDataAccess tipoprioridadempresaproduDataAccess; 	
	protected TipoPrioridadEmpresaProdu tipoprioridadempresaprodu;
	protected List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus;
	protected Object tipoprioridadempresaproduObject;	
	protected List<Object> tipoprioridadempresaprodusObject;
	
	public static ClassValidator<TipoPrioridadEmpresaProdu> tipoprioridadempresaproduValidator = new ClassValidator<TipoPrioridadEmpresaProdu>(TipoPrioridadEmpresaProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoPrioridadEmpresaProduLogicAdditional tipoprioridadempresaproduLogicAdditional=null;
	
	public TipoPrioridadEmpresaProduLogicAdditional getTipoPrioridadEmpresaProduLogicAdditional() {
		return this.tipoprioridadempresaproduLogicAdditional;
	}
	
	public void setTipoPrioridadEmpresaProduLogicAdditional(TipoPrioridadEmpresaProduLogicAdditional tipoprioridadempresaproduLogicAdditional) {
		try {
			this.tipoprioridadempresaproduLogicAdditional=tipoprioridadempresaproduLogicAdditional;
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
	
	
	
	
	public  TipoPrioridadEmpresaProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoprioridadempresaproduDataAccess = new TipoPrioridadEmpresaProduDataAccess();
			
			this.tipoprioridadempresaprodus= new ArrayList<TipoPrioridadEmpresaProdu>();
			this.tipoprioridadempresaprodu= new TipoPrioridadEmpresaProdu();
			
			this.tipoprioridadempresaproduObject=new Object();
			this.tipoprioridadempresaprodusObject=new ArrayList<Object>();
				
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
			
			this.tipoprioridadempresaproduDataAccess.setConnexionType(this.connexionType);
			this.tipoprioridadempresaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoPrioridadEmpresaProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoprioridadempresaproduDataAccess = new TipoPrioridadEmpresaProduDataAccess();
			this.tipoprioridadempresaprodus= new ArrayList<TipoPrioridadEmpresaProdu>();
			this.tipoprioridadempresaprodu= new TipoPrioridadEmpresaProdu();
			this.tipoprioridadempresaproduObject=new Object();
			this.tipoprioridadempresaprodusObject=new ArrayList<Object>();
			
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
			
			this.tipoprioridadempresaproduDataAccess.setConnexionType(this.connexionType);
			this.tipoprioridadempresaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoPrioridadEmpresaProdu getTipoPrioridadEmpresaProdu() throws Exception {	
		TipoPrioridadEmpresaProduLogicAdditional.checkTipoPrioridadEmpresaProduToGet(tipoprioridadempresaprodu,this.datosCliente,this.arrDatoGeneral);
		TipoPrioridadEmpresaProduLogicAdditional.updateTipoPrioridadEmpresaProduToGet(tipoprioridadempresaprodu,this.arrDatoGeneral);
		
		return tipoprioridadempresaprodu;
	}
		
	public void setTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu newTipoPrioridadEmpresaProdu) {
		this.tipoprioridadempresaprodu = newTipoPrioridadEmpresaProdu;
	}
	
	public TipoPrioridadEmpresaProduDataAccess getTipoPrioridadEmpresaProduDataAccess() {
		return tipoprioridadempresaproduDataAccess;
	}
	
	public void setTipoPrioridadEmpresaProduDataAccess(TipoPrioridadEmpresaProduDataAccess newtipoprioridadempresaproduDataAccess) {
		this.tipoprioridadempresaproduDataAccess = newtipoprioridadempresaproduDataAccess;
	}
	
	public List<TipoPrioridadEmpresaProdu> getTipoPrioridadEmpresaProdus() throws Exception {		
		this.quitarTipoPrioridadEmpresaProdusNulos();
		
		TipoPrioridadEmpresaProduLogicAdditional.checkTipoPrioridadEmpresaProduToGets(tipoprioridadempresaprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoPrioridadEmpresaProdu tipoprioridadempresaproduLocal: tipoprioridadempresaprodus ) {
			TipoPrioridadEmpresaProduLogicAdditional.updateTipoPrioridadEmpresaProduToGet(tipoprioridadempresaproduLocal,this.arrDatoGeneral);
		}
		
		return tipoprioridadempresaprodus;
	}
	
	public void setTipoPrioridadEmpresaProdus(List<TipoPrioridadEmpresaProdu> newTipoPrioridadEmpresaProdus) {
		this.tipoprioridadempresaprodus = newTipoPrioridadEmpresaProdus;
	}
	
	public Object getTipoPrioridadEmpresaProduObject() {	
		this.tipoprioridadempresaproduObject=this.tipoprioridadempresaproduDataAccess.getEntityObject();
		return this.tipoprioridadempresaproduObject;
	}
		
	public void setTipoPrioridadEmpresaProduObject(Object newTipoPrioridadEmpresaProduObject) {
		this.tipoprioridadempresaproduObject = newTipoPrioridadEmpresaProduObject;
	}
	
	public List<Object> getTipoPrioridadEmpresaProdusObject() {		
		this.tipoprioridadempresaprodusObject=this.tipoprioridadempresaproduDataAccess.getEntitiesObject();
		return this.tipoprioridadempresaprodusObject;
	}
		
	public void setTipoPrioridadEmpresaProdusObject(List<Object> newTipoPrioridadEmpresaProdusObject) {
		this.tipoprioridadempresaprodusObject = newTipoPrioridadEmpresaProdusObject;
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
		
		if(this.tipoprioridadempresaproduDataAccess!=null) {
			this.tipoprioridadempresaproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoprioridadempresaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoprioridadempresaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprioridadempresaprodu=tipoprioridadempresaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprioridadempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodu);
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
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		  		  
        try {
			
			tipoprioridadempresaprodu=tipoprioridadempresaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprioridadempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprioridadempresaprodu=tipoprioridadempresaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprioridadempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodu);
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
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		  		  
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
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		  		  
        try {
			
			tipoprioridadempresaprodu=tipoprioridadempresaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprioridadempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		  		  
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
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoprioridadempresaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoprioridadempresaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoprioridadempresaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoprioridadempresaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoprioridadempresaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoprioridadempresaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
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
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		  		  
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
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		  		  
        try {			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		  		  
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
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
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
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		  		  
        try {
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
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
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
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
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodu=tipoprioridadempresaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodu);
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
		tipoprioridadempresaprodu = new  TipoPrioridadEmpresaProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodu=tipoprioridadempresaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
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
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		  		  
        try {
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoPrioridadEmpresaProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getTodosTipoPrioridadEmpresaProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
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
	
	public  void  getTodosTipoPrioridadEmpresaProdus(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprioridadempresaprodus = new  ArrayList<TipoPrioridadEmpresaProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoprioridadempresaprodu.getIsNew() || tipoprioridadempresaprodu.getIsChanged()) { 
			this.invalidValues = tipoprioridadempresaproduValidator.getInvalidValues(tipoprioridadempresaprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoprioridadempresaprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoPrioridadEmpresaProdu(List<TipoPrioridadEmpresaProdu> TipoPrioridadEmpresaProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduLocal:tipoprioridadempresaprodus) {				
			estaValidadoObjeto=this.validarGuardarTipoPrioridadEmpresaProdu(tipoprioridadempresaproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoPrioridadEmpresaProdu(List<TipoPrioridadEmpresaProdu> TipoPrioridadEmpresaProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu TipoPrioridadEmpresaProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPrioridadEmpresaProdu(tipoprioridadempresaprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoprioridadempresaprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoPrioridadEmpresaProduConstantesFunciones.getTipoPrioridadEmpresaProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoprioridadempresaprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoPrioridadEmpresaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoPrioridadEmpresaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoPrioridadEmpresaProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-saveTipoPrioridadEmpresaProduWithConnection");connexion.begin();			
			
			TipoPrioridadEmpresaProduLogicAdditional.checkTipoPrioridadEmpresaProduToSave(this.tipoprioridadempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoPrioridadEmpresaProduLogicAdditional.updateTipoPrioridadEmpresaProduToSave(this.tipoprioridadempresaprodu,this.arrDatoGeneral);
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprioridadempresaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoPrioridadEmpresaProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodu)) {
				TipoPrioridadEmpresaProduDataAccess.save(this.tipoprioridadempresaprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoprioridadempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoPrioridadEmpresaProduLogicAdditional.checkTipoPrioridadEmpresaProduToSaveAfter(this.tipoprioridadempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPrioridadEmpresaProdu();
			
			connexion.commit();			
			
			if(this.tipoprioridadempresaprodu.getIsDeleted()) {
				this.tipoprioridadempresaprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoPrioridadEmpresaProdu()throws Exception {	
		try {	
			
			TipoPrioridadEmpresaProduLogicAdditional.checkTipoPrioridadEmpresaProduToSave(this.tipoprioridadempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoPrioridadEmpresaProduLogicAdditional.updateTipoPrioridadEmpresaProduToSave(this.tipoprioridadempresaprodu,this.arrDatoGeneral);
			
			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprioridadempresaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodu)) {			
				TipoPrioridadEmpresaProduDataAccess.save(this.tipoprioridadempresaprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoprioridadempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoPrioridadEmpresaProduLogicAdditional.checkTipoPrioridadEmpresaProduToSaveAfter(this.tipoprioridadempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoprioridadempresaprodu.getIsDeleted()) {
				this.tipoprioridadempresaprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoPrioridadEmpresaProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-saveTipoPrioridadEmpresaProdusWithConnection");connexion.begin();			
			
			TipoPrioridadEmpresaProduLogicAdditional.checkTipoPrioridadEmpresaProduToSaves(tipoprioridadempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoPrioridadEmpresaProdus();
			
			Boolean validadoTodosTipoPrioridadEmpresaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduLocal:tipoprioridadempresaprodus) {		
				if(tipoprioridadempresaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoPrioridadEmpresaProduLogicAdditional.updateTipoPrioridadEmpresaProduToSave(tipoprioridadempresaproduLocal,this.arrDatoGeneral);
	        	
				TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprioridadempresaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPrioridadEmpresaProdu(tipoprioridadempresaproduLocal)) {
					TipoPrioridadEmpresaProduDataAccess.save(tipoprioridadempresaproduLocal, connexion);				
				} else {
					validadoTodosTipoPrioridadEmpresaProdu=false;
				}
			}
			
			if(!validadoTodosTipoPrioridadEmpresaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoPrioridadEmpresaProduLogicAdditional.checkTipoPrioridadEmpresaProduToSavesAfter(tipoprioridadempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPrioridadEmpresaProdus();
			
			connexion.commit();		
			
			this.quitarTipoPrioridadEmpresaProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoPrioridadEmpresaProdus()throws Exception {				
		 try {	
			TipoPrioridadEmpresaProduLogicAdditional.checkTipoPrioridadEmpresaProduToSaves(tipoprioridadempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoPrioridadEmpresaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduLocal:tipoprioridadempresaprodus) {				
				if(tipoprioridadempresaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoPrioridadEmpresaProduLogicAdditional.updateTipoPrioridadEmpresaProduToSave(tipoprioridadempresaproduLocal,this.arrDatoGeneral);
	        	
				TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprioridadempresaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPrioridadEmpresaProdu(tipoprioridadempresaproduLocal)) {				
					TipoPrioridadEmpresaProduDataAccess.save(tipoprioridadempresaproduLocal, connexion);				
				} else {
					validadoTodosTipoPrioridadEmpresaProdu=false;
				}
			}
			
			if(!validadoTodosTipoPrioridadEmpresaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoPrioridadEmpresaProduLogicAdditional.checkTipoPrioridadEmpresaProduToSavesAfter(tipoprioridadempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoPrioridadEmpresaProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPrioridadEmpresaProduParameterReturnGeneral procesarAccionTipoPrioridadEmpresaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,TipoPrioridadEmpresaProduParameterReturnGeneral tipoprioridadempresaproduParameterGeneral)throws Exception {
		 try {	
			TipoPrioridadEmpresaProduParameterReturnGeneral tipoprioridadempresaproduReturnGeneral=new TipoPrioridadEmpresaProduParameterReturnGeneral();
	
			TipoPrioridadEmpresaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprioridadempresaprodus,tipoprioridadempresaproduParameterGeneral,tipoprioridadempresaproduReturnGeneral);
			
			return tipoprioridadempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPrioridadEmpresaProduParameterReturnGeneral procesarAccionTipoPrioridadEmpresaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,TipoPrioridadEmpresaProduParameterReturnGeneral tipoprioridadempresaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-procesarAccionTipoPrioridadEmpresaProdusWithConnection");connexion.begin();			
			
			TipoPrioridadEmpresaProduParameterReturnGeneral tipoprioridadempresaproduReturnGeneral=new TipoPrioridadEmpresaProduParameterReturnGeneral();
	
			TipoPrioridadEmpresaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprioridadempresaprodus,tipoprioridadempresaproduParameterGeneral,tipoprioridadempresaproduReturnGeneral);
			
			this.connexion.commit();
			
			return tipoprioridadempresaproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPrioridadEmpresaProduParameterReturnGeneral procesarEventosTipoPrioridadEmpresaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,TipoPrioridadEmpresaProduParameterReturnGeneral tipoprioridadempresaproduParameterGeneral,Boolean isEsNuevoTipoPrioridadEmpresaProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoPrioridadEmpresaProduParameterReturnGeneral tipoprioridadempresaproduReturnGeneral=new TipoPrioridadEmpresaProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprioridadempresaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoPrioridadEmpresaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprioridadempresaprodus,tipoprioridadempresaprodu,tipoprioridadempresaproduParameterGeneral,tipoprioridadempresaproduReturnGeneral,isEsNuevoTipoPrioridadEmpresaProdu,clases);
			
			return tipoprioridadempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoPrioridadEmpresaProduParameterReturnGeneral procesarEventosTipoPrioridadEmpresaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodus,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,TipoPrioridadEmpresaProduParameterReturnGeneral tipoprioridadempresaproduParameterGeneral,Boolean isEsNuevoTipoPrioridadEmpresaProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-procesarEventosTipoPrioridadEmpresaProdusWithConnection");connexion.begin();			
			
			TipoPrioridadEmpresaProduParameterReturnGeneral tipoprioridadempresaproduReturnGeneral=new TipoPrioridadEmpresaProduParameterReturnGeneral();
	
			tipoprioridadempresaproduReturnGeneral.setTipoPrioridadEmpresaProdu(tipoprioridadempresaprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprioridadempresaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoPrioridadEmpresaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprioridadempresaprodus,tipoprioridadempresaprodu,tipoprioridadempresaproduParameterGeneral,tipoprioridadempresaproduReturnGeneral,isEsNuevoTipoPrioridadEmpresaProdu,clases);
			
			this.connexion.commit();
			
			return tipoprioridadempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPrioridadEmpresaProduParameterReturnGeneral procesarImportacionTipoPrioridadEmpresaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoPrioridadEmpresaProduParameterReturnGeneral tipoprioridadempresaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-procesarImportacionTipoPrioridadEmpresaProdusWithConnection");connexion.begin();			
			
			TipoPrioridadEmpresaProduParameterReturnGeneral tipoprioridadempresaproduReturnGeneral=new TipoPrioridadEmpresaProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoprioridadempresaprodus=new ArrayList<TipoPrioridadEmpresaProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoprioridadempresaprodu=new TipoPrioridadEmpresaProdu();
				
				
				if(conColumnasBase) {this.tipoprioridadempresaprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoprioridadempresaprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoprioridadempresaprodu.setnombre(arrColumnas[iColumn++]);
				this.tipoprioridadempresaprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipoprioridadempresaprodus.add(this.tipoprioridadempresaprodu);
			}
			
			this.saveTipoPrioridadEmpresaProdus();
			
			this.connexion.commit();
			
			tipoprioridadempresaproduReturnGeneral.setConRetornoEstaProcesado(true);
			tipoprioridadempresaproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoprioridadempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoPrioridadEmpresaProdusEliminados() throws Exception {				
		
		List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodusAux= new ArrayList<TipoPrioridadEmpresaProdu>();
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu:tipoprioridadempresaprodus) {
			if(!tipoprioridadempresaprodu.getIsDeleted()) {
				tipoprioridadempresaprodusAux.add(tipoprioridadempresaprodu);
			}
		}
		
		tipoprioridadempresaprodus=tipoprioridadempresaprodusAux;
	}
	
	public void quitarTipoPrioridadEmpresaProdusNulos() throws Exception {				
		
		List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodusAux= new ArrayList<TipoPrioridadEmpresaProdu>();
		
		for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu : this.tipoprioridadempresaprodus) {
			if(tipoprioridadempresaprodu==null) {
				tipoprioridadempresaprodusAux.add(tipoprioridadempresaprodu);
			}
		}
		
		//this.tipoprioridadempresaprodus=tipoprioridadempresaprodusAux;
		
		this.tipoprioridadempresaprodus.removeAll(tipoprioridadempresaprodusAux);
	}
	
	public void getSetVersionRowTipoPrioridadEmpresaProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoprioridadempresaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoprioridadempresaprodu.getIsDeleted() || (tipoprioridadempresaprodu.getIsChanged()&&!tipoprioridadempresaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoprioridadempresaproduDataAccess.getSetVersionRowTipoPrioridadEmpresaProdu(connexion,tipoprioridadempresaprodu.getId());
				
				if(!tipoprioridadempresaprodu.getVersionRow().equals(timestamp)) {	
					tipoprioridadempresaprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoprioridadempresaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoPrioridadEmpresaProdu()throws Exception {	
		
		if(tipoprioridadempresaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoprioridadempresaprodu.getIsDeleted() || (tipoprioridadempresaprodu.getIsChanged()&&!tipoprioridadempresaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoprioridadempresaproduDataAccess.getSetVersionRowTipoPrioridadEmpresaProdu(connexion,tipoprioridadempresaprodu.getId());
			
			try {							
				if(!tipoprioridadempresaprodu.getVersionRow().equals(timestamp)) {	
					tipoprioridadempresaprodu.setVersionRow(timestamp);
				}
				
				tipoprioridadempresaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoPrioridadEmpresaProdusWithConnection()throws Exception {	
		if(tipoprioridadempresaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduAux:tipoprioridadempresaprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoprioridadempresaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprioridadempresaproduAux.getIsDeleted() || (tipoprioridadempresaproduAux.getIsChanged()&&!tipoprioridadempresaproduAux.getIsNew())) {
						
						timestamp=tipoprioridadempresaproduDataAccess.getSetVersionRowTipoPrioridadEmpresaProdu(connexion,tipoprioridadempresaproduAux.getId());
						
						if(!tipoprioridadempresaprodu.getVersionRow().equals(timestamp)) {	
							tipoprioridadempresaproduAux.setVersionRow(timestamp);
						}
								
						tipoprioridadempresaproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoPrioridadEmpresaProdus()throws Exception {	
		if(tipoprioridadempresaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoPrioridadEmpresaProdu tipoprioridadempresaproduAux:tipoprioridadempresaprodus) {
					if(tipoprioridadempresaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprioridadempresaproduAux.getIsDeleted() || (tipoprioridadempresaproduAux.getIsChanged()&&!tipoprioridadempresaproduAux.getIsNew())) {
						
						timestamp=tipoprioridadempresaproduDataAccess.getSetVersionRowTipoPrioridadEmpresaProdu(connexion,tipoprioridadempresaproduAux.getId());
						
						if(!tipoprioridadempresaproduAux.getVersionRow().equals(timestamp)) {	
							tipoprioridadempresaproduAux.setVersionRow(timestamp);
						}
						
													
						tipoprioridadempresaproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoPrioridadEmpresaProduParameterReturnGeneral cargarCombosLoteForeignKeyTipoPrioridadEmpresaProduWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoPrioridadEmpresaProduParameterReturnGeneral  tipoprioridadempresaproduReturnGeneral =new TipoPrioridadEmpresaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoPrioridadEmpresaProduWithConnection");connexion.begin();
			
			tipoprioridadempresaproduReturnGeneral =new TipoPrioridadEmpresaProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoprioridadempresaproduReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoprioridadempresaproduReturnGeneral;
	}
	
	public TipoPrioridadEmpresaProduParameterReturnGeneral cargarCombosLoteForeignKeyTipoPrioridadEmpresaProdu(String finalQueryGlobalEmpresa) throws Exception {
		TipoPrioridadEmpresaProduParameterReturnGeneral  tipoprioridadempresaproduReturnGeneral =new TipoPrioridadEmpresaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoprioridadempresaproduReturnGeneral =new TipoPrioridadEmpresaProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoprioridadempresaproduReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoprioridadempresaproduReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoPrioridadEmpresaProduWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			OrdenProduLogic ordenproduLogic=new OrdenProduLogic();
			PedidoProduLogic pedidoproduLogic=new PedidoProduLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoPrioridadEmpresaProduWithConnection");connexion.begin();
			
			
			classes.add(new Classe(OrdenProdu.class));
			classes.add(new Classe(PedidoProdu.class));
											
			

			ordenproduLogic.setConnexion(this.getConnexion());
			ordenproduLogic.setDatosCliente(this.datosCliente);
			ordenproduLogic.setIsConRefrescarForeignKeys(true);

			pedidoproduLogic.setConnexion(this.getConnexion());
			pedidoproduLogic.setDatosCliente(this.datosCliente);
			pedidoproduLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu:this.tipoprioridadempresaprodus) {
				

				classes=new ArrayList<Classe>();
				classes=OrdenProduConstantesFunciones.getClassesForeignKeysOfOrdenProdu(new ArrayList<Classe>(),DeepLoadType.NONE);

				ordenproduLogic.setOrdenProdus(tipoprioridadempresaprodu.ordenprodus);
				ordenproduLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoProduConstantesFunciones.getClassesForeignKeysOfPedidoProdu(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidoproduLogic.setPedidoProdus(tipoprioridadempresaprodu.pedidoprodus);
				pedidoproduLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoPrioridadEmpresaProduLogicAdditional.updateTipoPrioridadEmpresaProduToGet(tipoprioridadempresaprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprioridadempresaprodu.setEmpresa(tipoprioridadempresaproduDataAccess.getEmpresa(connexion,tipoprioridadempresaprodu));
		tipoprioridadempresaprodu.setOrdenProdus(tipoprioridadempresaproduDataAccess.getOrdenProdus(connexion,tipoprioridadempresaprodu));
		tipoprioridadempresaprodu.setPedidoProdus(tipoprioridadempresaproduDataAccess.getPedidoProdus(connexion,tipoprioridadempresaprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoprioridadempresaprodu.setEmpresa(tipoprioridadempresaproduDataAccess.getEmpresa(connexion,tipoprioridadempresaprodu));
				continue;
			}

			if(clas.clas.equals(OrdenProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprioridadempresaprodu.setOrdenProdus(tipoprioridadempresaproduDataAccess.getOrdenProdus(connexion,tipoprioridadempresaprodu));

				if(this.isConDeep) {
					OrdenProduLogic ordenproduLogic= new OrdenProduLogic(this.connexion);
					ordenproduLogic.setOrdenProdus(tipoprioridadempresaprodu.getOrdenProdus());
					ArrayList<Classe> classesLocal=OrdenProduConstantesFunciones.getClassesForeignKeysOfOrdenProdu(new ArrayList<Classe>(),DeepLoadType.NONE);
					ordenproduLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					OrdenProduConstantesFunciones.refrescarForeignKeysDescripcionesOrdenProdu(ordenproduLogic.getOrdenProdus());
					tipoprioridadempresaprodu.setOrdenProdus(ordenproduLogic.getOrdenProdus());
				}

				continue;
			}

			if(clas.clas.equals(PedidoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprioridadempresaprodu.setPedidoProdus(tipoprioridadempresaproduDataAccess.getPedidoProdus(connexion,tipoprioridadempresaprodu));

				if(this.isConDeep) {
					PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(this.connexion);
					pedidoproduLogic.setPedidoProdus(tipoprioridadempresaprodu.getPedidoProdus());
					ArrayList<Classe> classesLocal=PedidoProduConstantesFunciones.getClassesForeignKeysOfPedidoProdu(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidoproduLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(pedidoproduLogic.getPedidoProdus());
					tipoprioridadempresaprodu.setPedidoProdus(pedidoproduLogic.getPedidoProdus());
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
			tipoprioridadempresaprodu.setEmpresa(tipoprioridadempresaproduDataAccess.getEmpresa(connexion,tipoprioridadempresaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(OrdenProdu.class));
			tipoprioridadempresaprodu.setOrdenProdus(tipoprioridadempresaproduDataAccess.getOrdenProdus(connexion,tipoprioridadempresaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoProdu.class));
			tipoprioridadempresaprodu.setPedidoProdus(tipoprioridadempresaproduDataAccess.getPedidoProdus(connexion,tipoprioridadempresaprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprioridadempresaprodu.setEmpresa(tipoprioridadempresaproduDataAccess.getEmpresa(connexion,tipoprioridadempresaprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoprioridadempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoprioridadempresaprodu.setOrdenProdus(tipoprioridadempresaproduDataAccess.getOrdenProdus(connexion,tipoprioridadempresaprodu));

		for(OrdenProdu ordenprodu:tipoprioridadempresaprodu.getOrdenProdus()) {
			OrdenProduLogic ordenproduLogic= new OrdenProduLogic(connexion);
			ordenproduLogic.deepLoad(ordenprodu,isDeep,deepLoadType,clases);
		}

		tipoprioridadempresaprodu.setPedidoProdus(tipoprioridadempresaproduDataAccess.getPedidoProdus(connexion,tipoprioridadempresaprodu));

		for(PedidoProdu pedidoprodu:tipoprioridadempresaprodu.getPedidoProdus()) {
			PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
			pedidoproduLogic.deepLoad(pedidoprodu,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoprioridadempresaprodu.setEmpresa(tipoprioridadempresaproduDataAccess.getEmpresa(connexion,tipoprioridadempresaprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoprioridadempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprioridadempresaprodu.setOrdenProdus(tipoprioridadempresaproduDataAccess.getOrdenProdus(connexion,tipoprioridadempresaprodu));

				for(OrdenProdu ordenprodu:tipoprioridadempresaprodu.getOrdenProdus()) {
					OrdenProduLogic ordenproduLogic= new OrdenProduLogic(connexion);
					ordenproduLogic.deepLoad(ordenprodu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprioridadempresaprodu.setPedidoProdus(tipoprioridadempresaproduDataAccess.getPedidoProdus(connexion,tipoprioridadempresaprodu));

				for(PedidoProdu pedidoprodu:tipoprioridadempresaprodu.getPedidoProdus()) {
					PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
					pedidoproduLogic.deepLoad(pedidoprodu,isDeep,deepLoadType,clases);
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
			tipoprioridadempresaprodu.setEmpresa(tipoprioridadempresaproduDataAccess.getEmpresa(connexion,tipoprioridadempresaprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoprioridadempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(OrdenProdu.class));
			tipoprioridadempresaprodu.setOrdenProdus(tipoprioridadempresaproduDataAccess.getOrdenProdus(connexion,tipoprioridadempresaprodu));

			for(OrdenProdu ordenprodu:tipoprioridadempresaprodu.getOrdenProdus()) {
				OrdenProduLogic ordenproduLogic= new OrdenProduLogic(connexion);
				ordenproduLogic.deepLoad(ordenprodu,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoProdu.class));
			tipoprioridadempresaprodu.setPedidoProdus(tipoprioridadempresaproduDataAccess.getPedidoProdus(connexion,tipoprioridadempresaprodu));

			for(PedidoProdu pedidoprodu:tipoprioridadempresaprodu.getPedidoProdus()) {
				PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
				pedidoproduLogic.deepLoad(pedidoprodu,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoPrioridadEmpresaProduLogicAdditional.updateTipoPrioridadEmpresaProduToSave(tipoprioridadempresaprodu,this.arrDatoGeneral);
			
TipoPrioridadEmpresaProduDataAccess.save(tipoprioridadempresaprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoprioridadempresaprodu.getEmpresa(),connexion);

		for(OrdenProdu ordenprodu:tipoprioridadempresaprodu.getOrdenProdus()) {
			ordenprodu.setid_tipo_prioridad_empresa_produ(tipoprioridadempresaprodu.getId());
			OrdenProduDataAccess.save(ordenprodu,connexion);
		}

		for(PedidoProdu pedidoprodu:tipoprioridadempresaprodu.getPedidoProdus()) {
			pedidoprodu.setid_tipo_prioridad_empresa_produ(tipoprioridadempresaprodu.getId());
			PedidoProduDataAccess.save(pedidoprodu,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoprioridadempresaprodu.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(OrdenProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(OrdenProdu ordenprodu:tipoprioridadempresaprodu.getOrdenProdus()) {
					ordenprodu.setid_tipo_prioridad_empresa_produ(tipoprioridadempresaprodu.getId());
					OrdenProduDataAccess.save(ordenprodu,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PedidoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoProdu pedidoprodu:tipoprioridadempresaprodu.getPedidoProdus()) {
					pedidoprodu.setid_tipo_prioridad_empresa_produ(tipoprioridadempresaprodu.getId());
					PedidoProduDataAccess.save(pedidoprodu,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoprioridadempresaprodu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoprioridadempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(OrdenProdu ordenprodu:tipoprioridadempresaprodu.getOrdenProdus()) {
			OrdenProduLogic ordenproduLogic= new OrdenProduLogic(connexion);
			ordenprodu.setid_tipo_prioridad_empresa_produ(tipoprioridadempresaprodu.getId());
			OrdenProduDataAccess.save(ordenprodu,connexion);
			ordenproduLogic.deepSave(ordenprodu,isDeep,deepLoadType,clases);
		}

		for(PedidoProdu pedidoprodu:tipoprioridadempresaprodu.getPedidoProdus()) {
			PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
			pedidoprodu.setid_tipo_prioridad_empresa_produ(tipoprioridadempresaprodu.getId());
			PedidoProduDataAccess.save(pedidoprodu,connexion);
			pedidoproduLogic.deepSave(pedidoprodu,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoprioridadempresaprodu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoprioridadempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(OrdenProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(OrdenProdu ordenprodu:tipoprioridadempresaprodu.getOrdenProdus()) {
					OrdenProduLogic ordenproduLogic= new OrdenProduLogic(connexion);
					ordenprodu.setid_tipo_prioridad_empresa_produ(tipoprioridadempresaprodu.getId());
					OrdenProduDataAccess.save(ordenprodu,connexion);
					ordenproduLogic.deepSave(ordenprodu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoProdu pedidoprodu:tipoprioridadempresaprodu.getPedidoProdus()) {
					PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
					pedidoprodu.setid_tipo_prioridad_empresa_produ(tipoprioridadempresaprodu.getId());
					PedidoProduDataAccess.save(pedidoprodu,connexion);
					pedidoproduLogic.deepSave(pedidoprodu,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoPrioridadEmpresaProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoprioridadempresaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(tipoprioridadempresaprodu);
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
			this.deepLoad(this.tipoprioridadempresaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoPrioridadEmpresaProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoprioridadempresaprodus!=null) {
				for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu:tipoprioridadempresaprodus) {
					this.deepLoad(tipoprioridadempresaprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
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
			if(tipoprioridadempresaprodus!=null) {
				for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu:tipoprioridadempresaprodus) {
					this.deepLoad(tipoprioridadempresaprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(tipoprioridadempresaprodus);
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
			this.getNewConnexionToDeep(TipoPrioridadEmpresaProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoprioridadempresaprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoPrioridadEmpresaProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoprioridadempresaprodus!=null) {
				for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu:tipoprioridadempresaprodus) {
					this.deepSave(tipoprioridadempresaprodu,isDeep,deepLoadType,clases);
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
			if(tipoprioridadempresaprodus!=null) {
				for(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu:tipoprioridadempresaprodus) {
					this.deepSave(tipoprioridadempresaprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoPrioridadEmpresaProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPrioridadEmpresaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPrioridadEmpresaProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoPrioridadEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprioridadempresaprodus=tipoprioridadempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPrioridadEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrioridadEmpresaProdu(this.tipoprioridadempresaprodus);
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
			if(TipoPrioridadEmpresaProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrioridadEmpresaProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoPrioridadEmpresaProduConstantesFunciones.ISCONAUDITORIA) {
				if(tipoprioridadempresaprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrioridadEmpresaProduDataAccess.TABLENAME, tipoprioridadempresaprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPrioridadEmpresaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPrioridadEmpresaProduLogic.registrarAuditoriaDetallesTipoPrioridadEmpresaProdu(connexion,tipoprioridadempresaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoprioridadempresaprodu.getIsDeleted()) {
					/*if(!tipoprioridadempresaprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoPrioridadEmpresaProduDataAccess.TABLENAME, tipoprioridadempresaprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoPrioridadEmpresaProduLogic.registrarAuditoriaDetallesTipoPrioridadEmpresaProdu(connexion,tipoprioridadempresaprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrioridadEmpresaProduDataAccess.TABLENAME, tipoprioridadempresaprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoprioridadempresaprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPrioridadEmpresaProduDataAccess.TABLENAME, tipoprioridadempresaprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPrioridadEmpresaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPrioridadEmpresaProduLogic.registrarAuditoriaDetallesTipoPrioridadEmpresaProdu(connexion,tipoprioridadempresaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoPrioridadEmpresaProdu(Connexion connexion,TipoPrioridadEmpresaProdu tipoprioridadempresaprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoprioridadempresaprodu.getIsNew()||!tipoprioridadempresaprodu.getid_empresa().equals(tipoprioridadempresaprodu.getTipoPrioridadEmpresaProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprioridadempresaprodu.getTipoPrioridadEmpresaProduOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoprioridadempresaprodu.getTipoPrioridadEmpresaProduOriginal().getid_empresa().toString();
				}
				if(tipoprioridadempresaprodu.getid_empresa()!=null)
				{
					strValorNuevo=tipoprioridadempresaprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrioridadEmpresaProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoprioridadempresaprodu.getIsNew()||!tipoprioridadempresaprodu.getnombre().equals(tipoprioridadempresaprodu.getTipoPrioridadEmpresaProduOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprioridadempresaprodu.getTipoPrioridadEmpresaProduOriginal().getnombre()!=null)
				{
					strValorActual=tipoprioridadempresaprodu.getTipoPrioridadEmpresaProduOriginal().getnombre();
				}
				if(tipoprioridadempresaprodu.getnombre()!=null)
				{
					strValorNuevo=tipoprioridadempresaprodu.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrioridadEmpresaProduConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipoprioridadempresaprodu.getIsNew()||!tipoprioridadempresaprodu.getdescripcion().equals(tipoprioridadempresaprodu.getTipoPrioridadEmpresaProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprioridadempresaprodu.getTipoPrioridadEmpresaProduOriginal().getdescripcion()!=null)
				{
					strValorActual=tipoprioridadempresaprodu.getTipoPrioridadEmpresaProduOriginal().getdescripcion();
				}
				if(tipoprioridadempresaprodu.getdescripcion()!=null)
				{
					strValorNuevo=tipoprioridadempresaprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPrioridadEmpresaProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoPrioridadEmpresaProduRelacionesWithConnection(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,List<OrdenProdu> ordenprodus,List<PedidoProdu> pedidoprodus) throws Exception {

		if(!tipoprioridadempresaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoPrioridadEmpresaProduRelacionesBase(tipoprioridadempresaprodu,ordenprodus,pedidoprodus,true);
		}
	}

	public void saveTipoPrioridadEmpresaProduRelaciones(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,List<OrdenProdu> ordenprodus,List<PedidoProdu> pedidoprodus)throws Exception {

		if(!tipoprioridadempresaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoPrioridadEmpresaProduRelacionesBase(tipoprioridadempresaprodu,ordenprodus,pedidoprodus,false);
		}
	}

	public void saveTipoPrioridadEmpresaProduRelacionesBase(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu,List<OrdenProdu> ordenprodus,List<PedidoProdu> pedidoprodus,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoPrioridadEmpresaProdu-saveRelacionesWithConnection");}
	
			tipoprioridadempresaprodu.setOrdenProdus(ordenprodus);
			tipoprioridadempresaprodu.setPedidoProdus(pedidoprodus);

			this.setTipoPrioridadEmpresaProdu(tipoprioridadempresaprodu);

			if(TipoPrioridadEmpresaProduLogicAdditional.validarSaveRelaciones(tipoprioridadempresaprodu,this)) {

				TipoPrioridadEmpresaProduLogicAdditional.updateRelacionesToSave(tipoprioridadempresaprodu,this);

				if((tipoprioridadempresaprodu.getIsNew()||tipoprioridadempresaprodu.getIsChanged())&&!tipoprioridadempresaprodu.getIsDeleted()) {
					this.saveTipoPrioridadEmpresaProdu();
					this.saveTipoPrioridadEmpresaProduRelacionesDetalles(ordenprodus,pedidoprodus);

				} else if(tipoprioridadempresaprodu.getIsDeleted()) {
					this.saveTipoPrioridadEmpresaProduRelacionesDetalles(ordenprodus,pedidoprodus);
					this.saveTipoPrioridadEmpresaProdu();
				}

				TipoPrioridadEmpresaProduLogicAdditional.updateRelacionesToSaveAfter(tipoprioridadempresaprodu,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			OrdenProduConstantesFunciones.InicializarGeneralEntityAuxiliaresOrdenProdus(ordenprodus,true,true);
			PedidoProduConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoProdus(pedidoprodus,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoPrioridadEmpresaProduRelacionesDetalles(List<OrdenProdu> ordenprodus,List<PedidoProdu> pedidoprodus)throws Exception {
		try {
	

			Long idTipoPrioridadEmpresaProduActual=this.getTipoPrioridadEmpresaProdu().getId();

			OrdenProduLogic ordenproduLogic_Desde_TipoPrioridadEmpresaProdu=new OrdenProduLogic();
			ordenproduLogic_Desde_TipoPrioridadEmpresaProdu.setOrdenProdus(ordenprodus);

			ordenproduLogic_Desde_TipoPrioridadEmpresaProdu.setConnexion(this.getConnexion());
			ordenproduLogic_Desde_TipoPrioridadEmpresaProdu.setDatosCliente(this.datosCliente);

			for(OrdenProdu ordenprodu_Desde_TipoPrioridadEmpresaProdu:ordenproduLogic_Desde_TipoPrioridadEmpresaProdu.getOrdenProdus()) {
				ordenprodu_Desde_TipoPrioridadEmpresaProdu.setid_tipo_prioridad_empresa_produ(idTipoPrioridadEmpresaProduActual);

				ordenproduLogic_Desde_TipoPrioridadEmpresaProdu.setOrdenProdu(ordenprodu_Desde_TipoPrioridadEmpresaProdu);
				ordenproduLogic_Desde_TipoPrioridadEmpresaProdu.saveOrdenProdu();

				Long idOrdenProduActual=ordenprodu_Desde_TipoPrioridadEmpresaProdu.getId();

				OrdenDetaProduLogic ordendetaproduLogic_Desde_OrdenProdu=new OrdenDetaProduLogic();

				if(ordenprodu_Desde_TipoPrioridadEmpresaProdu.getOrdenDetaProdus()==null){
					ordenprodu_Desde_TipoPrioridadEmpresaProdu.setOrdenDetaProdus(new ArrayList<OrdenDetaProdu>());
				}

				ordendetaproduLogic_Desde_OrdenProdu.setOrdenDetaProdus(ordenprodu_Desde_TipoPrioridadEmpresaProdu.getOrdenDetaProdus());

				ordendetaproduLogic_Desde_OrdenProdu.setConnexion(this.getConnexion());
				ordendetaproduLogic_Desde_OrdenProdu.setDatosCliente(this.datosCliente);

				for(OrdenDetaProdu ordendetaprodu_Desde_OrdenProdu:ordendetaproduLogic_Desde_OrdenProdu.getOrdenDetaProdus()) {
					ordendetaprodu_Desde_OrdenProdu.setid_orden_produ(idOrdenProduActual);

					ordendetaproduLogic_Desde_OrdenProdu.setOrdenDetaProdu(ordendetaprodu_Desde_OrdenProdu);
					ordendetaproduLogic_Desde_OrdenProdu.saveOrdenDetaProdu();

					Long idOrdenDetaProduActual=ordendetaprodu_Desde_OrdenProdu.getId();

					ProductoOrdenDetaProduGastoLogic productoordendetaprodugastoLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduGastoLogic();

					if(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduGastos()==null){
						ordendetaprodu_Desde_OrdenProdu.setProductoOrdenDetaProduGastos(new ArrayList<ProductoOrdenDetaProduGasto>());
					}

					productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduGastos(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduGastos());

					productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
					productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

					for(ProductoOrdenDetaProduGasto productoordendetaprodugasto_Desde_OrdenDetaProdu:productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduGastos()) {
						productoordendetaprodugasto_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
					}

					productoordendetaprodugastoLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduGastos();

					ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduManoLogic();

					if(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduManos()==null){
						ordendetaprodu_Desde_OrdenProdu.setProductoOrdenDetaProduManos(new ArrayList<ProductoOrdenDetaProduMano>());
					}

					productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduManos(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduManos());

					productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
					productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

					for(ProductoOrdenDetaProduMano productoordendetaprodumano_Desde_OrdenDetaProdu:productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduManos()) {
						productoordendetaprodumano_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
					}

					productoordendetaprodumanoLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduManos();

					ProductoOrdenDetaProduLogic productoordendetaproduLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduLogic();

					if(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProdus()==null){
						ordendetaprodu_Desde_OrdenProdu.setProductoOrdenDetaProdus(new ArrayList<ProductoOrdenDetaProdu>());
					}

					productoordendetaproduLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProdus(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProdus());

					productoordendetaproduLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
					productoordendetaproduLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

					for(ProductoOrdenDetaProdu productoordendetaprodu_Desde_OrdenDetaProdu:productoordendetaproduLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProdus()) {
						productoordendetaprodu_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
					}

					productoordendetaproduLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProdus();

					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduMaquinaLogic();

					if(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduMaquinas()==null){
						ordendetaprodu_Desde_OrdenProdu.setProductoOrdenDetaProduMaquinas(new ArrayList<ProductoOrdenDetaProduMaquina>());
					}

					productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduMaquinas(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduMaquinas());

					productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
					productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

					for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina_Desde_OrdenDetaProdu:productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduMaquinas()) {
						productoordendetaprodumaquina_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
					}

					productoordendetaprodumaquinaLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduMaquinas();

					ProductoOrdenDetaProduMermaLogic productoordendetaprodumermaLogic_Desde_OrdenDetaProdu=new ProductoOrdenDetaProduMermaLogic();

					if(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduMermas()==null){
						ordendetaprodu_Desde_OrdenProdu.setProductoOrdenDetaProduMermas(new ArrayList<ProductoOrdenDetaProduMerma>());
					}

					productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.setProductoOrdenDetaProduMermas(ordendetaprodu_Desde_OrdenProdu.getProductoOrdenDetaProduMermas());

					productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.setConnexion(this.getConnexion());
					productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.setDatosCliente(this.datosCliente);

					for(ProductoOrdenDetaProduMerma productoordendetaprodumerma_Desde_OrdenDetaProdu:productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.getProductoOrdenDetaProduMermas()) {
						productoordendetaprodumerma_Desde_OrdenDetaProdu.setid_orden_deta_produ(idOrdenDetaProduActual);
					}

					productoordendetaprodumermaLogic_Desde_OrdenDetaProdu.saveProductoOrdenDetaProduMermas();
				}

			}


			PedidoProduLogic pedidoproduLogic_Desde_TipoPrioridadEmpresaProdu=new PedidoProduLogic();
			pedidoproduLogic_Desde_TipoPrioridadEmpresaProdu.setPedidoProdus(pedidoprodus);

			pedidoproduLogic_Desde_TipoPrioridadEmpresaProdu.setConnexion(this.getConnexion());
			pedidoproduLogic_Desde_TipoPrioridadEmpresaProdu.setDatosCliente(this.datosCliente);

			for(PedidoProdu pedidoprodu_Desde_TipoPrioridadEmpresaProdu:pedidoproduLogic_Desde_TipoPrioridadEmpresaProdu.getPedidoProdus()) {
				pedidoprodu_Desde_TipoPrioridadEmpresaProdu.setid_tipo_prioridad_empresa_produ(idTipoPrioridadEmpresaProduActual);

				pedidoproduLogic_Desde_TipoPrioridadEmpresaProdu.setPedidoProdu(pedidoprodu_Desde_TipoPrioridadEmpresaProdu);
				pedidoproduLogic_Desde_TipoPrioridadEmpresaProdu.savePedidoProdu();

				Long idPedidoProduActual=pedidoprodu_Desde_TipoPrioridadEmpresaProdu.getId();

				PedidoDetaProduLogic pedidodetaproduLogic_Desde_PedidoProdu=new PedidoDetaProduLogic();

				if(pedidoprodu_Desde_TipoPrioridadEmpresaProdu.getPedidoDetaProdus()==null){
					pedidoprodu_Desde_TipoPrioridadEmpresaProdu.setPedidoDetaProdus(new ArrayList<PedidoDetaProdu>());
				}

				pedidodetaproduLogic_Desde_PedidoProdu.setPedidoDetaProdus(pedidoprodu_Desde_TipoPrioridadEmpresaProdu.getPedidoDetaProdus());

				pedidodetaproduLogic_Desde_PedidoProdu.setConnexion(this.getConnexion());
				pedidodetaproduLogic_Desde_PedidoProdu.setDatosCliente(this.datosCliente);

				for(PedidoDetaProdu pedidodetaprodu_Desde_PedidoProdu:pedidodetaproduLogic_Desde_PedidoProdu.getPedidoDetaProdus()) {
					pedidodetaprodu_Desde_PedidoProdu.setid_pedido_produ(idPedidoProduActual);
				}

				pedidodetaproduLogic_Desde_PedidoProdu.savePedidoDetaProdus();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPrioridadEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPrioridadEmpresaProduConstantesFunciones.getClassesForeignKeysOfTipoPrioridadEmpresaProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPrioridadEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPrioridadEmpresaProduConstantesFunciones.getClassesRelationshipsOfTipoPrioridadEmpresaProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
