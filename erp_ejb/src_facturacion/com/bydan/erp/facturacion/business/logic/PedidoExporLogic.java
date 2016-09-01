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
import com.bydan.erp.facturacion.util.PedidoExporConstantesFunciones;
import com.bydan.erp.facturacion.util.PedidoExporParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.PedidoExporParameterGeneral;
import com.bydan.erp.facturacion.business.entity.PedidoExpor;
import com.bydan.erp.facturacion.business.logic.PedidoExporLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;








@SuppressWarnings("unused")
public class PedidoExporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PedidoExporLogic.class);
	
	protected PedidoExporDataAccess pedidoexporDataAccess; 	
	protected PedidoExpor pedidoexpor;
	protected List<PedidoExpor> pedidoexpors;
	protected Object pedidoexporObject;	
	protected List<Object> pedidoexporsObject;
	
	public static ClassValidator<PedidoExpor> pedidoexporValidator = new ClassValidator<PedidoExpor>(PedidoExpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PedidoExporLogicAdditional pedidoexporLogicAdditional=null;
	
	public PedidoExporLogicAdditional getPedidoExporLogicAdditional() {
		return this.pedidoexporLogicAdditional;
	}
	
	public void setPedidoExporLogicAdditional(PedidoExporLogicAdditional pedidoexporLogicAdditional) {
		try {
			this.pedidoexporLogicAdditional=pedidoexporLogicAdditional;
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
	
	
	
	
	public  PedidoExporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.pedidoexporDataAccess = new PedidoExporDataAccess();
			
			this.pedidoexpors= new ArrayList<PedidoExpor>();
			this.pedidoexpor= new PedidoExpor();
			
			this.pedidoexporObject=new Object();
			this.pedidoexporsObject=new ArrayList<Object>();
				
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
			
			this.pedidoexporDataAccess.setConnexionType(this.connexionType);
			this.pedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PedidoExporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.pedidoexporDataAccess = new PedidoExporDataAccess();
			this.pedidoexpors= new ArrayList<PedidoExpor>();
			this.pedidoexpor= new PedidoExpor();
			this.pedidoexporObject=new Object();
			this.pedidoexporsObject=new ArrayList<Object>();
			
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
			
			this.pedidoexporDataAccess.setConnexionType(this.connexionType);
			this.pedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PedidoExpor getPedidoExpor() throws Exception {	
		PedidoExporLogicAdditional.checkPedidoExporToGet(pedidoexpor,this.datosCliente,this.arrDatoGeneral);
		PedidoExporLogicAdditional.updatePedidoExporToGet(pedidoexpor,this.arrDatoGeneral);
		
		return pedidoexpor;
	}
		
	public void setPedidoExpor(PedidoExpor newPedidoExpor) {
		this.pedidoexpor = newPedidoExpor;
	}
	
	public PedidoExporDataAccess getPedidoExporDataAccess() {
		return pedidoexporDataAccess;
	}
	
	public void setPedidoExporDataAccess(PedidoExporDataAccess newpedidoexporDataAccess) {
		this.pedidoexporDataAccess = newpedidoexporDataAccess;
	}
	
	public List<PedidoExpor> getPedidoExpors() throws Exception {		
		this.quitarPedidoExporsNulos();
		
		PedidoExporLogicAdditional.checkPedidoExporToGets(pedidoexpors,this.datosCliente,this.arrDatoGeneral);
		
		for (PedidoExpor pedidoexporLocal: pedidoexpors ) {
			PedidoExporLogicAdditional.updatePedidoExporToGet(pedidoexporLocal,this.arrDatoGeneral);
		}
		
		return pedidoexpors;
	}
	
	public void setPedidoExpors(List<PedidoExpor> newPedidoExpors) {
		this.pedidoexpors = newPedidoExpors;
	}
	
	public Object getPedidoExporObject() {	
		this.pedidoexporObject=this.pedidoexporDataAccess.getEntityObject();
		return this.pedidoexporObject;
	}
		
	public void setPedidoExporObject(Object newPedidoExporObject) {
		this.pedidoexporObject = newPedidoExporObject;
	}
	
	public List<Object> getPedidoExporsObject() {		
		this.pedidoexporsObject=this.pedidoexporDataAccess.getEntitiesObject();
		return this.pedidoexporsObject;
	}
		
	public void setPedidoExporsObject(List<Object> newPedidoExporsObject) {
		this.pedidoexporsObject = newPedidoExporsObject;
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
		
		if(this.pedidoexporDataAccess!=null) {
			this.pedidoexporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			pedidoexporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			pedidoexporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		pedidoexpor = new  PedidoExpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidoexpor=pedidoexporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpor);
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
		pedidoexpor = new  PedidoExpor();
		  		  
        try {
			
			pedidoexpor=pedidoexporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		pedidoexpor = new  PedidoExpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidoexpor=pedidoexporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpor);
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
		pedidoexpor = new  PedidoExpor();
		  		  
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
		pedidoexpor = new  PedidoExpor();
		  		  
        try {
			
			pedidoexpor=pedidoexporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		pedidoexpor = new  PedidoExpor();
		  		  
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
		pedidoexpor = new  PedidoExpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =pedidoexporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidoexpor = new  PedidoExpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=pedidoexporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidoexpor = new  PedidoExpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =pedidoexporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidoexpor = new  PedidoExpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=pedidoexporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidoexpor = new  PedidoExpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =pedidoexporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidoexpor = new  PedidoExpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=pedidoexporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidoexpors = new  ArrayList<PedidoExpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoExpor(pedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
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
		pedidoexpors = new  ArrayList<PedidoExpor>();
		  		  
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
		pedidoexpors = new  ArrayList<PedidoExpor>();
		  		  
        try {			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPedidoExpor(pedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		pedidoexpors = new  ArrayList<PedidoExpor>();
		  		  
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
		pedidoexpors = new  ArrayList<PedidoExpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoExpor(pedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
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
		pedidoexpors = new  ArrayList<PedidoExpor>();
		  		  
        try {
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoExpor(pedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
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
		pedidoexpors = new  ArrayList<PedidoExpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoExpor(pedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
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
		pedidoexpors = new  ArrayList<PedidoExpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoExpor(pedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		pedidoexpor = new  PedidoExpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpor=pedidoexporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoExpor(pedidoexpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpor);
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
		pedidoexpor = new  PedidoExpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpor=pedidoexporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoExpor(pedidoexpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidoexpors = new  ArrayList<PedidoExpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpors=pedidoexporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoExpor(pedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
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
		pedidoexpors = new  ArrayList<PedidoExpor>();
		  		  
        try {
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpors=pedidoexporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoExpor(pedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPedidoExporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		pedidoexpors = new  ArrayList<PedidoExpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getTodosPedidoExporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoExpor(pedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
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
	
	public  void  getTodosPedidoExpors(String sFinalQuery,Pagination pagination)throws Exception {
		pedidoexpors = new  ArrayList<PedidoExpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoExpor(pedidoexpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPedidoExpor(PedidoExpor pedidoexpor) throws Exception {
		Boolean estaValidado=false;
		
		if(pedidoexpor.getIsNew() || pedidoexpor.getIsChanged()) { 
			this.invalidValues = pedidoexporValidator.getInvalidValues(pedidoexpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(pedidoexpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPedidoExpor(List<PedidoExpor> PedidoExpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PedidoExpor pedidoexporLocal:pedidoexpors) {				
			estaValidadoObjeto=this.validarGuardarPedidoExpor(pedidoexporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPedidoExpor(List<PedidoExpor> PedidoExpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoExpor(pedidoexpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPedidoExpor(PedidoExpor PedidoExpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoExpor(pedidoexpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PedidoExpor pedidoexpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+pedidoexpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PedidoExporConstantesFunciones.getPedidoExporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"pedidoexpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PedidoExporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PedidoExporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePedidoExporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-savePedidoExporWithConnection");connexion.begin();			
			
			PedidoExporLogicAdditional.checkPedidoExporToSave(this.pedidoexpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoExporLogicAdditional.updatePedidoExporToSave(this.pedidoexpor,this.arrDatoGeneral);
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidoexpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPedidoExpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoExpor(this.pedidoexpor)) {
				PedidoExporDataAccess.save(this.pedidoexpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.pedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoExporLogicAdditional.checkPedidoExporToSaveAfter(this.pedidoexpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoExpor();
			
			connexion.commit();			
			
			if(this.pedidoexpor.getIsDeleted()) {
				this.pedidoexpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePedidoExpor()throws Exception {	
		try {	
			
			PedidoExporLogicAdditional.checkPedidoExporToSave(this.pedidoexpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoExporLogicAdditional.updatePedidoExporToSave(this.pedidoexpor,this.arrDatoGeneral);
			
			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidoexpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoExpor(this.pedidoexpor)) {			
				PedidoExporDataAccess.save(this.pedidoexpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.pedidoexpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoExporLogicAdditional.checkPedidoExporToSaveAfter(this.pedidoexpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.pedidoexpor.getIsDeleted()) {
				this.pedidoexpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePedidoExporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-savePedidoExporsWithConnection");connexion.begin();			
			
			PedidoExporLogicAdditional.checkPedidoExporToSaves(pedidoexpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPedidoExpors();
			
			Boolean validadoTodosPedidoExpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoExpor pedidoexporLocal:pedidoexpors) {		
				if(pedidoexporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoExporLogicAdditional.updatePedidoExporToSave(pedidoexporLocal,this.arrDatoGeneral);
	        	
				PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidoexporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoExpor(pedidoexporLocal)) {
					PedidoExporDataAccess.save(pedidoexporLocal, connexion);				
				} else {
					validadoTodosPedidoExpor=false;
				}
			}
			
			if(!validadoTodosPedidoExpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoExporLogicAdditional.checkPedidoExporToSavesAfter(pedidoexpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoExpors();
			
			connexion.commit();		
			
			this.quitarPedidoExporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePedidoExpors()throws Exception {				
		 try {	
			PedidoExporLogicAdditional.checkPedidoExporToSaves(pedidoexpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPedidoExpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoExpor pedidoexporLocal:pedidoexpors) {				
				if(pedidoexporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoExporLogicAdditional.updatePedidoExporToSave(pedidoexporLocal,this.arrDatoGeneral);
	        	
				PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidoexporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoExpor(pedidoexporLocal)) {				
					PedidoExporDataAccess.save(pedidoexporLocal, connexion);				
				} else {
					validadoTodosPedidoExpor=false;
				}
			}
			
			if(!validadoTodosPedidoExpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoExporLogicAdditional.checkPedidoExporToSavesAfter(pedidoexpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPedidoExporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoExporParameterReturnGeneral procesarAccionPedidoExpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoExpor> pedidoexpors,PedidoExporParameterReturnGeneral pedidoexporParameterGeneral)throws Exception {
		 try {	
			PedidoExporParameterReturnGeneral pedidoexporReturnGeneral=new PedidoExporParameterReturnGeneral();
	
			PedidoExporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidoexpors,pedidoexporParameterGeneral,pedidoexporReturnGeneral);
			
			return pedidoexporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoExporParameterReturnGeneral procesarAccionPedidoExporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoExpor> pedidoexpors,PedidoExporParameterReturnGeneral pedidoexporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-procesarAccionPedidoExporsWithConnection");connexion.begin();			
			
			PedidoExporParameterReturnGeneral pedidoexporReturnGeneral=new PedidoExporParameterReturnGeneral();
	
			PedidoExporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidoexpors,pedidoexporParameterGeneral,pedidoexporReturnGeneral);
			
			this.connexion.commit();
			
			return pedidoexporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoExporParameterReturnGeneral procesarEventosPedidoExpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoExpor> pedidoexpors,PedidoExpor pedidoexpor,PedidoExporParameterReturnGeneral pedidoexporParameterGeneral,Boolean isEsNuevoPedidoExpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			PedidoExporParameterReturnGeneral pedidoexporReturnGeneral=new PedidoExporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidoexporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoExporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidoexpors,pedidoexpor,pedidoexporParameterGeneral,pedidoexporReturnGeneral,isEsNuevoPedidoExpor,clases);
			
			return pedidoexporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PedidoExporParameterReturnGeneral procesarEventosPedidoExporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoExpor> pedidoexpors,PedidoExpor pedidoexpor,PedidoExporParameterReturnGeneral pedidoexporParameterGeneral,Boolean isEsNuevoPedidoExpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-procesarEventosPedidoExporsWithConnection");connexion.begin();			
			
			PedidoExporParameterReturnGeneral pedidoexporReturnGeneral=new PedidoExporParameterReturnGeneral();
	
			pedidoexporReturnGeneral.setPedidoExpor(pedidoexpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidoexporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoExporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidoexpors,pedidoexpor,pedidoexporParameterGeneral,pedidoexporReturnGeneral,isEsNuevoPedidoExpor,clases);
			
			this.connexion.commit();
			
			return pedidoexporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoExporParameterReturnGeneral procesarImportacionPedidoExporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PedidoExporParameterReturnGeneral pedidoexporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-procesarImportacionPedidoExporsWithConnection");connexion.begin();			
			
			PedidoExporParameterReturnGeneral pedidoexporReturnGeneral=new PedidoExporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.pedidoexpors=new ArrayList<PedidoExpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.pedidoexpor=new PedidoExpor();
				
				
				if(conColumnasBase) {this.pedidoexpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.pedidoexpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.pedidoexpor.setnumero(arrColumnas[iColumn++]);
				this.pedidoexpor.setnumero_preimpreso(arrColumnas[iColumn++]);
				this.pedidoexpor.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedidoexpor.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedidoexpor.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setdireccion(arrColumnas[iColumn++]);
				this.pedidoexpor.settelefono(arrColumnas[iColumn++]);
				this.pedidoexpor.setruc(arrColumnas[iColumn++]);
				this.pedidoexpor.setlugar_entrega(arrColumnas[iColumn++]);
				this.pedidoexpor.setembarque(arrColumnas[iColumn++]);
				this.pedidoexpor.setnegociacion(arrColumnas[iColumn++]);
				this.pedidoexpor.setforma_pago(arrColumnas[iColumn++]);
				this.pedidoexpor.setorden(arrColumnas[iColumn++]);
				this.pedidoexpor.setdescripcion(arrColumnas[iColumn++]);
				this.pedidoexpor.setmonto(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setsaldo(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setdisponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setdescuento_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.settotal_con_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.settotal_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.settotal_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setsubtotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setseguros(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidoexpor.setfinanciamiento(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.pedidoexpors.add(this.pedidoexpor);
			}
			
			this.savePedidoExpors();
			
			this.connexion.commit();
			
			pedidoexporReturnGeneral.setConRetornoEstaProcesado(true);
			pedidoexporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return pedidoexporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPedidoExporsEliminados() throws Exception {				
		
		List<PedidoExpor> pedidoexporsAux= new ArrayList<PedidoExpor>();
		
		for(PedidoExpor pedidoexpor:pedidoexpors) {
			if(!pedidoexpor.getIsDeleted()) {
				pedidoexporsAux.add(pedidoexpor);
			}
		}
		
		pedidoexpors=pedidoexporsAux;
	}
	
	public void quitarPedidoExporsNulos() throws Exception {				
		
		List<PedidoExpor> pedidoexporsAux= new ArrayList<PedidoExpor>();
		
		for(PedidoExpor pedidoexpor : this.pedidoexpors) {
			if(pedidoexpor==null) {
				pedidoexporsAux.add(pedidoexpor);
			}
		}
		
		//this.pedidoexpors=pedidoexporsAux;
		
		this.pedidoexpors.removeAll(pedidoexporsAux);
	}
	
	public void getSetVersionRowPedidoExporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(pedidoexpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((pedidoexpor.getIsDeleted() || (pedidoexpor.getIsChanged()&&!pedidoexpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=pedidoexporDataAccess.getSetVersionRowPedidoExpor(connexion,pedidoexpor.getId());
				
				if(!pedidoexpor.getVersionRow().equals(timestamp)) {	
					pedidoexpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				pedidoexpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPedidoExpor()throws Exception {	
		
		if(pedidoexpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((pedidoexpor.getIsDeleted() || (pedidoexpor.getIsChanged()&&!pedidoexpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=pedidoexporDataAccess.getSetVersionRowPedidoExpor(connexion,pedidoexpor.getId());
			
			try {							
				if(!pedidoexpor.getVersionRow().equals(timestamp)) {	
					pedidoexpor.setVersionRow(timestamp);
				}
				
				pedidoexpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPedidoExporsWithConnection()throws Exception {	
		if(pedidoexpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PedidoExpor pedidoexporAux:pedidoexpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(pedidoexporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidoexporAux.getIsDeleted() || (pedidoexporAux.getIsChanged()&&!pedidoexporAux.getIsNew())) {
						
						timestamp=pedidoexporDataAccess.getSetVersionRowPedidoExpor(connexion,pedidoexporAux.getId());
						
						if(!pedidoexpor.getVersionRow().equals(timestamp)) {	
							pedidoexporAux.setVersionRow(timestamp);
						}
								
						pedidoexporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPedidoExpors()throws Exception {	
		if(pedidoexpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PedidoExpor pedidoexporAux:pedidoexpors) {
					if(pedidoexporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidoexporAux.getIsDeleted() || (pedidoexporAux.getIsChanged()&&!pedidoexporAux.getIsNew())) {
						
						timestamp=pedidoexporDataAccess.getSetVersionRowPedidoExpor(connexion,pedidoexporAux.getId());
						
						if(!pedidoexporAux.getVersionRow().equals(timestamp)) {	
							pedidoexporAux.setVersionRow(timestamp);
						}
						
													
						pedidoexporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PedidoExporParameterReturnGeneral cargarCombosLoteForeignKeyPedidoExporWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoPrecio,String finalQueryGlobalFormato,String finalQueryGlobalCliente,String finalQueryGlobalPais,String finalQueryGlobalTransporte,String finalQueryGlobalVendedor,String finalQueryGlobalSubCliente,String finalQueryGlobalConsignatario,String finalQueryGlobalConsultor,String finalQueryGlobalEstadoPedidoExpor,String finalQueryGlobalTipoCambio,String finalQueryGlobalCentroCosto,String finalQueryGlobalResponsable,String finalQueryGlobalTransportista) throws Exception {
		PedidoExporParameterReturnGeneral  pedidoexporReturnGeneral =new PedidoExporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-cargarCombosLoteForeignKeyPedidoExporWithConnection");connexion.begin();
			
			pedidoexporReturnGeneral =new PedidoExporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidoexporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidoexporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidoexporReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidoexporReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			pedidoexporReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			pedidoexporReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			pedidoexporReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			pedidoexporReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			pedidoexporReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			pedidoexporReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			pedidoexporReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidoexporReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			pedidoexporReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			pedidoexporReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			pedidoexporReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			pedidoexporReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<Consignatario> consignatariosForeignKey=new ArrayList<Consignatario>();
			ConsignatarioLogic consignatarioLogic=new ConsignatarioLogic();
			consignatarioLogic.setConnexion(this.connexion);
			consignatarioLogic.getConsignatarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsignatario.equals("NONE")) {
				consignatarioLogic.getTodosConsignatarios(finalQueryGlobalConsignatario,new Pagination());
				consignatariosForeignKey=consignatarioLogic.getConsignatarios();
			}

			pedidoexporReturnGeneral.setconsignatariosForeignKey(consignatariosForeignKey);


			List<Consultor> consultorsForeignKey=new ArrayList<Consultor>();
			ConsultorLogic consultorLogic=new ConsultorLogic();
			consultorLogic.setConnexion(this.connexion);
			consultorLogic.getConsultorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsultor.equals("NONE")) {
				consultorLogic.getTodosConsultors(finalQueryGlobalConsultor,new Pagination());
				consultorsForeignKey=consultorLogic.getConsultors();
			}

			pedidoexporReturnGeneral.setconsultorsForeignKey(consultorsForeignKey);


			List<EstadoPedido> estadopedidoexporsForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoexporLogic=new EstadoPedidoLogic();
			estadopedidoexporLogic.setConnexion(this.connexion);
			estadopedidoexporLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoExpor.equals("NONE")) {
				estadopedidoexporLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoExpor,new Pagination());
				estadopedidoexporsForeignKey=estadopedidoexporLogic.getEstadoPedidos();
			}

			pedidoexporReturnGeneral.setestadopedidoexporsForeignKey(estadopedidoexporsForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			pedidoexporReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			pedidoexporReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			pedidoexporReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			pedidoexporReturnGeneral.settransportistasForeignKey(transportistasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return pedidoexporReturnGeneral;
	}
	
	public PedidoExporParameterReturnGeneral cargarCombosLoteForeignKeyPedidoExpor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoPrecio,String finalQueryGlobalFormato,String finalQueryGlobalCliente,String finalQueryGlobalPais,String finalQueryGlobalTransporte,String finalQueryGlobalVendedor,String finalQueryGlobalSubCliente,String finalQueryGlobalConsignatario,String finalQueryGlobalConsultor,String finalQueryGlobalEstadoPedidoExpor,String finalQueryGlobalTipoCambio,String finalQueryGlobalCentroCosto,String finalQueryGlobalResponsable,String finalQueryGlobalTransportista) throws Exception {
		PedidoExporParameterReturnGeneral  pedidoexporReturnGeneral =new PedidoExporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			pedidoexporReturnGeneral =new PedidoExporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidoexporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidoexporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidoexporReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidoexporReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			pedidoexporReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			pedidoexporReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			pedidoexporReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			pedidoexporReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			pedidoexporReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			pedidoexporReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			pedidoexporReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidoexporReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			pedidoexporReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			pedidoexporReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			pedidoexporReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<SubCliente> subclientesForeignKey=new ArrayList<SubCliente>();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			subclienteLogic.setConnexion(this.connexion);
			subclienteLogic.getSubClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubCliente.equals("NONE")) {
				subclienteLogic.getTodosSubClientes(finalQueryGlobalSubCliente,new Pagination());
				subclientesForeignKey=subclienteLogic.getSubClientes();
			}

			pedidoexporReturnGeneral.setsubclientesForeignKey(subclientesForeignKey);


			List<Consignatario> consignatariosForeignKey=new ArrayList<Consignatario>();
			ConsignatarioLogic consignatarioLogic=new ConsignatarioLogic();
			consignatarioLogic.setConnexion(this.connexion);
			consignatarioLogic.getConsignatarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsignatario.equals("NONE")) {
				consignatarioLogic.getTodosConsignatarios(finalQueryGlobalConsignatario,new Pagination());
				consignatariosForeignKey=consignatarioLogic.getConsignatarios();
			}

			pedidoexporReturnGeneral.setconsignatariosForeignKey(consignatariosForeignKey);


			List<Consultor> consultorsForeignKey=new ArrayList<Consultor>();
			ConsultorLogic consultorLogic=new ConsultorLogic();
			consultorLogic.setConnexion(this.connexion);
			consultorLogic.getConsultorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsultor.equals("NONE")) {
				consultorLogic.getTodosConsultors(finalQueryGlobalConsultor,new Pagination());
				consultorsForeignKey=consultorLogic.getConsultors();
			}

			pedidoexporReturnGeneral.setconsultorsForeignKey(consultorsForeignKey);


			List<EstadoPedido> estadopedidoexporsForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoexporLogic=new EstadoPedidoLogic();
			estadopedidoexporLogic.setConnexion(this.connexion);
			estadopedidoexporLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoExpor.equals("NONE")) {
				estadopedidoexporLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoExpor,new Pagination());
				estadopedidoexporsForeignKey=estadopedidoexporLogic.getEstadoPedidos();
			}

			pedidoexporReturnGeneral.setestadopedidoexporsForeignKey(estadopedidoexporsForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			pedidoexporReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			pedidoexporReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			pedidoexporReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			pedidoexporReturnGeneral.settransportistasForeignKey(transportistasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return pedidoexporReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPedidoExporWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetallePedidoExporLogic detallepedidoexporLogic=new DetallePedidoExporLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPedidoExporWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetallePedidoExpor.class));
											
			

			detallepedidoexporLogic.setConnexion(this.getConnexion());
			detallepedidoexporLogic.setDatosCliente(this.datosCliente);
			detallepedidoexporLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PedidoExpor pedidoexpor:this.pedidoexpors) {
				

				classes=new ArrayList<Classe>();
				classes=DetallePedidoExporConstantesFunciones.getClassesForeignKeysOfDetallePedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallepedidoexporLogic.setDetallePedidoExpors(pedidoexpor.detallepedidoexpors);
				detallepedidoexporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PedidoExpor pedidoexpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PedidoExporLogicAdditional.updatePedidoExporToGet(pedidoexpor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidoexpor.setEmpresa(pedidoexporDataAccess.getEmpresa(connexion,pedidoexpor));
		pedidoexpor.setSucursal(pedidoexporDataAccess.getSucursal(connexion,pedidoexpor));
		pedidoexpor.setEjercicio(pedidoexporDataAccess.getEjercicio(connexion,pedidoexpor));
		pedidoexpor.setPeriodo(pedidoexporDataAccess.getPeriodo(connexion,pedidoexpor));
		pedidoexpor.setAnio(pedidoexporDataAccess.getAnio(connexion,pedidoexpor));
		pedidoexpor.setMes(pedidoexporDataAccess.getMes(connexion,pedidoexpor));
		pedidoexpor.setUsuario(pedidoexporDataAccess.getUsuario(connexion,pedidoexpor));
		pedidoexpor.setMoneda(pedidoexporDataAccess.getMoneda(connexion,pedidoexpor));
		pedidoexpor.setEmpleado(pedidoexporDataAccess.getEmpleado(connexion,pedidoexpor));
		pedidoexpor.setTipoPrecio(pedidoexporDataAccess.getTipoPrecio(connexion,pedidoexpor));
		pedidoexpor.setFormato(pedidoexporDataAccess.getFormato(connexion,pedidoexpor));
		pedidoexpor.setCliente(pedidoexporDataAccess.getCliente(connexion,pedidoexpor));
		pedidoexpor.setPais(pedidoexporDataAccess.getPais(connexion,pedidoexpor));
		pedidoexpor.setTransporte(pedidoexporDataAccess.getTransporte(connexion,pedidoexpor));
		pedidoexpor.setVendedor(pedidoexporDataAccess.getVendedor(connexion,pedidoexpor));
		pedidoexpor.setSubCliente(pedidoexporDataAccess.getSubCliente(connexion,pedidoexpor));
		pedidoexpor.setConsignatario(pedidoexporDataAccess.getConsignatario(connexion,pedidoexpor));
		pedidoexpor.setConsultor(pedidoexporDataAccess.getConsultor(connexion,pedidoexpor));
		pedidoexpor.setEstadoPedidoExpor(pedidoexporDataAccess.getEstadoPedidoExpor(connexion,pedidoexpor));
		pedidoexpor.setTipoCambio(pedidoexporDataAccess.getTipoCambio(connexion,pedidoexpor));
		pedidoexpor.setCentroCosto(pedidoexporDataAccess.getCentroCosto(connexion,pedidoexpor));
		pedidoexpor.setResponsable(pedidoexporDataAccess.getResponsable(connexion,pedidoexpor));
		pedidoexpor.setTransportista(pedidoexporDataAccess.getTransportista(connexion,pedidoexpor));
		pedidoexpor.setDetallePedidoExpors(pedidoexporDataAccess.getDetallePedidoExpors(connexion,pedidoexpor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidoexpor.setEmpresa(pedidoexporDataAccess.getEmpresa(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidoexpor.setSucursal(pedidoexporDataAccess.getSucursal(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedidoexpor.setEjercicio(pedidoexporDataAccess.getEjercicio(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedidoexpor.setPeriodo(pedidoexporDataAccess.getPeriodo(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				pedidoexpor.setAnio(pedidoexporDataAccess.getAnio(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				pedidoexpor.setMes(pedidoexporDataAccess.getMes(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				pedidoexpor.setUsuario(pedidoexporDataAccess.getUsuario(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				pedidoexpor.setMoneda(pedidoexporDataAccess.getMoneda(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				pedidoexpor.setEmpleado(pedidoexporDataAccess.getEmpleado(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				pedidoexpor.setTipoPrecio(pedidoexporDataAccess.getTipoPrecio(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				pedidoexpor.setFormato(pedidoexporDataAccess.getFormato(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidoexpor.setCliente(pedidoexporDataAccess.getCliente(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				pedidoexpor.setPais(pedidoexporDataAccess.getPais(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				pedidoexpor.setTransporte(pedidoexporDataAccess.getTransporte(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				pedidoexpor.setVendedor(pedidoexporDataAccess.getVendedor(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				pedidoexpor.setSubCliente(pedidoexporDataAccess.getSubCliente(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				pedidoexpor.setConsignatario(pedidoexporDataAccess.getConsignatario(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				pedidoexpor.setConsultor(pedidoexporDataAccess.getConsultor(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				pedidoexpor.setEstadoPedidoExpor(pedidoexporDataAccess.getEstadoPedidoExpor(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				pedidoexpor.setTipoCambio(pedidoexporDataAccess.getTipoCambio(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				pedidoexpor.setCentroCosto(pedidoexporDataAccess.getCentroCosto(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				pedidoexpor.setResponsable(pedidoexporDataAccess.getResponsable(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				pedidoexpor.setTransportista(pedidoexporDataAccess.getTransportista(connexion,pedidoexpor));
				continue;
			}

			if(clas.clas.equals(DetallePedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidoexpor.setDetallePedidoExpors(pedidoexporDataAccess.getDetallePedidoExpors(connexion,pedidoexpor));

				if(this.isConDeep) {
					DetallePedidoExporLogic detallepedidoexporLogic= new DetallePedidoExporLogic(this.connexion);
					detallepedidoexporLogic.setDetallePedidoExpors(pedidoexpor.getDetallePedidoExpors());
					ArrayList<Classe> classesLocal=DetallePedidoExporConstantesFunciones.getClassesForeignKeysOfDetallePedidoExpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallepedidoexporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetallePedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoExpor(detallepedidoexporLogic.getDetallePedidoExpors());
					pedidoexpor.setDetallePedidoExpors(detallepedidoexporLogic.getDetallePedidoExpors());
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
			pedidoexpor.setEmpresa(pedidoexporDataAccess.getEmpresa(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setSucursal(pedidoexporDataAccess.getSucursal(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setEjercicio(pedidoexporDataAccess.getEjercicio(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setPeriodo(pedidoexporDataAccess.getPeriodo(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setAnio(pedidoexporDataAccess.getAnio(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setMes(pedidoexporDataAccess.getMes(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setUsuario(pedidoexporDataAccess.getUsuario(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setMoneda(pedidoexporDataAccess.getMoneda(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setEmpleado(pedidoexporDataAccess.getEmpleado(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setTipoPrecio(pedidoexporDataAccess.getTipoPrecio(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setFormato(pedidoexporDataAccess.getFormato(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setCliente(pedidoexporDataAccess.getCliente(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setPais(pedidoexporDataAccess.getPais(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setTransporte(pedidoexporDataAccess.getTransporte(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setVendedor(pedidoexporDataAccess.getVendedor(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setSubCliente(pedidoexporDataAccess.getSubCliente(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignatario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setConsignatario(pedidoexporDataAccess.getConsignatario(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consultor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setConsultor(pedidoexporDataAccess.getConsultor(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setEstadoPedidoExpor(pedidoexporDataAccess.getEstadoPedidoExpor(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setTipoCambio(pedidoexporDataAccess.getTipoCambio(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setCentroCosto(pedidoexporDataAccess.getCentroCosto(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setResponsable(pedidoexporDataAccess.getResponsable(connexion,pedidoexpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setTransportista(pedidoexporDataAccess.getTransportista(connexion,pedidoexpor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoExpor.class));
			pedidoexpor.setDetallePedidoExpors(pedidoexporDataAccess.getDetallePedidoExpors(connexion,pedidoexpor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidoexpor.setEmpresa(pedidoexporDataAccess.getEmpresa(connexion,pedidoexpor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidoexpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setSucursal(pedidoexporDataAccess.getSucursal(connexion,pedidoexpor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidoexpor.getSucursal(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setEjercicio(pedidoexporDataAccess.getEjercicio(connexion,pedidoexpor));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedidoexpor.getEjercicio(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setPeriodo(pedidoexporDataAccess.getPeriodo(connexion,pedidoexpor));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedidoexpor.getPeriodo(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setAnio(pedidoexporDataAccess.getAnio(connexion,pedidoexpor));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(pedidoexpor.getAnio(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setMes(pedidoexporDataAccess.getMes(connexion,pedidoexpor));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(pedidoexpor.getMes(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setUsuario(pedidoexporDataAccess.getUsuario(connexion,pedidoexpor));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(pedidoexpor.getUsuario(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setMoneda(pedidoexporDataAccess.getMoneda(connexion,pedidoexpor));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(pedidoexpor.getMoneda(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setEmpleado(pedidoexporDataAccess.getEmpleado(connexion,pedidoexpor));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(pedidoexpor.getEmpleado(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setTipoPrecio(pedidoexporDataAccess.getTipoPrecio(connexion,pedidoexpor));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(pedidoexpor.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setFormato(pedidoexporDataAccess.getFormato(connexion,pedidoexpor));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(pedidoexpor.getFormato(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setCliente(pedidoexporDataAccess.getCliente(connexion,pedidoexpor));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedidoexpor.getCliente(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setPais(pedidoexporDataAccess.getPais(connexion,pedidoexpor));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(pedidoexpor.getPais(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setTransporte(pedidoexporDataAccess.getTransporte(connexion,pedidoexpor));
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(pedidoexpor.getTransporte(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setVendedor(pedidoexporDataAccess.getVendedor(connexion,pedidoexpor));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(pedidoexpor.getVendedor(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setSubCliente(pedidoexporDataAccess.getSubCliente(connexion,pedidoexpor));
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(pedidoexpor.getSubCliente(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setConsignatario(pedidoexporDataAccess.getConsignatario(connexion,pedidoexpor));
		ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
		consignatarioLogic.deepLoad(pedidoexpor.getConsignatario(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setConsultor(pedidoexporDataAccess.getConsultor(connexion,pedidoexpor));
		ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
		consultorLogic.deepLoad(pedidoexpor.getConsultor(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setEstadoPedidoExpor(pedidoexporDataAccess.getEstadoPedidoExpor(connexion,pedidoexpor));
		EstadoPedidoLogic estadopedidoexporLogic= new EstadoPedidoLogic(connexion);
		estadopedidoexporLogic.deepLoad(pedidoexpor.getEstadoPedidoExpor(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setTipoCambio(pedidoexporDataAccess.getTipoCambio(connexion,pedidoexpor));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(pedidoexpor.getTipoCambio(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setCentroCosto(pedidoexporDataAccess.getCentroCosto(connexion,pedidoexpor));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(pedidoexpor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setResponsable(pedidoexporDataAccess.getResponsable(connexion,pedidoexpor));
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(pedidoexpor.getResponsable(),isDeep,deepLoadType,clases);
				
		pedidoexpor.setTransportista(pedidoexporDataAccess.getTransportista(connexion,pedidoexpor));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(pedidoexpor.getTransportista(),isDeep,deepLoadType,clases);
				

		pedidoexpor.setDetallePedidoExpors(pedidoexporDataAccess.getDetallePedidoExpors(connexion,pedidoexpor));

		for(DetallePedidoExpor detallepedidoexpor:pedidoexpor.getDetallePedidoExpors()) {
			DetallePedidoExporLogic detallepedidoexporLogic= new DetallePedidoExporLogic(connexion);
			detallepedidoexporLogic.deepLoad(detallepedidoexpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidoexpor.setEmpresa(pedidoexporDataAccess.getEmpresa(connexion,pedidoexpor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pedidoexpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidoexpor.setSucursal(pedidoexporDataAccess.getSucursal(connexion,pedidoexpor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(pedidoexpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedidoexpor.setEjercicio(pedidoexporDataAccess.getEjercicio(connexion,pedidoexpor));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(pedidoexpor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedidoexpor.setPeriodo(pedidoexporDataAccess.getPeriodo(connexion,pedidoexpor));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(pedidoexpor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				pedidoexpor.setAnio(pedidoexporDataAccess.getAnio(connexion,pedidoexpor));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(pedidoexpor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				pedidoexpor.setMes(pedidoexporDataAccess.getMes(connexion,pedidoexpor));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(pedidoexpor.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				pedidoexpor.setUsuario(pedidoexporDataAccess.getUsuario(connexion,pedidoexpor));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(pedidoexpor.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				pedidoexpor.setMoneda(pedidoexporDataAccess.getMoneda(connexion,pedidoexpor));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(pedidoexpor.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				pedidoexpor.setEmpleado(pedidoexporDataAccess.getEmpleado(connexion,pedidoexpor));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(pedidoexpor.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				pedidoexpor.setTipoPrecio(pedidoexporDataAccess.getTipoPrecio(connexion,pedidoexpor));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(pedidoexpor.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				pedidoexpor.setFormato(pedidoexporDataAccess.getFormato(connexion,pedidoexpor));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(pedidoexpor.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidoexpor.setCliente(pedidoexporDataAccess.getCliente(connexion,pedidoexpor));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(pedidoexpor.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				pedidoexpor.setPais(pedidoexporDataAccess.getPais(connexion,pedidoexpor));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(pedidoexpor.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				pedidoexpor.setTransporte(pedidoexporDataAccess.getTransporte(connexion,pedidoexpor));
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepLoad(pedidoexpor.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				pedidoexpor.setVendedor(pedidoexporDataAccess.getVendedor(connexion,pedidoexpor));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(pedidoexpor.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				pedidoexpor.setSubCliente(pedidoexporDataAccess.getSubCliente(connexion,pedidoexpor));
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(pedidoexpor.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				pedidoexpor.setConsignatario(pedidoexporDataAccess.getConsignatario(connexion,pedidoexpor));
				ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
				consignatarioLogic.deepLoad(pedidoexpor.getConsignatario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				pedidoexpor.setConsultor(pedidoexporDataAccess.getConsultor(connexion,pedidoexpor));
				ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
				consultorLogic.deepLoad(pedidoexpor.getConsultor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				pedidoexpor.setEstadoPedidoExpor(pedidoexporDataAccess.getEstadoPedidoExpor(connexion,pedidoexpor));
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepLoad(pedidoexpor.getEstadoPedidoExpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				pedidoexpor.setTipoCambio(pedidoexporDataAccess.getTipoCambio(connexion,pedidoexpor));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(pedidoexpor.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				pedidoexpor.setCentroCosto(pedidoexporDataAccess.getCentroCosto(connexion,pedidoexpor));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(pedidoexpor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				pedidoexpor.setResponsable(pedidoexporDataAccess.getResponsable(connexion,pedidoexpor));
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepLoad(pedidoexpor.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				pedidoexpor.setTransportista(pedidoexporDataAccess.getTransportista(connexion,pedidoexpor));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(pedidoexpor.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetallePedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidoexpor.setDetallePedidoExpors(pedidoexporDataAccess.getDetallePedidoExpors(connexion,pedidoexpor));

				for(DetallePedidoExpor detallepedidoexpor:pedidoexpor.getDetallePedidoExpors()) {
					DetallePedidoExporLogic detallepedidoexporLogic= new DetallePedidoExporLogic(connexion);
					detallepedidoexporLogic.deepLoad(detallepedidoexpor,isDeep,deepLoadType,clases);
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
			pedidoexpor.setEmpresa(pedidoexporDataAccess.getEmpresa(connexion,pedidoexpor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pedidoexpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setSucursal(pedidoexporDataAccess.getSucursal(connexion,pedidoexpor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(pedidoexpor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setEjercicio(pedidoexporDataAccess.getEjercicio(connexion,pedidoexpor));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(pedidoexpor.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setPeriodo(pedidoexporDataAccess.getPeriodo(connexion,pedidoexpor));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(pedidoexpor.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setAnio(pedidoexporDataAccess.getAnio(connexion,pedidoexpor));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(pedidoexpor.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setMes(pedidoexporDataAccess.getMes(connexion,pedidoexpor));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(pedidoexpor.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setUsuario(pedidoexporDataAccess.getUsuario(connexion,pedidoexpor));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(pedidoexpor.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setMoneda(pedidoexporDataAccess.getMoneda(connexion,pedidoexpor));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(pedidoexpor.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setEmpleado(pedidoexporDataAccess.getEmpleado(connexion,pedidoexpor));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(pedidoexpor.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setTipoPrecio(pedidoexporDataAccess.getTipoPrecio(connexion,pedidoexpor));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(pedidoexpor.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setFormato(pedidoexporDataAccess.getFormato(connexion,pedidoexpor));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(pedidoexpor.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setCliente(pedidoexporDataAccess.getCliente(connexion,pedidoexpor));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(pedidoexpor.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setPais(pedidoexporDataAccess.getPais(connexion,pedidoexpor));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(pedidoexpor.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setTransporte(pedidoexporDataAccess.getTransporte(connexion,pedidoexpor));
			TransporteLogic transporteLogic= new TransporteLogic(connexion);
			transporteLogic.deepLoad(pedidoexpor.getTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setVendedor(pedidoexporDataAccess.getVendedor(connexion,pedidoexpor));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(pedidoexpor.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setSubCliente(pedidoexporDataAccess.getSubCliente(connexion,pedidoexpor));
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(pedidoexpor.getSubCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Consignatario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setConsignatario(pedidoexporDataAccess.getConsignatario(connexion,pedidoexpor));
			ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
			consignatarioLogic.deepLoad(pedidoexpor.getConsignatario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Consultor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setConsultor(pedidoexporDataAccess.getConsultor(connexion,pedidoexpor));
			ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
			consultorLogic.deepLoad(pedidoexpor.getConsultor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setEstadoPedidoExpor(pedidoexporDataAccess.getEstadoPedidoExpor(connexion,pedidoexpor));
			EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
			estadopedidoLogic.deepLoad(pedidoexpor.getEstadoPedidoExpor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setTipoCambio(pedidoexporDataAccess.getTipoCambio(connexion,pedidoexpor));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(pedidoexpor.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setCentroCosto(pedidoexporDataAccess.getCentroCosto(connexion,pedidoexpor));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(pedidoexpor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setResponsable(pedidoexporDataAccess.getResponsable(connexion,pedidoexpor));
			ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
			responsableLogic.deepLoad(pedidoexpor.getResponsable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidoexpor.setTransportista(pedidoexporDataAccess.getTransportista(connexion,pedidoexpor));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(pedidoexpor.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoExpor.class));
			pedidoexpor.setDetallePedidoExpors(pedidoexporDataAccess.getDetallePedidoExpors(connexion,pedidoexpor));

			for(DetallePedidoExpor detallepedidoexpor:pedidoexpor.getDetallePedidoExpors()) {
				DetallePedidoExporLogic detallepedidoexporLogic= new DetallePedidoExporLogic(connexion);
				detallepedidoexporLogic.deepLoad(detallepedidoexpor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PedidoExpor pedidoexpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PedidoExporLogicAdditional.updatePedidoExporToSave(pedidoexpor,this.arrDatoGeneral);
			
PedidoExporDataAccess.save(pedidoexpor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidoexpor.getEmpresa(),connexion);

		SucursalDataAccess.save(pedidoexpor.getSucursal(),connexion);

		EjercicioDataAccess.save(pedidoexpor.getEjercicio(),connexion);

		PeriodoDataAccess.save(pedidoexpor.getPeriodo(),connexion);

		AnioDataAccess.save(pedidoexpor.getAnio(),connexion);

		MesDataAccess.save(pedidoexpor.getMes(),connexion);

		UsuarioDataAccess.save(pedidoexpor.getUsuario(),connexion);

		MonedaDataAccess.save(pedidoexpor.getMoneda(),connexion);

		EmpleadoDataAccess.save(pedidoexpor.getEmpleado(),connexion);

		TipoPrecioDataAccess.save(pedidoexpor.getTipoPrecio(),connexion);

		FormatoDataAccess.save(pedidoexpor.getFormato(),connexion);

		ClienteDataAccess.save(pedidoexpor.getCliente(),connexion);

		PaisDataAccess.save(pedidoexpor.getPais(),connexion);

		TransporteDataAccess.save(pedidoexpor.getTransporte(),connexion);

		VendedorDataAccess.save(pedidoexpor.getVendedor(),connexion);

		SubClienteDataAccess.save(pedidoexpor.getSubCliente(),connexion);

		ConsignatarioDataAccess.save(pedidoexpor.getConsignatario(),connexion);

		ConsultorDataAccess.save(pedidoexpor.getConsultor(),connexion);

		EstadoPedidoDataAccess.save(pedidoexpor.getEstadoPedidoExpor(),connexion);

		TipoCambioDataAccess.save(pedidoexpor.getTipoCambio(),connexion);

		CentroCostoDataAccess.save(pedidoexpor.getCentroCosto(),connexion);

		ResponsableDataAccess.save(pedidoexpor.getResponsable(),connexion);

		TransportistaDataAccess.save(pedidoexpor.getTransportista(),connexion);

		for(DetallePedidoExpor detallepedidoexpor:pedidoexpor.getDetallePedidoExpors()) {
			detallepedidoexpor.setid_pedido_expor(pedidoexpor.getId());
			DetallePedidoExporDataAccess.save(detallepedidoexpor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidoexpor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidoexpor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedidoexpor.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedidoexpor.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(pedidoexpor.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(pedidoexpor.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(pedidoexpor.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(pedidoexpor.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(pedidoexpor.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(pedidoexpor.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(pedidoexpor.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidoexpor.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(pedidoexpor.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(pedidoexpor.getTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(pedidoexpor.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(pedidoexpor.getSubCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				ConsignatarioDataAccess.save(pedidoexpor.getConsignatario(),connexion);
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				ConsultorDataAccess.save(pedidoexpor.getConsultor(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(pedidoexpor.getEstadoPedidoExpor(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(pedidoexpor.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(pedidoexpor.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(pedidoexpor.getResponsable(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(pedidoexpor.getTransportista(),connexion);
				continue;
			}


			if(clas.clas.equals(DetallePedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedidoExpor detallepedidoexpor:pedidoexpor.getDetallePedidoExpors()) {
					detallepedidoexpor.setid_pedido_expor(pedidoexpor.getId());
					DetallePedidoExporDataAccess.save(detallepedidoexpor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidoexpor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidoexpor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(pedidoexpor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidoexpor.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(pedidoexpor.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedidoexpor.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(pedidoexpor.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedidoexpor.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(pedidoexpor.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(pedidoexpor.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(pedidoexpor.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(pedidoexpor.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(pedidoexpor.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(pedidoexpor.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(pedidoexpor.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(pedidoexpor.getMoneda(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(pedidoexpor.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(pedidoexpor.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(pedidoexpor.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(pedidoexpor.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(pedidoexpor.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(pedidoexpor.getFormato(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(pedidoexpor.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedidoexpor.getCliente(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(pedidoexpor.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(pedidoexpor.getPais(),isDeep,deepLoadType,clases);
				

		TransporteDataAccess.save(pedidoexpor.getTransporte(),connexion);
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(pedidoexpor.getTransporte(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(pedidoexpor.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(pedidoexpor.getVendedor(),isDeep,deepLoadType,clases);
				

		SubClienteDataAccess.save(pedidoexpor.getSubCliente(),connexion);
		SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
		subclienteLogic.deepLoad(pedidoexpor.getSubCliente(),isDeep,deepLoadType,clases);
				

		ConsignatarioDataAccess.save(pedidoexpor.getConsignatario(),connexion);
		ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
		consignatarioLogic.deepLoad(pedidoexpor.getConsignatario(),isDeep,deepLoadType,clases);
				

		ConsultorDataAccess.save(pedidoexpor.getConsultor(),connexion);
		ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
		consultorLogic.deepLoad(pedidoexpor.getConsultor(),isDeep,deepLoadType,clases);
				

		EstadoPedidoDataAccess.save(pedidoexpor.getEstadoPedidoExpor(),connexion);
		EstadoPedidoLogic estadopedidoexporLogic= new EstadoPedidoLogic(connexion);
		estadopedidoexporLogic.deepLoad(pedidoexpor.getEstadoPedidoExpor(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(pedidoexpor.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(pedidoexpor.getTipoCambio(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(pedidoexpor.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(pedidoexpor.getCentroCosto(),isDeep,deepLoadType,clases);
				

		ResponsableDataAccess.save(pedidoexpor.getResponsable(),connexion);
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(pedidoexpor.getResponsable(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(pedidoexpor.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(pedidoexpor.getTransportista(),isDeep,deepLoadType,clases);
				

		for(DetallePedidoExpor detallepedidoexpor:pedidoexpor.getDetallePedidoExpors()) {
			DetallePedidoExporLogic detallepedidoexporLogic= new DetallePedidoExporLogic(connexion);
			detallepedidoexpor.setid_pedido_expor(pedidoexpor.getId());
			DetallePedidoExporDataAccess.save(detallepedidoexpor,connexion);
			detallepedidoexporLogic.deepSave(detallepedidoexpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidoexpor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(pedidoexpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidoexpor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(pedidoexpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedidoexpor.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(pedidoexpor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedidoexpor.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(pedidoexpor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(pedidoexpor.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(pedidoexpor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(pedidoexpor.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(pedidoexpor.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(pedidoexpor.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(pedidoexpor.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(pedidoexpor.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(pedidoexpor.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(pedidoexpor.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(pedidoexpor.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(pedidoexpor.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(pedidoexpor.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(pedidoexpor.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(pedidoexpor.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidoexpor.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(pedidoexpor.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(pedidoexpor.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(pedidoexpor.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(pedidoexpor.getTransporte(),connexion);
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepSave(pedidoexpor.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(pedidoexpor.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(pedidoexpor.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubCliente.class)) {
				SubClienteDataAccess.save(pedidoexpor.getSubCliente(),connexion);
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepSave(pedidoexpor.getSubCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consignatario.class)) {
				ConsignatarioDataAccess.save(pedidoexpor.getConsignatario(),connexion);
				ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
				consignatarioLogic.deepSave(pedidoexpor.getConsignatario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consultor.class)) {
				ConsultorDataAccess.save(pedidoexpor.getConsultor(),connexion);
				ConsultorLogic consultorLogic= new ConsultorLogic(connexion);
				consultorLogic.deepSave(pedidoexpor.getConsultor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(pedidoexpor.getEstadoPedidoExpor(),connexion);
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepSave(pedidoexpor.getEstadoPedidoExpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(pedidoexpor.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(pedidoexpor.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(pedidoexpor.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(pedidoexpor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(pedidoexpor.getResponsable(),connexion);
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepSave(pedidoexpor.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(pedidoexpor.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(pedidoexpor.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetallePedidoExpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedidoExpor detallepedidoexpor:pedidoexpor.getDetallePedidoExpors()) {
					DetallePedidoExporLogic detallepedidoexporLogic= new DetallePedidoExporLogic(connexion);
					detallepedidoexpor.setid_pedido_expor(pedidoexpor.getId());
					DetallePedidoExporDataAccess.save(detallepedidoexpor,connexion);
					detallepedidoexporLogic.deepSave(detallepedidoexpor,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PedidoExpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(pedidoexpor);
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
			this.deepLoad(this.pedidoexpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PedidoExpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(pedidoexpors!=null) {
				for(PedidoExpor pedidoexpor:pedidoexpors) {
					this.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(pedidoexpors);
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
			if(pedidoexpors!=null) {
				for(PedidoExpor pedidoexpor:pedidoexpors) {
					this.deepLoad(pedidoexpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(pedidoexpors);
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
			this.getNewConnexionToDeep(PedidoExpor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(pedidoexpor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PedidoExpor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(pedidoexpors!=null) {
				for(PedidoExpor pedidoexpor:pedidoexpors) {
					this.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
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
			if(pedidoexpors!=null) {
				for(PedidoExpor pedidoexpor:pedidoexpors) {
					this.deepSave(pedidoexpor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPedidoExporsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PedidoExporConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PedidoExporConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PedidoExporConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PedidoExporConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoExporConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoExporConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdConsignatarioWithConnection(String sFinalQuery,Pagination pagination,Long id_consignatario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsignatario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsignatario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consignatario,PedidoExporConstantesFunciones.IDCONSIGNATARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsignatario);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsignatario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdConsignatario(String sFinalQuery,Pagination pagination,Long id_consignatario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsignatario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsignatario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consignatario,PedidoExporConstantesFunciones.IDCONSIGNATARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsignatario);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsignatario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdConsultorWithConnection(String sFinalQuery,Pagination pagination,Long id_consultor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsultor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsultor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consultor,PedidoExporConstantesFunciones.IDCONSULTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsultor);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsultor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdConsultor(String sFinalQuery,Pagination pagination,Long id_consultor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsultor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsultor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consultor,PedidoExporConstantesFunciones.IDCONSULTOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsultor);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsultor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoExporConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoExporConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PedidoExporConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PedidoExporConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoExporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoExporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdEstadoPedidoExporWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoExpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoExpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido,PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoExpor);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoExpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdEstadoPedidoExpor(String sFinalQuery,Pagination pagination,Long id_estado_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoExpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoExpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido,PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoExpor);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoExpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PedidoExporConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PedidoExporConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PedidoExporConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PedidoExporConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,PedidoExporConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,PedidoExporConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PedidoExporConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PedidoExporConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoExporConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoExporConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdResponsableWithConnection(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,PedidoExporConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdResponsable(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,PedidoExporConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdSubClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,PedidoExporConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdSubCliente(String sFinalQuery,Pagination pagination,Long id_sub_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_cliente,PedidoExporConstantesFunciones.IDSUBCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubCliente);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoExporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoExporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,PedidoExporConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,PedidoExporConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,PedidoExporConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,PedidoExporConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,PedidoExporConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdTransporte(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,PedidoExporConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,PedidoExporConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,PedidoExporConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PedidoExporConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PedidoExporConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoExporsFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoExpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,PedidoExporConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoExporsFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,PedidoExporConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			PedidoExporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoExporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoExpor(this.pedidoexpors);
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
			if(PedidoExporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoExporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PedidoExpor pedidoexpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PedidoExporConstantesFunciones.ISCONAUDITORIA) {
				if(pedidoexpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoExporDataAccess.TABLENAME, pedidoexpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoExporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoExporLogic.registrarAuditoriaDetallesPedidoExpor(connexion,pedidoexpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(pedidoexpor.getIsDeleted()) {
					/*if(!pedidoexpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PedidoExporDataAccess.TABLENAME, pedidoexpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PedidoExporLogic.registrarAuditoriaDetallesPedidoExpor(connexion,pedidoexpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoExporDataAccess.TABLENAME, pedidoexpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(pedidoexpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoExporDataAccess.TABLENAME, pedidoexpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoExporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoExporLogic.registrarAuditoriaDetallesPedidoExpor(connexion,pedidoexpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPedidoExpor(Connexion connexion,PedidoExpor pedidoexpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_empresa().equals(pedidoexpor.getPedidoExporOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_empresa()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_empresa().toString();
				}
				if(pedidoexpor.getid_empresa()!=null)
				{
					strValorNuevo=pedidoexpor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_sucursal().equals(pedidoexpor.getPedidoExporOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_sucursal()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_sucursal().toString();
				}
				if(pedidoexpor.getid_sucursal()!=null)
				{
					strValorNuevo=pedidoexpor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_ejercicio().equals(pedidoexpor.getPedidoExporOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_ejercicio()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_ejercicio().toString();
				}
				if(pedidoexpor.getid_ejercicio()!=null)
				{
					strValorNuevo=pedidoexpor.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_periodo().equals(pedidoexpor.getPedidoExporOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_periodo()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_periodo().toString();
				}
				if(pedidoexpor.getid_periodo()!=null)
				{
					strValorNuevo=pedidoexpor.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_anio().equals(pedidoexpor.getPedidoExporOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_anio()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_anio().toString();
				}
				if(pedidoexpor.getid_anio()!=null)
				{
					strValorNuevo=pedidoexpor.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_mes().equals(pedidoexpor.getPedidoExporOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_mes()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_mes().toString();
				}
				if(pedidoexpor.getid_mes()!=null)
				{
					strValorNuevo=pedidoexpor.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_usuario().equals(pedidoexpor.getPedidoExporOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_usuario()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_usuario().toString();
				}
				if(pedidoexpor.getid_usuario()!=null)
				{
					strValorNuevo=pedidoexpor.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getnumero().equals(pedidoexpor.getPedidoExporOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getnumero()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getnumero();
				}
				if(pedidoexpor.getnumero()!=null)
				{
					strValorNuevo=pedidoexpor.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getnumero_preimpreso().equals(pedidoexpor.getPedidoExporOriginal().getnumero_preimpreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getnumero_preimpreso()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getnumero_preimpreso();
				}
				if(pedidoexpor.getnumero_preimpreso()!=null)
				{
					strValorNuevo=pedidoexpor.getnumero_preimpreso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.NUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getfecha_emision().equals(pedidoexpor.getPedidoExporOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getfecha_emision()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getfecha_emision().toString();
				}
				if(pedidoexpor.getfecha_emision()!=null)
				{
					strValorNuevo=pedidoexpor.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getfecha_vencimiento().equals(pedidoexpor.getPedidoExporOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getfecha_vencimiento().toString();
				}
				if(pedidoexpor.getfecha_vencimiento()!=null)
				{
					strValorNuevo=pedidoexpor.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_moneda().equals(pedidoexpor.getPedidoExporOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_moneda()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_moneda().toString();
				}
				if(pedidoexpor.getid_moneda()!=null)
				{
					strValorNuevo=pedidoexpor.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getcotizacion().equals(pedidoexpor.getPedidoExporOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getcotizacion()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getcotizacion().toString();
				}
				if(pedidoexpor.getcotizacion()!=null)
				{
					strValorNuevo=pedidoexpor.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_empleado().equals(pedidoexpor.getPedidoExporOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_empleado()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_empleado().toString();
				}
				if(pedidoexpor.getid_empleado()!=null)
				{
					strValorNuevo=pedidoexpor.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_tipo_precio().equals(pedidoexpor.getPedidoExporOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_tipo_precio().toString();
				}
				if(pedidoexpor.getid_tipo_precio()!=null)
				{
					strValorNuevo=pedidoexpor.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_formato().equals(pedidoexpor.getPedidoExporOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_formato()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_formato().toString();
				}
				if(pedidoexpor.getid_formato()!=null)
				{
					strValorNuevo=pedidoexpor.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getdireccion().equals(pedidoexpor.getPedidoExporOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getdireccion()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getdireccion();
				}
				if(pedidoexpor.getdireccion()!=null)
				{
					strValorNuevo=pedidoexpor.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_cliente().equals(pedidoexpor.getPedidoExporOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_cliente()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_cliente().toString();
				}
				if(pedidoexpor.getid_cliente()!=null)
				{
					strValorNuevo=pedidoexpor.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.gettelefono().equals(pedidoexpor.getPedidoExporOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().gettelefono()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().gettelefono();
				}
				if(pedidoexpor.gettelefono()!=null)
				{
					strValorNuevo=pedidoexpor.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getruc().equals(pedidoexpor.getPedidoExporOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getruc()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getruc();
				}
				if(pedidoexpor.getruc()!=null)
				{
					strValorNuevo=pedidoexpor.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_pais().equals(pedidoexpor.getPedidoExporOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_pais()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_pais().toString();
				}
				if(pedidoexpor.getid_pais()!=null)
				{
					strValorNuevo=pedidoexpor.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getlugar_entrega().equals(pedidoexpor.getPedidoExporOriginal().getlugar_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getlugar_entrega()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getlugar_entrega();
				}
				if(pedidoexpor.getlugar_entrega()!=null)
				{
					strValorNuevo=pedidoexpor.getlugar_entrega() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.LUGARENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getembarque().equals(pedidoexpor.getPedidoExporOriginal().getembarque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getembarque()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getembarque();
				}
				if(pedidoexpor.getembarque()!=null)
				{
					strValorNuevo=pedidoexpor.getembarque() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.EMBARQUE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getnegociacion().equals(pedidoexpor.getPedidoExporOriginal().getnegociacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getnegociacion()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getnegociacion();
				}
				if(pedidoexpor.getnegociacion()!=null)
				{
					strValorNuevo=pedidoexpor.getnegociacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.NEGOCIACION,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_transporte().equals(pedidoexpor.getPedidoExporOriginal().getid_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_transporte()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_transporte().toString();
				}
				if(pedidoexpor.getid_transporte()!=null)
				{
					strValorNuevo=pedidoexpor.getid_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDTRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_vendedor().equals(pedidoexpor.getPedidoExporOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_vendedor()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_vendedor().toString();
				}
				if(pedidoexpor.getid_vendedor()!=null)
				{
					strValorNuevo=pedidoexpor.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getforma_pago().equals(pedidoexpor.getPedidoExporOriginal().getforma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getforma_pago()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getforma_pago();
				}
				if(pedidoexpor.getforma_pago()!=null)
				{
					strValorNuevo=pedidoexpor.getforma_pago() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.FORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_sub_cliente().equals(pedidoexpor.getPedidoExporOriginal().getid_sub_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_sub_cliente()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_sub_cliente().toString();
				}
				if(pedidoexpor.getid_sub_cliente()!=null)
				{
					strValorNuevo=pedidoexpor.getid_sub_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDSUBCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_consignatario().equals(pedidoexpor.getPedidoExporOriginal().getid_consignatario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_consignatario()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_consignatario().toString();
				}
				if(pedidoexpor.getid_consignatario()!=null)
				{
					strValorNuevo=pedidoexpor.getid_consignatario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDCONSIGNATARIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_consultor().equals(pedidoexpor.getPedidoExporOriginal().getid_consultor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_consultor()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_consultor().toString();
				}
				if(pedidoexpor.getid_consultor()!=null)
				{
					strValorNuevo=pedidoexpor.getid_consultor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDCONSULTOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getorden().equals(pedidoexpor.getPedidoExporOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getorden()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getorden();
				}
				if(pedidoexpor.getorden()!=null)
				{
					strValorNuevo=pedidoexpor.getorden() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_estado_pedido().equals(pedidoexpor.getPedidoExporOriginal().getid_estado_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_estado_pedido()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_estado_pedido().toString();
				}
				if(pedidoexpor.getid_estado_pedido()!=null)
				{
					strValorNuevo=pedidoexpor.getid_estado_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getdescripcion().equals(pedidoexpor.getPedidoExporOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getdescripcion()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getdescripcion();
				}
				if(pedidoexpor.getdescripcion()!=null)
				{
					strValorNuevo=pedidoexpor.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getmonto().equals(pedidoexpor.getPedidoExporOriginal().getmonto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getmonto()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getmonto().toString();
				}
				if(pedidoexpor.getmonto()!=null)
				{
					strValorNuevo=pedidoexpor.getmonto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.MONTO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getsaldo().equals(pedidoexpor.getPedidoExporOriginal().getsaldo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getsaldo()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getsaldo().toString();
				}
				if(pedidoexpor.getsaldo()!=null)
				{
					strValorNuevo=pedidoexpor.getsaldo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.SALDO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getdisponible().equals(pedidoexpor.getPedidoExporOriginal().getdisponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getdisponible()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getdisponible().toString();
				}
				if(pedidoexpor.getdisponible()!=null)
				{
					strValorNuevo=pedidoexpor.getdisponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.DISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getdescuento_porcentaje().equals(pedidoexpor.getPedidoExporOriginal().getdescuento_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getdescuento_porcentaje()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getdescuento_porcentaje().toString();
				}
				if(pedidoexpor.getdescuento_porcentaje()!=null)
				{
					strValorNuevo=pedidoexpor.getdescuento_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.gettotal_con_iva().equals(pedidoexpor.getPedidoExporOriginal().gettotal_con_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().gettotal_con_iva()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().gettotal_con_iva().toString();
				}
				if(pedidoexpor.gettotal_con_iva()!=null)
				{
					strValorNuevo=pedidoexpor.gettotal_con_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.TOTALCONIVA,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getsuman().equals(pedidoexpor.getPedidoExporOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getsuman()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getsuman().toString();
				}
				if(pedidoexpor.getsuman()!=null)
				{
					strValorNuevo=pedidoexpor.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getdescuento_valor().equals(pedidoexpor.getPedidoExporOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getdescuento_valor()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getdescuento_valor().toString();
				}
				if(pedidoexpor.getdescuento_valor()!=null)
				{
					strValorNuevo=pedidoexpor.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.gettotal_sin_iva().equals(pedidoexpor.getPedidoExporOriginal().gettotal_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().gettotal_sin_iva()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().gettotal_sin_iva().toString();
				}
				if(pedidoexpor.gettotal_sin_iva()!=null)
				{
					strValorNuevo=pedidoexpor.gettotal_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.TOTALSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.gettotal_descuento().equals(pedidoexpor.getPedidoExporOriginal().gettotal_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().gettotal_descuento()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().gettotal_descuento().toString();
				}
				if(pedidoexpor.gettotal_descuento()!=null)
				{
					strValorNuevo=pedidoexpor.gettotal_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.TOTALDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getflete().equals(pedidoexpor.getPedidoExporOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getflete()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getflete().toString();
				}
				if(pedidoexpor.getflete()!=null)
				{
					strValorNuevo=pedidoexpor.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.gettotal().equals(pedidoexpor.getPedidoExporOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().gettotal()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().gettotal().toString();
				}
				if(pedidoexpor.gettotal()!=null)
				{
					strValorNuevo=pedidoexpor.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getsubtotal().equals(pedidoexpor.getPedidoExporOriginal().getsubtotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getsubtotal()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getsubtotal().toString();
				}
				if(pedidoexpor.getsubtotal()!=null)
				{
					strValorNuevo=pedidoexpor.getsubtotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getseguros().equals(pedidoexpor.getPedidoExporOriginal().getseguros()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getseguros()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getseguros().toString();
				}
				if(pedidoexpor.getseguros()!=null)
				{
					strValorNuevo=pedidoexpor.getseguros().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.SEGUROS,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getiva().equals(pedidoexpor.getPedidoExporOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getiva()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getiva().toString();
				}
				if(pedidoexpor.getiva()!=null)
				{
					strValorNuevo=pedidoexpor.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getfinanciamiento().equals(pedidoexpor.getPedidoExporOriginal().getfinanciamiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getfinanciamiento()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getfinanciamiento().toString();
				}
				if(pedidoexpor.getfinanciamiento()!=null)
				{
					strValorNuevo=pedidoexpor.getfinanciamiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.FINANCIAMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getmonto_retencion().equals(pedidoexpor.getPedidoExporOriginal().getmonto_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getmonto_retencion()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getmonto_retencion().toString();
				}
				if(pedidoexpor.getmonto_retencion()!=null)
				{
					strValorNuevo=pedidoexpor.getmonto_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.MONTORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getotro().equals(pedidoexpor.getPedidoExporOriginal().getotro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getotro()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getotro().toString();
				}
				if(pedidoexpor.getotro()!=null)
				{
					strValorNuevo=pedidoexpor.getotro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.OTRO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getice().equals(pedidoexpor.getPedidoExporOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getice()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getice().toString();
				}
				if(pedidoexpor.getice()!=null)
				{
					strValorNuevo=pedidoexpor.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getfecha().equals(pedidoexpor.getPedidoExporOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getfecha()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getfecha().toString();
				}
				if(pedidoexpor.getfecha()!=null)
				{
					strValorNuevo=pedidoexpor.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getfecha_servidor().equals(pedidoexpor.getPedidoExporOriginal().getfecha_servidor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getfecha_servidor()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getfecha_servidor().toString();
				}
				if(pedidoexpor.getfecha_servidor()!=null)
				{
					strValorNuevo=pedidoexpor.getfecha_servidor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.FECHASERVIDOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_tipo_cambio().equals(pedidoexpor.getPedidoExporOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_tipo_cambio().toString();
				}
				if(pedidoexpor.getid_tipo_cambio()!=null)
				{
					strValorNuevo=pedidoexpor.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getnumero_fue().equals(pedidoexpor.getPedidoExporOriginal().getnumero_fue()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getnumero_fue()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getnumero_fue();
				}
				if(pedidoexpor.getnumero_fue()!=null)
				{
					strValorNuevo=pedidoexpor.getnumero_fue() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.NUMEROFUE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_centro_costo().equals(pedidoexpor.getPedidoExporOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_centro_costo()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_centro_costo().toString();
				}
				if(pedidoexpor.getid_centro_costo()!=null)
				{
					strValorNuevo=pedidoexpor.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_responsable().equals(pedidoexpor.getPedidoExporOriginal().getid_responsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_responsable()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_responsable().toString();
				}
				if(pedidoexpor.getid_responsable()!=null)
				{
					strValorNuevo=pedidoexpor.getid_responsable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDRESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.gethora_inicio().equals(pedidoexpor.getPedidoExporOriginal().gethora_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().gethora_inicio()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().gethora_inicio().toString();
				}
				if(pedidoexpor.gethora_inicio()!=null)
				{
					strValorNuevo=pedidoexpor.gethora_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.HORAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.gethora_fin().equals(pedidoexpor.getPedidoExporOriginal().gethora_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().gethora_fin()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().gethora_fin().toString();
				}
				if(pedidoexpor.gethora_fin()!=null)
				{
					strValorNuevo=pedidoexpor.gethora_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.HORAFIN,strValorActual,strValorNuevo);
			}	
			
			if(pedidoexpor.getIsNew()||!pedidoexpor.getid_transportista().equals(pedidoexpor.getPedidoExporOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidoexpor.getPedidoExporOriginal().getid_transportista()!=null)
				{
					strValorActual=pedidoexpor.getPedidoExporOriginal().getid_transportista().toString();
				}
				if(pedidoexpor.getid_transportista()!=null)
				{
					strValorNuevo=pedidoexpor.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoExporConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePedidoExporRelacionesWithConnection(PedidoExpor pedidoexpor,List<DetallePedidoExpor> detallepedidoexpors) throws Exception {

		if(!pedidoexpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoExporRelacionesBase(pedidoexpor,detallepedidoexpors,true);
		}
	}

	public void savePedidoExporRelaciones(PedidoExpor pedidoexpor,List<DetallePedidoExpor> detallepedidoexpors)throws Exception {

		if(!pedidoexpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoExporRelacionesBase(pedidoexpor,detallepedidoexpors,false);
		}
	}

	public void savePedidoExporRelacionesBase(PedidoExpor pedidoexpor,List<DetallePedidoExpor> detallepedidoexpors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PedidoExpor-saveRelacionesWithConnection");}
	
			pedidoexpor.setDetallePedidoExpors(detallepedidoexpors);

			this.setPedidoExpor(pedidoexpor);

			if(PedidoExporLogicAdditional.validarSaveRelaciones(pedidoexpor,this)) {

				PedidoExporLogicAdditional.updateRelacionesToSave(pedidoexpor,this);

				if((pedidoexpor.getIsNew()||pedidoexpor.getIsChanged())&&!pedidoexpor.getIsDeleted()) {
					this.savePedidoExpor();
					this.savePedidoExporRelacionesDetalles(detallepedidoexpors);

				} else if(pedidoexpor.getIsDeleted()) {
					this.savePedidoExporRelacionesDetalles(detallepedidoexpors);
					this.savePedidoExpor();
				}

				PedidoExporLogicAdditional.updateRelacionesToSaveAfter(pedidoexpor,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetallePedidoExporConstantesFunciones.InicializarGeneralEntityAuxiliaresDetallePedidoExpors(detallepedidoexpors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePedidoExporRelacionesDetalles(List<DetallePedidoExpor> detallepedidoexpors)throws Exception {
		try {
	

			Long idPedidoExporActual=this.getPedidoExpor().getId();

			DetallePedidoExporLogic detallepedidoexporLogic_Desde_PedidoExpor=new DetallePedidoExporLogic();
			detallepedidoexporLogic_Desde_PedidoExpor.setDetallePedidoExpors(detallepedidoexpors);

			detallepedidoexporLogic_Desde_PedidoExpor.setConnexion(this.getConnexion());
			detallepedidoexporLogic_Desde_PedidoExpor.setDatosCliente(this.datosCliente);

			for(DetallePedidoExpor detallepedidoexpor_Desde_PedidoExpor:detallepedidoexporLogic_Desde_PedidoExpor.getDetallePedidoExpors()) {
				detallepedidoexpor_Desde_PedidoExpor.setid_pedido_expor(idPedidoExporActual);
			}

			detallepedidoexporLogic_Desde_PedidoExpor.saveDetallePedidoExpors();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoExpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoExporConstantesFunciones.getClassesForeignKeysOfPedidoExpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoExpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoExporConstantesFunciones.getClassesRelationshipsOfPedidoExpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
