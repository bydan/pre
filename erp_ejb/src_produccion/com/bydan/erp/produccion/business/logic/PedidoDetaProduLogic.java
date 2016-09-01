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
import com.bydan.erp.produccion.util.PedidoDetaProduConstantesFunciones;
import com.bydan.erp.produccion.util.PedidoDetaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.PedidoDetaProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.PedidoDetaProdu;
import com.bydan.erp.produccion.business.logic.PedidoDetaProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class PedidoDetaProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PedidoDetaProduLogic.class);
	
	protected PedidoDetaProduDataAccess pedidodetaproduDataAccess; 	
	protected PedidoDetaProdu pedidodetaprodu;
	protected List<PedidoDetaProdu> pedidodetaprodus;
	protected Object pedidodetaproduObject;	
	protected List<Object> pedidodetaprodusObject;
	
	public static ClassValidator<PedidoDetaProdu> pedidodetaproduValidator = new ClassValidator<PedidoDetaProdu>(PedidoDetaProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PedidoDetaProduLogicAdditional pedidodetaproduLogicAdditional=null;
	
	public PedidoDetaProduLogicAdditional getPedidoDetaProduLogicAdditional() {
		return this.pedidodetaproduLogicAdditional;
	}
	
	public void setPedidoDetaProduLogicAdditional(PedidoDetaProduLogicAdditional pedidodetaproduLogicAdditional) {
		try {
			this.pedidodetaproduLogicAdditional=pedidodetaproduLogicAdditional;
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
	
	
	
	
	public  PedidoDetaProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.pedidodetaproduDataAccess = new PedidoDetaProduDataAccess();
			
			this.pedidodetaprodus= new ArrayList<PedidoDetaProdu>();
			this.pedidodetaprodu= new PedidoDetaProdu();
			
			this.pedidodetaproduObject=new Object();
			this.pedidodetaprodusObject=new ArrayList<Object>();
				
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
			
			this.pedidodetaproduDataAccess.setConnexionType(this.connexionType);
			this.pedidodetaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PedidoDetaProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.pedidodetaproduDataAccess = new PedidoDetaProduDataAccess();
			this.pedidodetaprodus= new ArrayList<PedidoDetaProdu>();
			this.pedidodetaprodu= new PedidoDetaProdu();
			this.pedidodetaproduObject=new Object();
			this.pedidodetaprodusObject=new ArrayList<Object>();
			
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
			
			this.pedidodetaproduDataAccess.setConnexionType(this.connexionType);
			this.pedidodetaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PedidoDetaProdu getPedidoDetaProdu() throws Exception {	
		PedidoDetaProduLogicAdditional.checkPedidoDetaProduToGet(pedidodetaprodu,this.datosCliente,this.arrDatoGeneral);
		PedidoDetaProduLogicAdditional.updatePedidoDetaProduToGet(pedidodetaprodu,this.arrDatoGeneral);
		
		return pedidodetaprodu;
	}
		
	public void setPedidoDetaProdu(PedidoDetaProdu newPedidoDetaProdu) {
		this.pedidodetaprodu = newPedidoDetaProdu;
	}
	
	public PedidoDetaProduDataAccess getPedidoDetaProduDataAccess() {
		return pedidodetaproduDataAccess;
	}
	
	public void setPedidoDetaProduDataAccess(PedidoDetaProduDataAccess newpedidodetaproduDataAccess) {
		this.pedidodetaproduDataAccess = newpedidodetaproduDataAccess;
	}
	
	public List<PedidoDetaProdu> getPedidoDetaProdus() throws Exception {		
		this.quitarPedidoDetaProdusNulos();
		
		PedidoDetaProduLogicAdditional.checkPedidoDetaProduToGets(pedidodetaprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (PedidoDetaProdu pedidodetaproduLocal: pedidodetaprodus ) {
			PedidoDetaProduLogicAdditional.updatePedidoDetaProduToGet(pedidodetaproduLocal,this.arrDatoGeneral);
		}
		
		return pedidodetaprodus;
	}
	
	public void setPedidoDetaProdus(List<PedidoDetaProdu> newPedidoDetaProdus) {
		this.pedidodetaprodus = newPedidoDetaProdus;
	}
	
	public Object getPedidoDetaProduObject() {	
		this.pedidodetaproduObject=this.pedidodetaproduDataAccess.getEntityObject();
		return this.pedidodetaproduObject;
	}
		
	public void setPedidoDetaProduObject(Object newPedidoDetaProduObject) {
		this.pedidodetaproduObject = newPedidoDetaProduObject;
	}
	
	public List<Object> getPedidoDetaProdusObject() {		
		this.pedidodetaprodusObject=this.pedidodetaproduDataAccess.getEntitiesObject();
		return this.pedidodetaprodusObject;
	}
		
	public void setPedidoDetaProdusObject(List<Object> newPedidoDetaProdusObject) {
		this.pedidodetaprodusObject = newPedidoDetaProdusObject;
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
		
		if(this.pedidodetaproduDataAccess!=null) {
			this.pedidodetaproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			pedidodetaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			pedidodetaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		pedidodetaprodu = new  PedidoDetaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidodetaprodu=pedidodetaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidodetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodu);
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
		pedidodetaprodu = new  PedidoDetaProdu();
		  		  
        try {
			
			pedidodetaprodu=pedidodetaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidodetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		pedidodetaprodu = new  PedidoDetaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidodetaprodu=pedidodetaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidodetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodu);
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
		pedidodetaprodu = new  PedidoDetaProdu();
		  		  
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
		pedidodetaprodu = new  PedidoDetaProdu();
		  		  
        try {
			
			pedidodetaprodu=pedidodetaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidodetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		pedidodetaprodu = new  PedidoDetaProdu();
		  		  
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
		pedidodetaprodu = new  PedidoDetaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =pedidodetaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidodetaprodu = new  PedidoDetaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=pedidodetaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidodetaprodu = new  PedidoDetaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =pedidodetaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidodetaprodu = new  PedidoDetaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=pedidodetaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidodetaprodu = new  PedidoDetaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =pedidodetaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidodetaprodu = new  PedidoDetaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=pedidodetaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
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
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		  		  
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
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		  		  
        try {			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		  		  
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
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
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
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		  		  
        try {
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
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
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
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
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		pedidodetaprodu = new  PedidoDetaProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodu=pedidodetaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodu);
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
		pedidodetaprodu = new  PedidoDetaProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodu=pedidodetaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodus=pedidodetaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
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
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		  		  
        try {
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodus=pedidodetaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPedidoDetaProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getTodosPedidoDetaProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
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
	
	public  void  getTodosPedidoDetaProdus(String sFinalQuery,Pagination pagination)throws Exception {
		pedidodetaprodus = new  ArrayList<PedidoDetaProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoDetaProdu(pedidodetaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPedidoDetaProdu(PedidoDetaProdu pedidodetaprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(pedidodetaprodu.getIsNew() || pedidodetaprodu.getIsChanged()) { 
			this.invalidValues = pedidodetaproduValidator.getInvalidValues(pedidodetaprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(pedidodetaprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPedidoDetaProdu(List<PedidoDetaProdu> PedidoDetaProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PedidoDetaProdu pedidodetaproduLocal:pedidodetaprodus) {				
			estaValidadoObjeto=this.validarGuardarPedidoDetaProdu(pedidodetaproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPedidoDetaProdu(List<PedidoDetaProdu> PedidoDetaProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoDetaProdu(pedidodetaprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPedidoDetaProdu(PedidoDetaProdu PedidoDetaProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoDetaProdu(pedidodetaprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PedidoDetaProdu pedidodetaprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+pedidodetaprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PedidoDetaProduConstantesFunciones.getPedidoDetaProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"pedidodetaprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PedidoDetaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PedidoDetaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePedidoDetaProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-savePedidoDetaProduWithConnection");connexion.begin();			
			
			PedidoDetaProduLogicAdditional.checkPedidoDetaProduToSave(this.pedidodetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoDetaProduLogicAdditional.updatePedidoDetaProduToSave(this.pedidodetaprodu,this.arrDatoGeneral);
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidodetaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPedidoDetaProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoDetaProdu(this.pedidodetaprodu)) {
				PedidoDetaProduDataAccess.save(this.pedidodetaprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.pedidodetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoDetaProduLogicAdditional.checkPedidoDetaProduToSaveAfter(this.pedidodetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoDetaProdu();
			
			connexion.commit();			
			
			if(this.pedidodetaprodu.getIsDeleted()) {
				this.pedidodetaprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePedidoDetaProdu()throws Exception {	
		try {	
			
			PedidoDetaProduLogicAdditional.checkPedidoDetaProduToSave(this.pedidodetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoDetaProduLogicAdditional.updatePedidoDetaProduToSave(this.pedidodetaprodu,this.arrDatoGeneral);
			
			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidodetaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoDetaProdu(this.pedidodetaprodu)) {			
				PedidoDetaProduDataAccess.save(this.pedidodetaprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.pedidodetaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoDetaProduLogicAdditional.checkPedidoDetaProduToSaveAfter(this.pedidodetaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.pedidodetaprodu.getIsDeleted()) {
				this.pedidodetaprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePedidoDetaProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-savePedidoDetaProdusWithConnection");connexion.begin();			
			
			PedidoDetaProduLogicAdditional.checkPedidoDetaProduToSaves(pedidodetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPedidoDetaProdus();
			
			Boolean validadoTodosPedidoDetaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoDetaProdu pedidodetaproduLocal:pedidodetaprodus) {		
				if(pedidodetaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoDetaProduLogicAdditional.updatePedidoDetaProduToSave(pedidodetaproduLocal,this.arrDatoGeneral);
	        	
				PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidodetaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoDetaProdu(pedidodetaproduLocal)) {
					PedidoDetaProduDataAccess.save(pedidodetaproduLocal, connexion);				
				} else {
					validadoTodosPedidoDetaProdu=false;
				}
			}
			
			if(!validadoTodosPedidoDetaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoDetaProduLogicAdditional.checkPedidoDetaProduToSavesAfter(pedidodetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoDetaProdus();
			
			connexion.commit();		
			
			this.quitarPedidoDetaProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePedidoDetaProdus()throws Exception {				
		 try {	
			PedidoDetaProduLogicAdditional.checkPedidoDetaProduToSaves(pedidodetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPedidoDetaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoDetaProdu pedidodetaproduLocal:pedidodetaprodus) {				
				if(pedidodetaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoDetaProduLogicAdditional.updatePedidoDetaProduToSave(pedidodetaproduLocal,this.arrDatoGeneral);
	        	
				PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidodetaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoDetaProdu(pedidodetaproduLocal)) {				
					PedidoDetaProduDataAccess.save(pedidodetaproduLocal, connexion);				
				} else {
					validadoTodosPedidoDetaProdu=false;
				}
			}
			
			if(!validadoTodosPedidoDetaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoDetaProduLogicAdditional.checkPedidoDetaProduToSavesAfter(pedidodetaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPedidoDetaProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoDetaProduParameterReturnGeneral procesarAccionPedidoDetaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoDetaProdu> pedidodetaprodus,PedidoDetaProduParameterReturnGeneral pedidodetaproduParameterGeneral)throws Exception {
		 try {	
			PedidoDetaProduParameterReturnGeneral pedidodetaproduReturnGeneral=new PedidoDetaProduParameterReturnGeneral();
	
			PedidoDetaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidodetaprodus,pedidodetaproduParameterGeneral,pedidodetaproduReturnGeneral);
			
			return pedidodetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoDetaProduParameterReturnGeneral procesarAccionPedidoDetaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoDetaProdu> pedidodetaprodus,PedidoDetaProduParameterReturnGeneral pedidodetaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-procesarAccionPedidoDetaProdusWithConnection");connexion.begin();			
			
			PedidoDetaProduParameterReturnGeneral pedidodetaproduReturnGeneral=new PedidoDetaProduParameterReturnGeneral();
	
			PedidoDetaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidodetaprodus,pedidodetaproduParameterGeneral,pedidodetaproduReturnGeneral);
			
			this.connexion.commit();
			
			return pedidodetaproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoDetaProduParameterReturnGeneral procesarEventosPedidoDetaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoDetaProdu> pedidodetaprodus,PedidoDetaProdu pedidodetaprodu,PedidoDetaProduParameterReturnGeneral pedidodetaproduParameterGeneral,Boolean isEsNuevoPedidoDetaProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			PedidoDetaProduParameterReturnGeneral pedidodetaproduReturnGeneral=new PedidoDetaProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidodetaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoDetaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidodetaprodus,pedidodetaprodu,pedidodetaproduParameterGeneral,pedidodetaproduReturnGeneral,isEsNuevoPedidoDetaProdu,clases);
			
			return pedidodetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PedidoDetaProduParameterReturnGeneral procesarEventosPedidoDetaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoDetaProdu> pedidodetaprodus,PedidoDetaProdu pedidodetaprodu,PedidoDetaProduParameterReturnGeneral pedidodetaproduParameterGeneral,Boolean isEsNuevoPedidoDetaProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-procesarEventosPedidoDetaProdusWithConnection");connexion.begin();			
			
			PedidoDetaProduParameterReturnGeneral pedidodetaproduReturnGeneral=new PedidoDetaProduParameterReturnGeneral();
	
			pedidodetaproduReturnGeneral.setPedidoDetaProdu(pedidodetaprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidodetaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoDetaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidodetaprodus,pedidodetaprodu,pedidodetaproduParameterGeneral,pedidodetaproduReturnGeneral,isEsNuevoPedidoDetaProdu,clases);
			
			this.connexion.commit();
			
			return pedidodetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoDetaProduParameterReturnGeneral procesarImportacionPedidoDetaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PedidoDetaProduParameterReturnGeneral pedidodetaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-procesarImportacionPedidoDetaProdusWithConnection");connexion.begin();			
			
			PedidoDetaProduParameterReturnGeneral pedidodetaproduReturnGeneral=new PedidoDetaProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.pedidodetaprodus=new ArrayList<PedidoDetaProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.pedidodetaprodu=new PedidoDetaProdu();
				
				
				if(conColumnasBase) {this.pedidodetaprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.pedidodetaprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.pedidodetaprodu.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.pedidodetaprodu.setcantidad_pendiente(Integer.parseInt(arrColumnas[iColumn++]));
			this.pedidodetaprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.pedidodetaprodus.add(this.pedidodetaprodu);
			}
			
			this.savePedidoDetaProdus();
			
			this.connexion.commit();
			
			pedidodetaproduReturnGeneral.setConRetornoEstaProcesado(true);
			pedidodetaproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return pedidodetaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPedidoDetaProdusEliminados() throws Exception {				
		
		List<PedidoDetaProdu> pedidodetaprodusAux= new ArrayList<PedidoDetaProdu>();
		
		for(PedidoDetaProdu pedidodetaprodu:pedidodetaprodus) {
			if(!pedidodetaprodu.getIsDeleted()) {
				pedidodetaprodusAux.add(pedidodetaprodu);
			}
		}
		
		pedidodetaprodus=pedidodetaprodusAux;
	}
	
	public void quitarPedidoDetaProdusNulos() throws Exception {				
		
		List<PedidoDetaProdu> pedidodetaprodusAux= new ArrayList<PedidoDetaProdu>();
		
		for(PedidoDetaProdu pedidodetaprodu : this.pedidodetaprodus) {
			if(pedidodetaprodu==null) {
				pedidodetaprodusAux.add(pedidodetaprodu);
			}
		}
		
		//this.pedidodetaprodus=pedidodetaprodusAux;
		
		this.pedidodetaprodus.removeAll(pedidodetaprodusAux);
	}
	
	public void getSetVersionRowPedidoDetaProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(pedidodetaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((pedidodetaprodu.getIsDeleted() || (pedidodetaprodu.getIsChanged()&&!pedidodetaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=pedidodetaproduDataAccess.getSetVersionRowPedidoDetaProdu(connexion,pedidodetaprodu.getId());
				
				if(!pedidodetaprodu.getVersionRow().equals(timestamp)) {	
					pedidodetaprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				pedidodetaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPedidoDetaProdu()throws Exception {	
		
		if(pedidodetaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((pedidodetaprodu.getIsDeleted() || (pedidodetaprodu.getIsChanged()&&!pedidodetaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=pedidodetaproduDataAccess.getSetVersionRowPedidoDetaProdu(connexion,pedidodetaprodu.getId());
			
			try {							
				if(!pedidodetaprodu.getVersionRow().equals(timestamp)) {	
					pedidodetaprodu.setVersionRow(timestamp);
				}
				
				pedidodetaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPedidoDetaProdusWithConnection()throws Exception {	
		if(pedidodetaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PedidoDetaProdu pedidodetaproduAux:pedidodetaprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(pedidodetaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidodetaproduAux.getIsDeleted() || (pedidodetaproduAux.getIsChanged()&&!pedidodetaproduAux.getIsNew())) {
						
						timestamp=pedidodetaproduDataAccess.getSetVersionRowPedidoDetaProdu(connexion,pedidodetaproduAux.getId());
						
						if(!pedidodetaprodu.getVersionRow().equals(timestamp)) {	
							pedidodetaproduAux.setVersionRow(timestamp);
						}
								
						pedidodetaproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPedidoDetaProdus()throws Exception {	
		if(pedidodetaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PedidoDetaProdu pedidodetaproduAux:pedidodetaprodus) {
					if(pedidodetaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidodetaproduAux.getIsDeleted() || (pedidodetaproduAux.getIsChanged()&&!pedidodetaproduAux.getIsNew())) {
						
						timestamp=pedidodetaproduDataAccess.getSetVersionRowPedidoDetaProdu(connexion,pedidodetaproduAux.getId());
						
						if(!pedidodetaproduAux.getVersionRow().equals(timestamp)) {	
							pedidodetaproduAux.setVersionRow(timestamp);
						}
						
													
						pedidodetaproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PedidoDetaProduParameterReturnGeneral cargarCombosLoteForeignKeyPedidoDetaProduWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalPedidoProdu,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalBodegaDestino,String finalQueryGlobalTipoProcesoProdu) throws Exception {
		PedidoDetaProduParameterReturnGeneral  pedidodetaproduReturnGeneral =new PedidoDetaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyPedidoDetaProduWithConnection");connexion.begin();
			
			pedidodetaproduReturnGeneral =new PedidoDetaProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidodetaproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidodetaproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidodetaproduReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidodetaproduReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<PedidoProdu> pedidoprodusForeignKey=new ArrayList<PedidoProdu>();
			PedidoProduLogic pedidoproduLogic=new PedidoProduLogic();
			pedidoproduLogic.setConnexion(this.connexion);
			pedidoproduLogic.getPedidoProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoProdu.equals("NONE")) {
				pedidoproduLogic.getTodosPedidoProdus(finalQueryGlobalPedidoProdu,new Pagination());
				pedidoprodusForeignKey=pedidoproduLogic.getPedidoProdus();
			}

			pedidodetaproduReturnGeneral.setpedidoprodusForeignKey(pedidoprodusForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			pedidodetaproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			pedidodetaproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			pedidodetaproduReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Bodega> bodegadestinosForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegadestinoLogic=new BodegaLogic();
			bodegadestinoLogic.setConnexion(this.connexion);
			bodegadestinoLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaDestino.equals("NONE")) {
				bodegadestinoLogic.getTodosBodegas(finalQueryGlobalBodegaDestino,new Pagination());
				bodegadestinosForeignKey=bodegadestinoLogic.getBodegas();
			}

			pedidodetaproduReturnGeneral.setbodegadestinosForeignKey(bodegadestinosForeignKey);


			List<TipoProcesoProdu> tipoprocesoprodusForeignKey=new ArrayList<TipoProcesoProdu>();
			TipoProcesoProduLogic tipoprocesoproduLogic=new TipoProcesoProduLogic();
			tipoprocesoproduLogic.setConnexion(this.connexion);
			tipoprocesoproduLogic.getTipoProcesoProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoProdu.equals("NONE")) {
				tipoprocesoproduLogic.getTodosTipoProcesoProdus(finalQueryGlobalTipoProcesoProdu,new Pagination());
				tipoprocesoprodusForeignKey=tipoprocesoproduLogic.getTipoProcesoProdus();
			}

			pedidodetaproduReturnGeneral.settipoprocesoprodusForeignKey(tipoprocesoprodusForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return pedidodetaproduReturnGeneral;
	}
	
	public PedidoDetaProduParameterReturnGeneral cargarCombosLoteForeignKeyPedidoDetaProdu(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalPedidoProdu,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalBodegaDestino,String finalQueryGlobalTipoProcesoProdu) throws Exception {
		PedidoDetaProduParameterReturnGeneral  pedidodetaproduReturnGeneral =new PedidoDetaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			pedidodetaproduReturnGeneral =new PedidoDetaProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidodetaproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidodetaproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidodetaproduReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidodetaproduReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<PedidoProdu> pedidoprodusForeignKey=new ArrayList<PedidoProdu>();
			PedidoProduLogic pedidoproduLogic=new PedidoProduLogic();
			pedidoproduLogic.setConnexion(this.connexion);
			pedidoproduLogic.getPedidoProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPedidoProdu.equals("NONE")) {
				pedidoproduLogic.getTodosPedidoProdus(finalQueryGlobalPedidoProdu,new Pagination());
				pedidoprodusForeignKey=pedidoproduLogic.getPedidoProdus();
			}

			pedidodetaproduReturnGeneral.setpedidoprodusForeignKey(pedidoprodusForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			pedidodetaproduReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			pedidodetaproduReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			pedidodetaproduReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Bodega> bodegadestinosForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegadestinoLogic=new BodegaLogic();
			bodegadestinoLogic.setConnexion(this.connexion);
			bodegadestinoLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaDestino.equals("NONE")) {
				bodegadestinoLogic.getTodosBodegas(finalQueryGlobalBodegaDestino,new Pagination());
				bodegadestinosForeignKey=bodegadestinoLogic.getBodegas();
			}

			pedidodetaproduReturnGeneral.setbodegadestinosForeignKey(bodegadestinosForeignKey);


			List<TipoProcesoProdu> tipoprocesoprodusForeignKey=new ArrayList<TipoProcesoProdu>();
			TipoProcesoProduLogic tipoprocesoproduLogic=new TipoProcesoProduLogic();
			tipoprocesoproduLogic.setConnexion(this.connexion);
			tipoprocesoproduLogic.getTipoProcesoProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProcesoProdu.equals("NONE")) {
				tipoprocesoproduLogic.getTodosTipoProcesoProdus(finalQueryGlobalTipoProcesoProdu,new Pagination());
				tipoprocesoprodusForeignKey=tipoprocesoproduLogic.getTipoProcesoProdus();
			}

			pedidodetaproduReturnGeneral.settipoprocesoprodusForeignKey(tipoprocesoprodusForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return pedidodetaproduReturnGeneral;
	}
	
	
	public void deepLoad(PedidoDetaProdu pedidodetaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PedidoDetaProduLogicAdditional.updatePedidoDetaProduToGet(pedidodetaprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidodetaprodu.setEmpresa(pedidodetaproduDataAccess.getEmpresa(connexion,pedidodetaprodu));
		pedidodetaprodu.setSucursal(pedidodetaproduDataAccess.getSucursal(connexion,pedidodetaprodu));
		pedidodetaprodu.setEjercicio(pedidodetaproduDataAccess.getEjercicio(connexion,pedidodetaprodu));
		pedidodetaprodu.setPeriodo(pedidodetaproduDataAccess.getPeriodo(connexion,pedidodetaprodu));
		pedidodetaprodu.setPedidoProdu(pedidodetaproduDataAccess.getPedidoProdu(connexion,pedidodetaprodu));
		pedidodetaprodu.setBodega(pedidodetaproduDataAccess.getBodega(connexion,pedidodetaprodu));
		pedidodetaprodu.setProducto(pedidodetaproduDataAccess.getProducto(connexion,pedidodetaprodu));
		pedidodetaprodu.setUnidad(pedidodetaproduDataAccess.getUnidad(connexion,pedidodetaprodu));
		pedidodetaprodu.setBodegaDestino(pedidodetaproduDataAccess.getBodegaDestino(connexion,pedidodetaprodu));
		pedidodetaprodu.setTipoProcesoProdu(pedidodetaproduDataAccess.getTipoProcesoProdu(connexion,pedidodetaprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidodetaprodu.setEmpresa(pedidodetaproduDataAccess.getEmpresa(connexion,pedidodetaprodu));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidodetaprodu.setSucursal(pedidodetaproduDataAccess.getSucursal(connexion,pedidodetaprodu));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedidodetaprodu.setEjercicio(pedidodetaproduDataAccess.getEjercicio(connexion,pedidodetaprodu));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedidodetaprodu.setPeriodo(pedidodetaproduDataAccess.getPeriodo(connexion,pedidodetaprodu));
				continue;
			}

			if(clas.clas.equals(PedidoProdu.class)) {
				pedidodetaprodu.setPedidoProdu(pedidodetaproduDataAccess.getPedidoProdu(connexion,pedidodetaprodu));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				pedidodetaprodu.setBodega(pedidodetaproduDataAccess.getBodega(connexion,pedidodetaprodu));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				pedidodetaprodu.setProducto(pedidodetaproduDataAccess.getProducto(connexion,pedidodetaprodu));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				pedidodetaprodu.setUnidad(pedidodetaproduDataAccess.getUnidad(connexion,pedidodetaprodu));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				pedidodetaprodu.setBodegaDestino(pedidodetaproduDataAccess.getBodegaDestino(connexion,pedidodetaprodu));
				continue;
			}

			if(clas.clas.equals(TipoProcesoProdu.class)) {
				pedidodetaprodu.setTipoProcesoProdu(pedidodetaproduDataAccess.getTipoProcesoProdu(connexion,pedidodetaprodu));
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
			pedidodetaprodu.setEmpresa(pedidodetaproduDataAccess.getEmpresa(connexion,pedidodetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setSucursal(pedidodetaproduDataAccess.getSucursal(connexion,pedidodetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setEjercicio(pedidodetaproduDataAccess.getEjercicio(connexion,pedidodetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setPeriodo(pedidodetaproduDataAccess.getPeriodo(connexion,pedidodetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setPedidoProdu(pedidodetaproduDataAccess.getPedidoProdu(connexion,pedidodetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setBodega(pedidodetaproduDataAccess.getBodega(connexion,pedidodetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setProducto(pedidodetaproduDataAccess.getProducto(connexion,pedidodetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setUnidad(pedidodetaproduDataAccess.getUnidad(connexion,pedidodetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setBodegaDestino(pedidodetaproduDataAccess.getBodegaDestino(connexion,pedidodetaprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setTipoProcesoProdu(pedidodetaproduDataAccess.getTipoProcesoProdu(connexion,pedidodetaprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidodetaprodu.setEmpresa(pedidodetaproduDataAccess.getEmpresa(connexion,pedidodetaprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidodetaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		pedidodetaprodu.setSucursal(pedidodetaproduDataAccess.getSucursal(connexion,pedidodetaprodu));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidodetaprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		pedidodetaprodu.setEjercicio(pedidodetaproduDataAccess.getEjercicio(connexion,pedidodetaprodu));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedidodetaprodu.getEjercicio(),isDeep,deepLoadType,clases);
				
		pedidodetaprodu.setPeriodo(pedidodetaproduDataAccess.getPeriodo(connexion,pedidodetaprodu));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedidodetaprodu.getPeriodo(),isDeep,deepLoadType,clases);
				
		pedidodetaprodu.setPedidoProdu(pedidodetaproduDataAccess.getPedidoProdu(connexion,pedidodetaprodu));
		PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
		pedidoproduLogic.deepLoad(pedidodetaprodu.getPedidoProdu(),isDeep,deepLoadType,clases);
				
		pedidodetaprodu.setBodega(pedidodetaproduDataAccess.getBodega(connexion,pedidodetaprodu));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(pedidodetaprodu.getBodega(),isDeep,deepLoadType,clases);
				
		pedidodetaprodu.setProducto(pedidodetaproduDataAccess.getProducto(connexion,pedidodetaprodu));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(pedidodetaprodu.getProducto(),isDeep,deepLoadType,clases);
				
		pedidodetaprodu.setUnidad(pedidodetaproduDataAccess.getUnidad(connexion,pedidodetaprodu));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(pedidodetaprodu.getUnidad(),isDeep,deepLoadType,clases);
				
		pedidodetaprodu.setBodegaDestino(pedidodetaproduDataAccess.getBodegaDestino(connexion,pedidodetaprodu));
		BodegaLogic bodegadestinoLogic= new BodegaLogic(connexion);
		bodegadestinoLogic.deepLoad(pedidodetaprodu.getBodegaDestino(),isDeep,deepLoadType,clases);
				
		pedidodetaprodu.setTipoProcesoProdu(pedidodetaproduDataAccess.getTipoProcesoProdu(connexion,pedidodetaprodu));
		TipoProcesoProduLogic tipoprocesoproduLogic= new TipoProcesoProduLogic(connexion);
		tipoprocesoproduLogic.deepLoad(pedidodetaprodu.getTipoProcesoProdu(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidodetaprodu.setEmpresa(pedidodetaproduDataAccess.getEmpresa(connexion,pedidodetaprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pedidodetaprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidodetaprodu.setSucursal(pedidodetaproduDataAccess.getSucursal(connexion,pedidodetaprodu));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(pedidodetaprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedidodetaprodu.setEjercicio(pedidodetaproduDataAccess.getEjercicio(connexion,pedidodetaprodu));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(pedidodetaprodu.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedidodetaprodu.setPeriodo(pedidodetaproduDataAccess.getPeriodo(connexion,pedidodetaprodu));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(pedidodetaprodu.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoProdu.class)) {
				pedidodetaprodu.setPedidoProdu(pedidodetaproduDataAccess.getPedidoProdu(connexion,pedidodetaprodu));
				PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
				pedidoproduLogic.deepLoad(pedidodetaprodu.getPedidoProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				pedidodetaprodu.setBodega(pedidodetaproduDataAccess.getBodega(connexion,pedidodetaprodu));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(pedidodetaprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				pedidodetaprodu.setProducto(pedidodetaproduDataAccess.getProducto(connexion,pedidodetaprodu));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(pedidodetaprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				pedidodetaprodu.setUnidad(pedidodetaproduDataAccess.getUnidad(connexion,pedidodetaprodu));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(pedidodetaprodu.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				pedidodetaprodu.setBodegaDestino(pedidodetaproduDataAccess.getBodegaDestino(connexion,pedidodetaprodu));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(pedidodetaprodu.getBodegaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoProdu.class)) {
				pedidodetaprodu.setTipoProcesoProdu(pedidodetaproduDataAccess.getTipoProcesoProdu(connexion,pedidodetaprodu));
				TipoProcesoProduLogic tipoprocesoproduLogic= new TipoProcesoProduLogic(connexion);
				tipoprocesoproduLogic.deepLoad(pedidodetaprodu.getTipoProcesoProdu(),isDeep,deepLoadType,clases);				
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
			pedidodetaprodu.setEmpresa(pedidodetaproduDataAccess.getEmpresa(connexion,pedidodetaprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pedidodetaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setSucursal(pedidodetaproduDataAccess.getSucursal(connexion,pedidodetaprodu));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(pedidodetaprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setEjercicio(pedidodetaproduDataAccess.getEjercicio(connexion,pedidodetaprodu));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(pedidodetaprodu.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setPeriodo(pedidodetaproduDataAccess.getPeriodo(connexion,pedidodetaprodu));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(pedidodetaprodu.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setPedidoProdu(pedidodetaproduDataAccess.getPedidoProdu(connexion,pedidodetaprodu));
			PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
			pedidoproduLogic.deepLoad(pedidodetaprodu.getPedidoProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setBodega(pedidodetaproduDataAccess.getBodega(connexion,pedidodetaprodu));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(pedidodetaprodu.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setProducto(pedidodetaproduDataAccess.getProducto(connexion,pedidodetaprodu));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(pedidodetaprodu.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setUnidad(pedidodetaproduDataAccess.getUnidad(connexion,pedidodetaprodu));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(pedidodetaprodu.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setBodegaDestino(pedidodetaproduDataAccess.getBodegaDestino(connexion,pedidodetaprodu));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(pedidodetaprodu.getBodegaDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProcesoProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidodetaprodu.setTipoProcesoProdu(pedidodetaproduDataAccess.getTipoProcesoProdu(connexion,pedidodetaprodu));
			TipoProcesoProduLogic tipoprocesoproduLogic= new TipoProcesoProduLogic(connexion);
			tipoprocesoproduLogic.deepLoad(pedidodetaprodu.getTipoProcesoProdu(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PedidoDetaProdu pedidodetaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PedidoDetaProduLogicAdditional.updatePedidoDetaProduToSave(pedidodetaprodu,this.arrDatoGeneral);
			
PedidoDetaProduDataAccess.save(pedidodetaprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidodetaprodu.getEmpresa(),connexion);

		SucursalDataAccess.save(pedidodetaprodu.getSucursal(),connexion);

		EjercicioDataAccess.save(pedidodetaprodu.getEjercicio(),connexion);

		PeriodoDataAccess.save(pedidodetaprodu.getPeriodo(),connexion);

		PedidoProduDataAccess.save(pedidodetaprodu.getPedidoProdu(),connexion);

		BodegaDataAccess.save(pedidodetaprodu.getBodega(),connexion);

		ProductoDataAccess.save(pedidodetaprodu.getProducto(),connexion);

		UnidadDataAccess.save(pedidodetaprodu.getUnidad(),connexion);

		BodegaDataAccess.save(pedidodetaprodu.getBodegaDestino(),connexion);

		TipoProcesoProduDataAccess.save(pedidodetaprodu.getTipoProcesoProdu(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidodetaprodu.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidodetaprodu.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedidodetaprodu.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedidodetaprodu.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(PedidoProdu.class)) {
				PedidoProduDataAccess.save(pedidodetaprodu.getPedidoProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(pedidodetaprodu.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(pedidodetaprodu.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(pedidodetaprodu.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(pedidodetaprodu.getBodegaDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProcesoProdu.class)) {
				TipoProcesoProduDataAccess.save(pedidodetaprodu.getTipoProcesoProdu(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidodetaprodu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidodetaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(pedidodetaprodu.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidodetaprodu.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(pedidodetaprodu.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedidodetaprodu.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(pedidodetaprodu.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedidodetaprodu.getPeriodo(),isDeep,deepLoadType,clases);
				

		PedidoProduDataAccess.save(pedidodetaprodu.getPedidoProdu(),connexion);
		PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
		pedidoproduLogic.deepLoad(pedidodetaprodu.getPedidoProdu(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(pedidodetaprodu.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(pedidodetaprodu.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(pedidodetaprodu.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(pedidodetaprodu.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(pedidodetaprodu.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(pedidodetaprodu.getUnidad(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(pedidodetaprodu.getBodegaDestino(),connexion);
		BodegaLogic bodegadestinoLogic= new BodegaLogic(connexion);
		bodegadestinoLogic.deepLoad(pedidodetaprodu.getBodegaDestino(),isDeep,deepLoadType,clases);
				

		TipoProcesoProduDataAccess.save(pedidodetaprodu.getTipoProcesoProdu(),connexion);
		TipoProcesoProduLogic tipoprocesoproduLogic= new TipoProcesoProduLogic(connexion);
		tipoprocesoproduLogic.deepLoad(pedidodetaprodu.getTipoProcesoProdu(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidodetaprodu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(pedidodetaprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidodetaprodu.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(pedidodetaprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedidodetaprodu.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(pedidodetaprodu.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedidodetaprodu.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(pedidodetaprodu.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoProdu.class)) {
				PedidoProduDataAccess.save(pedidodetaprodu.getPedidoProdu(),connexion);
				PedidoProduLogic pedidoproduLogic= new PedidoProduLogic(connexion);
				pedidoproduLogic.deepSave(pedidodetaprodu.getPedidoProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(pedidodetaprodu.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(pedidodetaprodu.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(pedidodetaprodu.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(pedidodetaprodu.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(pedidodetaprodu.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(pedidodetaprodu.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(pedidodetaprodu.getBodegaDestino(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(pedidodetaprodu.getBodegaDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProcesoProdu.class)) {
				TipoProcesoProduDataAccess.save(pedidodetaprodu.getTipoProcesoProdu(),connexion);
				TipoProcesoProduLogic tipoprocesoproduLogic= new TipoProcesoProduLogic(connexion);
				tipoprocesoproduLogic.deepSave(pedidodetaprodu.getTipoProcesoProdu(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PedidoDetaProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(pedidodetaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(pedidodetaprodu);
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
			this.deepLoad(this.pedidodetaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PedidoDetaProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(pedidodetaprodus!=null) {
				for(PedidoDetaProdu pedidodetaprodu:pedidodetaprodus) {
					this.deepLoad(pedidodetaprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(pedidodetaprodus);
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
			if(pedidodetaprodus!=null) {
				for(PedidoDetaProdu pedidodetaprodu:pedidodetaprodus) {
					this.deepLoad(pedidodetaprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(pedidodetaprodus);
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
			this.getNewConnexionToDeep(PedidoDetaProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(pedidodetaprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PedidoDetaProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(pedidodetaprodus!=null) {
				for(PedidoDetaProdu pedidodetaprodu:pedidodetaprodus) {
					this.deepSave(pedidodetaprodu,isDeep,deepLoadType,clases);
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
			if(pedidodetaprodus!=null) {
				for(PedidoDetaProdu pedidodetaprodu:pedidodetaprodus) {
					this.deepSave(pedidodetaprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPedidoDetaProdusFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,PedidoDetaProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoDetaProdusFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,PedidoDetaProduConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoDetaProdusFK_IdBodegaDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_destino,PedidoDetaProduConstantesFunciones.IDBODEGADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaDestino);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoDetaProdusFK_IdBodegaDestino(String sFinalQuery,Pagination pagination,Long id_bodega_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_destino,PedidoDetaProduConstantesFunciones.IDBODEGADESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaDestino);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoDetaProdusFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoDetaProduConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoDetaProdusFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoDetaProduConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoDetaProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoDetaProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoDetaProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoDetaProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoDetaProdusFK_IdPedidoProduWithConnection(String sFinalQuery,Pagination pagination,Long id_pedido_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_produ,PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoProdu);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoDetaProdusFK_IdPedidoProdu(String sFinalQuery,Pagination pagination,Long id_pedido_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPedidoProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPedidoProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pedido_produ,PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPedidoProdu);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPedidoProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoDetaProdusFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoDetaProduConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoDetaProdusFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoDetaProduConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoDetaProdusFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PedidoDetaProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoDetaProdusFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,PedidoDetaProduConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoDetaProdusFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoDetaProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoDetaProdusFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoDetaProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoDetaProdusFK_IdTipoProcesoProduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_produ,PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoProdu);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoDetaProdusFK_IdTipoProcesoProdu(String sFinalQuery,Pagination pagination,Long id_tipo_proceso_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProcesoProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProcesoProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_proceso_produ,PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProcesoProdu);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProcesoProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoDetaProdusFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoDetaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,PedidoDetaProduConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoDetaProdusFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,PedidoDetaProduConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			PedidoDetaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(this.pedidodetaprodus);
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
			if(PedidoDetaProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoDetaProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PedidoDetaProdu pedidodetaprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PedidoDetaProduConstantesFunciones.ISCONAUDITORIA) {
				if(pedidodetaprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoDetaProduDataAccess.TABLENAME, pedidodetaprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoDetaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoDetaProduLogic.registrarAuditoriaDetallesPedidoDetaProdu(connexion,pedidodetaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(pedidodetaprodu.getIsDeleted()) {
					/*if(!pedidodetaprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PedidoDetaProduDataAccess.TABLENAME, pedidodetaprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PedidoDetaProduLogic.registrarAuditoriaDetallesPedidoDetaProdu(connexion,pedidodetaprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoDetaProduDataAccess.TABLENAME, pedidodetaprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(pedidodetaprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoDetaProduDataAccess.TABLENAME, pedidodetaprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoDetaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoDetaProduLogic.registrarAuditoriaDetallesPedidoDetaProdu(connexion,pedidodetaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPedidoDetaProdu(Connexion connexion,PedidoDetaProdu pedidodetaprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getid_empresa().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getid_empresa()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getid_empresa().toString();
				}
				if(pedidodetaprodu.getid_empresa()!=null)
				{
					strValorNuevo=pedidodetaprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getid_sucursal().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getid_sucursal()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getid_sucursal().toString();
				}
				if(pedidodetaprodu.getid_sucursal()!=null)
				{
					strValorNuevo=pedidodetaprodu.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getid_ejercicio().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getid_ejercicio()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getid_ejercicio().toString();
				}
				if(pedidodetaprodu.getid_ejercicio()!=null)
				{
					strValorNuevo=pedidodetaprodu.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getid_periodo().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getid_periodo()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getid_periodo().toString();
				}
				if(pedidodetaprodu.getid_periodo()!=null)
				{
					strValorNuevo=pedidodetaprodu.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getid_pedido_produ().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getid_pedido_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getid_pedido_produ()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getid_pedido_produ().toString();
				}
				if(pedidodetaprodu.getid_pedido_produ()!=null)
				{
					strValorNuevo=pedidodetaprodu.getid_pedido_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.IDPEDIDOPRODU,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getid_bodega().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getid_bodega()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getid_bodega().toString();
				}
				if(pedidodetaprodu.getid_bodega()!=null)
				{
					strValorNuevo=pedidodetaprodu.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getid_producto().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getid_producto()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getid_producto().toString();
				}
				if(pedidodetaprodu.getid_producto()!=null)
				{
					strValorNuevo=pedidodetaprodu.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getid_unidad().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getid_unidad()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getid_unidad().toString();
				}
				if(pedidodetaprodu.getid_unidad()!=null)
				{
					strValorNuevo=pedidodetaprodu.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getid_bodega_destino().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getid_bodega_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getid_bodega_destino()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getid_bodega_destino().toString();
				}
				if(pedidodetaprodu.getid_bodega_destino()!=null)
				{
					strValorNuevo=pedidodetaprodu.getid_bodega_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.IDBODEGADESTINO,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getid_tipo_proceso_produ().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getid_tipo_proceso_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getid_tipo_proceso_produ()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getid_tipo_proceso_produ().toString();
				}
				if(pedidodetaprodu.getid_tipo_proceso_produ()!=null)
				{
					strValorNuevo=pedidodetaprodu.getid_tipo_proceso_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.IDTIPOPROCESOPRODU,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getcantidad().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getcantidad()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getcantidad().toString();
				}
				if(pedidodetaprodu.getcantidad()!=null)
				{
					strValorNuevo=pedidodetaprodu.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getcantidad_pendiente().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getcantidad_pendiente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getcantidad_pendiente()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getcantidad_pendiente().toString();
				}
				if(pedidodetaprodu.getcantidad_pendiente()!=null)
				{
					strValorNuevo=pedidodetaprodu.getcantidad_pendiente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.CANTIDADPENDIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidodetaprodu.getIsNew()||!pedidodetaprodu.getdescripcion().equals(pedidodetaprodu.getPedidoDetaProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidodetaprodu.getPedidoDetaProduOriginal().getdescripcion()!=null)
				{
					strValorActual=pedidodetaprodu.getPedidoDetaProduOriginal().getdescripcion();
				}
				if(pedidodetaprodu.getdescripcion()!=null)
				{
					strValorNuevo=pedidodetaprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoDetaProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePedidoDetaProduRelacionesWithConnection(PedidoDetaProdu pedidodetaprodu) throws Exception {

		if(!pedidodetaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoDetaProduRelacionesBase(pedidodetaprodu,true);
		}
	}

	public void savePedidoDetaProduRelaciones(PedidoDetaProdu pedidodetaprodu)throws Exception {

		if(!pedidodetaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoDetaProduRelacionesBase(pedidodetaprodu,false);
		}
	}

	public void savePedidoDetaProduRelacionesBase(PedidoDetaProdu pedidodetaprodu,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PedidoDetaProdu-saveRelacionesWithConnection");}
	

			this.setPedidoDetaProdu(pedidodetaprodu);

			if(PedidoDetaProduLogicAdditional.validarSaveRelaciones(pedidodetaprodu,this)) {

				PedidoDetaProduLogicAdditional.updateRelacionesToSave(pedidodetaprodu,this);

				if((pedidodetaprodu.getIsNew()||pedidodetaprodu.getIsChanged())&&!pedidodetaprodu.getIsDeleted()) {
					this.savePedidoDetaProdu();
					this.savePedidoDetaProduRelacionesDetalles();

				} else if(pedidodetaprodu.getIsDeleted()) {
					this.savePedidoDetaProduRelacionesDetalles();
					this.savePedidoDetaProdu();
				}

				PedidoDetaProduLogicAdditional.updateRelacionesToSaveAfter(pedidodetaprodu,this);

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
	
	
	private void savePedidoDetaProduRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoDetaProduConstantesFunciones.getClassesForeignKeysOfPedidoDetaProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoDetaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoDetaProduConstantesFunciones.getClassesRelationshipsOfPedidoDetaProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
