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
import com.bydan.erp.inventario.util.RecargoCompraConstantesFunciones;
import com.bydan.erp.inventario.util.RecargoCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.RecargoCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.RecargoCompra;
import com.bydan.erp.inventario.business.logic.RecargoCompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RecargoCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RecargoCompraLogic.class);
	
	protected RecargoCompraDataAccess recargocompraDataAccess; 	
	protected RecargoCompra recargocompra;
	protected List<RecargoCompra> recargocompras;
	protected Object recargocompraObject;	
	protected List<Object> recargocomprasObject;
	
	public static ClassValidator<RecargoCompra> recargocompraValidator = new ClassValidator<RecargoCompra>(RecargoCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RecargoCompraLogicAdditional recargocompraLogicAdditional=null;
	
	public RecargoCompraLogicAdditional getRecargoCompraLogicAdditional() {
		return this.recargocompraLogicAdditional;
	}
	
	public void setRecargoCompraLogicAdditional(RecargoCompraLogicAdditional recargocompraLogicAdditional) {
		try {
			this.recargocompraLogicAdditional=recargocompraLogicAdditional;
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
	
	
	
	
	public  RecargoCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.recargocompraDataAccess = new RecargoCompraDataAccess();
			
			this.recargocompras= new ArrayList<RecargoCompra>();
			this.recargocompra= new RecargoCompra();
			
			this.recargocompraObject=new Object();
			this.recargocomprasObject=new ArrayList<Object>();
				
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
			
			this.recargocompraDataAccess.setConnexionType(this.connexionType);
			this.recargocompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RecargoCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.recargocompraDataAccess = new RecargoCompraDataAccess();
			this.recargocompras= new ArrayList<RecargoCompra>();
			this.recargocompra= new RecargoCompra();
			this.recargocompraObject=new Object();
			this.recargocomprasObject=new ArrayList<Object>();
			
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
			
			this.recargocompraDataAccess.setConnexionType(this.connexionType);
			this.recargocompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RecargoCompra getRecargoCompra() throws Exception {	
		RecargoCompraLogicAdditional.checkRecargoCompraToGet(recargocompra,this.datosCliente,this.arrDatoGeneral);
		RecargoCompraLogicAdditional.updateRecargoCompraToGet(recargocompra,this.arrDatoGeneral);
		
		return recargocompra;
	}
		
	public void setRecargoCompra(RecargoCompra newRecargoCompra) {
		this.recargocompra = newRecargoCompra;
	}
	
	public RecargoCompraDataAccess getRecargoCompraDataAccess() {
		return recargocompraDataAccess;
	}
	
	public void setRecargoCompraDataAccess(RecargoCompraDataAccess newrecargocompraDataAccess) {
		this.recargocompraDataAccess = newrecargocompraDataAccess;
	}
	
	public List<RecargoCompra> getRecargoCompras() throws Exception {		
		this.quitarRecargoComprasNulos();
		
		RecargoCompraLogicAdditional.checkRecargoCompraToGets(recargocompras,this.datosCliente,this.arrDatoGeneral);
		
		for (RecargoCompra recargocompraLocal: recargocompras ) {
			RecargoCompraLogicAdditional.updateRecargoCompraToGet(recargocompraLocal,this.arrDatoGeneral);
		}
		
		return recargocompras;
	}
	
	public void setRecargoCompras(List<RecargoCompra> newRecargoCompras) {
		this.recargocompras = newRecargoCompras;
	}
	
	public Object getRecargoCompraObject() {	
		this.recargocompraObject=this.recargocompraDataAccess.getEntityObject();
		return this.recargocompraObject;
	}
		
	public void setRecargoCompraObject(Object newRecargoCompraObject) {
		this.recargocompraObject = newRecargoCompraObject;
	}
	
	public List<Object> getRecargoComprasObject() {		
		this.recargocomprasObject=this.recargocompraDataAccess.getEntitiesObject();
		return this.recargocomprasObject;
	}
		
	public void setRecargoComprasObject(List<Object> newRecargoComprasObject) {
		this.recargocomprasObject = newRecargoComprasObject;
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
		
		if(this.recargocompraDataAccess!=null) {
			this.recargocompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			recargocompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			recargocompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		recargocompra = new  RecargoCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			recargocompra=recargocompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recargocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompra);
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
		recargocompra = new  RecargoCompra();
		  		  
        try {
			
			recargocompra=recargocompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recargocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		recargocompra = new  RecargoCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			recargocompra=recargocompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recargocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompra);
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
		recargocompra = new  RecargoCompra();
		  		  
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
		recargocompra = new  RecargoCompra();
		  		  
        try {
			
			recargocompra=recargocompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recargocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		recargocompra = new  RecargoCompra();
		  		  
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
		recargocompra = new  RecargoCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =recargocompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		recargocompra = new  RecargoCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=recargocompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		recargocompra = new  RecargoCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =recargocompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		recargocompra = new  RecargoCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=recargocompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		recargocompra = new  RecargoCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =recargocompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		recargocompra = new  RecargoCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=recargocompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		recargocompras = new  ArrayList<RecargoCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompras=recargocompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRecargoCompra(recargocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
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
		recargocompras = new  ArrayList<RecargoCompra>();
		  		  
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
		recargocompras = new  ArrayList<RecargoCompra>();
		  		  
        try {			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompras=recargocompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRecargoCompra(recargocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		recargocompras = new  ArrayList<RecargoCompra>();
		  		  
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
		recargocompras = new  ArrayList<RecargoCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompras=recargocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRecargoCompra(recargocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
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
		recargocompras = new  ArrayList<RecargoCompra>();
		  		  
        try {
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompras=recargocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRecargoCompra(recargocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
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
		recargocompras = new  ArrayList<RecargoCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompras=recargocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRecargoCompra(recargocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
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
		recargocompras = new  ArrayList<RecargoCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompras=recargocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRecargoCompra(recargocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		recargocompra = new  RecargoCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompra=recargocompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRecargoCompra(recargocompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompra);
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
		recargocompra = new  RecargoCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompra=recargocompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRecargoCompra(recargocompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		recargocompras = new  ArrayList<RecargoCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompras=recargocompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRecargoCompra(recargocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
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
		recargocompras = new  ArrayList<RecargoCompra>();
		  		  
        try {
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompras=recargocompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRecargoCompra(recargocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRecargoComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		recargocompras = new  ArrayList<RecargoCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getTodosRecargoComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompras=recargocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRecargoCompra(recargocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
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
	
	public  void  getTodosRecargoCompras(String sFinalQuery,Pagination pagination)throws Exception {
		recargocompras = new  ArrayList<RecargoCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recargocompras=recargocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRecargoCompra(recargocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRecargoCompra(RecargoCompra recargocompra) throws Exception {
		Boolean estaValidado=false;
		
		if(recargocompra.getIsNew() || recargocompra.getIsChanged()) { 
			this.invalidValues = recargocompraValidator.getInvalidValues(recargocompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(recargocompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRecargoCompra(List<RecargoCompra> RecargoCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RecargoCompra recargocompraLocal:recargocompras) {				
			estaValidadoObjeto=this.validarGuardarRecargoCompra(recargocompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRecargoCompra(List<RecargoCompra> RecargoCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRecargoCompra(recargocompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRecargoCompra(RecargoCompra RecargoCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRecargoCompra(recargocompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RecargoCompra recargocompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+recargocompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RecargoCompraConstantesFunciones.getRecargoCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"recargocompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RecargoCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RecargoCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRecargoCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-saveRecargoCompraWithConnection");connexion.begin();			
			
			RecargoCompraLogicAdditional.checkRecargoCompraToSave(this.recargocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RecargoCompraLogicAdditional.updateRecargoCompraToSave(this.recargocompra,this.arrDatoGeneral);
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.recargocompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRecargoCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRecargoCompra(this.recargocompra)) {
				RecargoCompraDataAccess.save(this.recargocompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.recargocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RecargoCompraLogicAdditional.checkRecargoCompraToSaveAfter(this.recargocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRecargoCompra();
			
			connexion.commit();			
			
			if(this.recargocompra.getIsDeleted()) {
				this.recargocompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRecargoCompra()throws Exception {	
		try {	
			
			RecargoCompraLogicAdditional.checkRecargoCompraToSave(this.recargocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RecargoCompraLogicAdditional.updateRecargoCompraToSave(this.recargocompra,this.arrDatoGeneral);
			
			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.recargocompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRecargoCompra(this.recargocompra)) {			
				RecargoCompraDataAccess.save(this.recargocompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.recargocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RecargoCompraLogicAdditional.checkRecargoCompraToSaveAfter(this.recargocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.recargocompra.getIsDeleted()) {
				this.recargocompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRecargoComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-saveRecargoComprasWithConnection");connexion.begin();			
			
			RecargoCompraLogicAdditional.checkRecargoCompraToSaves(recargocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRecargoCompras();
			
			Boolean validadoTodosRecargoCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RecargoCompra recargocompraLocal:recargocompras) {		
				if(recargocompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RecargoCompraLogicAdditional.updateRecargoCompraToSave(recargocompraLocal,this.arrDatoGeneral);
	        	
				RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),recargocompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRecargoCompra(recargocompraLocal)) {
					RecargoCompraDataAccess.save(recargocompraLocal, connexion);				
				} else {
					validadoTodosRecargoCompra=false;
				}
			}
			
			if(!validadoTodosRecargoCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RecargoCompraLogicAdditional.checkRecargoCompraToSavesAfter(recargocompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRecargoCompras();
			
			connexion.commit();		
			
			this.quitarRecargoComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRecargoCompras()throws Exception {				
		 try {	
			RecargoCompraLogicAdditional.checkRecargoCompraToSaves(recargocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRecargoCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RecargoCompra recargocompraLocal:recargocompras) {				
				if(recargocompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RecargoCompraLogicAdditional.updateRecargoCompraToSave(recargocompraLocal,this.arrDatoGeneral);
	        	
				RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),recargocompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRecargoCompra(recargocompraLocal)) {				
					RecargoCompraDataAccess.save(recargocompraLocal, connexion);				
				} else {
					validadoTodosRecargoCompra=false;
				}
			}
			
			if(!validadoTodosRecargoCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RecargoCompraLogicAdditional.checkRecargoCompraToSavesAfter(recargocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRecargoComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RecargoCompraParameterReturnGeneral procesarAccionRecargoCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RecargoCompra> recargocompras,RecargoCompraParameterReturnGeneral recargocompraParameterGeneral)throws Exception {
		 try {	
			RecargoCompraParameterReturnGeneral recargocompraReturnGeneral=new RecargoCompraParameterReturnGeneral();
	
			RecargoCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,recargocompras,recargocompraParameterGeneral,recargocompraReturnGeneral);
			
			return recargocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RecargoCompraParameterReturnGeneral procesarAccionRecargoComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RecargoCompra> recargocompras,RecargoCompraParameterReturnGeneral recargocompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-procesarAccionRecargoComprasWithConnection");connexion.begin();			
			
			RecargoCompraParameterReturnGeneral recargocompraReturnGeneral=new RecargoCompraParameterReturnGeneral();
	
			RecargoCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,recargocompras,recargocompraParameterGeneral,recargocompraReturnGeneral);
			
			this.connexion.commit();
			
			return recargocompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RecargoCompraParameterReturnGeneral procesarEventosRecargoCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RecargoCompra> recargocompras,RecargoCompra recargocompra,RecargoCompraParameterReturnGeneral recargocompraParameterGeneral,Boolean isEsNuevoRecargoCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			RecargoCompraParameterReturnGeneral recargocompraReturnGeneral=new RecargoCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				recargocompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RecargoCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,recargocompras,recargocompra,recargocompraParameterGeneral,recargocompraReturnGeneral,isEsNuevoRecargoCompra,clases);
			
			return recargocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RecargoCompraParameterReturnGeneral procesarEventosRecargoComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RecargoCompra> recargocompras,RecargoCompra recargocompra,RecargoCompraParameterReturnGeneral recargocompraParameterGeneral,Boolean isEsNuevoRecargoCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-procesarEventosRecargoComprasWithConnection");connexion.begin();			
			
			RecargoCompraParameterReturnGeneral recargocompraReturnGeneral=new RecargoCompraParameterReturnGeneral();
	
			recargocompraReturnGeneral.setRecargoCompra(recargocompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				recargocompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RecargoCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,recargocompras,recargocompra,recargocompraParameterGeneral,recargocompraReturnGeneral,isEsNuevoRecargoCompra,clases);
			
			this.connexion.commit();
			
			return recargocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RecargoCompraParameterReturnGeneral procesarImportacionRecargoComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RecargoCompraParameterReturnGeneral recargocompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-procesarImportacionRecargoComprasWithConnection");connexion.begin();			
			
			RecargoCompraParameterReturnGeneral recargocompraReturnGeneral=new RecargoCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.recargocompras=new ArrayList<RecargoCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.recargocompra=new RecargoCompra();
				
				
				if(conColumnasBase) {this.recargocompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.recargocompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.recargocompra.setnombre(arrColumnas[iColumn++]);
				this.recargocompra.setes_servicio(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.recargocompras.add(this.recargocompra);
			}
			
			this.saveRecargoCompras();
			
			this.connexion.commit();
			
			recargocompraReturnGeneral.setConRetornoEstaProcesado(true);
			recargocompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return recargocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRecargoComprasEliminados() throws Exception {				
		
		List<RecargoCompra> recargocomprasAux= new ArrayList<RecargoCompra>();
		
		for(RecargoCompra recargocompra:recargocompras) {
			if(!recargocompra.getIsDeleted()) {
				recargocomprasAux.add(recargocompra);
			}
		}
		
		recargocompras=recargocomprasAux;
	}
	
	public void quitarRecargoComprasNulos() throws Exception {				
		
		List<RecargoCompra> recargocomprasAux= new ArrayList<RecargoCompra>();
		
		for(RecargoCompra recargocompra : this.recargocompras) {
			if(recargocompra==null) {
				recargocomprasAux.add(recargocompra);
			}
		}
		
		//this.recargocompras=recargocomprasAux;
		
		this.recargocompras.removeAll(recargocomprasAux);
	}
	
	public void getSetVersionRowRecargoCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(recargocompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((recargocompra.getIsDeleted() || (recargocompra.getIsChanged()&&!recargocompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=recargocompraDataAccess.getSetVersionRowRecargoCompra(connexion,recargocompra.getId());
				
				if(!recargocompra.getVersionRow().equals(timestamp)) {	
					recargocompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				recargocompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRecargoCompra()throws Exception {	
		
		if(recargocompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((recargocompra.getIsDeleted() || (recargocompra.getIsChanged()&&!recargocompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=recargocompraDataAccess.getSetVersionRowRecargoCompra(connexion,recargocompra.getId());
			
			try {							
				if(!recargocompra.getVersionRow().equals(timestamp)) {	
					recargocompra.setVersionRow(timestamp);
				}
				
				recargocompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRecargoComprasWithConnection()throws Exception {	
		if(recargocompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RecargoCompra recargocompraAux:recargocompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(recargocompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(recargocompraAux.getIsDeleted() || (recargocompraAux.getIsChanged()&&!recargocompraAux.getIsNew())) {
						
						timestamp=recargocompraDataAccess.getSetVersionRowRecargoCompra(connexion,recargocompraAux.getId());
						
						if(!recargocompra.getVersionRow().equals(timestamp)) {	
							recargocompraAux.setVersionRow(timestamp);
						}
								
						recargocompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRecargoCompras()throws Exception {	
		if(recargocompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RecargoCompra recargocompraAux:recargocompras) {
					if(recargocompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(recargocompraAux.getIsDeleted() || (recargocompraAux.getIsChanged()&&!recargocompraAux.getIsNew())) {
						
						timestamp=recargocompraDataAccess.getSetVersionRowRecargoCompra(connexion,recargocompraAux.getId());
						
						if(!recargocompraAux.getVersionRow().equals(timestamp)) {	
							recargocompraAux.setVersionRow(timestamp);
						}
						
													
						recargocompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RecargoCompraParameterReturnGeneral cargarCombosLoteForeignKeyRecargoCompraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito) throws Exception {
		RecargoCompraParameterReturnGeneral  recargocompraReturnGeneral =new RecargoCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyRecargoCompraWithConnection");connexion.begin();
			
			recargocompraReturnGeneral =new RecargoCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			recargocompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			recargocompraReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			recargocompraReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return recargocompraReturnGeneral;
	}
	
	public RecargoCompraParameterReturnGeneral cargarCombosLoteForeignKeyRecargoCompra(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito) throws Exception {
		RecargoCompraParameterReturnGeneral  recargocompraReturnGeneral =new RecargoCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			recargocompraReturnGeneral =new RecargoCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			recargocompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			recargocompraReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			recargocompraReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return recargocompraReturnGeneral;
	}
	
	
	public void deepLoad(RecargoCompra recargocompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RecargoCompraLogicAdditional.updateRecargoCompraToGet(recargocompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		recargocompra.setEmpresa(recargocompraDataAccess.getEmpresa(connexion,recargocompra));
		recargocompra.setCuentaContableDebito(recargocompraDataAccess.getCuentaContableDebito(connexion,recargocompra));
		recargocompra.setCuentaContableCredito(recargocompraDataAccess.getCuentaContableCredito(connexion,recargocompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				recargocompra.setEmpresa(recargocompraDataAccess.getEmpresa(connexion,recargocompra));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				recargocompra.setCuentaContableDebito(recargocompraDataAccess.getCuentaContableDebito(connexion,recargocompra));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				recargocompra.setCuentaContableCredito(recargocompraDataAccess.getCuentaContableCredito(connexion,recargocompra));
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
			recargocompra.setEmpresa(recargocompraDataAccess.getEmpresa(connexion,recargocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recargocompra.setCuentaContableDebito(recargocompraDataAccess.getCuentaContableDebito(connexion,recargocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recargocompra.setCuentaContableCredito(recargocompraDataAccess.getCuentaContableCredito(connexion,recargocompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		recargocompra.setEmpresa(recargocompraDataAccess.getEmpresa(connexion,recargocompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(recargocompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		recargocompra.setCuentaContableDebito(recargocompraDataAccess.getCuentaContableDebito(connexion,recargocompra));
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(recargocompra.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		recargocompra.setCuentaContableCredito(recargocompraDataAccess.getCuentaContableCredito(connexion,recargocompra));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(recargocompra.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				recargocompra.setEmpresa(recargocompraDataAccess.getEmpresa(connexion,recargocompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(recargocompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				recargocompra.setCuentaContableDebito(recargocompraDataAccess.getCuentaContableDebito(connexion,recargocompra));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(recargocompra.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				recargocompra.setCuentaContableCredito(recargocompraDataAccess.getCuentaContableCredito(connexion,recargocompra));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(recargocompra.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			recargocompra.setEmpresa(recargocompraDataAccess.getEmpresa(connexion,recargocompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(recargocompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recargocompra.setCuentaContableDebito(recargocompraDataAccess.getCuentaContableDebito(connexion,recargocompra));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(recargocompra.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recargocompra.setCuentaContableCredito(recargocompraDataAccess.getCuentaContableCredito(connexion,recargocompra));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(recargocompra.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RecargoCompra recargocompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RecargoCompraLogicAdditional.updateRecargoCompraToSave(recargocompra,this.arrDatoGeneral);
			
RecargoCompraDataAccess.save(recargocompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(recargocompra.getEmpresa(),connexion);

		CuentaContableDataAccess.save(recargocompra.getCuentaContableDebito(),connexion);

		CuentaContableDataAccess.save(recargocompra.getCuentaContableCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(recargocompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(recargocompra.getCuentaContableDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(recargocompra.getCuentaContableCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(recargocompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(recargocompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(recargocompra.getCuentaContableDebito(),connexion);
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(recargocompra.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(recargocompra.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(recargocompra.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(recargocompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(recargocompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(recargocompra.getCuentaContableDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(recargocompra.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(recargocompra.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(recargocompra.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RecargoCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(recargocompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(recargocompra);
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
			this.deepLoad(this.recargocompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RecargoCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(recargocompras!=null) {
				for(RecargoCompra recargocompra:recargocompras) {
					this.deepLoad(recargocompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(recargocompras);
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
			if(recargocompras!=null) {
				for(RecargoCompra recargocompra:recargocompras) {
					this.deepLoad(recargocompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(recargocompras);
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
			this.getNewConnexionToDeep(RecargoCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(recargocompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RecargoCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(recargocompras!=null) {
				for(RecargoCompra recargocompra:recargocompras) {
					this.deepSave(recargocompra,isDeep,deepLoadType,clases);
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
			if(recargocompras!=null) {
				for(RecargoCompra recargocompra:recargocompras) {
					this.deepSave(recargocompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRecargoComprasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",RecargoCompraConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recargocompras=recargocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRecargoComprasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",RecargoCompraConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recargocompras=recargocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRecargoComprasFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,RecargoCompraConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recargocompras=recargocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRecargoComprasFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,RecargoCompraConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recargocompras=recargocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRecargoComprasFK_IdCuentaContableDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,RecargoCompraConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recargocompras=recargocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRecargoComprasFK_IdCuentaContableDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,RecargoCompraConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recargocompras=recargocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRecargoComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RecargoCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RecargoCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recargocompras=recargocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRecargoComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RecargoCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RecargoCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recargocompras=recargocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecargoCompraConstantesFunciones.refrescarForeignKeysDescripcionesRecargoCompra(this.recargocompras);
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
			if(RecargoCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RecargoCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RecargoCompra recargocompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RecargoCompraConstantesFunciones.ISCONAUDITORIA) {
				if(recargocompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RecargoCompraDataAccess.TABLENAME, recargocompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RecargoCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RecargoCompraLogic.registrarAuditoriaDetallesRecargoCompra(connexion,recargocompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(recargocompra.getIsDeleted()) {
					/*if(!recargocompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RecargoCompraDataAccess.TABLENAME, recargocompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RecargoCompraLogic.registrarAuditoriaDetallesRecargoCompra(connexion,recargocompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RecargoCompraDataAccess.TABLENAME, recargocompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(recargocompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RecargoCompraDataAccess.TABLENAME, recargocompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RecargoCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RecargoCompraLogic.registrarAuditoriaDetallesRecargoCompra(connexion,recargocompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRecargoCompra(Connexion connexion,RecargoCompra recargocompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(recargocompra.getIsNew()||!recargocompra.getid_empresa().equals(recargocompra.getRecargoCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recargocompra.getRecargoCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=recargocompra.getRecargoCompraOriginal().getid_empresa().toString();
				}
				if(recargocompra.getid_empresa()!=null)
				{
					strValorNuevo=recargocompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecargoCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(recargocompra.getIsNew()||!recargocompra.getnombre().equals(recargocompra.getRecargoCompraOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recargocompra.getRecargoCompraOriginal().getnombre()!=null)
				{
					strValorActual=recargocompra.getRecargoCompraOriginal().getnombre();
				}
				if(recargocompra.getnombre()!=null)
				{
					strValorNuevo=recargocompra.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecargoCompraConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(recargocompra.getIsNew()||!recargocompra.getid_cuenta_contable_debito().equals(recargocompra.getRecargoCompraOriginal().getid_cuenta_contable_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recargocompra.getRecargoCompraOriginal().getid_cuenta_contable_debito()!=null)
				{
					strValorActual=recargocompra.getRecargoCompraOriginal().getid_cuenta_contable_debito().toString();
				}
				if(recargocompra.getid_cuenta_contable_debito()!=null)
				{
					strValorNuevo=recargocompra.getid_cuenta_contable_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecargoCompraConstantesFunciones.IDCUENTACONTABLEDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(recargocompra.getIsNew()||!recargocompra.getid_cuenta_contable_credito().equals(recargocompra.getRecargoCompraOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recargocompra.getRecargoCompraOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=recargocompra.getRecargoCompraOriginal().getid_cuenta_contable_credito().toString();
				}
				if(recargocompra.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=recargocompra.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecargoCompraConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(recargocompra.getIsNew()||!recargocompra.getes_servicio().equals(recargocompra.getRecargoCompraOriginal().getes_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recargocompra.getRecargoCompraOriginal().getes_servicio()!=null)
				{
					strValorActual=recargocompra.getRecargoCompraOriginal().getes_servicio().toString();
				}
				if(recargocompra.getes_servicio()!=null)
				{
					strValorNuevo=recargocompra.getes_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecargoCompraConstantesFunciones.ESSERVICIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRecargoCompraRelacionesWithConnection(RecargoCompra recargocompra) throws Exception {

		if(!recargocompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRecargoCompraRelacionesBase(recargocompra,true);
		}
	}

	public void saveRecargoCompraRelaciones(RecargoCompra recargocompra)throws Exception {

		if(!recargocompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRecargoCompraRelacionesBase(recargocompra,false);
		}
	}

	public void saveRecargoCompraRelacionesBase(RecargoCompra recargocompra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RecargoCompra-saveRelacionesWithConnection");}
	

			this.setRecargoCompra(recargocompra);

			if(RecargoCompraLogicAdditional.validarSaveRelaciones(recargocompra,this)) {

				RecargoCompraLogicAdditional.updateRelacionesToSave(recargocompra,this);

				if((recargocompra.getIsNew()||recargocompra.getIsChanged())&&!recargocompra.getIsDeleted()) {
					this.saveRecargoCompra();
					this.saveRecargoCompraRelacionesDetalles();

				} else if(recargocompra.getIsDeleted()) {
					this.saveRecargoCompraRelacionesDetalles();
					this.saveRecargoCompra();
				}

				RecargoCompraLogicAdditional.updateRelacionesToSaveAfter(recargocompra,this);

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
	
	
	private void saveRecargoCompraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRecargoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RecargoCompraConstantesFunciones.getClassesForeignKeysOfRecargoCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRecargoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RecargoCompraConstantesFunciones.getClassesRelationshipsOfRecargoCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
