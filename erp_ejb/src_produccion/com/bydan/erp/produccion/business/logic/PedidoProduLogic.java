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
import com.bydan.erp.produccion.util.PedidoProduConstantesFunciones;
import com.bydan.erp.produccion.util.PedidoProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.PedidoProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.PedidoProdu;
import com.bydan.erp.produccion.business.logic.PedidoProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class PedidoProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PedidoProduLogic.class);
	
	protected PedidoProduDataAccess pedidoproduDataAccess; 	
	protected PedidoProdu pedidoprodu;
	protected List<PedidoProdu> pedidoprodus;
	protected Object pedidoproduObject;	
	protected List<Object> pedidoprodusObject;
	
	public static ClassValidator<PedidoProdu> pedidoproduValidator = new ClassValidator<PedidoProdu>(PedidoProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PedidoProduLogicAdditional pedidoproduLogicAdditional=null;
	
	public PedidoProduLogicAdditional getPedidoProduLogicAdditional() {
		return this.pedidoproduLogicAdditional;
	}
	
	public void setPedidoProduLogicAdditional(PedidoProduLogicAdditional pedidoproduLogicAdditional) {
		try {
			this.pedidoproduLogicAdditional=pedidoproduLogicAdditional;
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
	
	
	
	
	public  PedidoProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.pedidoproduDataAccess = new PedidoProduDataAccess();
			
			this.pedidoprodus= new ArrayList<PedidoProdu>();
			this.pedidoprodu= new PedidoProdu();
			
			this.pedidoproduObject=new Object();
			this.pedidoprodusObject=new ArrayList<Object>();
				
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
			
			this.pedidoproduDataAccess.setConnexionType(this.connexionType);
			this.pedidoproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PedidoProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.pedidoproduDataAccess = new PedidoProduDataAccess();
			this.pedidoprodus= new ArrayList<PedidoProdu>();
			this.pedidoprodu= new PedidoProdu();
			this.pedidoproduObject=new Object();
			this.pedidoprodusObject=new ArrayList<Object>();
			
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
			
			this.pedidoproduDataAccess.setConnexionType(this.connexionType);
			this.pedidoproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PedidoProdu getPedidoProdu() throws Exception {	
		PedidoProduLogicAdditional.checkPedidoProduToGet(pedidoprodu,this.datosCliente,this.arrDatoGeneral);
		PedidoProduLogicAdditional.updatePedidoProduToGet(pedidoprodu,this.arrDatoGeneral);
		
		return pedidoprodu;
	}
		
	public void setPedidoProdu(PedidoProdu newPedidoProdu) {
		this.pedidoprodu = newPedidoProdu;
	}
	
	public PedidoProduDataAccess getPedidoProduDataAccess() {
		return pedidoproduDataAccess;
	}
	
	public void setPedidoProduDataAccess(PedidoProduDataAccess newpedidoproduDataAccess) {
		this.pedidoproduDataAccess = newpedidoproduDataAccess;
	}
	
	public List<PedidoProdu> getPedidoProdus() throws Exception {		
		this.quitarPedidoProdusNulos();
		
		PedidoProduLogicAdditional.checkPedidoProduToGets(pedidoprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (PedidoProdu pedidoproduLocal: pedidoprodus ) {
			PedidoProduLogicAdditional.updatePedidoProduToGet(pedidoproduLocal,this.arrDatoGeneral);
		}
		
		return pedidoprodus;
	}
	
	public void setPedidoProdus(List<PedidoProdu> newPedidoProdus) {
		this.pedidoprodus = newPedidoProdus;
	}
	
	public Object getPedidoProduObject() {	
		this.pedidoproduObject=this.pedidoproduDataAccess.getEntityObject();
		return this.pedidoproduObject;
	}
		
	public void setPedidoProduObject(Object newPedidoProduObject) {
		this.pedidoproduObject = newPedidoProduObject;
	}
	
	public List<Object> getPedidoProdusObject() {		
		this.pedidoprodusObject=this.pedidoproduDataAccess.getEntitiesObject();
		return this.pedidoprodusObject;
	}
		
	public void setPedidoProdusObject(List<Object> newPedidoProdusObject) {
		this.pedidoprodusObject = newPedidoProdusObject;
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
		
		if(this.pedidoproduDataAccess!=null) {
			this.pedidoproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			pedidoproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			pedidoproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		pedidoprodu = new  PedidoProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidoprodu=pedidoproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodu);
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
		pedidoprodu = new  PedidoProdu();
		  		  
        try {
			
			pedidoprodu=pedidoproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		pedidoprodu = new  PedidoProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidoprodu=pedidoproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodu);
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
		pedidoprodu = new  PedidoProdu();
		  		  
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
		pedidoprodu = new  PedidoProdu();
		  		  
        try {
			
			pedidoprodu=pedidoproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		pedidoprodu = new  PedidoProdu();
		  		  
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
		pedidoprodu = new  PedidoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =pedidoproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidoprodu = new  PedidoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=pedidoproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidoprodu = new  PedidoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =pedidoproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidoprodu = new  PedidoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=pedidoproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidoprodu = new  PedidoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =pedidoproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidoprodu = new  PedidoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=pedidoproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidoprodus = new  ArrayList<PedidoProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoProdu(pedidoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
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
		pedidoprodus = new  ArrayList<PedidoProdu>();
		  		  
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
		pedidoprodus = new  ArrayList<PedidoProdu>();
		  		  
        try {			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPedidoProdu(pedidoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		pedidoprodus = new  ArrayList<PedidoProdu>();
		  		  
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
		pedidoprodus = new  ArrayList<PedidoProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoProdu(pedidoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
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
		pedidoprodus = new  ArrayList<PedidoProdu>();
		  		  
        try {
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoProdu(pedidoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
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
		pedidoprodus = new  ArrayList<PedidoProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoProdu(pedidoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
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
		pedidoprodus = new  ArrayList<PedidoProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoProdu(pedidoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		pedidoprodu = new  PedidoProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodu=pedidoproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoProdu(pedidoprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodu);
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
		pedidoprodu = new  PedidoProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodu=pedidoproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoProdu(pedidoprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidoprodus = new  ArrayList<PedidoProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodus=pedidoproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoProdu(pedidoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
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
		pedidoprodus = new  ArrayList<PedidoProdu>();
		  		  
        try {
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodus=pedidoproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoProdu(pedidoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPedidoProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		pedidoprodus = new  ArrayList<PedidoProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getTodosPedidoProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoProdu(pedidoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
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
	
	public  void  getTodosPedidoProdus(String sFinalQuery,Pagination pagination)throws Exception {
		pedidoprodus = new  ArrayList<PedidoProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoProdu(pedidoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPedidoProdu(PedidoProdu pedidoprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(pedidoprodu.getIsNew() || pedidoprodu.getIsChanged()) { 
			this.invalidValues = pedidoproduValidator.getInvalidValues(pedidoprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(pedidoprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPedidoProdu(List<PedidoProdu> PedidoProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PedidoProdu pedidoproduLocal:pedidoprodus) {				
			estaValidadoObjeto=this.validarGuardarPedidoProdu(pedidoproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPedidoProdu(List<PedidoProdu> PedidoProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoProdu(pedidoprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPedidoProdu(PedidoProdu PedidoProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoProdu(pedidoprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PedidoProdu pedidoprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+pedidoprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PedidoProduConstantesFunciones.getPedidoProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"pedidoprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PedidoProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PedidoProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePedidoProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-savePedidoProduWithConnection");connexion.begin();			
			
			PedidoProduLogicAdditional.checkPedidoProduToSave(this.pedidoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoProduLogicAdditional.updatePedidoProduToSave(this.pedidoprodu,this.arrDatoGeneral);
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidoprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPedidoProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoProdu(this.pedidoprodu)) {
				PedidoProduDataAccess.save(this.pedidoprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.pedidoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoProduLogicAdditional.checkPedidoProduToSaveAfter(this.pedidoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoProdu();
			
			connexion.commit();			
			
			if(this.pedidoprodu.getIsDeleted()) {
				this.pedidoprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePedidoProdu()throws Exception {	
		try {	
			
			PedidoProduLogicAdditional.checkPedidoProduToSave(this.pedidoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoProduLogicAdditional.updatePedidoProduToSave(this.pedidoprodu,this.arrDatoGeneral);
			
			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidoprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoProdu(this.pedidoprodu)) {			
				PedidoProduDataAccess.save(this.pedidoprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.pedidoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoProduLogicAdditional.checkPedidoProduToSaveAfter(this.pedidoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.pedidoprodu.getIsDeleted()) {
				this.pedidoprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePedidoProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-savePedidoProdusWithConnection");connexion.begin();			
			
			PedidoProduLogicAdditional.checkPedidoProduToSaves(pedidoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPedidoProdus();
			
			Boolean validadoTodosPedidoProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoProdu pedidoproduLocal:pedidoprodus) {		
				if(pedidoproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoProduLogicAdditional.updatePedidoProduToSave(pedidoproduLocal,this.arrDatoGeneral);
	        	
				PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidoproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoProdu(pedidoproduLocal)) {
					PedidoProduDataAccess.save(pedidoproduLocal, connexion);				
				} else {
					validadoTodosPedidoProdu=false;
				}
			}
			
			if(!validadoTodosPedidoProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoProduLogicAdditional.checkPedidoProduToSavesAfter(pedidoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoProdus();
			
			connexion.commit();		
			
			this.quitarPedidoProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePedidoProdus()throws Exception {				
		 try {	
			PedidoProduLogicAdditional.checkPedidoProduToSaves(pedidoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPedidoProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoProdu pedidoproduLocal:pedidoprodus) {				
				if(pedidoproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoProduLogicAdditional.updatePedidoProduToSave(pedidoproduLocal,this.arrDatoGeneral);
	        	
				PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidoproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoProdu(pedidoproduLocal)) {				
					PedidoProduDataAccess.save(pedidoproduLocal, connexion);				
				} else {
					validadoTodosPedidoProdu=false;
				}
			}
			
			if(!validadoTodosPedidoProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoProduLogicAdditional.checkPedidoProduToSavesAfter(pedidoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPedidoProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoProduParameterReturnGeneral procesarAccionPedidoProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoProdu> pedidoprodus,PedidoProduParameterReturnGeneral pedidoproduParameterGeneral)throws Exception {
		 try {	
			PedidoProduParameterReturnGeneral pedidoproduReturnGeneral=new PedidoProduParameterReturnGeneral();
	
			PedidoProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidoprodus,pedidoproduParameterGeneral,pedidoproduReturnGeneral);
			
			return pedidoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoProduParameterReturnGeneral procesarAccionPedidoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoProdu> pedidoprodus,PedidoProduParameterReturnGeneral pedidoproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-procesarAccionPedidoProdusWithConnection");connexion.begin();			
			
			PedidoProduParameterReturnGeneral pedidoproduReturnGeneral=new PedidoProduParameterReturnGeneral();
	
			PedidoProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidoprodus,pedidoproduParameterGeneral,pedidoproduReturnGeneral);
			
			this.connexion.commit();
			
			return pedidoproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoProduParameterReturnGeneral procesarEventosPedidoProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoProdu> pedidoprodus,PedidoProdu pedidoprodu,PedidoProduParameterReturnGeneral pedidoproduParameterGeneral,Boolean isEsNuevoPedidoProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			PedidoProduParameterReturnGeneral pedidoproduReturnGeneral=new PedidoProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidoproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidoprodus,pedidoprodu,pedidoproduParameterGeneral,pedidoproduReturnGeneral,isEsNuevoPedidoProdu,clases);
			
			return pedidoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PedidoProduParameterReturnGeneral procesarEventosPedidoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoProdu> pedidoprodus,PedidoProdu pedidoprodu,PedidoProduParameterReturnGeneral pedidoproduParameterGeneral,Boolean isEsNuevoPedidoProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-procesarEventosPedidoProdusWithConnection");connexion.begin();			
			
			PedidoProduParameterReturnGeneral pedidoproduReturnGeneral=new PedidoProduParameterReturnGeneral();
	
			pedidoproduReturnGeneral.setPedidoProdu(pedidoprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidoproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidoprodus,pedidoprodu,pedidoproduParameterGeneral,pedidoproduReturnGeneral,isEsNuevoPedidoProdu,clases);
			
			this.connexion.commit();
			
			return pedidoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoProduParameterReturnGeneral procesarImportacionPedidoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PedidoProduParameterReturnGeneral pedidoproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-procesarImportacionPedidoProdusWithConnection");connexion.begin();			
			
			PedidoProduParameterReturnGeneral pedidoproduReturnGeneral=new PedidoProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.pedidoprodus=new ArrayList<PedidoProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.pedidoprodu=new PedidoProdu();
				
				
				if(conColumnasBase) {this.pedidoprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.pedidoprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.pedidoprodu.setsecuencial(arrColumnas[iColumn++]);
				this.pedidoprodu.setdireccion_cliente(arrColumnas[iColumn++]);
				this.pedidoprodu.settelefono_cliente(arrColumnas[iColumn++]);
				this.pedidoprodu.setruc_cliente(arrColumnas[iColumn++]);
				this.pedidoprodu.setlote(arrColumnas[iColumn++]);
				this.pedidoprodu.setfecha_pedido(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedidoprodu.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedidoprodu.setes_uso_interno(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.pedidoprodu.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.pedidoprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.pedidoprodus.add(this.pedidoprodu);
			}
			
			this.savePedidoProdus();
			
			this.connexion.commit();
			
			pedidoproduReturnGeneral.setConRetornoEstaProcesado(true);
			pedidoproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return pedidoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPedidoProdusEliminados() throws Exception {				
		
		List<PedidoProdu> pedidoprodusAux= new ArrayList<PedidoProdu>();
		
		for(PedidoProdu pedidoprodu:pedidoprodus) {
			if(!pedidoprodu.getIsDeleted()) {
				pedidoprodusAux.add(pedidoprodu);
			}
		}
		
		pedidoprodus=pedidoprodusAux;
	}
	
	public void quitarPedidoProdusNulos() throws Exception {				
		
		List<PedidoProdu> pedidoprodusAux= new ArrayList<PedidoProdu>();
		
		for(PedidoProdu pedidoprodu : this.pedidoprodus) {
			if(pedidoprodu==null) {
				pedidoprodusAux.add(pedidoprodu);
			}
		}
		
		//this.pedidoprodus=pedidoprodusAux;
		
		this.pedidoprodus.removeAll(pedidoprodusAux);
	}
	
	public void getSetVersionRowPedidoProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(pedidoprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((pedidoprodu.getIsDeleted() || (pedidoprodu.getIsChanged()&&!pedidoprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=pedidoproduDataAccess.getSetVersionRowPedidoProdu(connexion,pedidoprodu.getId());
				
				if(!pedidoprodu.getVersionRow().equals(timestamp)) {	
					pedidoprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				pedidoprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPedidoProdu()throws Exception {	
		
		if(pedidoprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((pedidoprodu.getIsDeleted() || (pedidoprodu.getIsChanged()&&!pedidoprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=pedidoproduDataAccess.getSetVersionRowPedidoProdu(connexion,pedidoprodu.getId());
			
			try {							
				if(!pedidoprodu.getVersionRow().equals(timestamp)) {	
					pedidoprodu.setVersionRow(timestamp);
				}
				
				pedidoprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPedidoProdusWithConnection()throws Exception {	
		if(pedidoprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PedidoProdu pedidoproduAux:pedidoprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(pedidoproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidoproduAux.getIsDeleted() || (pedidoproduAux.getIsChanged()&&!pedidoproduAux.getIsNew())) {
						
						timestamp=pedidoproduDataAccess.getSetVersionRowPedidoProdu(connexion,pedidoproduAux.getId());
						
						if(!pedidoprodu.getVersionRow().equals(timestamp)) {	
							pedidoproduAux.setVersionRow(timestamp);
						}
								
						pedidoproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPedidoProdus()throws Exception {	
		if(pedidoprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PedidoProdu pedidoproduAux:pedidoprodus) {
					if(pedidoproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidoproduAux.getIsDeleted() || (pedidoproduAux.getIsChanged()&&!pedidoproduAux.getIsNew())) {
						
						timestamp=pedidoproduDataAccess.getSetVersionRowPedidoProdu(connexion,pedidoproduAux.getId());
						
						if(!pedidoproduAux.getVersionRow().equals(timestamp)) {	
							pedidoproduAux.setVersionRow(timestamp);
						}
						
													
						pedidoproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PedidoProduParameterReturnGeneral cargarCombosLoteForeignKeyPedidoProduWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFormato,String finalQueryGlobalTipoPrioridadEmpresaProdu,String finalQueryGlobalEmpleadoResponsable,String finalQueryGlobalCliente,String finalQueryGlobalEstadoOrdenProdu) throws Exception {
		PedidoProduParameterReturnGeneral  pedidoproduReturnGeneral =new PedidoProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyPedidoProduWithConnection");connexion.begin();
			
			pedidoproduReturnGeneral =new PedidoProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidoproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidoproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidoproduReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidoproduReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			pedidoproduReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodusForeignKey=new ArrayList<TipoPrioridadEmpresaProdu>();
			TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic=new TipoPrioridadEmpresaProduLogic();
			tipoprioridadempresaproduLogic.setConnexion(this.connexion);
			tipoprioridadempresaproduLogic.getTipoPrioridadEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrioridadEmpresaProdu.equals("NONE")) {
				tipoprioridadempresaproduLogic.getTodosTipoPrioridadEmpresaProdus(finalQueryGlobalTipoPrioridadEmpresaProdu,new Pagination());
				tipoprioridadempresaprodusForeignKey=tipoprioridadempresaproduLogic.getTipoPrioridadEmpresaProdus();
			}

			pedidoproduReturnGeneral.settipoprioridadempresaprodusForeignKey(tipoprioridadempresaprodusForeignKey);


			List<Empleado> empleadoresponsablesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoresponsableLogic=new EmpleadoLogic();
			empleadoresponsableLogic.setConnexion(this.connexion);
			empleadoresponsableLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoResponsable.equals("NONE")) {
				empleadoresponsableLogic.getTodosEmpleados(finalQueryGlobalEmpleadoResponsable,new Pagination());
				empleadoresponsablesForeignKey=empleadoresponsableLogic.getEmpleados();
			}

			pedidoproduReturnGeneral.setempleadoresponsablesForeignKey(empleadoresponsablesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidoproduReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<EstadoOrdenProdu> estadoordenprodusForeignKey=new ArrayList<EstadoOrdenProdu>();
			EstadoOrdenProduLogic estadoordenproduLogic=new EstadoOrdenProduLogic();
			estadoordenproduLogic.setConnexion(this.connexion);
			estadoordenproduLogic.getEstadoOrdenProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoOrdenProdu.equals("NONE")) {
				estadoordenproduLogic.getTodosEstadoOrdenProdus(finalQueryGlobalEstadoOrdenProdu,new Pagination());
				estadoordenprodusForeignKey=estadoordenproduLogic.getEstadoOrdenProdus();
			}

			pedidoproduReturnGeneral.setestadoordenprodusForeignKey(estadoordenprodusForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return pedidoproduReturnGeneral;
	}
	
	public PedidoProduParameterReturnGeneral cargarCombosLoteForeignKeyPedidoProdu(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFormato,String finalQueryGlobalTipoPrioridadEmpresaProdu,String finalQueryGlobalEmpleadoResponsable,String finalQueryGlobalCliente,String finalQueryGlobalEstadoOrdenProdu) throws Exception {
		PedidoProduParameterReturnGeneral  pedidoproduReturnGeneral =new PedidoProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			pedidoproduReturnGeneral =new PedidoProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidoproduReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidoproduReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidoproduReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidoproduReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			pedidoproduReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodusForeignKey=new ArrayList<TipoPrioridadEmpresaProdu>();
			TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic=new TipoPrioridadEmpresaProduLogic();
			tipoprioridadempresaproduLogic.setConnexion(this.connexion);
			tipoprioridadempresaproduLogic.getTipoPrioridadEmpresaProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrioridadEmpresaProdu.equals("NONE")) {
				tipoprioridadempresaproduLogic.getTodosTipoPrioridadEmpresaProdus(finalQueryGlobalTipoPrioridadEmpresaProdu,new Pagination());
				tipoprioridadempresaprodusForeignKey=tipoprioridadempresaproduLogic.getTipoPrioridadEmpresaProdus();
			}

			pedidoproduReturnGeneral.settipoprioridadempresaprodusForeignKey(tipoprioridadempresaprodusForeignKey);


			List<Empleado> empleadoresponsablesForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoresponsableLogic=new EmpleadoLogic();
			empleadoresponsableLogic.setConnexion(this.connexion);
			empleadoresponsableLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoResponsable.equals("NONE")) {
				empleadoresponsableLogic.getTodosEmpleados(finalQueryGlobalEmpleadoResponsable,new Pagination());
				empleadoresponsablesForeignKey=empleadoresponsableLogic.getEmpleados();
			}

			pedidoproduReturnGeneral.setempleadoresponsablesForeignKey(empleadoresponsablesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidoproduReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<EstadoOrdenProdu> estadoordenprodusForeignKey=new ArrayList<EstadoOrdenProdu>();
			EstadoOrdenProduLogic estadoordenproduLogic=new EstadoOrdenProduLogic();
			estadoordenproduLogic.setConnexion(this.connexion);
			estadoordenproduLogic.getEstadoOrdenProduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoOrdenProdu.equals("NONE")) {
				estadoordenproduLogic.getTodosEstadoOrdenProdus(finalQueryGlobalEstadoOrdenProdu,new Pagination());
				estadoordenprodusForeignKey=estadoordenproduLogic.getEstadoOrdenProdus();
			}

			pedidoproduReturnGeneral.setestadoordenprodusForeignKey(estadoordenprodusForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return pedidoproduReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPedidoProduWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PedidoDetaProduLogic pedidodetaproduLogic=new PedidoDetaProduLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPedidoProduWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PedidoDetaProdu.class));
											
			

			pedidodetaproduLogic.setConnexion(this.getConnexion());
			pedidodetaproduLogic.setDatosCliente(this.datosCliente);
			pedidodetaproduLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PedidoProdu pedidoprodu:this.pedidoprodus) {
				

				classes=new ArrayList<Classe>();
				classes=PedidoDetaProduConstantesFunciones.getClassesForeignKeysOfPedidoDetaProdu(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidodetaproduLogic.setPedidoDetaProdus(pedidoprodu.pedidodetaprodus);
				pedidodetaproduLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PedidoProdu pedidoprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PedidoProduLogicAdditional.updatePedidoProduToGet(pedidoprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidoprodu.setEmpresa(pedidoproduDataAccess.getEmpresa(connexion,pedidoprodu));
		pedidoprodu.setSucursal(pedidoproduDataAccess.getSucursal(connexion,pedidoprodu));
		pedidoprodu.setEjercicio(pedidoproduDataAccess.getEjercicio(connexion,pedidoprodu));
		pedidoprodu.setPeriodo(pedidoproduDataAccess.getPeriodo(connexion,pedidoprodu));
		pedidoprodu.setFormato(pedidoproduDataAccess.getFormato(connexion,pedidoprodu));
		pedidoprodu.setTipoPrioridadEmpresaProdu(pedidoproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,pedidoprodu));
		pedidoprodu.setEmpleadoResponsable(pedidoproduDataAccess.getEmpleadoResponsable(connexion,pedidoprodu));
		pedidoprodu.setCliente(pedidoproduDataAccess.getCliente(connexion,pedidoprodu));
		pedidoprodu.setEstadoOrdenProdu(pedidoproduDataAccess.getEstadoOrdenProdu(connexion,pedidoprodu));
		pedidoprodu.setPedidoDetaProdus(pedidoproduDataAccess.getPedidoDetaProdus(connexion,pedidoprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidoprodu.setEmpresa(pedidoproduDataAccess.getEmpresa(connexion,pedidoprodu));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidoprodu.setSucursal(pedidoproduDataAccess.getSucursal(connexion,pedidoprodu));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedidoprodu.setEjercicio(pedidoproduDataAccess.getEjercicio(connexion,pedidoprodu));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedidoprodu.setPeriodo(pedidoproduDataAccess.getPeriodo(connexion,pedidoprodu));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				pedidoprodu.setFormato(pedidoproduDataAccess.getFormato(connexion,pedidoprodu));
				continue;
			}

			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				pedidoprodu.setTipoPrioridadEmpresaProdu(pedidoproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,pedidoprodu));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				pedidoprodu.setEmpleadoResponsable(pedidoproduDataAccess.getEmpleadoResponsable(connexion,pedidoprodu));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidoprodu.setCliente(pedidoproduDataAccess.getCliente(connexion,pedidoprodu));
				continue;
			}

			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				pedidoprodu.setEstadoOrdenProdu(pedidoproduDataAccess.getEstadoOrdenProdu(connexion,pedidoprodu));
				continue;
			}

			if(clas.clas.equals(PedidoDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidoprodu.setPedidoDetaProdus(pedidoproduDataAccess.getPedidoDetaProdus(connexion,pedidoprodu));

				if(this.isConDeep) {
					PedidoDetaProduLogic pedidodetaproduLogic= new PedidoDetaProduLogic(this.connexion);
					pedidodetaproduLogic.setPedidoDetaProdus(pedidoprodu.getPedidoDetaProdus());
					ArrayList<Classe> classesLocal=PedidoDetaProduConstantesFunciones.getClassesForeignKeysOfPedidoDetaProdu(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidodetaproduLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(pedidodetaproduLogic.getPedidoDetaProdus());
					pedidoprodu.setPedidoDetaProdus(pedidodetaproduLogic.getPedidoDetaProdus());
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
			pedidoprodu.setEmpresa(pedidoproduDataAccess.getEmpresa(connexion,pedidoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setSucursal(pedidoproduDataAccess.getSucursal(connexion,pedidoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setEjercicio(pedidoproduDataAccess.getEjercicio(connexion,pedidoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setPeriodo(pedidoproduDataAccess.getPeriodo(connexion,pedidoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setFormato(pedidoproduDataAccess.getFormato(connexion,pedidoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setTipoPrioridadEmpresaProdu(pedidoproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,pedidoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setEmpleadoResponsable(pedidoproduDataAccess.getEmpleadoResponsable(connexion,pedidoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setCliente(pedidoproduDataAccess.getCliente(connexion,pedidoprodu));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setEstadoOrdenProdu(pedidoproduDataAccess.getEstadoOrdenProdu(connexion,pedidoprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoDetaProdu.class));
			pedidoprodu.setPedidoDetaProdus(pedidoproduDataAccess.getPedidoDetaProdus(connexion,pedidoprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidoprodu.setEmpresa(pedidoproduDataAccess.getEmpresa(connexion,pedidoprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidoprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		pedidoprodu.setSucursal(pedidoproduDataAccess.getSucursal(connexion,pedidoprodu));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidoprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		pedidoprodu.setEjercicio(pedidoproduDataAccess.getEjercicio(connexion,pedidoprodu));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedidoprodu.getEjercicio(),isDeep,deepLoadType,clases);
				
		pedidoprodu.setPeriodo(pedidoproduDataAccess.getPeriodo(connexion,pedidoprodu));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedidoprodu.getPeriodo(),isDeep,deepLoadType,clases);
				
		pedidoprodu.setFormato(pedidoproduDataAccess.getFormato(connexion,pedidoprodu));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(pedidoprodu.getFormato(),isDeep,deepLoadType,clases);
				
		pedidoprodu.setTipoPrioridadEmpresaProdu(pedidoproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,pedidoprodu));
		TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic= new TipoPrioridadEmpresaProduLogic(connexion);
		tipoprioridadempresaproduLogic.deepLoad(pedidoprodu.getTipoPrioridadEmpresaProdu(),isDeep,deepLoadType,clases);
				
		pedidoprodu.setEmpleadoResponsable(pedidoproduDataAccess.getEmpleadoResponsable(connexion,pedidoprodu));
		EmpleadoLogic empleadoresponsableLogic= new EmpleadoLogic(connexion);
		empleadoresponsableLogic.deepLoad(pedidoprodu.getEmpleadoResponsable(),isDeep,deepLoadType,clases);
				
		pedidoprodu.setCliente(pedidoproduDataAccess.getCliente(connexion,pedidoprodu));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedidoprodu.getCliente(),isDeep,deepLoadType,clases);
				
		pedidoprodu.setEstadoOrdenProdu(pedidoproduDataAccess.getEstadoOrdenProdu(connexion,pedidoprodu));
		EstadoOrdenProduLogic estadoordenproduLogic= new EstadoOrdenProduLogic(connexion);
		estadoordenproduLogic.deepLoad(pedidoprodu.getEstadoOrdenProdu(),isDeep,deepLoadType,clases);
				

		pedidoprodu.setPedidoDetaProdus(pedidoproduDataAccess.getPedidoDetaProdus(connexion,pedidoprodu));

		for(PedidoDetaProdu pedidodetaprodu:pedidoprodu.getPedidoDetaProdus()) {
			PedidoDetaProduLogic pedidodetaproduLogic= new PedidoDetaProduLogic(connexion);
			pedidodetaproduLogic.deepLoad(pedidodetaprodu,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidoprodu.setEmpresa(pedidoproduDataAccess.getEmpresa(connexion,pedidoprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pedidoprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidoprodu.setSucursal(pedidoproduDataAccess.getSucursal(connexion,pedidoprodu));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(pedidoprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedidoprodu.setEjercicio(pedidoproduDataAccess.getEjercicio(connexion,pedidoprodu));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(pedidoprodu.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedidoprodu.setPeriodo(pedidoproduDataAccess.getPeriodo(connexion,pedidoprodu));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(pedidoprodu.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				pedidoprodu.setFormato(pedidoproduDataAccess.getFormato(connexion,pedidoprodu));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(pedidoprodu.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				pedidoprodu.setTipoPrioridadEmpresaProdu(pedidoproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,pedidoprodu));
				TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic= new TipoPrioridadEmpresaProduLogic(connexion);
				tipoprioridadempresaproduLogic.deepLoad(pedidoprodu.getTipoPrioridadEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				pedidoprodu.setEmpleadoResponsable(pedidoproduDataAccess.getEmpleadoResponsable(connexion,pedidoprodu));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(pedidoprodu.getEmpleadoResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidoprodu.setCliente(pedidoproduDataAccess.getCliente(connexion,pedidoprodu));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(pedidoprodu.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				pedidoprodu.setEstadoOrdenProdu(pedidoproduDataAccess.getEstadoOrdenProdu(connexion,pedidoprodu));
				EstadoOrdenProduLogic estadoordenproduLogic= new EstadoOrdenProduLogic(connexion);
				estadoordenproduLogic.deepLoad(pedidoprodu.getEstadoOrdenProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidoprodu.setPedidoDetaProdus(pedidoproduDataAccess.getPedidoDetaProdus(connexion,pedidoprodu));

				for(PedidoDetaProdu pedidodetaprodu:pedidoprodu.getPedidoDetaProdus()) {
					PedidoDetaProduLogic pedidodetaproduLogic= new PedidoDetaProduLogic(connexion);
					pedidodetaproduLogic.deepLoad(pedidodetaprodu,isDeep,deepLoadType,clases);
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
			pedidoprodu.setEmpresa(pedidoproduDataAccess.getEmpresa(connexion,pedidoprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pedidoprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setSucursal(pedidoproduDataAccess.getSucursal(connexion,pedidoprodu));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(pedidoprodu.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setEjercicio(pedidoproduDataAccess.getEjercicio(connexion,pedidoprodu));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(pedidoprodu.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setPeriodo(pedidoproduDataAccess.getPeriodo(connexion,pedidoprodu));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(pedidoprodu.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setFormato(pedidoproduDataAccess.getFormato(connexion,pedidoprodu));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(pedidoprodu.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setTipoPrioridadEmpresaProdu(pedidoproduDataAccess.getTipoPrioridadEmpresaProdu(connexion,pedidoprodu));
			TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic= new TipoPrioridadEmpresaProduLogic(connexion);
			tipoprioridadempresaproduLogic.deepLoad(pedidoprodu.getTipoPrioridadEmpresaProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setEmpleadoResponsable(pedidoproduDataAccess.getEmpleadoResponsable(connexion,pedidoprodu));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(pedidoprodu.getEmpleadoResponsable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setCliente(pedidoproduDataAccess.getCliente(connexion,pedidoprodu));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(pedidoprodu.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoprodu.setEstadoOrdenProdu(pedidoproduDataAccess.getEstadoOrdenProdu(connexion,pedidoprodu));
			EstadoOrdenProduLogic estadoordenproduLogic= new EstadoOrdenProduLogic(connexion);
			estadoordenproduLogic.deepLoad(pedidoprodu.getEstadoOrdenProdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoDetaProdu.class));
			pedidoprodu.setPedidoDetaProdus(pedidoproduDataAccess.getPedidoDetaProdus(connexion,pedidoprodu));

			for(PedidoDetaProdu pedidodetaprodu:pedidoprodu.getPedidoDetaProdus()) {
				PedidoDetaProduLogic pedidodetaproduLogic= new PedidoDetaProduLogic(connexion);
				pedidodetaproduLogic.deepLoad(pedidodetaprodu,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PedidoProdu pedidoprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PedidoProduLogicAdditional.updatePedidoProduToSave(pedidoprodu,this.arrDatoGeneral);
			
PedidoProduDataAccess.save(pedidoprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidoprodu.getEmpresa(),connexion);

		SucursalDataAccess.save(pedidoprodu.getSucursal(),connexion);

		EjercicioDataAccess.save(pedidoprodu.getEjercicio(),connexion);

		PeriodoDataAccess.save(pedidoprodu.getPeriodo(),connexion);

		FormatoDataAccess.save(pedidoprodu.getFormato(),connexion);

		TipoPrioridadEmpresaProduDataAccess.save(pedidoprodu.getTipoPrioridadEmpresaProdu(),connexion);

		EmpleadoDataAccess.save(pedidoprodu.getEmpleadoResponsable(),connexion);

		ClienteDataAccess.save(pedidoprodu.getCliente(),connexion);

		EstadoOrdenProduDataAccess.save(pedidoprodu.getEstadoOrdenProdu(),connexion);

		for(PedidoDetaProdu pedidodetaprodu:pedidoprodu.getPedidoDetaProdus()) {
			pedidodetaprodu.setid_pedido_produ(pedidoprodu.getId());
			PedidoDetaProduDataAccess.save(pedidodetaprodu,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidoprodu.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidoprodu.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedidoprodu.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedidoprodu.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(pedidoprodu.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				TipoPrioridadEmpresaProduDataAccess.save(pedidoprodu.getTipoPrioridadEmpresaProdu(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(pedidoprodu.getEmpleadoResponsable(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidoprodu.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				EstadoOrdenProduDataAccess.save(pedidoprodu.getEstadoOrdenProdu(),connexion);
				continue;
			}


			if(clas.clas.equals(PedidoDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoDetaProdu pedidodetaprodu:pedidoprodu.getPedidoDetaProdus()) {
					pedidodetaprodu.setid_pedido_produ(pedidoprodu.getId());
					PedidoDetaProduDataAccess.save(pedidodetaprodu,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidoprodu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidoprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(pedidoprodu.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidoprodu.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(pedidoprodu.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedidoprodu.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(pedidoprodu.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedidoprodu.getPeriodo(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(pedidoprodu.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(pedidoprodu.getFormato(),isDeep,deepLoadType,clases);
				

		TipoPrioridadEmpresaProduDataAccess.save(pedidoprodu.getTipoPrioridadEmpresaProdu(),connexion);
		TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic= new TipoPrioridadEmpresaProduLogic(connexion);
		tipoprioridadempresaproduLogic.deepLoad(pedidoprodu.getTipoPrioridadEmpresaProdu(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(pedidoprodu.getEmpleadoResponsable(),connexion);
		EmpleadoLogic empleadoresponsableLogic= new EmpleadoLogic(connexion);
		empleadoresponsableLogic.deepLoad(pedidoprodu.getEmpleadoResponsable(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(pedidoprodu.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedidoprodu.getCliente(),isDeep,deepLoadType,clases);
				

		EstadoOrdenProduDataAccess.save(pedidoprodu.getEstadoOrdenProdu(),connexion);
		EstadoOrdenProduLogic estadoordenproduLogic= new EstadoOrdenProduLogic(connexion);
		estadoordenproduLogic.deepLoad(pedidoprodu.getEstadoOrdenProdu(),isDeep,deepLoadType,clases);
				

		for(PedidoDetaProdu pedidodetaprodu:pedidoprodu.getPedidoDetaProdus()) {
			PedidoDetaProduLogic pedidodetaproduLogic= new PedidoDetaProduLogic(connexion);
			pedidodetaprodu.setid_pedido_produ(pedidoprodu.getId());
			PedidoDetaProduDataAccess.save(pedidodetaprodu,connexion);
			pedidodetaproduLogic.deepSave(pedidodetaprodu,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidoprodu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(pedidoprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidoprodu.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(pedidoprodu.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedidoprodu.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(pedidoprodu.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedidoprodu.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(pedidoprodu.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(pedidoprodu.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(pedidoprodu.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrioridadEmpresaProdu.class)) {
				TipoPrioridadEmpresaProduDataAccess.save(pedidoprodu.getTipoPrioridadEmpresaProdu(),connexion);
				TipoPrioridadEmpresaProduLogic tipoprioridadempresaproduLogic= new TipoPrioridadEmpresaProduLogic(connexion);
				tipoprioridadempresaproduLogic.deepSave(pedidoprodu.getTipoPrioridadEmpresaProdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(pedidoprodu.getEmpleadoResponsable(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(pedidoprodu.getEmpleadoResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidoprodu.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(pedidoprodu.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoOrdenProdu.class)) {
				EstadoOrdenProduDataAccess.save(pedidoprodu.getEstadoOrdenProdu(),connexion);
				EstadoOrdenProduLogic estadoordenproduLogic= new EstadoOrdenProduLogic(connexion);
				estadoordenproduLogic.deepSave(pedidoprodu.getEstadoOrdenProdu(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PedidoDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PedidoDetaProdu pedidodetaprodu:pedidoprodu.getPedidoDetaProdus()) {
					PedidoDetaProduLogic pedidodetaproduLogic= new PedidoDetaProduLogic(connexion);
					pedidodetaprodu.setid_pedido_produ(pedidoprodu.getId());
					PedidoDetaProduDataAccess.save(pedidodetaprodu,connexion);
					pedidodetaproduLogic.deepSave(pedidodetaprodu,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PedidoProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(pedidoprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(pedidoprodu);
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
			this.deepLoad(this.pedidoprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PedidoProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(pedidoprodus!=null) {
				for(PedidoProdu pedidoprodu:pedidoprodus) {
					this.deepLoad(pedidoprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(pedidoprodus);
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
			if(pedidoprodus!=null) {
				for(PedidoProdu pedidoprodu:pedidoprodus) {
					this.deepLoad(pedidoprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(pedidoprodus);
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
			this.getNewConnexionToDeep(PedidoProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(pedidoprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PedidoProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(pedidoprodus!=null) {
				for(PedidoProdu pedidoprodu:pedidoprodus) {
					this.deepSave(pedidoprodu,isDeep,deepLoadType,clases);
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
			if(pedidoprodus!=null) {
				for(PedidoProdu pedidoprodu:pedidoprodus) {
					this.deepSave(pedidoprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPedidoProdusFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoProduConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoProdusFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoProduConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoProdusFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoProduConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoProdusFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoProduConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoProdusFK_IdEmpleadoResponsableWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_responsable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_responsable,PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoResponsable);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoProdusFK_IdEmpleadoResponsable(String sFinalQuery,Pagination pagination,Long id_empleado_responsable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_responsable,PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoResponsable);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoProdusFK_IdEstadoOrdenProduWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_orden_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoOrdenProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoOrdenProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_orden_produ,PedidoProduConstantesFunciones.IDESTADOORDENPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoOrdenProdu);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoOrdenProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoProdusFK_IdEstadoOrdenProdu(String sFinalQuery,Pagination pagination,Long id_estado_orden_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoOrdenProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoOrdenProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_orden_produ,PedidoProduConstantesFunciones.IDESTADOORDENPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoOrdenProdu);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoOrdenProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoProdusFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PedidoProduConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoProdusFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PedidoProduConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoProdusFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoProduConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoProdusFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoProduConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoProdusFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoProdusFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoProduConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoProdusFK_IdTipoPrioridadEmpresaProduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_prioridad_empresa_produ)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrioridadEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrioridadEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_prioridad_empresa_produ,PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrioridadEmpresaProdu);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrioridadEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoProdusFK_IdTipoPrioridadEmpresaProdu(String sFinalQuery,Pagination pagination,Long id_tipo_prioridad_empresa_produ)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrioridadEmpresaProdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrioridadEmpresaProdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_prioridad_empresa_produ,PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrioridadEmpresaProdu);

			PedidoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrioridadEmpresaProdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoprodus=pedidoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoProdu(this.pedidoprodus);
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
			if(PedidoProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PedidoProdu pedidoprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PedidoProduConstantesFunciones.ISCONAUDITORIA) {
				if(pedidoprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoProduDataAccess.TABLENAME, pedidoprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoProduLogic.registrarAuditoriaDetallesPedidoProdu(connexion,pedidoprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(pedidoprodu.getIsDeleted()) {
					/*if(!pedidoprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PedidoProduDataAccess.TABLENAME, pedidoprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PedidoProduLogic.registrarAuditoriaDetallesPedidoProdu(connexion,pedidoprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoProduDataAccess.TABLENAME, pedidoprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(pedidoprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoProduDataAccess.TABLENAME, pedidoprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoProduLogic.registrarAuditoriaDetallesPedidoProdu(connexion,pedidoprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPedidoProdu(Connexion connexion,PedidoProdu pedidoprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getid_empresa().equals(pedidoprodu.getPedidoProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getid_empresa()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getid_empresa().toString();
				}
				if(pedidoprodu.getid_empresa()!=null)
				{
					strValorNuevo=pedidoprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getid_sucursal().equals(pedidoprodu.getPedidoProduOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getid_sucursal()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getid_sucursal().toString();
				}
				if(pedidoprodu.getid_sucursal()!=null)
				{
					strValorNuevo=pedidoprodu.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getid_ejercicio().equals(pedidoprodu.getPedidoProduOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getid_ejercicio()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getid_ejercicio().toString();
				}
				if(pedidoprodu.getid_ejercicio()!=null)
				{
					strValorNuevo=pedidoprodu.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getid_periodo().equals(pedidoprodu.getPedidoProduOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getid_periodo()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getid_periodo().toString();
				}
				if(pedidoprodu.getid_periodo()!=null)
				{
					strValorNuevo=pedidoprodu.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getid_formato().equals(pedidoprodu.getPedidoProduOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getid_formato()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getid_formato().toString();
				}
				if(pedidoprodu.getid_formato()!=null)
				{
					strValorNuevo=pedidoprodu.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getid_tipo_prioridad_empresa_produ().equals(pedidoprodu.getPedidoProduOriginal().getid_tipo_prioridad_empresa_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getid_tipo_prioridad_empresa_produ()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getid_tipo_prioridad_empresa_produ().toString();
				}
				if(pedidoprodu.getid_tipo_prioridad_empresa_produ()!=null)
				{
					strValorNuevo=pedidoprodu.getid_tipo_prioridad_empresa_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getid_empleado_responsable().equals(pedidoprodu.getPedidoProduOriginal().getid_empleado_responsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getid_empleado_responsable()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getid_empleado_responsable().toString();
				}
				if(pedidoprodu.getid_empleado_responsable()!=null)
				{
					strValorNuevo=pedidoprodu.getid_empleado_responsable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getsecuencial().equals(pedidoprodu.getPedidoProduOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getsecuencial()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getsecuencial();
				}
				if(pedidoprodu.getsecuencial()!=null)
				{
					strValorNuevo=pedidoprodu.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getid_cliente().equals(pedidoprodu.getPedidoProduOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getid_cliente()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getid_cliente().toString();
				}
				if(pedidoprodu.getid_cliente()!=null)
				{
					strValorNuevo=pedidoprodu.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getdireccion_cliente().equals(pedidoprodu.getPedidoProduOriginal().getdireccion_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getdireccion_cliente()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getdireccion_cliente();
				}
				if(pedidoprodu.getdireccion_cliente()!=null)
				{
					strValorNuevo=pedidoprodu.getdireccion_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.DIRECCIONCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.gettelefono_cliente().equals(pedidoprodu.getPedidoProduOriginal().gettelefono_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().gettelefono_cliente()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().gettelefono_cliente();
				}
				if(pedidoprodu.gettelefono_cliente()!=null)
				{
					strValorNuevo=pedidoprodu.gettelefono_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.TELEFONOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getruc_cliente().equals(pedidoprodu.getPedidoProduOriginal().getruc_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getruc_cliente()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getruc_cliente();
				}
				if(pedidoprodu.getruc_cliente()!=null)
				{
					strValorNuevo=pedidoprodu.getruc_cliente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.RUCCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getlote().equals(pedidoprodu.getPedidoProduOriginal().getlote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getlote()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getlote();
				}
				if(pedidoprodu.getlote()!=null)
				{
					strValorNuevo=pedidoprodu.getlote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.LOTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getfecha_pedido().equals(pedidoprodu.getPedidoProduOriginal().getfecha_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getfecha_pedido()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getfecha_pedido().toString();
				}
				if(pedidoprodu.getfecha_pedido()!=null)
				{
					strValorNuevo=pedidoprodu.getfecha_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.FECHAPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getfecha_entrega().equals(pedidoprodu.getPedidoProduOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getfecha_entrega()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getfecha_entrega().toString();
				}
				if(pedidoprodu.getfecha_entrega()!=null)
				{
					strValorNuevo=pedidoprodu.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getes_uso_interno().equals(pedidoprodu.getPedidoProduOriginal().getes_uso_interno()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getes_uso_interno()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getes_uso_interno().toString();
				}
				if(pedidoprodu.getes_uso_interno()!=null)
				{
					strValorNuevo=pedidoprodu.getes_uso_interno().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.ESUSOINTERNO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getfecha().equals(pedidoprodu.getPedidoProduOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getfecha()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getfecha().toString();
				}
				if(pedidoprodu.getfecha()!=null)
				{
					strValorNuevo=pedidoprodu.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getdescripcion().equals(pedidoprodu.getPedidoProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getdescripcion()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getdescripcion();
				}
				if(pedidoprodu.getdescripcion()!=null)
				{
					strValorNuevo=pedidoprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(pedidoprodu.getIsNew()||!pedidoprodu.getid_estado_orden_produ().equals(pedidoprodu.getPedidoProduOriginal().getid_estado_orden_produ()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoprodu.getPedidoProduOriginal().getid_estado_orden_produ()!=null)
				{
					strValorActual=pedidoprodu.getPedidoProduOriginal().getid_estado_orden_produ().toString();
				}
				if(pedidoprodu.getid_estado_orden_produ()!=null)
				{
					strValorNuevo=pedidoprodu.getid_estado_orden_produ().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoProduConstantesFunciones.IDESTADOORDENPRODU,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePedidoProduRelacionesWithConnection(PedidoProdu pedidoprodu,List<PedidoDetaProdu> pedidodetaprodus) throws Exception {

		if(!pedidoprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoProduRelacionesBase(pedidoprodu,pedidodetaprodus,true);
		}
	}

	public void savePedidoProduRelaciones(PedidoProdu pedidoprodu,List<PedidoDetaProdu> pedidodetaprodus)throws Exception {

		if(!pedidoprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoProduRelacionesBase(pedidoprodu,pedidodetaprodus,false);
		}
	}

	public void savePedidoProduRelacionesBase(PedidoProdu pedidoprodu,List<PedidoDetaProdu> pedidodetaprodus,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PedidoProdu-saveRelacionesWithConnection");}
	
			pedidoprodu.setPedidoDetaProdus(pedidodetaprodus);

			this.setPedidoProdu(pedidoprodu);

			if(PedidoProduLogicAdditional.validarSaveRelaciones(pedidoprodu,this)) {

				PedidoProduLogicAdditional.updateRelacionesToSave(pedidoprodu,this);

				if((pedidoprodu.getIsNew()||pedidoprodu.getIsChanged())&&!pedidoprodu.getIsDeleted()) {
					this.savePedidoProdu();
					this.savePedidoProduRelacionesDetalles(pedidodetaprodus);

				} else if(pedidoprodu.getIsDeleted()) {
					this.savePedidoProduRelacionesDetalles(pedidodetaprodus);
					this.savePedidoProdu();
				}

				PedidoProduLogicAdditional.updateRelacionesToSaveAfter(pedidoprodu,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PedidoDetaProduConstantesFunciones.InicializarGeneralEntityAuxiliaresPedidoDetaProdus(pedidodetaprodus,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePedidoProduRelacionesDetalles(List<PedidoDetaProdu> pedidodetaprodus)throws Exception {
		try {
	

			Long idPedidoProduActual=this.getPedidoProdu().getId();

			PedidoDetaProduLogic pedidodetaproduLogic_Desde_PedidoProdu=new PedidoDetaProduLogic();
			pedidodetaproduLogic_Desde_PedidoProdu.setPedidoDetaProdus(pedidodetaprodus);

			pedidodetaproduLogic_Desde_PedidoProdu.setConnexion(this.getConnexion());
			pedidodetaproduLogic_Desde_PedidoProdu.setDatosCliente(this.datosCliente);

			for(PedidoDetaProdu pedidodetaprodu_Desde_PedidoProdu:pedidodetaproduLogic_Desde_PedidoProdu.getPedidoDetaProdus()) {
				pedidodetaprodu_Desde_PedidoProdu.setid_pedido_produ(idPedidoProduActual);
			}

			pedidodetaproduLogic_Desde_PedidoProdu.savePedidoDetaProdus();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoProduConstantesFunciones.getClassesForeignKeysOfPedidoProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoProduConstantesFunciones.getClassesRelationshipsOfPedidoProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
