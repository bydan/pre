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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.RequisicionCompraConstantesFunciones;
import com.bydan.erp.inventario.util.RequisicionCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.RequisicionCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.RequisicionCompra;
import com.bydan.erp.inventario.business.logic.RequisicionCompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class RequisicionCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RequisicionCompraLogic.class);
	
	protected RequisicionCompraDataAccess requisicioncompraDataAccess; 	
	protected RequisicionCompra requisicioncompra;
	protected List<RequisicionCompra> requisicioncompras;
	protected Object requisicioncompraObject;	
	protected List<Object> requisicioncomprasObject;
	
	public static ClassValidator<RequisicionCompra> requisicioncompraValidator = new ClassValidator<RequisicionCompra>(RequisicionCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RequisicionCompraLogicAdditional requisicioncompraLogicAdditional=null;
	
	public RequisicionCompraLogicAdditional getRequisicionCompraLogicAdditional() {
		return this.requisicioncompraLogicAdditional;
	}
	
	public void setRequisicionCompraLogicAdditional(RequisicionCompraLogicAdditional requisicioncompraLogicAdditional) {
		try {
			this.requisicioncompraLogicAdditional=requisicioncompraLogicAdditional;
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
	
	
	
	
	public  RequisicionCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.requisicioncompraDataAccess = new RequisicionCompraDataAccess();
			
			this.requisicioncompras= new ArrayList<RequisicionCompra>();
			this.requisicioncompra= new RequisicionCompra();
			
			this.requisicioncompraObject=new Object();
			this.requisicioncomprasObject=new ArrayList<Object>();
				
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
			
			this.requisicioncompraDataAccess.setConnexionType(this.connexionType);
			this.requisicioncompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RequisicionCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.requisicioncompraDataAccess = new RequisicionCompraDataAccess();
			this.requisicioncompras= new ArrayList<RequisicionCompra>();
			this.requisicioncompra= new RequisicionCompra();
			this.requisicioncompraObject=new Object();
			this.requisicioncomprasObject=new ArrayList<Object>();
			
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
			
			this.requisicioncompraDataAccess.setConnexionType(this.connexionType);
			this.requisicioncompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RequisicionCompra getRequisicionCompra() throws Exception {	
		RequisicionCompraLogicAdditional.checkRequisicionCompraToGet(requisicioncompra,this.datosCliente,this.arrDatoGeneral);
		RequisicionCompraLogicAdditional.updateRequisicionCompraToGet(requisicioncompra,this.arrDatoGeneral);
		
		return requisicioncompra;
	}
		
	public void setRequisicionCompra(RequisicionCompra newRequisicionCompra) {
		this.requisicioncompra = newRequisicionCompra;
	}
	
	public RequisicionCompraDataAccess getRequisicionCompraDataAccess() {
		return requisicioncompraDataAccess;
	}
	
	public void setRequisicionCompraDataAccess(RequisicionCompraDataAccess newrequisicioncompraDataAccess) {
		this.requisicioncompraDataAccess = newrequisicioncompraDataAccess;
	}
	
	public List<RequisicionCompra> getRequisicionCompras() throws Exception {		
		this.quitarRequisicionComprasNulos();
		
		RequisicionCompraLogicAdditional.checkRequisicionCompraToGets(requisicioncompras,this.datosCliente,this.arrDatoGeneral);
		
		for (RequisicionCompra requisicioncompraLocal: requisicioncompras ) {
			RequisicionCompraLogicAdditional.updateRequisicionCompraToGet(requisicioncompraLocal,this.arrDatoGeneral);
		}
		
		return requisicioncompras;
	}
	
	public void setRequisicionCompras(List<RequisicionCompra> newRequisicionCompras) {
		this.requisicioncompras = newRequisicionCompras;
	}
	
	public Object getRequisicionCompraObject() {	
		this.requisicioncompraObject=this.requisicioncompraDataAccess.getEntityObject();
		return this.requisicioncompraObject;
	}
		
	public void setRequisicionCompraObject(Object newRequisicionCompraObject) {
		this.requisicioncompraObject = newRequisicionCompraObject;
	}
	
	public List<Object> getRequisicionComprasObject() {		
		this.requisicioncomprasObject=this.requisicioncompraDataAccess.getEntitiesObject();
		return this.requisicioncomprasObject;
	}
		
	public void setRequisicionComprasObject(List<Object> newRequisicionComprasObject) {
		this.requisicioncomprasObject = newRequisicionComprasObject;
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
		
		if(this.requisicioncompraDataAccess!=null) {
			this.requisicioncompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			requisicioncompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			requisicioncompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		requisicioncompra = new  RequisicionCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			requisicioncompra=requisicioncompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.requisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompra);
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
		requisicioncompra = new  RequisicionCompra();
		  		  
        try {
			
			requisicioncompra=requisicioncompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.requisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		requisicioncompra = new  RequisicionCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			requisicioncompra=requisicioncompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.requisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompra);
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
		requisicioncompra = new  RequisicionCompra();
		  		  
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
		requisicioncompra = new  RequisicionCompra();
		  		  
        try {
			
			requisicioncompra=requisicioncompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.requisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		requisicioncompra = new  RequisicionCompra();
		  		  
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
		requisicioncompra = new  RequisicionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =requisicioncompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		requisicioncompra = new  RequisicionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=requisicioncompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		requisicioncompra = new  RequisicionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =requisicioncompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		requisicioncompra = new  RequisicionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=requisicioncompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		requisicioncompra = new  RequisicionCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =requisicioncompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		requisicioncompra = new  RequisicionCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=requisicioncompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
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
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		  		  
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
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		  		  
        try {			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRequisicionCompra(requisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		  		  
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
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
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
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		  		  
        try {
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
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
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
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
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		requisicioncompra = new  RequisicionCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompra=requisicioncompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompra);
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
		requisicioncompra = new  RequisicionCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompra=requisicioncompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompras=requisicioncompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
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
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		  		  
        try {
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompras=requisicioncompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRequisicionComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getTodosRequisicionComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
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
	
	public  void  getTodosRequisicionCompras(String sFinalQuery,Pagination pagination)throws Exception {
		requisicioncompras = new  ArrayList<RequisicionCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRequisicionCompra(requisicioncompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRequisicionCompra(RequisicionCompra requisicioncompra) throws Exception {
		Boolean estaValidado=false;
		
		if(requisicioncompra.getIsNew() || requisicioncompra.getIsChanged()) { 
			this.invalidValues = requisicioncompraValidator.getInvalidValues(requisicioncompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(requisicioncompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRequisicionCompra(List<RequisicionCompra> RequisicionCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RequisicionCompra requisicioncompraLocal:requisicioncompras) {				
			estaValidadoObjeto=this.validarGuardarRequisicionCompra(requisicioncompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRequisicionCompra(List<RequisicionCompra> RequisicionCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRequisicionCompra(requisicioncompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRequisicionCompra(RequisicionCompra RequisicionCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRequisicionCompra(requisicioncompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RequisicionCompra requisicioncompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+requisicioncompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RequisicionCompraConstantesFunciones.getRequisicionCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"requisicioncompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RequisicionCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RequisicionCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRequisicionCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-saveRequisicionCompraWithConnection");connexion.begin();			
			
			RequisicionCompraLogicAdditional.checkRequisicionCompraToSave(this.requisicioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RequisicionCompraLogicAdditional.updateRequisicionCompraToSave(this.requisicioncompra,this.arrDatoGeneral);
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.requisicioncompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRequisicionCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRequisicionCompra(this.requisicioncompra)) {
				RequisicionCompraDataAccess.save(this.requisicioncompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.requisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RequisicionCompraLogicAdditional.checkRequisicionCompraToSaveAfter(this.requisicioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRequisicionCompra();
			
			connexion.commit();			
			
			if(this.requisicioncompra.getIsDeleted()) {
				this.requisicioncompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRequisicionCompra()throws Exception {	
		try {	
			
			RequisicionCompraLogicAdditional.checkRequisicionCompraToSave(this.requisicioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RequisicionCompraLogicAdditional.updateRequisicionCompraToSave(this.requisicioncompra,this.arrDatoGeneral);
			
			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.requisicioncompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRequisicionCompra(this.requisicioncompra)) {			
				RequisicionCompraDataAccess.save(this.requisicioncompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.requisicioncompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RequisicionCompraLogicAdditional.checkRequisicionCompraToSaveAfter(this.requisicioncompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.requisicioncompra.getIsDeleted()) {
				this.requisicioncompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRequisicionComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-saveRequisicionComprasWithConnection");connexion.begin();			
			
			RequisicionCompraLogicAdditional.checkRequisicionCompraToSaves(requisicioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRequisicionCompras();
			
			Boolean validadoTodosRequisicionCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RequisicionCompra requisicioncompraLocal:requisicioncompras) {		
				if(requisicioncompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RequisicionCompraLogicAdditional.updateRequisicionCompraToSave(requisicioncompraLocal,this.arrDatoGeneral);
	        	
				RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),requisicioncompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRequisicionCompra(requisicioncompraLocal)) {
					RequisicionCompraDataAccess.save(requisicioncompraLocal, connexion);				
				} else {
					validadoTodosRequisicionCompra=false;
				}
			}
			
			if(!validadoTodosRequisicionCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RequisicionCompraLogicAdditional.checkRequisicionCompraToSavesAfter(requisicioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRequisicionCompras();
			
			connexion.commit();		
			
			this.quitarRequisicionComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRequisicionCompras()throws Exception {				
		 try {	
			RequisicionCompraLogicAdditional.checkRequisicionCompraToSaves(requisicioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRequisicionCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RequisicionCompra requisicioncompraLocal:requisicioncompras) {				
				if(requisicioncompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RequisicionCompraLogicAdditional.updateRequisicionCompraToSave(requisicioncompraLocal,this.arrDatoGeneral);
	        	
				RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),requisicioncompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRequisicionCompra(requisicioncompraLocal)) {				
					RequisicionCompraDataAccess.save(requisicioncompraLocal, connexion);				
				} else {
					validadoTodosRequisicionCompra=false;
				}
			}
			
			if(!validadoTodosRequisicionCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RequisicionCompraLogicAdditional.checkRequisicionCompraToSavesAfter(requisicioncompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRequisicionComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RequisicionCompraParameterReturnGeneral procesarAccionRequisicionCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RequisicionCompra> requisicioncompras,RequisicionCompraParameterReturnGeneral requisicioncompraParameterGeneral)throws Exception {
		 try {	
			RequisicionCompraParameterReturnGeneral requisicioncompraReturnGeneral=new RequisicionCompraParameterReturnGeneral();
	
			RequisicionCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,requisicioncompras,requisicioncompraParameterGeneral,requisicioncompraReturnGeneral);
			
			return requisicioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RequisicionCompraParameterReturnGeneral procesarAccionRequisicionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RequisicionCompra> requisicioncompras,RequisicionCompraParameterReturnGeneral requisicioncompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-procesarAccionRequisicionComprasWithConnection");connexion.begin();			
			
			RequisicionCompraParameterReturnGeneral requisicioncompraReturnGeneral=new RequisicionCompraParameterReturnGeneral();
	
			RequisicionCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,requisicioncompras,requisicioncompraParameterGeneral,requisicioncompraReturnGeneral);
			
			this.connexion.commit();
			
			return requisicioncompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RequisicionCompraParameterReturnGeneral procesarEventosRequisicionCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RequisicionCompra> requisicioncompras,RequisicionCompra requisicioncompra,RequisicionCompraParameterReturnGeneral requisicioncompraParameterGeneral,Boolean isEsNuevoRequisicionCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			RequisicionCompraParameterReturnGeneral requisicioncompraReturnGeneral=new RequisicionCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				requisicioncompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RequisicionCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,requisicioncompras,requisicioncompra,requisicioncompraParameterGeneral,requisicioncompraReturnGeneral,isEsNuevoRequisicionCompra,clases);
			
			return requisicioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RequisicionCompraParameterReturnGeneral procesarEventosRequisicionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RequisicionCompra> requisicioncompras,RequisicionCompra requisicioncompra,RequisicionCompraParameterReturnGeneral requisicioncompraParameterGeneral,Boolean isEsNuevoRequisicionCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-procesarEventosRequisicionComprasWithConnection");connexion.begin();			
			
			RequisicionCompraParameterReturnGeneral requisicioncompraReturnGeneral=new RequisicionCompraParameterReturnGeneral();
	
			requisicioncompraReturnGeneral.setRequisicionCompra(requisicioncompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				requisicioncompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RequisicionCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,requisicioncompras,requisicioncompra,requisicioncompraParameterGeneral,requisicioncompraReturnGeneral,isEsNuevoRequisicionCompra,clases);
			
			this.connexion.commit();
			
			return requisicioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RequisicionCompraParameterReturnGeneral procesarImportacionRequisicionComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RequisicionCompraParameterReturnGeneral requisicioncompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-procesarImportacionRequisicionComprasWithConnection");connexion.begin();			
			
			RequisicionCompraParameterReturnGeneral requisicioncompraReturnGeneral=new RequisicionCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.requisicioncompras=new ArrayList<RequisicionCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.requisicioncompra=new RequisicionCompra();
				
				
				if(conColumnasBase) {this.requisicioncompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.requisicioncompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.requisicioncompra.setnumero_secuencial(arrColumnas[iColumn++]);
				this.requisicioncompra.setresponsable(arrColumnas[iColumn++]);
				this.requisicioncompra.setsolicitado_por(arrColumnas[iColumn++]);
				this.requisicioncompra.setmotivo_solicitud(arrColumnas[iColumn++]);
				this.requisicioncompra.setarea_solicitud(arrColumnas[iColumn++]);
				this.requisicioncompra.setpara_uso_de(arrColumnas[iColumn++]);
				this.requisicioncompra.setlugar_entrega(arrColumnas[iColumn++]);
			this.requisicioncompra.setdescripcion(arrColumnas[iColumn++]);
				this.requisicioncompra.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.requisicioncompra.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.requisicioncompras.add(this.requisicioncompra);
			}
			
			this.saveRequisicionCompras();
			
			this.connexion.commit();
			
			requisicioncompraReturnGeneral.setConRetornoEstaProcesado(true);
			requisicioncompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return requisicioncompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRequisicionComprasEliminados() throws Exception {				
		
		List<RequisicionCompra> requisicioncomprasAux= new ArrayList<RequisicionCompra>();
		
		for(RequisicionCompra requisicioncompra:requisicioncompras) {
			if(!requisicioncompra.getIsDeleted()) {
				requisicioncomprasAux.add(requisicioncompra);
			}
		}
		
		requisicioncompras=requisicioncomprasAux;
	}
	
	public void quitarRequisicionComprasNulos() throws Exception {				
		
		List<RequisicionCompra> requisicioncomprasAux= new ArrayList<RequisicionCompra>();
		
		for(RequisicionCompra requisicioncompra : this.requisicioncompras) {
			if(requisicioncompra==null) {
				requisicioncomprasAux.add(requisicioncompra);
			}
		}
		
		//this.requisicioncompras=requisicioncomprasAux;
		
		this.requisicioncompras.removeAll(requisicioncomprasAux);
	}
	
	public void getSetVersionRowRequisicionCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(requisicioncompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((requisicioncompra.getIsDeleted() || (requisicioncompra.getIsChanged()&&!requisicioncompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=requisicioncompraDataAccess.getSetVersionRowRequisicionCompra(connexion,requisicioncompra.getId());
				
				if(!requisicioncompra.getVersionRow().equals(timestamp)) {	
					requisicioncompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				requisicioncompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRequisicionCompra()throws Exception {	
		
		if(requisicioncompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((requisicioncompra.getIsDeleted() || (requisicioncompra.getIsChanged()&&!requisicioncompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=requisicioncompraDataAccess.getSetVersionRowRequisicionCompra(connexion,requisicioncompra.getId());
			
			try {							
				if(!requisicioncompra.getVersionRow().equals(timestamp)) {	
					requisicioncompra.setVersionRow(timestamp);
				}
				
				requisicioncompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRequisicionComprasWithConnection()throws Exception {	
		if(requisicioncompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RequisicionCompra requisicioncompraAux:requisicioncompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(requisicioncompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(requisicioncompraAux.getIsDeleted() || (requisicioncompraAux.getIsChanged()&&!requisicioncompraAux.getIsNew())) {
						
						timestamp=requisicioncompraDataAccess.getSetVersionRowRequisicionCompra(connexion,requisicioncompraAux.getId());
						
						if(!requisicioncompra.getVersionRow().equals(timestamp)) {	
							requisicioncompraAux.setVersionRow(timestamp);
						}
								
						requisicioncompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRequisicionCompras()throws Exception {	
		if(requisicioncompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RequisicionCompra requisicioncompraAux:requisicioncompras) {
					if(requisicioncompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(requisicioncompraAux.getIsDeleted() || (requisicioncompraAux.getIsChanged()&&!requisicioncompraAux.getIsNew())) {
						
						timestamp=requisicioncompraDataAccess.getSetVersionRowRequisicionCompra(connexion,requisicioncompraAux.getId());
						
						if(!requisicioncompraAux.getVersionRow().equals(timestamp)) {	
							requisicioncompraAux.setVersionRow(timestamp);
						}
						
													
						requisicioncompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RequisicionCompraParameterReturnGeneral cargarCombosLoteForeignKeyRequisicionCompraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCliente,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEstadoRequisicionCompra,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalTipoCambio) throws Exception {
		RequisicionCompraParameterReturnGeneral  requisicioncompraReturnGeneral =new RequisicionCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyRequisicionCompraWithConnection");connexion.begin();
			
			requisicioncompraReturnGeneral =new RequisicionCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			requisicioncompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			requisicioncompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			requisicioncompraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			requisicioncompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			requisicioncompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			requisicioncompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			requisicioncompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			requisicioncompraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			requisicioncompraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			requisicioncompraReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<EstadoRequisicion> estadorequisicioncomprasForeignKey=new ArrayList<EstadoRequisicion>();
			EstadoRequisicionLogic estadorequisicioncompraLogic=new EstadoRequisicionLogic();
			estadorequisicioncompraLogic.setConnexion(this.connexion);
			estadorequisicioncompraLogic.getEstadoRequisicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoRequisicionCompra.equals("NONE")) {
				estadorequisicioncompraLogic.getTodosEstadoRequisicions(finalQueryGlobalEstadoRequisicionCompra,new Pagination());
				estadorequisicioncomprasForeignKey=estadorequisicioncompraLogic.getEstadoRequisicions();
			}

			requisicioncompraReturnGeneral.setestadorequisicioncomprasForeignKey(estadorequisicioncomprasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			requisicioncompraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			requisicioncompraReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			requisicioncompraReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return requisicioncompraReturnGeneral;
	}
	
	public RequisicionCompraParameterReturnGeneral cargarCombosLoteForeignKeyRequisicionCompra(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCliente,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEstadoRequisicionCompra,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalTipoCambio) throws Exception {
		RequisicionCompraParameterReturnGeneral  requisicioncompraReturnGeneral =new RequisicionCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			requisicioncompraReturnGeneral =new RequisicionCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			requisicioncompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			requisicioncompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			requisicioncompraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			requisicioncompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			requisicioncompraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			requisicioncompraReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			requisicioncompraReturnGeneral.setmessForeignKey(messForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			requisicioncompraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			requisicioncompraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			requisicioncompraReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<EstadoRequisicion> estadorequisicioncomprasForeignKey=new ArrayList<EstadoRequisicion>();
			EstadoRequisicionLogic estadorequisicioncompraLogic=new EstadoRequisicionLogic();
			estadorequisicioncompraLogic.setConnexion(this.connexion);
			estadorequisicioncompraLogic.getEstadoRequisicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoRequisicionCompra.equals("NONE")) {
				estadorequisicioncompraLogic.getTodosEstadoRequisicions(finalQueryGlobalEstadoRequisicionCompra,new Pagination());
				estadorequisicioncomprasForeignKey=estadorequisicioncompraLogic.getEstadoRequisicions();
			}

			requisicioncompraReturnGeneral.setestadorequisicioncomprasForeignKey(estadorequisicioncomprasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			requisicioncompraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			requisicioncompraReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			requisicioncompraReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return requisicioncompraReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyRequisicionCompraWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleRequisicionCompraLogic detallerequisicioncompraLogic=new DetalleRequisicionCompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyRequisicionCompraWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleRequisicionCompra.class));
											
			

			detallerequisicioncompraLogic.setConnexion(this.getConnexion());
			detallerequisicioncompraLogic.setDatosCliente(this.datosCliente);
			detallerequisicioncompraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(RequisicionCompra requisicioncompra:this.requisicioncompras) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleRequisicionCompraConstantesFunciones.getClassesForeignKeysOfDetalleRequisicionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallerequisicioncompraLogic.setDetalleRequisicionCompras(requisicioncompra.detallerequisicioncompras);
				detallerequisicioncompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(RequisicionCompra requisicioncompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RequisicionCompraLogicAdditional.updateRequisicionCompraToGet(requisicioncompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		requisicioncompra.setEmpresa(requisicioncompraDataAccess.getEmpresa(connexion,requisicioncompra));
		requisicioncompra.setSucursal(requisicioncompraDataAccess.getSucursal(connexion,requisicioncompra));
		requisicioncompra.setModulo(requisicioncompraDataAccess.getModulo(connexion,requisicioncompra));
		requisicioncompra.setEjercicio(requisicioncompraDataAccess.getEjercicio(connexion,requisicioncompra));
		requisicioncompra.setPeriodo(requisicioncompraDataAccess.getPeriodo(connexion,requisicioncompra));
		requisicioncompra.setAnio(requisicioncompraDataAccess.getAnio(connexion,requisicioncompra));
		requisicioncompra.setMes(requisicioncompraDataAccess.getMes(connexion,requisicioncompra));
		requisicioncompra.setCliente(requisicioncompraDataAccess.getCliente(connexion,requisicioncompra));
		requisicioncompra.setUsuario(requisicioncompraDataAccess.getUsuario(connexion,requisicioncompra));
		requisicioncompra.setMoneda(requisicioncompraDataAccess.getMoneda(connexion,requisicioncompra));
		requisicioncompra.setEstadoRequisicionCompra(requisicioncompraDataAccess.getEstadoRequisicionCompra(connexion,requisicioncompra));
		requisicioncompra.setEmpleado(requisicioncompraDataAccess.getEmpleado(connexion,requisicioncompra));
		requisicioncompra.setFormato(requisicioncompraDataAccess.getFormato(connexion,requisicioncompra));
		requisicioncompra.setTipoCambio(requisicioncompraDataAccess.getTipoCambio(connexion,requisicioncompra));
		requisicioncompra.setDetalleRequisicionCompras(requisicioncompraDataAccess.getDetalleRequisicionCompras(connexion,requisicioncompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				requisicioncompra.setEmpresa(requisicioncompraDataAccess.getEmpresa(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				requisicioncompra.setSucursal(requisicioncompraDataAccess.getSucursal(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				requisicioncompra.setModulo(requisicioncompraDataAccess.getModulo(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				requisicioncompra.setEjercicio(requisicioncompraDataAccess.getEjercicio(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				requisicioncompra.setPeriodo(requisicioncompraDataAccess.getPeriodo(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				requisicioncompra.setAnio(requisicioncompraDataAccess.getAnio(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				requisicioncompra.setMes(requisicioncompraDataAccess.getMes(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				requisicioncompra.setCliente(requisicioncompraDataAccess.getCliente(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				requisicioncompra.setUsuario(requisicioncompraDataAccess.getUsuario(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				requisicioncompra.setMoneda(requisicioncompraDataAccess.getMoneda(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(EstadoRequisicion.class)) {
				requisicioncompra.setEstadoRequisicionCompra(requisicioncompraDataAccess.getEstadoRequisicionCompra(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				requisicioncompra.setEmpleado(requisicioncompraDataAccess.getEmpleado(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				requisicioncompra.setFormato(requisicioncompraDataAccess.getFormato(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				requisicioncompra.setTipoCambio(requisicioncompraDataAccess.getTipoCambio(connexion,requisicioncompra));
				continue;
			}

			if(clas.clas.equals(DetalleRequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				requisicioncompra.setDetalleRequisicionCompras(requisicioncompraDataAccess.getDetalleRequisicionCompras(connexion,requisicioncompra));

				if(this.isConDeep) {
					DetalleRequisicionCompraLogic detallerequisicioncompraLogic= new DetalleRequisicionCompraLogic(this.connexion);
					detallerequisicioncompraLogic.setDetalleRequisicionCompras(requisicioncompra.getDetalleRequisicionCompras());
					ArrayList<Classe> classesLocal=DetalleRequisicionCompraConstantesFunciones.getClassesForeignKeysOfDetalleRequisicionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallerequisicioncompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleRequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicionCompra(detallerequisicioncompraLogic.getDetalleRequisicionCompras());
					requisicioncompra.setDetalleRequisicionCompras(detallerequisicioncompraLogic.getDetalleRequisicionCompras());
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
			requisicioncompra.setEmpresa(requisicioncompraDataAccess.getEmpresa(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setSucursal(requisicioncompraDataAccess.getSucursal(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setModulo(requisicioncompraDataAccess.getModulo(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setEjercicio(requisicioncompraDataAccess.getEjercicio(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setPeriodo(requisicioncompraDataAccess.getPeriodo(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setAnio(requisicioncompraDataAccess.getAnio(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setMes(requisicioncompraDataAccess.getMes(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setCliente(requisicioncompraDataAccess.getCliente(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setUsuario(requisicioncompraDataAccess.getUsuario(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setMoneda(requisicioncompraDataAccess.getMoneda(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoRequisicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setEstadoRequisicionCompra(requisicioncompraDataAccess.getEstadoRequisicionCompra(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setEmpleado(requisicioncompraDataAccess.getEmpleado(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setFormato(requisicioncompraDataAccess.getFormato(connexion,requisicioncompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setTipoCambio(requisicioncompraDataAccess.getTipoCambio(connexion,requisicioncompra));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleRequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleRequisicionCompra.class));
			requisicioncompra.setDetalleRequisicionCompras(requisicioncompraDataAccess.getDetalleRequisicionCompras(connexion,requisicioncompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		requisicioncompra.setEmpresa(requisicioncompraDataAccess.getEmpresa(connexion,requisicioncompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(requisicioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setSucursal(requisicioncompraDataAccess.getSucursal(connexion,requisicioncompra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(requisicioncompra.getSucursal(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setModulo(requisicioncompraDataAccess.getModulo(connexion,requisicioncompra));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(requisicioncompra.getModulo(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setEjercicio(requisicioncompraDataAccess.getEjercicio(connexion,requisicioncompra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(requisicioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setPeriodo(requisicioncompraDataAccess.getPeriodo(connexion,requisicioncompra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(requisicioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setAnio(requisicioncompraDataAccess.getAnio(connexion,requisicioncompra));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(requisicioncompra.getAnio(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setMes(requisicioncompraDataAccess.getMes(connexion,requisicioncompra));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(requisicioncompra.getMes(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setCliente(requisicioncompraDataAccess.getCliente(connexion,requisicioncompra));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(requisicioncompra.getCliente(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setUsuario(requisicioncompraDataAccess.getUsuario(connexion,requisicioncompra));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(requisicioncompra.getUsuario(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setMoneda(requisicioncompraDataAccess.getMoneda(connexion,requisicioncompra));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(requisicioncompra.getMoneda(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setEstadoRequisicionCompra(requisicioncompraDataAccess.getEstadoRequisicionCompra(connexion,requisicioncompra));
		EstadoRequisicionLogic estadorequisicioncompraLogic= new EstadoRequisicionLogic(connexion);
		estadorequisicioncompraLogic.deepLoad(requisicioncompra.getEstadoRequisicionCompra(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setEmpleado(requisicioncompraDataAccess.getEmpleado(connexion,requisicioncompra));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(requisicioncompra.getEmpleado(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setFormato(requisicioncompraDataAccess.getFormato(connexion,requisicioncompra));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(requisicioncompra.getFormato(),isDeep,deepLoadType,clases);
				
		requisicioncompra.setTipoCambio(requisicioncompraDataAccess.getTipoCambio(connexion,requisicioncompra));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(requisicioncompra.getTipoCambio(),isDeep,deepLoadType,clases);
				

		requisicioncompra.setDetalleRequisicionCompras(requisicioncompraDataAccess.getDetalleRequisicionCompras(connexion,requisicioncompra));

		for(DetalleRequisicionCompra detallerequisicioncompra:requisicioncompra.getDetalleRequisicionCompras()) {
			DetalleRequisicionCompraLogic detallerequisicioncompraLogic= new DetalleRequisicionCompraLogic(connexion);
			detallerequisicioncompraLogic.deepLoad(detallerequisicioncompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				requisicioncompra.setEmpresa(requisicioncompraDataAccess.getEmpresa(connexion,requisicioncompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(requisicioncompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				requisicioncompra.setSucursal(requisicioncompraDataAccess.getSucursal(connexion,requisicioncompra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(requisicioncompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				requisicioncompra.setModulo(requisicioncompraDataAccess.getModulo(connexion,requisicioncompra));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(requisicioncompra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				requisicioncompra.setEjercicio(requisicioncompraDataAccess.getEjercicio(connexion,requisicioncompra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(requisicioncompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				requisicioncompra.setPeriodo(requisicioncompraDataAccess.getPeriodo(connexion,requisicioncompra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(requisicioncompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				requisicioncompra.setAnio(requisicioncompraDataAccess.getAnio(connexion,requisicioncompra));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(requisicioncompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				requisicioncompra.setMes(requisicioncompraDataAccess.getMes(connexion,requisicioncompra));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(requisicioncompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				requisicioncompra.setCliente(requisicioncompraDataAccess.getCliente(connexion,requisicioncompra));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(requisicioncompra.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				requisicioncompra.setUsuario(requisicioncompraDataAccess.getUsuario(connexion,requisicioncompra));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(requisicioncompra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				requisicioncompra.setMoneda(requisicioncompraDataAccess.getMoneda(connexion,requisicioncompra));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(requisicioncompra.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoRequisicion.class)) {
				requisicioncompra.setEstadoRequisicionCompra(requisicioncompraDataAccess.getEstadoRequisicionCompra(connexion,requisicioncompra));
				EstadoRequisicionLogic estadorequisicionLogic= new EstadoRequisicionLogic(connexion);
				estadorequisicionLogic.deepLoad(requisicioncompra.getEstadoRequisicionCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				requisicioncompra.setEmpleado(requisicioncompraDataAccess.getEmpleado(connexion,requisicioncompra));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(requisicioncompra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				requisicioncompra.setFormato(requisicioncompraDataAccess.getFormato(connexion,requisicioncompra));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(requisicioncompra.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				requisicioncompra.setTipoCambio(requisicioncompraDataAccess.getTipoCambio(connexion,requisicioncompra));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(requisicioncompra.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleRequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				requisicioncompra.setDetalleRequisicionCompras(requisicioncompraDataAccess.getDetalleRequisicionCompras(connexion,requisicioncompra));

				for(DetalleRequisicionCompra detallerequisicioncompra:requisicioncompra.getDetalleRequisicionCompras()) {
					DetalleRequisicionCompraLogic detallerequisicioncompraLogic= new DetalleRequisicionCompraLogic(connexion);
					detallerequisicioncompraLogic.deepLoad(detallerequisicioncompra,isDeep,deepLoadType,clases);
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
			requisicioncompra.setEmpresa(requisicioncompraDataAccess.getEmpresa(connexion,requisicioncompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(requisicioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setSucursal(requisicioncompraDataAccess.getSucursal(connexion,requisicioncompra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(requisicioncompra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setModulo(requisicioncompraDataAccess.getModulo(connexion,requisicioncompra));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(requisicioncompra.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setEjercicio(requisicioncompraDataAccess.getEjercicio(connexion,requisicioncompra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(requisicioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setPeriodo(requisicioncompraDataAccess.getPeriodo(connexion,requisicioncompra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(requisicioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setAnio(requisicioncompraDataAccess.getAnio(connexion,requisicioncompra));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(requisicioncompra.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setMes(requisicioncompraDataAccess.getMes(connexion,requisicioncompra));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(requisicioncompra.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setCliente(requisicioncompraDataAccess.getCliente(connexion,requisicioncompra));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(requisicioncompra.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setUsuario(requisicioncompraDataAccess.getUsuario(connexion,requisicioncompra));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(requisicioncompra.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setMoneda(requisicioncompraDataAccess.getMoneda(connexion,requisicioncompra));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(requisicioncompra.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoRequisicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setEstadoRequisicionCompra(requisicioncompraDataAccess.getEstadoRequisicionCompra(connexion,requisicioncompra));
			EstadoRequisicionLogic estadorequisicionLogic= new EstadoRequisicionLogic(connexion);
			estadorequisicionLogic.deepLoad(requisicioncompra.getEstadoRequisicionCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setEmpleado(requisicioncompraDataAccess.getEmpleado(connexion,requisicioncompra));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(requisicioncompra.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setFormato(requisicioncompraDataAccess.getFormato(connexion,requisicioncompra));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(requisicioncompra.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicioncompra.setTipoCambio(requisicioncompraDataAccess.getTipoCambio(connexion,requisicioncompra));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(requisicioncompra.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleRequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleRequisicionCompra.class));
			requisicioncompra.setDetalleRequisicionCompras(requisicioncompraDataAccess.getDetalleRequisicionCompras(connexion,requisicioncompra));

			for(DetalleRequisicionCompra detallerequisicioncompra:requisicioncompra.getDetalleRequisicionCompras()) {
				DetalleRequisicionCompraLogic detallerequisicioncompraLogic= new DetalleRequisicionCompraLogic(connexion);
				detallerequisicioncompraLogic.deepLoad(detallerequisicioncompra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RequisicionCompra requisicioncompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RequisicionCompraLogicAdditional.updateRequisicionCompraToSave(requisicioncompra,this.arrDatoGeneral);
			
RequisicionCompraDataAccess.save(requisicioncompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(requisicioncompra.getEmpresa(),connexion);

		SucursalDataAccess.save(requisicioncompra.getSucursal(),connexion);

		ModuloDataAccess.save(requisicioncompra.getModulo(),connexion);

		EjercicioDataAccess.save(requisicioncompra.getEjercicio(),connexion);

		PeriodoDataAccess.save(requisicioncompra.getPeriodo(),connexion);

		AnioDataAccess.save(requisicioncompra.getAnio(),connexion);

		MesDataAccess.save(requisicioncompra.getMes(),connexion);

		ClienteDataAccess.save(requisicioncompra.getCliente(),connexion);

		UsuarioDataAccess.save(requisicioncompra.getUsuario(),connexion);

		MonedaDataAccess.save(requisicioncompra.getMoneda(),connexion);

		EstadoRequisicionDataAccess.save(requisicioncompra.getEstadoRequisicionCompra(),connexion);

		EmpleadoDataAccess.save(requisicioncompra.getEmpleado(),connexion);

		FormatoDataAccess.save(requisicioncompra.getFormato(),connexion);

		TipoCambioDataAccess.save(requisicioncompra.getTipoCambio(),connexion);

		for(DetalleRequisicionCompra detallerequisicioncompra:requisicioncompra.getDetalleRequisicionCompras()) {
			detallerequisicioncompra.setid_requisicion_compra(requisicioncompra.getId());
			DetalleRequisicionCompraDataAccess.save(detallerequisicioncompra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(requisicioncompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(requisicioncompra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(requisicioncompra.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(requisicioncompra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(requisicioncompra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(requisicioncompra.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(requisicioncompra.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(requisicioncompra.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(requisicioncompra.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(requisicioncompra.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoRequisicion.class)) {
				EstadoRequisicionDataAccess.save(requisicioncompra.getEstadoRequisicionCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(requisicioncompra.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(requisicioncompra.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(requisicioncompra.getTipoCambio(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleRequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleRequisicionCompra detallerequisicioncompra:requisicioncompra.getDetalleRequisicionCompras()) {
					detallerequisicioncompra.setid_requisicion_compra(requisicioncompra.getId());
					DetalleRequisicionCompraDataAccess.save(detallerequisicioncompra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(requisicioncompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(requisicioncompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(requisicioncompra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(requisicioncompra.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(requisicioncompra.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(requisicioncompra.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(requisicioncompra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(requisicioncompra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(requisicioncompra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(requisicioncompra.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(requisicioncompra.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(requisicioncompra.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(requisicioncompra.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(requisicioncompra.getMes(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(requisicioncompra.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(requisicioncompra.getCliente(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(requisicioncompra.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(requisicioncompra.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(requisicioncompra.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(requisicioncompra.getMoneda(),isDeep,deepLoadType,clases);
				

		EstadoRequisicionDataAccess.save(requisicioncompra.getEstadoRequisicionCompra(),connexion);
		EstadoRequisicionLogic estadorequisicioncompraLogic= new EstadoRequisicionLogic(connexion);
		estadorequisicioncompraLogic.deepLoad(requisicioncompra.getEstadoRequisicionCompra(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(requisicioncompra.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(requisicioncompra.getEmpleado(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(requisicioncompra.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(requisicioncompra.getFormato(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(requisicioncompra.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(requisicioncompra.getTipoCambio(),isDeep,deepLoadType,clases);
				

		for(DetalleRequisicionCompra detallerequisicioncompra:requisicioncompra.getDetalleRequisicionCompras()) {
			DetalleRequisicionCompraLogic detallerequisicioncompraLogic= new DetalleRequisicionCompraLogic(connexion);
			detallerequisicioncompra.setid_requisicion_compra(requisicioncompra.getId());
			DetalleRequisicionCompraDataAccess.save(detallerequisicioncompra,connexion);
			detallerequisicioncompraLogic.deepSave(detallerequisicioncompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(requisicioncompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(requisicioncompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(requisicioncompra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(requisicioncompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(requisicioncompra.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(requisicioncompra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(requisicioncompra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(requisicioncompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(requisicioncompra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(requisicioncompra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(requisicioncompra.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(requisicioncompra.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(requisicioncompra.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(requisicioncompra.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(requisicioncompra.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(requisicioncompra.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(requisicioncompra.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(requisicioncompra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(requisicioncompra.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(requisicioncompra.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoRequisicion.class)) {
				EstadoRequisicionDataAccess.save(requisicioncompra.getEstadoRequisicionCompra(),connexion);
				EstadoRequisicionLogic estadorequisicionLogic= new EstadoRequisicionLogic(connexion);
				estadorequisicionLogic.deepSave(requisicioncompra.getEstadoRequisicionCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(requisicioncompra.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(requisicioncompra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(requisicioncompra.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(requisicioncompra.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(requisicioncompra.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(requisicioncompra.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleRequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleRequisicionCompra detallerequisicioncompra:requisicioncompra.getDetalleRequisicionCompras()) {
					DetalleRequisicionCompraLogic detallerequisicioncompraLogic= new DetalleRequisicionCompraLogic(connexion);
					detallerequisicioncompra.setid_requisicion_compra(requisicioncompra.getId());
					DetalleRequisicionCompraDataAccess.save(detallerequisicioncompra,connexion);
					detallerequisicioncompraLogic.deepSave(detallerequisicioncompra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(RequisicionCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(requisicioncompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(requisicioncompra);
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
			this.deepLoad(this.requisicioncompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RequisicionCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(requisicioncompras!=null) {
				for(RequisicionCompra requisicioncompra:requisicioncompras) {
					this.deepLoad(requisicioncompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(requisicioncompras);
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
			if(requisicioncompras!=null) {
				for(RequisicionCompra requisicioncompra:requisicioncompras) {
					this.deepLoad(requisicioncompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(requisicioncompras);
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
			this.getNewConnexionToDeep(RequisicionCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(requisicioncompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RequisicionCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(requisicioncompras!=null) {
				for(RequisicionCompra requisicioncompra:requisicioncompras) {
					this.deepSave(requisicioncompra,isDeep,deepLoadType,clases);
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
			if(requisicioncompras!=null) {
				for(RequisicionCompra requisicioncompra:requisicioncompras) {
					this.deepSave(requisicioncompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRequisicionComprasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,RequisicionCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,RequisicionCompraConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,RequisicionCompraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,RequisicionCompraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,RequisicionCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,RequisicionCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,RequisicionCompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,RequisicionCompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RequisicionCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RequisicionCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdEstadoRequisicionCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_requisicion_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoRequisicionCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoRequisicionCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_requisicion_compra,RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoRequisicionCompra);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoRequisicionCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdEstadoRequisicionCompra(String sFinalQuery,Pagination pagination,Long id_estado_requisicion_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoRequisicionCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoRequisicionCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_requisicion_compra,RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoRequisicionCompra);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoRequisicionCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,RequisicionCompraConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,RequisicionCompraConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,RequisicionCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,RequisicionCompraConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,RequisicionCompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,RequisicionCompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,RequisicionCompraConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,RequisicionCompraConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,RequisicionCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,RequisicionCompraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RequisicionCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RequisicionCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,RequisicionCompraConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,RequisicionCompraConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionComprasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RequisicionCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,RequisicionCompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionComprasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,RequisicionCompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			RequisicionCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(this.requisicioncompras);
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
			if(RequisicionCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RequisicionCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RequisicionCompra requisicioncompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RequisicionCompraConstantesFunciones.ISCONAUDITORIA) {
				if(requisicioncompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RequisicionCompraDataAccess.TABLENAME, requisicioncompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RequisicionCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RequisicionCompraLogic.registrarAuditoriaDetallesRequisicionCompra(connexion,requisicioncompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(requisicioncompra.getIsDeleted()) {
					/*if(!requisicioncompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RequisicionCompraDataAccess.TABLENAME, requisicioncompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RequisicionCompraLogic.registrarAuditoriaDetallesRequisicionCompra(connexion,requisicioncompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RequisicionCompraDataAccess.TABLENAME, requisicioncompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(requisicioncompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RequisicionCompraDataAccess.TABLENAME, requisicioncompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RequisicionCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RequisicionCompraLogic.registrarAuditoriaDetallesRequisicionCompra(connexion,requisicioncompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRequisicionCompra(Connexion connexion,RequisicionCompra requisicioncompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_empresa().equals(requisicioncompra.getRequisicionCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_empresa().toString();
				}
				if(requisicioncompra.getid_empresa()!=null)
				{
					strValorNuevo=requisicioncompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_sucursal().equals(requisicioncompra.getRequisicionCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_sucursal().toString();
				}
				if(requisicioncompra.getid_sucursal()!=null)
				{
					strValorNuevo=requisicioncompra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_modulo().equals(requisicioncompra.getRequisicionCompraOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_modulo()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_modulo().toString();
				}
				if(requisicioncompra.getid_modulo()!=null)
				{
					strValorNuevo=requisicioncompra.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_ejercicio().equals(requisicioncompra.getRequisicionCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_ejercicio().toString();
				}
				if(requisicioncompra.getid_ejercicio()!=null)
				{
					strValorNuevo=requisicioncompra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_periodo().equals(requisicioncompra.getRequisicionCompraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_periodo()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_periodo().toString();
				}
				if(requisicioncompra.getid_periodo()!=null)
				{
					strValorNuevo=requisicioncompra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_anio().equals(requisicioncompra.getRequisicionCompraOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_anio()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_anio().toString();
				}
				if(requisicioncompra.getid_anio()!=null)
				{
					strValorNuevo=requisicioncompra.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_mes().equals(requisicioncompra.getRequisicionCompraOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_mes()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_mes().toString();
				}
				if(requisicioncompra.getid_mes()!=null)
				{
					strValorNuevo=requisicioncompra.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getnumero_secuencial().equals(requisicioncompra.getRequisicionCompraOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getnumero_secuencial();
				}
				if(requisicioncompra.getnumero_secuencial()!=null)
				{
					strValorNuevo=requisicioncompra.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_cliente().equals(requisicioncompra.getRequisicionCompraOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_cliente()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_cliente().toString();
				}
				if(requisicioncompra.getid_cliente()!=null)
				{
					strValorNuevo=requisicioncompra.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_usuario().equals(requisicioncompra.getRequisicionCompraOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_usuario()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_usuario().toString();
				}
				if(requisicioncompra.getid_usuario()!=null)
				{
					strValorNuevo=requisicioncompra.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_moneda().equals(requisicioncompra.getRequisicionCompraOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_moneda()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_moneda().toString();
				}
				if(requisicioncompra.getid_moneda()!=null)
				{
					strValorNuevo=requisicioncompra.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_estado_requisicion_compra().equals(requisicioncompra.getRequisicionCompraOriginal().getid_estado_requisicion_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_estado_requisicion_compra()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_estado_requisicion_compra().toString();
				}
				if(requisicioncompra.getid_estado_requisicion_compra()!=null)
				{
					strValorNuevo=requisicioncompra.getid_estado_requisicion_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.gettotal().equals(requisicioncompra.getRequisicionCompraOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().gettotal()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().gettotal().toString();
				}
				if(requisicioncompra.gettotal()!=null)
				{
					strValorNuevo=requisicioncompra.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getfecha().equals(requisicioncompra.getRequisicionCompraOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getfecha()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getfecha().toString();
				}
				if(requisicioncompra.getfecha()!=null)
				{
					strValorNuevo=requisicioncompra.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_empleado().equals(requisicioncompra.getRequisicionCompraOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_empleado()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_empleado().toString();
				}
				if(requisicioncompra.getid_empleado()!=null)
				{
					strValorNuevo=requisicioncompra.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getresponsable().equals(requisicioncompra.getRequisicionCompraOriginal().getresponsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getresponsable()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getresponsable();
				}
				if(requisicioncompra.getresponsable()!=null)
				{
					strValorNuevo=requisicioncompra.getresponsable() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.RESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getsolicitado_por().equals(requisicioncompra.getRequisicionCompraOriginal().getsolicitado_por()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getsolicitado_por()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getsolicitado_por();
				}
				if(requisicioncompra.getsolicitado_por()!=null)
				{
					strValorNuevo=requisicioncompra.getsolicitado_por() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.SOLICITADOPOR,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getmotivo_solicitud().equals(requisicioncompra.getRequisicionCompraOriginal().getmotivo_solicitud()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getmotivo_solicitud()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getmotivo_solicitud();
				}
				if(requisicioncompra.getmotivo_solicitud()!=null)
				{
					strValorNuevo=requisicioncompra.getmotivo_solicitud() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.MOTIVOSOLICITUD,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getarea_solicitud().equals(requisicioncompra.getRequisicionCompraOriginal().getarea_solicitud()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getarea_solicitud()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getarea_solicitud();
				}
				if(requisicioncompra.getarea_solicitud()!=null)
				{
					strValorNuevo=requisicioncompra.getarea_solicitud() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.AREASOLICITUD,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getpara_uso_de().equals(requisicioncompra.getRequisicionCompraOriginal().getpara_uso_de()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getpara_uso_de()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getpara_uso_de();
				}
				if(requisicioncompra.getpara_uso_de()!=null)
				{
					strValorNuevo=requisicioncompra.getpara_uso_de() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.PARAUSODE,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getlugar_entrega().equals(requisicioncompra.getRequisicionCompraOriginal().getlugar_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getlugar_entrega()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getlugar_entrega();
				}
				if(requisicioncompra.getlugar_entrega()!=null)
				{
					strValorNuevo=requisicioncompra.getlugar_entrega() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.LUGARENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getdescripcion().equals(requisicioncompra.getRequisicionCompraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getdescripcion()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getdescripcion();
				}
				if(requisicioncompra.getdescripcion()!=null)
				{
					strValorNuevo=requisicioncompra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getfecha_emision().equals(requisicioncompra.getRequisicionCompraOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getfecha_emision()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getfecha_emision().toString();
				}
				if(requisicioncompra.getfecha_emision()!=null)
				{
					strValorNuevo=requisicioncompra.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getfecha_entrega().equals(requisicioncompra.getRequisicionCompraOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getfecha_entrega()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getfecha_entrega().toString();
				}
				if(requisicioncompra.getfecha_entrega()!=null)
				{
					strValorNuevo=requisicioncompra.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_formato().equals(requisicioncompra.getRequisicionCompraOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_formato()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_formato().toString();
				}
				if(requisicioncompra.getid_formato()!=null)
				{
					strValorNuevo=requisicioncompra.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(requisicioncompra.getIsNew()||!requisicioncompra.getid_tipo_cambio().equals(requisicioncompra.getRequisicionCompraOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicioncompra.getRequisicionCompraOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=requisicioncompra.getRequisicionCompraOriginal().getid_tipo_cambio().toString();
				}
				if(requisicioncompra.getid_tipo_cambio()!=null)
				{
					strValorNuevo=requisicioncompra.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionCompraConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRequisicionCompraRelacionesWithConnection(RequisicionCompra requisicioncompra,List<DetalleRequisicionCompra> detallerequisicioncompras) throws Exception {

		if(!requisicioncompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRequisicionCompraRelacionesBase(requisicioncompra,detallerequisicioncompras,true);
		}
	}

	public void saveRequisicionCompraRelaciones(RequisicionCompra requisicioncompra,List<DetalleRequisicionCompra> detallerequisicioncompras)throws Exception {

		if(!requisicioncompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRequisicionCompraRelacionesBase(requisicioncompra,detallerequisicioncompras,false);
		}
	}

	public void saveRequisicionCompraRelacionesBase(RequisicionCompra requisicioncompra,List<DetalleRequisicionCompra> detallerequisicioncompras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RequisicionCompra-saveRelacionesWithConnection");}
	
			requisicioncompra.setDetalleRequisicionCompras(detallerequisicioncompras);

			this.setRequisicionCompra(requisicioncompra);

			if(RequisicionCompraLogicAdditional.validarSaveRelaciones(requisicioncompra,this)) {

				RequisicionCompraLogicAdditional.updateRelacionesToSave(requisicioncompra,this);

				if((requisicioncompra.getIsNew()||requisicioncompra.getIsChanged())&&!requisicioncompra.getIsDeleted()) {
					this.saveRequisicionCompra();
					this.saveRequisicionCompraRelacionesDetalles(detallerequisicioncompras);

				} else if(requisicioncompra.getIsDeleted()) {
					this.saveRequisicionCompraRelacionesDetalles(detallerequisicioncompras);
					this.saveRequisicionCompra();
				}

				RequisicionCompraLogicAdditional.updateRelacionesToSaveAfter(requisicioncompra,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleRequisicionCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleRequisicionCompras(detallerequisicioncompras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveRequisicionCompraRelacionesDetalles(List<DetalleRequisicionCompra> detallerequisicioncompras)throws Exception {
		try {
	

			Long idRequisicionCompraActual=this.getRequisicionCompra().getId();

			DetalleRequisicionCompraLogic detallerequisicioncompraLogic_Desde_RequisicionCompra=new DetalleRequisicionCompraLogic();
			detallerequisicioncompraLogic_Desde_RequisicionCompra.setDetalleRequisicionCompras(detallerequisicioncompras);

			detallerequisicioncompraLogic_Desde_RequisicionCompra.setConnexion(this.getConnexion());
			detallerequisicioncompraLogic_Desde_RequisicionCompra.setDatosCliente(this.datosCliente);

			for(DetalleRequisicionCompra detallerequisicioncompra_Desde_RequisicionCompra:detallerequisicioncompraLogic_Desde_RequisicionCompra.getDetalleRequisicionCompras()) {
				detallerequisicioncompra_Desde_RequisicionCompra.setid_requisicion_compra(idRequisicionCompraActual);
			}

			detallerequisicioncompraLogic_Desde_RequisicionCompra.saveDetalleRequisicionCompras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRequisicionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RequisicionCompraConstantesFunciones.getClassesForeignKeysOfRequisicionCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRequisicionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RequisicionCompraConstantesFunciones.getClassesRelationshipsOfRequisicionCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
