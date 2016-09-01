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
import com.bydan.erp.importaciones.util.PedidoCompraImporConstantesFunciones;
import com.bydan.erp.importaciones.util.PedidoCompraImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.PedidoCompraImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.PedidoCompraImpor;
import com.bydan.erp.importaciones.business.logic.PedidoCompraImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class PedidoCompraImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PedidoCompraImporLogic.class);
	
	protected PedidoCompraImporDataAccess pedidocompraimporDataAccess; 	
	protected PedidoCompraImpor pedidocompraimpor;
	protected List<PedidoCompraImpor> pedidocompraimpors;
	protected Object pedidocompraimporObject;	
	protected List<Object> pedidocompraimporsObject;
	
	public static ClassValidator<PedidoCompraImpor> pedidocompraimporValidator = new ClassValidator<PedidoCompraImpor>(PedidoCompraImpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PedidoCompraImporLogicAdditional pedidocompraimporLogicAdditional=null;
	
	public PedidoCompraImporLogicAdditional getPedidoCompraImporLogicAdditional() {
		return this.pedidocompraimporLogicAdditional;
	}
	
	public void setPedidoCompraImporLogicAdditional(PedidoCompraImporLogicAdditional pedidocompraimporLogicAdditional) {
		try {
			this.pedidocompraimporLogicAdditional=pedidocompraimporLogicAdditional;
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
	
	
	
	
	public  PedidoCompraImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.pedidocompraimporDataAccess = new PedidoCompraImporDataAccess();
			
			this.pedidocompraimpors= new ArrayList<PedidoCompraImpor>();
			this.pedidocompraimpor= new PedidoCompraImpor();
			
			this.pedidocompraimporObject=new Object();
			this.pedidocompraimporsObject=new ArrayList<Object>();
				
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
			
			this.pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			this.pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PedidoCompraImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.pedidocompraimporDataAccess = new PedidoCompraImporDataAccess();
			this.pedidocompraimpors= new ArrayList<PedidoCompraImpor>();
			this.pedidocompraimpor= new PedidoCompraImpor();
			this.pedidocompraimporObject=new Object();
			this.pedidocompraimporsObject=new ArrayList<Object>();
			
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
			
			this.pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			this.pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PedidoCompraImpor getPedidoCompraImpor() throws Exception {	
		PedidoCompraImporLogicAdditional.checkPedidoCompraImporToGet(pedidocompraimpor,this.datosCliente,this.arrDatoGeneral);
		PedidoCompraImporLogicAdditional.updatePedidoCompraImporToGet(pedidocompraimpor,this.arrDatoGeneral);
		
		return pedidocompraimpor;
	}
		
	public void setPedidoCompraImpor(PedidoCompraImpor newPedidoCompraImpor) {
		this.pedidocompraimpor = newPedidoCompraImpor;
	}
	
	public PedidoCompraImporDataAccess getPedidoCompraImporDataAccess() {
		return pedidocompraimporDataAccess;
	}
	
	public void setPedidoCompraImporDataAccess(PedidoCompraImporDataAccess newpedidocompraimporDataAccess) {
		this.pedidocompraimporDataAccess = newpedidocompraimporDataAccess;
	}
	
	public List<PedidoCompraImpor> getPedidoCompraImpors() throws Exception {		
		this.quitarPedidoCompraImporsNulos();
		
		PedidoCompraImporLogicAdditional.checkPedidoCompraImporToGets(pedidocompraimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (PedidoCompraImpor pedidocompraimporLocal: pedidocompraimpors ) {
			PedidoCompraImporLogicAdditional.updatePedidoCompraImporToGet(pedidocompraimporLocal,this.arrDatoGeneral);
		}
		
		return pedidocompraimpors;
	}
	
	public void setPedidoCompraImpors(List<PedidoCompraImpor> newPedidoCompraImpors) {
		this.pedidocompraimpors = newPedidoCompraImpors;
	}
	
	public Object getPedidoCompraImporObject() {	
		this.pedidocompraimporObject=this.pedidocompraimporDataAccess.getEntityObject();
		return this.pedidocompraimporObject;
	}
		
	public void setPedidoCompraImporObject(Object newPedidoCompraImporObject) {
		this.pedidocompraimporObject = newPedidoCompraImporObject;
	}
	
	public List<Object> getPedidoCompraImporsObject() {		
		this.pedidocompraimporsObject=this.pedidocompraimporDataAccess.getEntitiesObject();
		return this.pedidocompraimporsObject;
	}
		
	public void setPedidoCompraImporsObject(List<Object> newPedidoCompraImporsObject) {
		this.pedidocompraimporsObject = newPedidoCompraImporsObject;
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
		
		if(this.pedidocompraimporDataAccess!=null) {
			this.pedidocompraimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			pedidocompraimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			pedidocompraimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		pedidocompraimpor = new  PedidoCompraImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidocompraimpor=pedidocompraimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpor);
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
		pedidocompraimpor = new  PedidoCompraImpor();
		  		  
        try {
			
			pedidocompraimpor=pedidocompraimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		pedidocompraimpor = new  PedidoCompraImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			pedidocompraimpor=pedidocompraimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpor);
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
		pedidocompraimpor = new  PedidoCompraImpor();
		  		  
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
		pedidocompraimpor = new  PedidoCompraImpor();
		  		  
        try {
			
			pedidocompraimpor=pedidocompraimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.pedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		pedidocompraimpor = new  PedidoCompraImpor();
		  		  
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
		pedidocompraimpor = new  PedidoCompraImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =pedidocompraimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidocompraimpor = new  PedidoCompraImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=pedidocompraimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidocompraimpor = new  PedidoCompraImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =pedidocompraimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidocompraimpor = new  PedidoCompraImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=pedidocompraimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		pedidocompraimpor = new  PedidoCompraImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =pedidocompraimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		pedidocompraimpor = new  PedidoCompraImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=pedidocompraimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
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
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		  		  
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
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		  		  
        try {			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		  		  
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
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
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
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		  		  
        try {
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
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
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
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
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		pedidocompraimpor = new  PedidoCompraImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpor=pedidocompraimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpor);
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
		pedidocompraimpor = new  PedidoCompraImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpor=pedidocompraimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpors=pedidocompraimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
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
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		  		  
        try {
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpors=pedidocompraimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPedidoCompraImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getTodosPedidoCompraImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
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
	
	public  void  getTodosPedidoCompraImpors(String sFinalQuery,Pagination pagination)throws Exception {
		pedidocompraimpors = new  ArrayList<PedidoCompraImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPedidoCompraImpor(pedidocompraimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPedidoCompraImpor(PedidoCompraImpor pedidocompraimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(pedidocompraimpor.getIsNew() || pedidocompraimpor.getIsChanged()) { 
			this.invalidValues = pedidocompraimporValidator.getInvalidValues(pedidocompraimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(pedidocompraimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPedidoCompraImpor(List<PedidoCompraImpor> PedidoCompraImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PedidoCompraImpor pedidocompraimporLocal:pedidocompraimpors) {				
			estaValidadoObjeto=this.validarGuardarPedidoCompraImpor(pedidocompraimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPedidoCompraImpor(List<PedidoCompraImpor> PedidoCompraImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoCompraImpor(pedidocompraimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPedidoCompraImpor(PedidoCompraImpor PedidoCompraImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPedidoCompraImpor(pedidocompraimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PedidoCompraImpor pedidocompraimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+pedidocompraimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PedidoCompraImporConstantesFunciones.getPedidoCompraImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"pedidocompraimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PedidoCompraImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PedidoCompraImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePedidoCompraImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-savePedidoCompraImporWithConnection");connexion.begin();			
			
			PedidoCompraImporLogicAdditional.checkPedidoCompraImporToSave(this.pedidocompraimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoCompraImporLogicAdditional.updatePedidoCompraImporToSave(this.pedidocompraimpor,this.arrDatoGeneral);
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidocompraimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPedidoCompraImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoCompraImpor(this.pedidocompraimpor)) {
				PedidoCompraImporDataAccess.save(this.pedidocompraimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.pedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoCompraImporLogicAdditional.checkPedidoCompraImporToSaveAfter(this.pedidocompraimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoCompraImpor();
			
			connexion.commit();			
			
			if(this.pedidocompraimpor.getIsDeleted()) {
				this.pedidocompraimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePedidoCompraImpor()throws Exception {	
		try {	
			
			PedidoCompraImporLogicAdditional.checkPedidoCompraImporToSave(this.pedidocompraimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PedidoCompraImporLogicAdditional.updatePedidoCompraImporToSave(this.pedidocompraimpor,this.arrDatoGeneral);
			
			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.pedidocompraimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPedidoCompraImpor(this.pedidocompraimpor)) {			
				PedidoCompraImporDataAccess.save(this.pedidocompraimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.pedidocompraimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PedidoCompraImporLogicAdditional.checkPedidoCompraImporToSaveAfter(this.pedidocompraimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.pedidocompraimpor.getIsDeleted()) {
				this.pedidocompraimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePedidoCompraImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-savePedidoCompraImporsWithConnection");connexion.begin();			
			
			PedidoCompraImporLogicAdditional.checkPedidoCompraImporToSaves(pedidocompraimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPedidoCompraImpors();
			
			Boolean validadoTodosPedidoCompraImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoCompraImpor pedidocompraimporLocal:pedidocompraimpors) {		
				if(pedidocompraimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoCompraImporLogicAdditional.updatePedidoCompraImporToSave(pedidocompraimporLocal,this.arrDatoGeneral);
	        	
				PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidocompraimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoCompraImpor(pedidocompraimporLocal)) {
					PedidoCompraImporDataAccess.save(pedidocompraimporLocal, connexion);				
				} else {
					validadoTodosPedidoCompraImpor=false;
				}
			}
			
			if(!validadoTodosPedidoCompraImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoCompraImporLogicAdditional.checkPedidoCompraImporToSavesAfter(pedidocompraimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPedidoCompraImpors();
			
			connexion.commit();		
			
			this.quitarPedidoCompraImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePedidoCompraImpors()throws Exception {				
		 try {	
			PedidoCompraImporLogicAdditional.checkPedidoCompraImporToSaves(pedidocompraimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPedidoCompraImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PedidoCompraImpor pedidocompraimporLocal:pedidocompraimpors) {				
				if(pedidocompraimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PedidoCompraImporLogicAdditional.updatePedidoCompraImporToSave(pedidocompraimporLocal,this.arrDatoGeneral);
	        	
				PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),pedidocompraimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPedidoCompraImpor(pedidocompraimporLocal)) {				
					PedidoCompraImporDataAccess.save(pedidocompraimporLocal, connexion);				
				} else {
					validadoTodosPedidoCompraImpor=false;
				}
			}
			
			if(!validadoTodosPedidoCompraImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PedidoCompraImporLogicAdditional.checkPedidoCompraImporToSavesAfter(pedidocompraimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPedidoCompraImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoCompraImporParameterReturnGeneral procesarAccionPedidoCompraImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoCompraImpor> pedidocompraimpors,PedidoCompraImporParameterReturnGeneral pedidocompraimporParameterGeneral)throws Exception {
		 try {	
			PedidoCompraImporParameterReturnGeneral pedidocompraimporReturnGeneral=new PedidoCompraImporParameterReturnGeneral();
	
			PedidoCompraImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidocompraimpors,pedidocompraimporParameterGeneral,pedidocompraimporReturnGeneral);
			
			return pedidocompraimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PedidoCompraImporParameterReturnGeneral procesarAccionPedidoCompraImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PedidoCompraImpor> pedidocompraimpors,PedidoCompraImporParameterReturnGeneral pedidocompraimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-procesarAccionPedidoCompraImporsWithConnection");connexion.begin();			
			
			PedidoCompraImporParameterReturnGeneral pedidocompraimporReturnGeneral=new PedidoCompraImporParameterReturnGeneral();
	
			PedidoCompraImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,pedidocompraimpors,pedidocompraimporParameterGeneral,pedidocompraimporReturnGeneral);
			
			this.connexion.commit();
			
			return pedidocompraimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoCompraImporParameterReturnGeneral procesarEventosPedidoCompraImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoCompraImpor> pedidocompraimpors,PedidoCompraImpor pedidocompraimpor,PedidoCompraImporParameterReturnGeneral pedidocompraimporParameterGeneral,Boolean isEsNuevoPedidoCompraImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			PedidoCompraImporParameterReturnGeneral pedidocompraimporReturnGeneral=new PedidoCompraImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidocompraimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoCompraImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidocompraimpors,pedidocompraimpor,pedidocompraimporParameterGeneral,pedidocompraimporReturnGeneral,isEsNuevoPedidoCompraImpor,clases);
			
			return pedidocompraimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PedidoCompraImporParameterReturnGeneral procesarEventosPedidoCompraImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PedidoCompraImpor> pedidocompraimpors,PedidoCompraImpor pedidocompraimpor,PedidoCompraImporParameterReturnGeneral pedidocompraimporParameterGeneral,Boolean isEsNuevoPedidoCompraImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-procesarEventosPedidoCompraImporsWithConnection");connexion.begin();			
			
			PedidoCompraImporParameterReturnGeneral pedidocompraimporReturnGeneral=new PedidoCompraImporParameterReturnGeneral();
	
			pedidocompraimporReturnGeneral.setPedidoCompraImpor(pedidocompraimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				pedidocompraimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PedidoCompraImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,pedidocompraimpors,pedidocompraimpor,pedidocompraimporParameterGeneral,pedidocompraimporReturnGeneral,isEsNuevoPedidoCompraImpor,clases);
			
			this.connexion.commit();
			
			return pedidocompraimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PedidoCompraImporParameterReturnGeneral procesarImportacionPedidoCompraImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PedidoCompraImporParameterReturnGeneral pedidocompraimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-procesarImportacionPedidoCompraImporsWithConnection");connexion.begin();			
			
			PedidoCompraImporParameterReturnGeneral pedidocompraimporReturnGeneral=new PedidoCompraImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.pedidocompraimpors=new ArrayList<PedidoCompraImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.pedidocompraimpor=new PedidoCompraImpor();
				
				
				if(conColumnasBase) {this.pedidocompraimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.pedidocompraimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.pedidocompraimpor.setforma_pago(arrColumnas[iColumn++]);
				this.pedidocompraimpor.setnumero_dui(arrColumnas[iColumn++]);
				this.pedidocompraimpor.setsecuencial(arrColumnas[iColumn++]);
				this.pedidocompraimpor.setnumero_orden(Integer.parseInt(arrColumnas[iColumn++]));
				this.pedidocompraimpor.setuso_en(arrColumnas[iColumn++]);
				this.pedidocompraimpor.setresponsable(arrColumnas[iColumn++]);
				this.pedidocompraimpor.setorden_compra(arrColumnas[iColumn++]);
				this.pedidocompraimpor.setlugar_entrega(arrColumnas[iColumn++]);
			this.pedidocompraimpor.setdescripcion(arrColumnas[iColumn++]);
				this.pedidocompraimpor.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedidocompraimpor.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedidocompraimpor.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedidocompraimpor.setfecha_entrega_cliente(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.pedidocompraimpor.setnombre_seguro(arrColumnas[iColumn++]);
				this.pedidocompraimpor.setnombre_consignatario(arrColumnas[iColumn++]);
				this.pedidocompraimpor.setprecios(arrColumnas[iColumn++]);
				this.pedidocompraimpor.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidocompraimpor.setseguro(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidocompraimpor.setgastos(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidocompraimpor.setcfr(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidocompraimpor.setcif(Double.parseDouble(arrColumnas[iColumn++]));
				this.pedidocompraimpor.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.pedidocompraimpors.add(this.pedidocompraimpor);
			}
			
			this.savePedidoCompraImpors();
			
			this.connexion.commit();
			
			pedidocompraimporReturnGeneral.setConRetornoEstaProcesado(true);
			pedidocompraimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return pedidocompraimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPedidoCompraImporsEliminados() throws Exception {				
		
		List<PedidoCompraImpor> pedidocompraimporsAux= new ArrayList<PedidoCompraImpor>();
		
		for(PedidoCompraImpor pedidocompraimpor:pedidocompraimpors) {
			if(!pedidocompraimpor.getIsDeleted()) {
				pedidocompraimporsAux.add(pedidocompraimpor);
			}
		}
		
		pedidocompraimpors=pedidocompraimporsAux;
	}
	
	public void quitarPedidoCompraImporsNulos() throws Exception {				
		
		List<PedidoCompraImpor> pedidocompraimporsAux= new ArrayList<PedidoCompraImpor>();
		
		for(PedidoCompraImpor pedidocompraimpor : this.pedidocompraimpors) {
			if(pedidocompraimpor==null) {
				pedidocompraimporsAux.add(pedidocompraimpor);
			}
		}
		
		//this.pedidocompraimpors=pedidocompraimporsAux;
		
		this.pedidocompraimpors.removeAll(pedidocompraimporsAux);
	}
	
	public void getSetVersionRowPedidoCompraImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(pedidocompraimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((pedidocompraimpor.getIsDeleted() || (pedidocompraimpor.getIsChanged()&&!pedidocompraimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=pedidocompraimporDataAccess.getSetVersionRowPedidoCompraImpor(connexion,pedidocompraimpor.getId());
				
				if(!pedidocompraimpor.getVersionRow().equals(timestamp)) {	
					pedidocompraimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				pedidocompraimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPedidoCompraImpor()throws Exception {	
		
		if(pedidocompraimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((pedidocompraimpor.getIsDeleted() || (pedidocompraimpor.getIsChanged()&&!pedidocompraimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=pedidocompraimporDataAccess.getSetVersionRowPedidoCompraImpor(connexion,pedidocompraimpor.getId());
			
			try {							
				if(!pedidocompraimpor.getVersionRow().equals(timestamp)) {	
					pedidocompraimpor.setVersionRow(timestamp);
				}
				
				pedidocompraimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPedidoCompraImporsWithConnection()throws Exception {	
		if(pedidocompraimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PedidoCompraImpor pedidocompraimporAux:pedidocompraimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(pedidocompraimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidocompraimporAux.getIsDeleted() || (pedidocompraimporAux.getIsChanged()&&!pedidocompraimporAux.getIsNew())) {
						
						timestamp=pedidocompraimporDataAccess.getSetVersionRowPedidoCompraImpor(connexion,pedidocompraimporAux.getId());
						
						if(!pedidocompraimpor.getVersionRow().equals(timestamp)) {	
							pedidocompraimporAux.setVersionRow(timestamp);
						}
								
						pedidocompraimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPedidoCompraImpors()throws Exception {	
		if(pedidocompraimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PedidoCompraImpor pedidocompraimporAux:pedidocompraimpors) {
					if(pedidocompraimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(pedidocompraimporAux.getIsDeleted() || (pedidocompraimporAux.getIsChanged()&&!pedidocompraimporAux.getIsNew())) {
						
						timestamp=pedidocompraimporDataAccess.getSetVersionRowPedidoCompraImpor(connexion,pedidocompraimporAux.getId());
						
						if(!pedidocompraimporAux.getVersionRow().equals(timestamp)) {	
							pedidocompraimporAux.setVersionRow(timestamp);
						}
						
													
						pedidocompraimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PedidoCompraImporParameterReturnGeneral cargarCombosLoteForeignKeyPedidoCompraImporWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalPais,String finalQueryGlobalCliente,String finalQueryGlobalClienteProveedor,String finalQueryGlobalEmpleado,String finalQueryGlobalUsuario,String finalQueryGlobalTipoCambio,String finalQueryGlobalMoneda,String finalQueryGlobalTipoProrrateoImpor,String finalQueryGlobalEmbarcador,String finalQueryGlobalTipoViaTransporte,String finalQueryGlobalPuerto,String finalQueryGlobalPuertoDestino,String finalQueryGlobalTipoTerminosImpor,String finalQueryGlobalEstadoPedidoCompra,String finalQueryGlobalFormato,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PedidoCompraImporParameterReturnGeneral  pedidocompraimporReturnGeneral =new PedidoCompraImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-cargarCombosLoteForeignKeyPedidoCompraImporWithConnection");connexion.begin();
			
			pedidocompraimporReturnGeneral =new PedidoCompraImporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidocompraimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidocompraimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			pedidocompraimporReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidocompraimporReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidocompraimporReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			pedidocompraimporReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidocompraimporReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Cliente> clienteproveedorsForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteproveedorLogic=new ClienteLogic();
			clienteproveedorLogic.setConnexion(this.connexion);
			clienteproveedorLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteProveedor.equals("NONE")) {
				clienteproveedorLogic.getTodosClientes(finalQueryGlobalClienteProveedor,new Pagination());
				clienteproveedorsForeignKey=clienteproveedorLogic.getClientes();
			}

			pedidocompraimporReturnGeneral.setclienteproveedorsForeignKey(clienteproveedorsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			pedidocompraimporReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			pedidocompraimporReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			pedidocompraimporReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			pedidocompraimporReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoProrrateoImpor> tipoprorrateoimporsForeignKey=new ArrayList<TipoProrrateoImpor>();
			TipoProrrateoImporLogic tipoprorrateoimporLogic=new TipoProrrateoImporLogic();
			tipoprorrateoimporLogic.setConnexion(this.connexion);
			tipoprorrateoimporLogic.getTipoProrrateoImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProrrateoImpor.equals("NONE")) {
				tipoprorrateoimporLogic.getTodosTipoProrrateoImpors(finalQueryGlobalTipoProrrateoImpor,new Pagination());
				tipoprorrateoimporsForeignKey=tipoprorrateoimporLogic.getTipoProrrateoImpors();
			}

			pedidocompraimporReturnGeneral.settipoprorrateoimporsForeignKey(tipoprorrateoimporsForeignKey);


			List<Embarcador> embarcadorsForeignKey=new ArrayList<Embarcador>();
			EmbarcadorLogic embarcadorLogic=new EmbarcadorLogic();
			embarcadorLogic.setConnexion(this.connexion);
			embarcadorLogic.getEmbarcadorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmbarcador.equals("NONE")) {
				embarcadorLogic.getTodosEmbarcadors(finalQueryGlobalEmbarcador,new Pagination());
				embarcadorsForeignKey=embarcadorLogic.getEmbarcadors();
			}

			pedidocompraimporReturnGeneral.setembarcadorsForeignKey(embarcadorsForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			pedidocompraimporReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);


			List<Puerto> puertosForeignKey=new ArrayList<Puerto>();
			PuertoLogic puertoLogic=new PuertoLogic();
			puertoLogic.setConnexion(this.connexion);
			puertoLogic.getPuertoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPuerto.equals("NONE")) {
				puertoLogic.getTodosPuertos(finalQueryGlobalPuerto,new Pagination());
				puertosForeignKey=puertoLogic.getPuertos();
			}

			pedidocompraimporReturnGeneral.setpuertosForeignKey(puertosForeignKey);


			List<Puerto> puertodestinosForeignKey=new ArrayList<Puerto>();
			PuertoLogic puertodestinoLogic=new PuertoLogic();
			puertodestinoLogic.setConnexion(this.connexion);
			puertodestinoLogic.getPuertoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPuertoDestino.equals("NONE")) {
				puertodestinoLogic.getTodosPuertos(finalQueryGlobalPuertoDestino,new Pagination());
				puertodestinosForeignKey=puertodestinoLogic.getPuertos();
			}

			pedidocompraimporReturnGeneral.setpuertodestinosForeignKey(puertodestinosForeignKey);


			List<TipoTerminosImpor> tipoterminosimporsForeignKey=new ArrayList<TipoTerminosImpor>();
			TipoTerminosImporLogic tipoterminosimporLogic=new TipoTerminosImporLogic();
			tipoterminosimporLogic.setConnexion(this.connexion);
			tipoterminosimporLogic.getTipoTerminosImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTerminosImpor.equals("NONE")) {
				tipoterminosimporLogic.getTodosTipoTerminosImpors(finalQueryGlobalTipoTerminosImpor,new Pagination());
				tipoterminosimporsForeignKey=tipoterminosimporLogic.getTipoTerminosImpors();
			}

			pedidocompraimporReturnGeneral.settipoterminosimporsForeignKey(tipoterminosimporsForeignKey);


			List<EstadoPedidoCompra> estadopedidocomprasForeignKey=new ArrayList<EstadoPedidoCompra>();
			EstadoPedidoCompraLogic estadopedidocompraLogic=new EstadoPedidoCompraLogic();
			estadopedidocompraLogic.setConnexion(this.connexion);
			estadopedidocompraLogic.getEstadoPedidoCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoCompra.equals("NONE")) {
				estadopedidocompraLogic.getTodosEstadoPedidoCompras(finalQueryGlobalEstadoPedidoCompra,new Pagination());
				estadopedidocomprasForeignKey=estadopedidocompraLogic.getEstadoPedidoCompras();
			}

			pedidocompraimporReturnGeneral.setestadopedidocomprasForeignKey(estadopedidocomprasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			pedidocompraimporReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			pedidocompraimporReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			pedidocompraimporReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return pedidocompraimporReturnGeneral;
	}
	
	public PedidoCompraImporParameterReturnGeneral cargarCombosLoteForeignKeyPedidoCompraImpor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalPais,String finalQueryGlobalCliente,String finalQueryGlobalClienteProveedor,String finalQueryGlobalEmpleado,String finalQueryGlobalUsuario,String finalQueryGlobalTipoCambio,String finalQueryGlobalMoneda,String finalQueryGlobalTipoProrrateoImpor,String finalQueryGlobalEmbarcador,String finalQueryGlobalTipoViaTransporte,String finalQueryGlobalPuerto,String finalQueryGlobalPuertoDestino,String finalQueryGlobalTipoTerminosImpor,String finalQueryGlobalEstadoPedidoCompra,String finalQueryGlobalFormato,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PedidoCompraImporParameterReturnGeneral  pedidocompraimporReturnGeneral =new PedidoCompraImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			pedidocompraimporReturnGeneral =new PedidoCompraImporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			pedidocompraimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			pedidocompraimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			pedidocompraimporReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			pedidocompraimporReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			pedidocompraimporReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			pedidocompraimporReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			pedidocompraimporReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Cliente> clienteproveedorsForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteproveedorLogic=new ClienteLogic();
			clienteproveedorLogic.setConnexion(this.connexion);
			clienteproveedorLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteProveedor.equals("NONE")) {
				clienteproveedorLogic.getTodosClientes(finalQueryGlobalClienteProveedor,new Pagination());
				clienteproveedorsForeignKey=clienteproveedorLogic.getClientes();
			}

			pedidocompraimporReturnGeneral.setclienteproveedorsForeignKey(clienteproveedorsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			pedidocompraimporReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			pedidocompraimporReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			pedidocompraimporReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			pedidocompraimporReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoProrrateoImpor> tipoprorrateoimporsForeignKey=new ArrayList<TipoProrrateoImpor>();
			TipoProrrateoImporLogic tipoprorrateoimporLogic=new TipoProrrateoImporLogic();
			tipoprorrateoimporLogic.setConnexion(this.connexion);
			tipoprorrateoimporLogic.getTipoProrrateoImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProrrateoImpor.equals("NONE")) {
				tipoprorrateoimporLogic.getTodosTipoProrrateoImpors(finalQueryGlobalTipoProrrateoImpor,new Pagination());
				tipoprorrateoimporsForeignKey=tipoprorrateoimporLogic.getTipoProrrateoImpors();
			}

			pedidocompraimporReturnGeneral.settipoprorrateoimporsForeignKey(tipoprorrateoimporsForeignKey);


			List<Embarcador> embarcadorsForeignKey=new ArrayList<Embarcador>();
			EmbarcadorLogic embarcadorLogic=new EmbarcadorLogic();
			embarcadorLogic.setConnexion(this.connexion);
			embarcadorLogic.getEmbarcadorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmbarcador.equals("NONE")) {
				embarcadorLogic.getTodosEmbarcadors(finalQueryGlobalEmbarcador,new Pagination());
				embarcadorsForeignKey=embarcadorLogic.getEmbarcadors();
			}

			pedidocompraimporReturnGeneral.setembarcadorsForeignKey(embarcadorsForeignKey);


			List<TipoViaTransporte> tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
			TipoViaTransporteLogic tipoviatransporteLogic=new TipoViaTransporteLogic();
			tipoviatransporteLogic.setConnexion(this.connexion);
			tipoviatransporteLogic.getTipoViaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoViaTransporte.equals("NONE")) {
				tipoviatransporteLogic.getTodosTipoViaTransportes(finalQueryGlobalTipoViaTransporte,new Pagination());
				tipoviatransportesForeignKey=tipoviatransporteLogic.getTipoViaTransportes();
			}

			pedidocompraimporReturnGeneral.settipoviatransportesForeignKey(tipoviatransportesForeignKey);


			List<Puerto> puertosForeignKey=new ArrayList<Puerto>();
			PuertoLogic puertoLogic=new PuertoLogic();
			puertoLogic.setConnexion(this.connexion);
			puertoLogic.getPuertoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPuerto.equals("NONE")) {
				puertoLogic.getTodosPuertos(finalQueryGlobalPuerto,new Pagination());
				puertosForeignKey=puertoLogic.getPuertos();
			}

			pedidocompraimporReturnGeneral.setpuertosForeignKey(puertosForeignKey);


			List<Puerto> puertodestinosForeignKey=new ArrayList<Puerto>();
			PuertoLogic puertodestinoLogic=new PuertoLogic();
			puertodestinoLogic.setConnexion(this.connexion);
			puertodestinoLogic.getPuertoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPuertoDestino.equals("NONE")) {
				puertodestinoLogic.getTodosPuertos(finalQueryGlobalPuertoDestino,new Pagination());
				puertodestinosForeignKey=puertodestinoLogic.getPuertos();
			}

			pedidocompraimporReturnGeneral.setpuertodestinosForeignKey(puertodestinosForeignKey);


			List<TipoTerminosImpor> tipoterminosimporsForeignKey=new ArrayList<TipoTerminosImpor>();
			TipoTerminosImporLogic tipoterminosimporLogic=new TipoTerminosImporLogic();
			tipoterminosimporLogic.setConnexion(this.connexion);
			tipoterminosimporLogic.getTipoTerminosImporDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTerminosImpor.equals("NONE")) {
				tipoterminosimporLogic.getTodosTipoTerminosImpors(finalQueryGlobalTipoTerminosImpor,new Pagination());
				tipoterminosimporsForeignKey=tipoterminosimporLogic.getTipoTerminosImpors();
			}

			pedidocompraimporReturnGeneral.settipoterminosimporsForeignKey(tipoterminosimporsForeignKey);


			List<EstadoPedidoCompra> estadopedidocomprasForeignKey=new ArrayList<EstadoPedidoCompra>();
			EstadoPedidoCompraLogic estadopedidocompraLogic=new EstadoPedidoCompraLogic();
			estadopedidocompraLogic.setConnexion(this.connexion);
			estadopedidocompraLogic.getEstadoPedidoCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoCompra.equals("NONE")) {
				estadopedidocompraLogic.getTodosEstadoPedidoCompras(finalQueryGlobalEstadoPedidoCompra,new Pagination());
				estadopedidocomprasForeignKey=estadopedidocompraLogic.getEstadoPedidoCompras();
			}

			pedidocompraimporReturnGeneral.setestadopedidocomprasForeignKey(estadopedidocomprasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			pedidocompraimporReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			pedidocompraimporReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			pedidocompraimporReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return pedidocompraimporReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPedidoCompraImporWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetallePedidoCompraImporLogic detallepedidocompraimporLogic=new DetallePedidoCompraImporLogic();
			LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic=new LiquidacionImpuestoImporLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPedidoCompraImporWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetallePedidoCompraImpor.class));
			classes.add(new Classe(LiquidacionImpuestoImpor.class));
											
			

			detallepedidocompraimporLogic.setConnexion(this.getConnexion());
			detallepedidocompraimporLogic.setDatosCliente(this.datosCliente);
			detallepedidocompraimporLogic.setIsConRefrescarForeignKeys(true);

			liquidacionimpuestoimporLogic.setConnexion(this.getConnexion());
			liquidacionimpuestoimporLogic.setDatosCliente(this.datosCliente);
			liquidacionimpuestoimporLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PedidoCompraImpor pedidocompraimpor:this.pedidocompraimpors) {
				

				classes=new ArrayList<Classe>();
				classes=DetallePedidoCompraImporConstantesFunciones.getClassesForeignKeysOfDetallePedidoCompraImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallepedidocompraimporLogic.setDetallePedidoCompraImpors(pedidocompraimpor.detallepedidocompraimpors);
				detallepedidocompraimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=LiquidacionImpuestoImporConstantesFunciones.getClassesForeignKeysOfLiquidacionImpuestoImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				liquidacionimpuestoimporLogic.setLiquidacionImpuestoImpors(pedidocompraimpor.liquidacionimpuestoimpors);
				liquidacionimpuestoimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PedidoCompraImpor pedidocompraimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PedidoCompraImporLogicAdditional.updatePedidoCompraImporToGet(pedidocompraimpor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidocompraimpor.setEmpresa(pedidocompraimporDataAccess.getEmpresa(connexion,pedidocompraimpor));
		pedidocompraimpor.setSucursal(pedidocompraimporDataAccess.getSucursal(connexion,pedidocompraimpor));
		pedidocompraimpor.setModulo(pedidocompraimporDataAccess.getModulo(connexion,pedidocompraimpor));
		pedidocompraimpor.setEjercicio(pedidocompraimporDataAccess.getEjercicio(connexion,pedidocompraimpor));
		pedidocompraimpor.setPeriodo(pedidocompraimporDataAccess.getPeriodo(connexion,pedidocompraimpor));
		pedidocompraimpor.setPais(pedidocompraimporDataAccess.getPais(connexion,pedidocompraimpor));
		pedidocompraimpor.setCliente(pedidocompraimporDataAccess.getCliente(connexion,pedidocompraimpor));
		pedidocompraimpor.setClienteProveedor(pedidocompraimporDataAccess.getClienteProveedor(connexion,pedidocompraimpor));
		pedidocompraimpor.setEmpleado(pedidocompraimporDataAccess.getEmpleado(connexion,pedidocompraimpor));
		pedidocompraimpor.setUsuario(pedidocompraimporDataAccess.getUsuario(connexion,pedidocompraimpor));
		pedidocompraimpor.setTipoCambio(pedidocompraimporDataAccess.getTipoCambio(connexion,pedidocompraimpor));
		pedidocompraimpor.setMoneda(pedidocompraimporDataAccess.getMoneda(connexion,pedidocompraimpor));
		pedidocompraimpor.setTipoProrrateoImpor(pedidocompraimporDataAccess.getTipoProrrateoImpor(connexion,pedidocompraimpor));
		pedidocompraimpor.setEmbarcador(pedidocompraimporDataAccess.getEmbarcador(connexion,pedidocompraimpor));
		pedidocompraimpor.setTipoViaTransporte(pedidocompraimporDataAccess.getTipoViaTransporte(connexion,pedidocompraimpor));
		pedidocompraimpor.setPuerto(pedidocompraimporDataAccess.getPuerto(connexion,pedidocompraimpor));
		pedidocompraimpor.setPuertoDestino(pedidocompraimporDataAccess.getPuertoDestino(connexion,pedidocompraimpor));
		pedidocompraimpor.setTipoTerminosImpor(pedidocompraimporDataAccess.getTipoTerminosImpor(connexion,pedidocompraimpor));
		pedidocompraimpor.setEstadoPedidoCompra(pedidocompraimporDataAccess.getEstadoPedidoCompra(connexion,pedidocompraimpor));
		pedidocompraimpor.setFormato(pedidocompraimporDataAccess.getFormato(connexion,pedidocompraimpor));
		pedidocompraimpor.setAnio(pedidocompraimporDataAccess.getAnio(connexion,pedidocompraimpor));
		pedidocompraimpor.setMes(pedidocompraimporDataAccess.getMes(connexion,pedidocompraimpor));
		pedidocompraimpor.setDetallePedidoCompraImpors(pedidocompraimporDataAccess.getDetallePedidoCompraImpors(connexion,pedidocompraimpor));
		pedidocompraimpor.setLiquidacionImpuestoImpors(pedidocompraimporDataAccess.getLiquidacionImpuestoImpors(connexion,pedidocompraimpor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidocompraimpor.setEmpresa(pedidocompraimporDataAccess.getEmpresa(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidocompraimpor.setSucursal(pedidocompraimporDataAccess.getSucursal(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				pedidocompraimpor.setModulo(pedidocompraimporDataAccess.getModulo(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedidocompraimpor.setEjercicio(pedidocompraimporDataAccess.getEjercicio(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedidocompraimpor.setPeriodo(pedidocompraimporDataAccess.getPeriodo(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				pedidocompraimpor.setPais(pedidocompraimporDataAccess.getPais(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidocompraimpor.setCliente(pedidocompraimporDataAccess.getCliente(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidocompraimpor.setClienteProveedor(pedidocompraimporDataAccess.getClienteProveedor(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				pedidocompraimpor.setEmpleado(pedidocompraimporDataAccess.getEmpleado(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				pedidocompraimpor.setUsuario(pedidocompraimporDataAccess.getUsuario(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				pedidocompraimpor.setTipoCambio(pedidocompraimporDataAccess.getTipoCambio(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				pedidocompraimpor.setMoneda(pedidocompraimporDataAccess.getMoneda(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(TipoProrrateoImpor.class)) {
				pedidocompraimpor.setTipoProrrateoImpor(pedidocompraimporDataAccess.getTipoProrrateoImpor(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Embarcador.class)) {
				pedidocompraimpor.setEmbarcador(pedidocompraimporDataAccess.getEmbarcador(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				pedidocompraimpor.setTipoViaTransporte(pedidocompraimporDataAccess.getTipoViaTransporte(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				pedidocompraimpor.setPuerto(pedidocompraimporDataAccess.getPuerto(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				pedidocompraimpor.setPuertoDestino(pedidocompraimporDataAccess.getPuertoDestino(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(TipoTerminosImpor.class)) {
				pedidocompraimpor.setTipoTerminosImpor(pedidocompraimporDataAccess.getTipoTerminosImpor(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				pedidocompraimpor.setEstadoPedidoCompra(pedidocompraimporDataAccess.getEstadoPedidoCompra(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				pedidocompraimpor.setFormato(pedidocompraimporDataAccess.getFormato(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				pedidocompraimpor.setAnio(pedidocompraimporDataAccess.getAnio(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				pedidocompraimpor.setMes(pedidocompraimporDataAccess.getMes(connexion,pedidocompraimpor));
				continue;
			}

			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidocompraimpor.setDetallePedidoCompraImpors(pedidocompraimporDataAccess.getDetallePedidoCompraImpors(connexion,pedidocompraimpor));

				if(this.isConDeep) {
					DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(this.connexion);
					detallepedidocompraimporLogic.setDetallePedidoCompraImpors(pedidocompraimpor.getDetallePedidoCompraImpors());
					ArrayList<Classe> classesLocal=DetallePedidoCompraImporConstantesFunciones.getClassesForeignKeysOfDetallePedidoCompraImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallepedidocompraimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetallePedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(detallepedidocompraimporLogic.getDetallePedidoCompraImpors());
					pedidocompraimpor.setDetallePedidoCompraImpors(detallepedidocompraimporLogic.getDetallePedidoCompraImpors());
				}

				continue;
			}

			if(clas.clas.equals(LiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidocompraimpor.setLiquidacionImpuestoImpors(pedidocompraimporDataAccess.getLiquidacionImpuestoImpors(connexion,pedidocompraimpor));

				if(this.isConDeep) {
					LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(this.connexion);
					liquidacionimpuestoimporLogic.setLiquidacionImpuestoImpors(pedidocompraimpor.getLiquidacionImpuestoImpors());
					ArrayList<Classe> classesLocal=LiquidacionImpuestoImporConstantesFunciones.getClassesForeignKeysOfLiquidacionImpuestoImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					liquidacionimpuestoimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					LiquidacionImpuestoImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpuestoImpor(liquidacionimpuestoimporLogic.getLiquidacionImpuestoImpors());
					pedidocompraimpor.setLiquidacionImpuestoImpors(liquidacionimpuestoimporLogic.getLiquidacionImpuestoImpors());
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
			pedidocompraimpor.setEmpresa(pedidocompraimporDataAccess.getEmpresa(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setSucursal(pedidocompraimporDataAccess.getSucursal(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setModulo(pedidocompraimporDataAccess.getModulo(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setEjercicio(pedidocompraimporDataAccess.getEjercicio(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setPeriodo(pedidocompraimporDataAccess.getPeriodo(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setPais(pedidocompraimporDataAccess.getPais(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setCliente(pedidocompraimporDataAccess.getCliente(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setClienteProveedor(pedidocompraimporDataAccess.getClienteProveedor(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setEmpleado(pedidocompraimporDataAccess.getEmpleado(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setUsuario(pedidocompraimporDataAccess.getUsuario(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setTipoCambio(pedidocompraimporDataAccess.getTipoCambio(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setMoneda(pedidocompraimporDataAccess.getMoneda(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProrrateoImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setTipoProrrateoImpor(pedidocompraimporDataAccess.getTipoProrrateoImpor(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Embarcador.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setEmbarcador(pedidocompraimporDataAccess.getEmbarcador(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setTipoViaTransporte(pedidocompraimporDataAccess.getTipoViaTransporte(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Puerto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setPuerto(pedidocompraimporDataAccess.getPuerto(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Puerto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setPuertoDestino(pedidocompraimporDataAccess.getPuertoDestino(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTerminosImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setTipoTerminosImpor(pedidocompraimporDataAccess.getTipoTerminosImpor(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setEstadoPedidoCompra(pedidocompraimporDataAccess.getEstadoPedidoCompra(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setFormato(pedidocompraimporDataAccess.getFormato(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setAnio(pedidocompraimporDataAccess.getAnio(connexion,pedidocompraimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setMes(pedidocompraimporDataAccess.getMes(connexion,pedidocompraimpor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoCompraImpor.class));
			pedidocompraimpor.setDetallePedidoCompraImpors(pedidocompraimporDataAccess.getDetallePedidoCompraImpors(connexion,pedidocompraimpor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LiquidacionImpuestoImpor.class));
			pedidocompraimpor.setLiquidacionImpuestoImpors(pedidocompraimporDataAccess.getLiquidacionImpuestoImpors(connexion,pedidocompraimpor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		pedidocompraimpor.setEmpresa(pedidocompraimporDataAccess.getEmpresa(connexion,pedidocompraimpor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidocompraimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setSucursal(pedidocompraimporDataAccess.getSucursal(connexion,pedidocompraimpor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidocompraimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setModulo(pedidocompraimporDataAccess.getModulo(connexion,pedidocompraimpor));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(pedidocompraimpor.getModulo(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setEjercicio(pedidocompraimporDataAccess.getEjercicio(connexion,pedidocompraimpor));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedidocompraimpor.getEjercicio(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setPeriodo(pedidocompraimporDataAccess.getPeriodo(connexion,pedidocompraimpor));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedidocompraimpor.getPeriodo(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setPais(pedidocompraimporDataAccess.getPais(connexion,pedidocompraimpor));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(pedidocompraimpor.getPais(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setCliente(pedidocompraimporDataAccess.getCliente(connexion,pedidocompraimpor));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedidocompraimpor.getCliente(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setClienteProveedor(pedidocompraimporDataAccess.getClienteProveedor(connexion,pedidocompraimpor));
		ClienteLogic clienteproveedorLogic= new ClienteLogic(connexion);
		clienteproveedorLogic.deepLoad(pedidocompraimpor.getClienteProveedor(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setEmpleado(pedidocompraimporDataAccess.getEmpleado(connexion,pedidocompraimpor));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(pedidocompraimpor.getEmpleado(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setUsuario(pedidocompraimporDataAccess.getUsuario(connexion,pedidocompraimpor));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(pedidocompraimpor.getUsuario(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setTipoCambio(pedidocompraimporDataAccess.getTipoCambio(connexion,pedidocompraimpor));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(pedidocompraimpor.getTipoCambio(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setMoneda(pedidocompraimporDataAccess.getMoneda(connexion,pedidocompraimpor));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(pedidocompraimpor.getMoneda(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setTipoProrrateoImpor(pedidocompraimporDataAccess.getTipoProrrateoImpor(connexion,pedidocompraimpor));
		TipoProrrateoImporLogic tipoprorrateoimporLogic= new TipoProrrateoImporLogic(connexion);
		tipoprorrateoimporLogic.deepLoad(pedidocompraimpor.getTipoProrrateoImpor(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setEmbarcador(pedidocompraimporDataAccess.getEmbarcador(connexion,pedidocompraimpor));
		EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
		embarcadorLogic.deepLoad(pedidocompraimpor.getEmbarcador(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setTipoViaTransporte(pedidocompraimporDataAccess.getTipoViaTransporte(connexion,pedidocompraimpor));
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(pedidocompraimpor.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setPuerto(pedidocompraimporDataAccess.getPuerto(connexion,pedidocompraimpor));
		PuertoLogic puertoLogic= new PuertoLogic(connexion);
		puertoLogic.deepLoad(pedidocompraimpor.getPuerto(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setPuertoDestino(pedidocompraimporDataAccess.getPuertoDestino(connexion,pedidocompraimpor));
		PuertoLogic puertodestinoLogic= new PuertoLogic(connexion);
		puertodestinoLogic.deepLoad(pedidocompraimpor.getPuertoDestino(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setTipoTerminosImpor(pedidocompraimporDataAccess.getTipoTerminosImpor(connexion,pedidocompraimpor));
		TipoTerminosImporLogic tipoterminosimporLogic= new TipoTerminosImporLogic(connexion);
		tipoterminosimporLogic.deepLoad(pedidocompraimpor.getTipoTerminosImpor(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setEstadoPedidoCompra(pedidocompraimporDataAccess.getEstadoPedidoCompra(connexion,pedidocompraimpor));
		EstadoPedidoCompraLogic estadopedidocompraLogic= new EstadoPedidoCompraLogic(connexion);
		estadopedidocompraLogic.deepLoad(pedidocompraimpor.getEstadoPedidoCompra(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setFormato(pedidocompraimporDataAccess.getFormato(connexion,pedidocompraimpor));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(pedidocompraimpor.getFormato(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setAnio(pedidocompraimporDataAccess.getAnio(connexion,pedidocompraimpor));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(pedidocompraimpor.getAnio(),isDeep,deepLoadType,clases);
				
		pedidocompraimpor.setMes(pedidocompraimporDataAccess.getMes(connexion,pedidocompraimpor));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(pedidocompraimpor.getMes(),isDeep,deepLoadType,clases);
				

		pedidocompraimpor.setDetallePedidoCompraImpors(pedidocompraimporDataAccess.getDetallePedidoCompraImpors(connexion,pedidocompraimpor));

		for(DetallePedidoCompraImpor detallepedidocompraimpor:pedidocompraimpor.getDetallePedidoCompraImpors()) {
			DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(connexion);
			detallepedidocompraimporLogic.deepLoad(detallepedidocompraimpor,isDeep,deepLoadType,clases);
		}

		pedidocompraimpor.setLiquidacionImpuestoImpors(pedidocompraimporDataAccess.getLiquidacionImpuestoImpors(connexion,pedidocompraimpor));

		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:pedidocompraimpor.getLiquidacionImpuestoImpors()) {
			LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(connexion);
			liquidacionimpuestoimporLogic.deepLoad(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				pedidocompraimpor.setEmpresa(pedidocompraimporDataAccess.getEmpresa(connexion,pedidocompraimpor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(pedidocompraimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				pedidocompraimpor.setSucursal(pedidocompraimporDataAccess.getSucursal(connexion,pedidocompraimpor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(pedidocompraimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				pedidocompraimpor.setModulo(pedidocompraimporDataAccess.getModulo(connexion,pedidocompraimpor));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(pedidocompraimpor.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				pedidocompraimpor.setEjercicio(pedidocompraimporDataAccess.getEjercicio(connexion,pedidocompraimpor));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(pedidocompraimpor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				pedidocompraimpor.setPeriodo(pedidocompraimporDataAccess.getPeriodo(connexion,pedidocompraimpor));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(pedidocompraimpor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				pedidocompraimpor.setPais(pedidocompraimporDataAccess.getPais(connexion,pedidocompraimpor));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(pedidocompraimpor.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidocompraimpor.setCliente(pedidocompraimporDataAccess.getCliente(connexion,pedidocompraimpor));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(pedidocompraimpor.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				pedidocompraimpor.setClienteProveedor(pedidocompraimporDataAccess.getClienteProveedor(connexion,pedidocompraimpor));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(pedidocompraimpor.getClienteProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				pedidocompraimpor.setEmpleado(pedidocompraimporDataAccess.getEmpleado(connexion,pedidocompraimpor));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(pedidocompraimpor.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				pedidocompraimpor.setUsuario(pedidocompraimporDataAccess.getUsuario(connexion,pedidocompraimpor));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(pedidocompraimpor.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				pedidocompraimpor.setTipoCambio(pedidocompraimporDataAccess.getTipoCambio(connexion,pedidocompraimpor));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(pedidocompraimpor.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				pedidocompraimpor.setMoneda(pedidocompraimporDataAccess.getMoneda(connexion,pedidocompraimpor));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(pedidocompraimpor.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProrrateoImpor.class)) {
				pedidocompraimpor.setTipoProrrateoImpor(pedidocompraimporDataAccess.getTipoProrrateoImpor(connexion,pedidocompraimpor));
				TipoProrrateoImporLogic tipoprorrateoimporLogic= new TipoProrrateoImporLogic(connexion);
				tipoprorrateoimporLogic.deepLoad(pedidocompraimpor.getTipoProrrateoImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Embarcador.class)) {
				pedidocompraimpor.setEmbarcador(pedidocompraimporDataAccess.getEmbarcador(connexion,pedidocompraimpor));
				EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
				embarcadorLogic.deepLoad(pedidocompraimpor.getEmbarcador(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				pedidocompraimpor.setTipoViaTransporte(pedidocompraimporDataAccess.getTipoViaTransporte(connexion,pedidocompraimpor));
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepLoad(pedidocompraimpor.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				pedidocompraimpor.setPuerto(pedidocompraimporDataAccess.getPuerto(connexion,pedidocompraimpor));
				PuertoLogic puertoLogic= new PuertoLogic(connexion);
				puertoLogic.deepLoad(pedidocompraimpor.getPuerto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				pedidocompraimpor.setPuertoDestino(pedidocompraimporDataAccess.getPuertoDestino(connexion,pedidocompraimpor));
				PuertoLogic puertoLogic= new PuertoLogic(connexion);
				puertoLogic.deepLoad(pedidocompraimpor.getPuertoDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTerminosImpor.class)) {
				pedidocompraimpor.setTipoTerminosImpor(pedidocompraimporDataAccess.getTipoTerminosImpor(connexion,pedidocompraimpor));
				TipoTerminosImporLogic tipoterminosimporLogic= new TipoTerminosImporLogic(connexion);
				tipoterminosimporLogic.deepLoad(pedidocompraimpor.getTipoTerminosImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				pedidocompraimpor.setEstadoPedidoCompra(pedidocompraimporDataAccess.getEstadoPedidoCompra(connexion,pedidocompraimpor));
				EstadoPedidoCompraLogic estadopedidocompraLogic= new EstadoPedidoCompraLogic(connexion);
				estadopedidocompraLogic.deepLoad(pedidocompraimpor.getEstadoPedidoCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				pedidocompraimpor.setFormato(pedidocompraimporDataAccess.getFormato(connexion,pedidocompraimpor));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(pedidocompraimpor.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				pedidocompraimpor.setAnio(pedidocompraimporDataAccess.getAnio(connexion,pedidocompraimpor));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(pedidocompraimpor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				pedidocompraimpor.setMes(pedidocompraimporDataAccess.getMes(connexion,pedidocompraimpor));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(pedidocompraimpor.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidocompraimpor.setDetallePedidoCompraImpors(pedidocompraimporDataAccess.getDetallePedidoCompraImpors(connexion,pedidocompraimpor));

				for(DetallePedidoCompraImpor detallepedidocompraimpor:pedidocompraimpor.getDetallePedidoCompraImpors()) {
					DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(connexion);
					detallepedidocompraimporLogic.deepLoad(detallepedidocompraimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(LiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				pedidocompraimpor.setLiquidacionImpuestoImpors(pedidocompraimporDataAccess.getLiquidacionImpuestoImpors(connexion,pedidocompraimpor));

				for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:pedidocompraimpor.getLiquidacionImpuestoImpors()) {
					LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(connexion);
					liquidacionimpuestoimporLogic.deepLoad(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);
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
			pedidocompraimpor.setEmpresa(pedidocompraimporDataAccess.getEmpresa(connexion,pedidocompraimpor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(pedidocompraimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setSucursal(pedidocompraimporDataAccess.getSucursal(connexion,pedidocompraimpor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(pedidocompraimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setModulo(pedidocompraimporDataAccess.getModulo(connexion,pedidocompraimpor));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(pedidocompraimpor.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setEjercicio(pedidocompraimporDataAccess.getEjercicio(connexion,pedidocompraimpor));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(pedidocompraimpor.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setPeriodo(pedidocompraimporDataAccess.getPeriodo(connexion,pedidocompraimpor));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(pedidocompraimpor.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setPais(pedidocompraimporDataAccess.getPais(connexion,pedidocompraimpor));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(pedidocompraimpor.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setCliente(pedidocompraimporDataAccess.getCliente(connexion,pedidocompraimpor));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(pedidocompraimpor.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setClienteProveedor(pedidocompraimporDataAccess.getClienteProveedor(connexion,pedidocompraimpor));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(pedidocompraimpor.getClienteProveedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setEmpleado(pedidocompraimporDataAccess.getEmpleado(connexion,pedidocompraimpor));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(pedidocompraimpor.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setUsuario(pedidocompraimporDataAccess.getUsuario(connexion,pedidocompraimpor));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(pedidocompraimpor.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setTipoCambio(pedidocompraimporDataAccess.getTipoCambio(connexion,pedidocompraimpor));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(pedidocompraimpor.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setMoneda(pedidocompraimporDataAccess.getMoneda(connexion,pedidocompraimpor));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(pedidocompraimpor.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProrrateoImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setTipoProrrateoImpor(pedidocompraimporDataAccess.getTipoProrrateoImpor(connexion,pedidocompraimpor));
			TipoProrrateoImporLogic tipoprorrateoimporLogic= new TipoProrrateoImporLogic(connexion);
			tipoprorrateoimporLogic.deepLoad(pedidocompraimpor.getTipoProrrateoImpor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Embarcador.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setEmbarcador(pedidocompraimporDataAccess.getEmbarcador(connexion,pedidocompraimpor));
			EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
			embarcadorLogic.deepLoad(pedidocompraimpor.getEmbarcador(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoViaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setTipoViaTransporte(pedidocompraimporDataAccess.getTipoViaTransporte(connexion,pedidocompraimpor));
			TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
			tipoviatransporteLogic.deepLoad(pedidocompraimpor.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Puerto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setPuerto(pedidocompraimporDataAccess.getPuerto(connexion,pedidocompraimpor));
			PuertoLogic puertoLogic= new PuertoLogic(connexion);
			puertoLogic.deepLoad(pedidocompraimpor.getPuerto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Puerto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setPuertoDestino(pedidocompraimporDataAccess.getPuertoDestino(connexion,pedidocompraimpor));
			PuertoLogic puertoLogic= new PuertoLogic(connexion);
			puertoLogic.deepLoad(pedidocompraimpor.getPuertoDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTerminosImpor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setTipoTerminosImpor(pedidocompraimporDataAccess.getTipoTerminosImpor(connexion,pedidocompraimpor));
			TipoTerminosImporLogic tipoterminosimporLogic= new TipoTerminosImporLogic(connexion);
			tipoterminosimporLogic.deepLoad(pedidocompraimpor.getTipoTerminosImpor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setEstadoPedidoCompra(pedidocompraimporDataAccess.getEstadoPedidoCompra(connexion,pedidocompraimpor));
			EstadoPedidoCompraLogic estadopedidocompraLogic= new EstadoPedidoCompraLogic(connexion);
			estadopedidocompraLogic.deepLoad(pedidocompraimpor.getEstadoPedidoCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setFormato(pedidocompraimporDataAccess.getFormato(connexion,pedidocompraimpor));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(pedidocompraimpor.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setAnio(pedidocompraimporDataAccess.getAnio(connexion,pedidocompraimpor));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(pedidocompraimpor.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			pedidocompraimpor.setMes(pedidocompraimporDataAccess.getMes(connexion,pedidocompraimpor));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(pedidocompraimpor.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetallePedidoCompraImpor.class));
			pedidocompraimpor.setDetallePedidoCompraImpors(pedidocompraimporDataAccess.getDetallePedidoCompraImpors(connexion,pedidocompraimpor));

			for(DetallePedidoCompraImpor detallepedidocompraimpor:pedidocompraimpor.getDetallePedidoCompraImpors()) {
				DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(connexion);
				detallepedidocompraimporLogic.deepLoad(detallepedidocompraimpor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LiquidacionImpuestoImpor.class));
			pedidocompraimpor.setLiquidacionImpuestoImpors(pedidocompraimporDataAccess.getLiquidacionImpuestoImpors(connexion,pedidocompraimpor));

			for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:pedidocompraimpor.getLiquidacionImpuestoImpors()) {
				LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(connexion);
				liquidacionimpuestoimporLogic.deepLoad(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PedidoCompraImpor pedidocompraimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PedidoCompraImporLogicAdditional.updatePedidoCompraImporToSave(pedidocompraimpor,this.arrDatoGeneral);
			
PedidoCompraImporDataAccess.save(pedidocompraimpor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidocompraimpor.getEmpresa(),connexion);

		SucursalDataAccess.save(pedidocompraimpor.getSucursal(),connexion);

		ModuloDataAccess.save(pedidocompraimpor.getModulo(),connexion);

		EjercicioDataAccess.save(pedidocompraimpor.getEjercicio(),connexion);

		PeriodoDataAccess.save(pedidocompraimpor.getPeriodo(),connexion);

		PaisDataAccess.save(pedidocompraimpor.getPais(),connexion);

		ClienteDataAccess.save(pedidocompraimpor.getCliente(),connexion);

		ClienteDataAccess.save(pedidocompraimpor.getClienteProveedor(),connexion);

		EmpleadoDataAccess.save(pedidocompraimpor.getEmpleado(),connexion);

		UsuarioDataAccess.save(pedidocompraimpor.getUsuario(),connexion);

		TipoCambioDataAccess.save(pedidocompraimpor.getTipoCambio(),connexion);

		MonedaDataAccess.save(pedidocompraimpor.getMoneda(),connexion);

		TipoProrrateoImporDataAccess.save(pedidocompraimpor.getTipoProrrateoImpor(),connexion);

		EmbarcadorDataAccess.save(pedidocompraimpor.getEmbarcador(),connexion);

		TipoViaTransporteDataAccess.save(pedidocompraimpor.getTipoViaTransporte(),connexion);

		PuertoDataAccess.save(pedidocompraimpor.getPuerto(),connexion);

		PuertoDataAccess.save(pedidocompraimpor.getPuertoDestino(),connexion);

		TipoTerminosImporDataAccess.save(pedidocompraimpor.getTipoTerminosImpor(),connexion);

		EstadoPedidoCompraDataAccess.save(pedidocompraimpor.getEstadoPedidoCompra(),connexion);

		FormatoDataAccess.save(pedidocompraimpor.getFormato(),connexion);

		AnioDataAccess.save(pedidocompraimpor.getAnio(),connexion);

		MesDataAccess.save(pedidocompraimpor.getMes(),connexion);

		for(DetallePedidoCompraImpor detallepedidocompraimpor:pedidocompraimpor.getDetallePedidoCompraImpors()) {
			detallepedidocompraimpor.setid_pedido_compra_impor(pedidocompraimpor.getId());
			DetallePedidoCompraImporDataAccess.save(detallepedidocompraimpor,connexion);
		}

		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:pedidocompraimpor.getLiquidacionImpuestoImpors()) {
			liquidacionimpuestoimpor.setid_pedido_compra_impor(pedidocompraimpor.getId());
			LiquidacionImpuestoImporDataAccess.save(liquidacionimpuestoimpor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidocompraimpor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidocompraimpor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(pedidocompraimpor.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedidocompraimpor.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedidocompraimpor.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(pedidocompraimpor.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidocompraimpor.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidocompraimpor.getClienteProveedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(pedidocompraimpor.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(pedidocompraimpor.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(pedidocompraimpor.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(pedidocompraimpor.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProrrateoImpor.class)) {
				TipoProrrateoImporDataAccess.save(pedidocompraimpor.getTipoProrrateoImpor(),connexion);
				continue;
			}

			if(clas.clas.equals(Embarcador.class)) {
				EmbarcadorDataAccess.save(pedidocompraimpor.getEmbarcador(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(pedidocompraimpor.getTipoViaTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				PuertoDataAccess.save(pedidocompraimpor.getPuerto(),connexion);
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				PuertoDataAccess.save(pedidocompraimpor.getPuertoDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTerminosImpor.class)) {
				TipoTerminosImporDataAccess.save(pedidocompraimpor.getTipoTerminosImpor(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				EstadoPedidoCompraDataAccess.save(pedidocompraimpor.getEstadoPedidoCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(pedidocompraimpor.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(pedidocompraimpor.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(pedidocompraimpor.getMes(),connexion);
				continue;
			}


			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedidoCompraImpor detallepedidocompraimpor:pedidocompraimpor.getDetallePedidoCompraImpors()) {
					detallepedidocompraimpor.setid_pedido_compra_impor(pedidocompraimpor.getId());
					DetallePedidoCompraImporDataAccess.save(detallepedidocompraimpor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(LiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:pedidocompraimpor.getLiquidacionImpuestoImpors()) {
					liquidacionimpuestoimpor.setid_pedido_compra_impor(pedidocompraimpor.getId());
					LiquidacionImpuestoImporDataAccess.save(liquidacionimpuestoimpor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(pedidocompraimpor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(pedidocompraimpor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(pedidocompraimpor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(pedidocompraimpor.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(pedidocompraimpor.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(pedidocompraimpor.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(pedidocompraimpor.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(pedidocompraimpor.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(pedidocompraimpor.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(pedidocompraimpor.getPeriodo(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(pedidocompraimpor.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(pedidocompraimpor.getPais(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(pedidocompraimpor.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(pedidocompraimpor.getCliente(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(pedidocompraimpor.getClienteProveedor(),connexion);
		ClienteLogic clienteproveedorLogic= new ClienteLogic(connexion);
		clienteproveedorLogic.deepLoad(pedidocompraimpor.getClienteProveedor(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(pedidocompraimpor.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(pedidocompraimpor.getEmpleado(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(pedidocompraimpor.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(pedidocompraimpor.getUsuario(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(pedidocompraimpor.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(pedidocompraimpor.getTipoCambio(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(pedidocompraimpor.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(pedidocompraimpor.getMoneda(),isDeep,deepLoadType,clases);
				

		TipoProrrateoImporDataAccess.save(pedidocompraimpor.getTipoProrrateoImpor(),connexion);
		TipoProrrateoImporLogic tipoprorrateoimporLogic= new TipoProrrateoImporLogic(connexion);
		tipoprorrateoimporLogic.deepLoad(pedidocompraimpor.getTipoProrrateoImpor(),isDeep,deepLoadType,clases);
				

		EmbarcadorDataAccess.save(pedidocompraimpor.getEmbarcador(),connexion);
		EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
		embarcadorLogic.deepLoad(pedidocompraimpor.getEmbarcador(),isDeep,deepLoadType,clases);
				

		TipoViaTransporteDataAccess.save(pedidocompraimpor.getTipoViaTransporte(),connexion);
		TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
		tipoviatransporteLogic.deepLoad(pedidocompraimpor.getTipoViaTransporte(),isDeep,deepLoadType,clases);
				

		PuertoDataAccess.save(pedidocompraimpor.getPuerto(),connexion);
		PuertoLogic puertoLogic= new PuertoLogic(connexion);
		puertoLogic.deepLoad(pedidocompraimpor.getPuerto(),isDeep,deepLoadType,clases);
				

		PuertoDataAccess.save(pedidocompraimpor.getPuertoDestino(),connexion);
		PuertoLogic puertodestinoLogic= new PuertoLogic(connexion);
		puertodestinoLogic.deepLoad(pedidocompraimpor.getPuertoDestino(),isDeep,deepLoadType,clases);
				

		TipoTerminosImporDataAccess.save(pedidocompraimpor.getTipoTerminosImpor(),connexion);
		TipoTerminosImporLogic tipoterminosimporLogic= new TipoTerminosImporLogic(connexion);
		tipoterminosimporLogic.deepLoad(pedidocompraimpor.getTipoTerminosImpor(),isDeep,deepLoadType,clases);
				

		EstadoPedidoCompraDataAccess.save(pedidocompraimpor.getEstadoPedidoCompra(),connexion);
		EstadoPedidoCompraLogic estadopedidocompraLogic= new EstadoPedidoCompraLogic(connexion);
		estadopedidocompraLogic.deepLoad(pedidocompraimpor.getEstadoPedidoCompra(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(pedidocompraimpor.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(pedidocompraimpor.getFormato(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(pedidocompraimpor.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(pedidocompraimpor.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(pedidocompraimpor.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(pedidocompraimpor.getMes(),isDeep,deepLoadType,clases);
				

		for(DetallePedidoCompraImpor detallepedidocompraimpor:pedidocompraimpor.getDetallePedidoCompraImpors()) {
			DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(connexion);
			detallepedidocompraimpor.setid_pedido_compra_impor(pedidocompraimpor.getId());
			DetallePedidoCompraImporDataAccess.save(detallepedidocompraimpor,connexion);
			detallepedidocompraimporLogic.deepSave(detallepedidocompraimpor,isDeep,deepLoadType,clases);
		}

		for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:pedidocompraimpor.getLiquidacionImpuestoImpors()) {
			LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(connexion);
			liquidacionimpuestoimpor.setid_pedido_compra_impor(pedidocompraimpor.getId());
			LiquidacionImpuestoImporDataAccess.save(liquidacionimpuestoimpor,connexion);
			liquidacionimpuestoimporLogic.deepSave(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(pedidocompraimpor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(pedidocompraimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(pedidocompraimpor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(pedidocompraimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(pedidocompraimpor.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(pedidocompraimpor.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(pedidocompraimpor.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(pedidocompraimpor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(pedidocompraimpor.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(pedidocompraimpor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(pedidocompraimpor.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(pedidocompraimpor.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidocompraimpor.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(pedidocompraimpor.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(pedidocompraimpor.getClienteProveedor(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(pedidocompraimpor.getClienteProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(pedidocompraimpor.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(pedidocompraimpor.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(pedidocompraimpor.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(pedidocompraimpor.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(pedidocompraimpor.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(pedidocompraimpor.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(pedidocompraimpor.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(pedidocompraimpor.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProrrateoImpor.class)) {
				TipoProrrateoImporDataAccess.save(pedidocompraimpor.getTipoProrrateoImpor(),connexion);
				TipoProrrateoImporLogic tipoprorrateoimporLogic= new TipoProrrateoImporLogic(connexion);
				tipoprorrateoimporLogic.deepSave(pedidocompraimpor.getTipoProrrateoImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Embarcador.class)) {
				EmbarcadorDataAccess.save(pedidocompraimpor.getEmbarcador(),connexion);
				EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
				embarcadorLogic.deepSave(pedidocompraimpor.getEmbarcador(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoViaTransporte.class)) {
				TipoViaTransporteDataAccess.save(pedidocompraimpor.getTipoViaTransporte(),connexion);
				TipoViaTransporteLogic tipoviatransporteLogic= new TipoViaTransporteLogic(connexion);
				tipoviatransporteLogic.deepSave(pedidocompraimpor.getTipoViaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				PuertoDataAccess.save(pedidocompraimpor.getPuerto(),connexion);
				PuertoLogic puertoLogic= new PuertoLogic(connexion);
				puertoLogic.deepSave(pedidocompraimpor.getPuerto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				PuertoDataAccess.save(pedidocompraimpor.getPuertoDestino(),connexion);
				PuertoLogic puertoLogic= new PuertoLogic(connexion);
				puertoLogic.deepSave(pedidocompraimpor.getPuertoDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTerminosImpor.class)) {
				TipoTerminosImporDataAccess.save(pedidocompraimpor.getTipoTerminosImpor(),connexion);
				TipoTerminosImporLogic tipoterminosimporLogic= new TipoTerminosImporLogic(connexion);
				tipoterminosimporLogic.deepSave(pedidocompraimpor.getTipoTerminosImpor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedidoCompra.class)) {
				EstadoPedidoCompraDataAccess.save(pedidocompraimpor.getEstadoPedidoCompra(),connexion);
				EstadoPedidoCompraLogic estadopedidocompraLogic= new EstadoPedidoCompraLogic(connexion);
				estadopedidocompraLogic.deepSave(pedidocompraimpor.getEstadoPedidoCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(pedidocompraimpor.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(pedidocompraimpor.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(pedidocompraimpor.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(pedidocompraimpor.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(pedidocompraimpor.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(pedidocompraimpor.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetallePedidoCompraImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetallePedidoCompraImpor detallepedidocompraimpor:pedidocompraimpor.getDetallePedidoCompraImpors()) {
					DetallePedidoCompraImporLogic detallepedidocompraimporLogic= new DetallePedidoCompraImporLogic(connexion);
					detallepedidocompraimpor.setid_pedido_compra_impor(pedidocompraimpor.getId());
					DetallePedidoCompraImporDataAccess.save(detallepedidocompraimpor,connexion);
					detallepedidocompraimporLogic.deepSave(detallepedidocompraimpor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(LiquidacionImpuestoImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(LiquidacionImpuestoImpor liquidacionimpuestoimpor:pedidocompraimpor.getLiquidacionImpuestoImpors()) {
					LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic= new LiquidacionImpuestoImporLogic(connexion);
					liquidacionimpuestoimpor.setid_pedido_compra_impor(pedidocompraimpor.getId());
					LiquidacionImpuestoImporDataAccess.save(liquidacionimpuestoimpor,connexion);
					liquidacionimpuestoimporLogic.deepSave(liquidacionimpuestoimpor,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PedidoCompraImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(pedidocompraimpor);
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
			this.deepLoad(this.pedidocompraimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PedidoCompraImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(pedidocompraimpors!=null) {
				for(PedidoCompraImpor pedidocompraimpor:pedidocompraimpors) {
					this.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(pedidocompraimpors);
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
			if(pedidocompraimpors!=null) {
				for(PedidoCompraImpor pedidocompraimpor:pedidocompraimpors) {
					this.deepLoad(pedidocompraimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(pedidocompraimpors);
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
			this.getNewConnexionToDeep(PedidoCompraImpor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(pedidocompraimpor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PedidoCompraImpor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(pedidocompraimpors!=null) {
				for(PedidoCompraImpor pedidocompraimpor:pedidocompraimpors) {
					this.deepSave(pedidocompraimpor,isDeep,deepLoadType,clases);
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
			if(pedidocompraimpors!=null) {
				for(PedidoCompraImpor pedidocompraimpor:pedidocompraimpors) {
					this.deepSave(pedidocompraimpor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPedidoCompraImporsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PedidoCompraImporConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PedidoCompraImporConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoCompraImporConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PedidoCompraImporConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdClienteProveedorWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente_proveedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_proveedor,PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteProveedor);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdClienteProveedor(String sFinalQuery,Pagination pagination,Long id_cliente_proveedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_proveedor,PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteProveedor);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoCompraImporConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PedidoCompraImporConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdEmbarcadorWithConnection(String sFinalQuery,Pagination pagination,Long id_embarcador)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmbarcador= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmbarcador.setParameterSelectionGeneralEqual(ParameterType.LONG,id_embarcador,PedidoCompraImporConstantesFunciones.IDEMBARCADOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmbarcador);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmbarcador","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdEmbarcador(String sFinalQuery,Pagination pagination,Long id_embarcador)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmbarcador= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmbarcador.setParameterSelectionGeneralEqual(ParameterType.LONG,id_embarcador,PedidoCompraImporConstantesFunciones.IDEMBARCADOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmbarcador);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmbarcador","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PedidoCompraImporConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PedidoCompraImporConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoCompraImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PedidoCompraImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdEstadoPedidoCompraEstadoPedoCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_compra,PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoCompra);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoCompraEstadoPedoCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdEstadoPedidoCompraEstadoPedoCompra(String sFinalQuery,Pagination pagination,Long id_estado_pedido_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_compra,PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoCompra);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoCompraEstadoPedoCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PedidoCompraImporConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,PedidoCompraImporConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PedidoCompraImporConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PedidoCompraImporConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,PedidoCompraImporConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,PedidoCompraImporConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,PedidoCompraImporConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,PedidoCompraImporConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PedidoCompraImporConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,PedidoCompraImporConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoCompraImporConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PedidoCompraImporConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdPuertoWithConnection(String sFinalQuery,Pagination pagination,Long id_puerto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPuerto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPuerto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_puerto,PedidoCompraImporConstantesFunciones.IDPUERTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPuerto);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPuerto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdPuerto(String sFinalQuery,Pagination pagination,Long id_puerto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPuerto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPuerto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_puerto,PedidoCompraImporConstantesFunciones.IDPUERTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPuerto);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPuerto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdPuertoDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_puerto_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPuertoDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPuertoDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_puerto_destino,PedidoCompraImporConstantesFunciones.IDPUERTODESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPuertoDestino);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPuertoDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdPuertoDestino(String sFinalQuery,Pagination pagination,Long id_puerto_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPuertoDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPuertoDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_puerto_destino,PedidoCompraImporConstantesFunciones.IDPUERTODESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPuertoDestino);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPuertoDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoCompraImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PedidoCompraImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdTipoProrrateoImporWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_prorrateo_impor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProrrateoImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProrrateoImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_prorrateo_impor,PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProrrateoImpor);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProrrateoImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdTipoProrrateoImpor(String sFinalQuery,Pagination pagination,Long id_tipo_prorrateo_impor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProrrateoImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProrrateoImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_prorrateo_impor,PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProrrateoImpor);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProrrateoImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdTipoTerminosImporWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_terminos_impor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTerminosImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTerminosImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_terminos_impor,PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTerminosImpor);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTerminosImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdTipoTerminosImpor(String sFinalQuery,Pagination pagination,Long id_tipo_terminos_impor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTerminosImpor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTerminosImpor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_terminos_impor,PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTerminosImpor);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTerminosImpor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdTipoViaTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdTipoViaTransporte(String sFinalQuery,Pagination pagination,Long id_tipo_via_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoViaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoViaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_via_transporte,PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoViaTransporte);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoViaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPedidoCompraImporsFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PedidoCompraImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PedidoCompraImporConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPedidoCompraImporsFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,PedidoCompraImporConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			PedidoCompraImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PedidoCompraImporConstantesFunciones.refrescarForeignKeysDescripcionesPedidoCompraImpor(this.pedidocompraimpors);
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
			if(PedidoCompraImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoCompraImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PedidoCompraImpor pedidocompraimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PedidoCompraImporConstantesFunciones.ISCONAUDITORIA) {
				if(pedidocompraimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoCompraImporDataAccess.TABLENAME, pedidocompraimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoCompraImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoCompraImporLogic.registrarAuditoriaDetallesPedidoCompraImpor(connexion,pedidocompraimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(pedidocompraimpor.getIsDeleted()) {
					/*if(!pedidocompraimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PedidoCompraImporDataAccess.TABLENAME, pedidocompraimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PedidoCompraImporLogic.registrarAuditoriaDetallesPedidoCompraImpor(connexion,pedidocompraimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoCompraImporDataAccess.TABLENAME, pedidocompraimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(pedidocompraimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PedidoCompraImporDataAccess.TABLENAME, pedidocompraimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PedidoCompraImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PedidoCompraImporLogic.registrarAuditoriaDetallesPedidoCompraImpor(connexion,pedidocompraimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPedidoCompraImpor(Connexion connexion,PedidoCompraImpor pedidocompraimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_empresa().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_empresa()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_empresa().toString();
				}
				if(pedidocompraimpor.getid_empresa()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_sucursal().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_sucursal()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_sucursal().toString();
				}
				if(pedidocompraimpor.getid_sucursal()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_modulo().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_modulo()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_modulo().toString();
				}
				if(pedidocompraimpor.getid_modulo()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_ejercicio().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_ejercicio()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_ejercicio().toString();
				}
				if(pedidocompraimpor.getid_ejercicio()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_periodo().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_periodo()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_periodo().toString();
				}
				if(pedidocompraimpor.getid_periodo()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_pais().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_pais()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_pais().toString();
				}
				if(pedidocompraimpor.getid_pais()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_cliente().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_cliente()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_cliente().toString();
				}
				if(pedidocompraimpor.getid_cliente()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_cliente_proveedor().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_cliente_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_cliente_proveedor()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_cliente_proveedor().toString();
				}
				if(pedidocompraimpor.getid_cliente_proveedor()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_cliente_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDCLIENTEPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_empleado().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_empleado()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_empleado().toString();
				}
				if(pedidocompraimpor.getid_empleado()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_usuario().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_usuario()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_usuario().toString();
				}
				if(pedidocompraimpor.getid_usuario()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_tipo_cambio().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_cambio().toString();
				}
				if(pedidocompraimpor.getid_tipo_cambio()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_moneda().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_moneda()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_moneda().toString();
				}
				if(pedidocompraimpor.getid_moneda()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_tipo_prorrateo_impor().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_prorrateo_impor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_prorrateo_impor()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_prorrateo_impor().toString();
				}
				if(pedidocompraimpor.getid_tipo_prorrateo_impor()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_tipo_prorrateo_impor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDTIPOPRORRATEOIMPOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_embarcador().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_embarcador()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_embarcador()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_embarcador().toString();
				}
				if(pedidocompraimpor.getid_embarcador()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_embarcador().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDEMBARCADOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_tipo_via_transporte().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_via_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_via_transporte()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_via_transporte().toString();
				}
				if(pedidocompraimpor.getid_tipo_via_transporte()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_tipo_via_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDTIPOVIATRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_puerto().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_puerto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_puerto()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_puerto().toString();
				}
				if(pedidocompraimpor.getid_puerto()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_puerto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDPUERTO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_puerto_destino().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_puerto_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_puerto_destino()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_puerto_destino().toString();
				}
				if(pedidocompraimpor.getid_puerto_destino()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_puerto_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDPUERTODESTINO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_tipo_terminos_impor().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_terminos_impor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_terminos_impor()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_tipo_terminos_impor().toString();
				}
				if(pedidocompraimpor.getid_tipo_terminos_impor()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_tipo_terminos_impor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDTIPOTERMINOSIMPOR,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_estado_pedido_compra().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_estado_pedido_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_estado_pedido_compra()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_estado_pedido_compra().toString();
				}
				if(pedidocompraimpor.getid_estado_pedido_compra()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_estado_pedido_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDESTADOPEDIDOCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getforma_pago().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getforma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getforma_pago()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getforma_pago();
				}
				if(pedidocompraimpor.getforma_pago()!=null)
				{
					strValorNuevo=pedidocompraimpor.getforma_pago() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.FORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getnumero_dui().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getnumero_dui()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getnumero_dui()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getnumero_dui();
				}
				if(pedidocompraimpor.getnumero_dui()!=null)
				{
					strValorNuevo=pedidocompraimpor.getnumero_dui() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.NUMERODUI,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getsecuencial().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getsecuencial()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getsecuencial();
				}
				if(pedidocompraimpor.getsecuencial()!=null)
				{
					strValorNuevo=pedidocompraimpor.getsecuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getnumero_orden().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getnumero_orden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getnumero_orden()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getnumero_orden().toString();
				}
				if(pedidocompraimpor.getnumero_orden()!=null)
				{
					strValorNuevo=pedidocompraimpor.getnumero_orden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.NUMEROORDEN,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getuso_en().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getuso_en()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getuso_en()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getuso_en();
				}
				if(pedidocompraimpor.getuso_en()!=null)
				{
					strValorNuevo=pedidocompraimpor.getuso_en() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.USOEN,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getresponsable().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getresponsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getresponsable()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getresponsable();
				}
				if(pedidocompraimpor.getresponsable()!=null)
				{
					strValorNuevo=pedidocompraimpor.getresponsable() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.RESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getorden_compra().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getorden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getorden_compra()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getorden_compra();
				}
				if(pedidocompraimpor.getorden_compra()!=null)
				{
					strValorNuevo=pedidocompraimpor.getorden_compra() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.ORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getlugar_entrega().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getlugar_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getlugar_entrega()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getlugar_entrega();
				}
				if(pedidocompraimpor.getlugar_entrega()!=null)
				{
					strValorNuevo=pedidocompraimpor.getlugar_entrega() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.LUGARENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getdescripcion().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getdescripcion()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getdescripcion();
				}
				if(pedidocompraimpor.getdescripcion()!=null)
				{
					strValorNuevo=pedidocompraimpor.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getfecha().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getfecha()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getfecha().toString();
				}
				if(pedidocompraimpor.getfecha()!=null)
				{
					strValorNuevo=pedidocompraimpor.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getfecha_emision().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getfecha_emision()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getfecha_emision().toString();
				}
				if(pedidocompraimpor.getfecha_emision()!=null)
				{
					strValorNuevo=pedidocompraimpor.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getfecha_entrega().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getfecha_entrega()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getfecha_entrega().toString();
				}
				if(pedidocompraimpor.getfecha_entrega()!=null)
				{
					strValorNuevo=pedidocompraimpor.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getfecha_entrega_cliente().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getfecha_entrega_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getfecha_entrega_cliente()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getfecha_entrega_cliente().toString();
				}
				if(pedidocompraimpor.getfecha_entrega_cliente()!=null)
				{
					strValorNuevo=pedidocompraimpor.getfecha_entrega_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.FECHAENTREGACLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getnombre_seguro().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getnombre_seguro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getnombre_seguro()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getnombre_seguro();
				}
				if(pedidocompraimpor.getnombre_seguro()!=null)
				{
					strValorNuevo=pedidocompraimpor.getnombre_seguro() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.NOMBRESEGURO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getnombre_consignatario().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getnombre_consignatario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getnombre_consignatario()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getnombre_consignatario();
				}
				if(pedidocompraimpor.getnombre_consignatario()!=null)
				{
					strValorNuevo=pedidocompraimpor.getnombre_consignatario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.NOMBRECONSIGNATARIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getprecios().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getprecios()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getprecios()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getprecios();
				}
				if(pedidocompraimpor.getprecios()!=null)
				{
					strValorNuevo=pedidocompraimpor.getprecios() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.PRECIOS,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getflete().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getflete()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getflete().toString();
				}
				if(pedidocompraimpor.getflete()!=null)
				{
					strValorNuevo=pedidocompraimpor.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getseguro().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getseguro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getseguro()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getseguro().toString();
				}
				if(pedidocompraimpor.getseguro()!=null)
				{
					strValorNuevo=pedidocompraimpor.getseguro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.SEGURO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getgastos().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getgastos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getgastos()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getgastos().toString();
				}
				if(pedidocompraimpor.getgastos()!=null)
				{
					strValorNuevo=pedidocompraimpor.getgastos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.GASTOS,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getcfr().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getcfr()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getcfr()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getcfr().toString();
				}
				if(pedidocompraimpor.getcfr()!=null)
				{
					strValorNuevo=pedidocompraimpor.getcfr().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.CFR,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getcif().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getcif()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getcif()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getcif().toString();
				}
				if(pedidocompraimpor.getcif()!=null)
				{
					strValorNuevo=pedidocompraimpor.getcif().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.CIF,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.gettotal().equals(pedidocompraimpor.getPedidoCompraImporOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().gettotal()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().gettotal().toString();
				}
				if(pedidocompraimpor.gettotal()!=null)
				{
					strValorNuevo=pedidocompraimpor.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_formato().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_formato()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_formato().toString();
				}
				if(pedidocompraimpor.getid_formato()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_anio().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_anio()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_anio().toString();
				}
				if(pedidocompraimpor.getid_anio()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(pedidocompraimpor.getIsNew()||!pedidocompraimpor.getid_mes().equals(pedidocompraimpor.getPedidoCompraImporOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(pedidocompraimpor.getPedidoCompraImporOriginal().getid_mes()!=null)
				{
					strValorActual=pedidocompraimpor.getPedidoCompraImporOriginal().getid_mes().toString();
				}
				if(pedidocompraimpor.getid_mes()!=null)
				{
					strValorNuevo=pedidocompraimpor.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PedidoCompraImporConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePedidoCompraImporRelacionesWithConnection(PedidoCompraImpor pedidocompraimpor,List<DetallePedidoCompraImpor> detallepedidocompraimpors,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors) throws Exception {

		if(!pedidocompraimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoCompraImporRelacionesBase(pedidocompraimpor,detallepedidocompraimpors,liquidacionimpuestoimpors,true);
		}
	}

	public void savePedidoCompraImporRelaciones(PedidoCompraImpor pedidocompraimpor,List<DetallePedidoCompraImpor> detallepedidocompraimpors,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors)throws Exception {

		if(!pedidocompraimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePedidoCompraImporRelacionesBase(pedidocompraimpor,detallepedidocompraimpors,liquidacionimpuestoimpors,false);
		}
	}

	public void savePedidoCompraImporRelacionesBase(PedidoCompraImpor pedidocompraimpor,List<DetallePedidoCompraImpor> detallepedidocompraimpors,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PedidoCompraImpor-saveRelacionesWithConnection");}
	
			pedidocompraimpor.setDetallePedidoCompraImpors(detallepedidocompraimpors);
			pedidocompraimpor.setLiquidacionImpuestoImpors(liquidacionimpuestoimpors);

			this.setPedidoCompraImpor(pedidocompraimpor);

			if(PedidoCompraImporLogicAdditional.validarSaveRelaciones(pedidocompraimpor,this)) {

				PedidoCompraImporLogicAdditional.updateRelacionesToSave(pedidocompraimpor,this);

				if((pedidocompraimpor.getIsNew()||pedidocompraimpor.getIsChanged())&&!pedidocompraimpor.getIsDeleted()) {
					this.savePedidoCompraImpor();
					this.savePedidoCompraImporRelacionesDetalles(detallepedidocompraimpors,liquidacionimpuestoimpors);

				} else if(pedidocompraimpor.getIsDeleted()) {
					this.savePedidoCompraImporRelacionesDetalles(detallepedidocompraimpors,liquidacionimpuestoimpors);
					this.savePedidoCompraImpor();
				}

				PedidoCompraImporLogicAdditional.updateRelacionesToSaveAfter(pedidocompraimpor,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetallePedidoCompraImporConstantesFunciones.InicializarGeneralEntityAuxiliaresDetallePedidoCompraImpors(detallepedidocompraimpors,true,true);
			LiquidacionImpuestoImporConstantesFunciones.InicializarGeneralEntityAuxiliaresLiquidacionImpuestoImpors(liquidacionimpuestoimpors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePedidoCompraImporRelacionesDetalles(List<DetallePedidoCompraImpor> detallepedidocompraimpors,List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors)throws Exception {
		try {
	

			Long idPedidoCompraImporActual=this.getPedidoCompraImpor().getId();

			DetallePedidoCompraImporLogic detallepedidocompraimporLogic_Desde_PedidoCompraImpor=new DetallePedidoCompraImporLogic();
			detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setDetallePedidoCompraImpors(detallepedidocompraimpors);

			detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setConnexion(this.getConnexion());
			detallepedidocompraimporLogic_Desde_PedidoCompraImpor.setDatosCliente(this.datosCliente);

			for(DetallePedidoCompraImpor detallepedidocompraimpor_Desde_PedidoCompraImpor:detallepedidocompraimporLogic_Desde_PedidoCompraImpor.getDetallePedidoCompraImpors()) {
				detallepedidocompraimpor_Desde_PedidoCompraImpor.setid_pedido_compra_impor(idPedidoCompraImporActual);
			}

			detallepedidocompraimporLogic_Desde_PedidoCompraImpor.saveDetallePedidoCompraImpors();

			LiquidacionImpuestoImporLogic liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor=new LiquidacionImpuestoImporLogic();
			liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setLiquidacionImpuestoImpors(liquidacionimpuestoimpors);

			liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setConnexion(this.getConnexion());
			liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setDatosCliente(this.datosCliente);

			for(LiquidacionImpuestoImpor liquidacionimpuestoimpor_Desde_PedidoCompraImpor:liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.getLiquidacionImpuestoImpors()) {
				liquidacionimpuestoimpor_Desde_PedidoCompraImpor.setid_pedido_compra_impor(idPedidoCompraImporActual);

				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.setLiquidacionImpuestoImpor(liquidacionimpuestoimpor_Desde_PedidoCompraImpor);
				liquidacionimpuestoimporLogic_Desde_PedidoCompraImpor.saveLiquidacionImpuestoImpor();

				Long idLiquidacionImpuestoImporActual=liquidacionimpuestoimpor_Desde_PedidoCompraImpor.getId();

				DetalleLiquidacionImpuestoImporLogic detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor=new DetalleLiquidacionImpuestoImporLogic();

				if(liquidacionimpuestoimpor_Desde_PedidoCompraImpor.getDetalleLiquidacionImpuestoImpors()==null){
					liquidacionimpuestoimpor_Desde_PedidoCompraImpor.setDetalleLiquidacionImpuestoImpors(new ArrayList<DetalleLiquidacionImpuestoImpor>());
				}

				detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setDetalleLiquidacionImpuestoImpors(liquidacionimpuestoimpor_Desde_PedidoCompraImpor.getDetalleLiquidacionImpuestoImpors());

				detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setConnexion(this.getConnexion());
				detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.setDatosCliente(this.datosCliente);

				for(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor_Desde_LiquidacionImpuestoImpor:detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.getDetalleLiquidacionImpuestoImpors()) {
					detalleliquidacionimpuestoimpor_Desde_LiquidacionImpuestoImpor.setid_liquidacion_impuesto_impor(idLiquidacionImpuestoImporActual);
				}

				detalleliquidacionimpuestoimporLogic_Desde_LiquidacionImpuestoImpor.saveDetalleLiquidacionImpuestoImpors();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPedidoCompraImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoCompraImporConstantesFunciones.getClassesForeignKeysOfPedidoCompraImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPedidoCompraImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PedidoCompraImporConstantesFunciones.getClassesRelationshipsOfPedidoCompraImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
