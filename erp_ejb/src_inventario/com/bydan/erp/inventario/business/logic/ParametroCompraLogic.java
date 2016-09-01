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
import com.bydan.erp.inventario.util.ParametroCompraConstantesFunciones;
import com.bydan.erp.inventario.util.ParametroCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ParametroCompraParameterGeneral;
import com.bydan.erp.inventario.business.entity.ParametroCompra;
import com.bydan.erp.inventario.business.logic.ParametroCompraLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroCompraLogic.class);
	
	protected ParametroCompraDataAccess parametrocompraDataAccess; 	
	protected ParametroCompra parametrocompra;
	protected List<ParametroCompra> parametrocompras;
	protected Object parametrocompraObject;	
	protected List<Object> parametrocomprasObject;
	
	public static ClassValidator<ParametroCompra> parametrocompraValidator = new ClassValidator<ParametroCompra>(ParametroCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroCompraLogicAdditional parametrocompraLogicAdditional=null;
	
	public ParametroCompraLogicAdditional getParametroCompraLogicAdditional() {
		return this.parametrocompraLogicAdditional;
	}
	
	public void setParametroCompraLogicAdditional(ParametroCompraLogicAdditional parametrocompraLogicAdditional) {
		try {
			this.parametrocompraLogicAdditional=parametrocompraLogicAdditional;
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
	
	
	
	
	public  ParametroCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrocompraDataAccess = new ParametroCompraDataAccess();
			
			this.parametrocompras= new ArrayList<ParametroCompra>();
			this.parametrocompra= new ParametroCompra();
			
			this.parametrocompraObject=new Object();
			this.parametrocomprasObject=new ArrayList<Object>();
				
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
			
			this.parametrocompraDataAccess.setConnexionType(this.connexionType);
			this.parametrocompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrocompraDataAccess = new ParametroCompraDataAccess();
			this.parametrocompras= new ArrayList<ParametroCompra>();
			this.parametrocompra= new ParametroCompra();
			this.parametrocompraObject=new Object();
			this.parametrocomprasObject=new ArrayList<Object>();
			
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
			
			this.parametrocompraDataAccess.setConnexionType(this.connexionType);
			this.parametrocompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroCompra getParametroCompra() throws Exception {	
		ParametroCompraLogicAdditional.checkParametroCompraToGet(parametrocompra,this.datosCliente,this.arrDatoGeneral);
		ParametroCompraLogicAdditional.updateParametroCompraToGet(parametrocompra,this.arrDatoGeneral);
		
		return parametrocompra;
	}
		
	public void setParametroCompra(ParametroCompra newParametroCompra) {
		this.parametrocompra = newParametroCompra;
	}
	
	public ParametroCompraDataAccess getParametroCompraDataAccess() {
		return parametrocompraDataAccess;
	}
	
	public void setParametroCompraDataAccess(ParametroCompraDataAccess newparametrocompraDataAccess) {
		this.parametrocompraDataAccess = newparametrocompraDataAccess;
	}
	
	public List<ParametroCompra> getParametroCompras() throws Exception {		
		this.quitarParametroComprasNulos();
		
		ParametroCompraLogicAdditional.checkParametroCompraToGets(parametrocompras,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroCompra parametrocompraLocal: parametrocompras ) {
			ParametroCompraLogicAdditional.updateParametroCompraToGet(parametrocompraLocal,this.arrDatoGeneral);
		}
		
		return parametrocompras;
	}
	
	public void setParametroCompras(List<ParametroCompra> newParametroCompras) {
		this.parametrocompras = newParametroCompras;
	}
	
	public Object getParametroCompraObject() {	
		this.parametrocompraObject=this.parametrocompraDataAccess.getEntityObject();
		return this.parametrocompraObject;
	}
		
	public void setParametroCompraObject(Object newParametroCompraObject) {
		this.parametrocompraObject = newParametroCompraObject;
	}
	
	public List<Object> getParametroComprasObject() {		
		this.parametrocomprasObject=this.parametrocompraDataAccess.getEntitiesObject();
		return this.parametrocomprasObject;
	}
		
	public void setParametroComprasObject(List<Object> newParametroComprasObject) {
		this.parametrocomprasObject = newParametroComprasObject;
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
		
		if(this.parametrocompraDataAccess!=null) {
			this.parametrocompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrocompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrocompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrocompra = new  ParametroCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrocompra=parametrocompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompra);
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
		parametrocompra = new  ParametroCompra();
		  		  
        try {
			
			parametrocompra=parametrocompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrocompra = new  ParametroCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrocompra=parametrocompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompra);
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
		parametrocompra = new  ParametroCompra();
		  		  
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
		parametrocompra = new  ParametroCompra();
		  		  
        try {
			
			parametrocompra=parametrocompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrocompra = new  ParametroCompra();
		  		  
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
		parametrocompra = new  ParametroCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrocompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocompra = new  ParametroCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrocompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrocompra = new  ParametroCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrocompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocompra = new  ParametroCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrocompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrocompra = new  ParametroCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrocompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrocompra = new  ParametroCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrocompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocompras = new  ArrayList<ParametroCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompras=parametrocompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCompra(parametrocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
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
		parametrocompras = new  ArrayList<ParametroCompra>();
		  		  
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
		parametrocompras = new  ArrayList<ParametroCompra>();
		  		  
        try {			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompras=parametrocompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroCompra(parametrocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrocompras = new  ArrayList<ParametroCompra>();
		  		  
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
		parametrocompras = new  ArrayList<ParametroCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCompra(parametrocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
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
		parametrocompras = new  ArrayList<ParametroCompra>();
		  		  
        try {
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCompra(parametrocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
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
		parametrocompras = new  ArrayList<ParametroCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCompra(parametrocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
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
		parametrocompras = new  ArrayList<ParametroCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCompra(parametrocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrocompra = new  ParametroCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompra=parametrocompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCompra(parametrocompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompra);
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
		parametrocompra = new  ParametroCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompra=parametrocompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroCompra(parametrocompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocompras = new  ArrayList<ParametroCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompras=parametrocompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCompra(parametrocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
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
		parametrocompras = new  ArrayList<ParametroCompra>();
		  		  
        try {
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompras=parametrocompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroCompra(parametrocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocompras = new  ArrayList<ParametroCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getTodosParametroComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroCompra(parametrocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
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
	
	public  void  getTodosParametroCompras(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocompras = new  ArrayList<ParametroCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroCompra(parametrocompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroCompra(ParametroCompra parametrocompra) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrocompra.getIsNew() || parametrocompra.getIsChanged()) { 
			this.invalidValues = parametrocompraValidator.getInvalidValues(parametrocompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrocompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroCompra(List<ParametroCompra> ParametroCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroCompra parametrocompraLocal:parametrocompras) {				
			estaValidadoObjeto=this.validarGuardarParametroCompra(parametrocompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroCompra(List<ParametroCompra> ParametroCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroCompra(parametrocompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroCompra(ParametroCompra ParametroCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroCompra(parametrocompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroCompra parametrocompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrocompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroCompraConstantesFunciones.getParametroCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrocompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-saveParametroCompraWithConnection");connexion.begin();			
			
			ParametroCompraLogicAdditional.checkParametroCompraToSave(this.parametrocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroCompraLogicAdditional.updateParametroCompraToSave(this.parametrocompra,this.arrDatoGeneral);
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrocompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroCompra(this.parametrocompra)) {
				ParametroCompraDataAccess.save(this.parametrocompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroCompraLogicAdditional.checkParametroCompraToSaveAfter(this.parametrocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroCompra();
			
			connexion.commit();			
			
			if(this.parametrocompra.getIsDeleted()) {
				this.parametrocompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroCompra()throws Exception {	
		try {	
			
			ParametroCompraLogicAdditional.checkParametroCompraToSave(this.parametrocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroCompraLogicAdditional.updateParametroCompraToSave(this.parametrocompra,this.arrDatoGeneral);
			
			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrocompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroCompra(this.parametrocompra)) {			
				ParametroCompraDataAccess.save(this.parametrocompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrocompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroCompraLogicAdditional.checkParametroCompraToSaveAfter(this.parametrocompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrocompra.getIsDeleted()) {
				this.parametrocompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-saveParametroComprasWithConnection");connexion.begin();			
			
			ParametroCompraLogicAdditional.checkParametroCompraToSaves(parametrocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroCompras();
			
			Boolean validadoTodosParametroCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroCompra parametrocompraLocal:parametrocompras) {		
				if(parametrocompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroCompraLogicAdditional.updateParametroCompraToSave(parametrocompraLocal,this.arrDatoGeneral);
	        	
				ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroCompra(parametrocompraLocal)) {
					ParametroCompraDataAccess.save(parametrocompraLocal, connexion);				
				} else {
					validadoTodosParametroCompra=false;
				}
			}
			
			if(!validadoTodosParametroCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroCompraLogicAdditional.checkParametroCompraToSavesAfter(parametrocompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroCompras();
			
			connexion.commit();		
			
			this.quitarParametroComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroCompras()throws Exception {				
		 try {	
			ParametroCompraLogicAdditional.checkParametroCompraToSaves(parametrocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroCompra parametrocompraLocal:parametrocompras) {				
				if(parametrocompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroCompraLogicAdditional.updateParametroCompraToSave(parametrocompraLocal,this.arrDatoGeneral);
	        	
				ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroCompra(parametrocompraLocal)) {				
					ParametroCompraDataAccess.save(parametrocompraLocal, connexion);				
				} else {
					validadoTodosParametroCompra=false;
				}
			}
			
			if(!validadoTodosParametroCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroCompraLogicAdditional.checkParametroCompraToSavesAfter(parametrocompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroCompraParameterReturnGeneral procesarAccionParametroCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroCompra> parametrocompras,ParametroCompraParameterReturnGeneral parametrocompraParameterGeneral)throws Exception {
		 try {	
			ParametroCompraParameterReturnGeneral parametrocompraReturnGeneral=new ParametroCompraParameterReturnGeneral();
	
			ParametroCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocompras,parametrocompraParameterGeneral,parametrocompraReturnGeneral);
			
			return parametrocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroCompraParameterReturnGeneral procesarAccionParametroComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroCompra> parametrocompras,ParametroCompraParameterReturnGeneral parametrocompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-procesarAccionParametroComprasWithConnection");connexion.begin();			
			
			ParametroCompraParameterReturnGeneral parametrocompraReturnGeneral=new ParametroCompraParameterReturnGeneral();
	
			ParametroCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocompras,parametrocompraParameterGeneral,parametrocompraReturnGeneral);
			
			this.connexion.commit();
			
			return parametrocompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroCompraParameterReturnGeneral procesarEventosParametroCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroCompra> parametrocompras,ParametroCompra parametrocompra,ParametroCompraParameterReturnGeneral parametrocompraParameterGeneral,Boolean isEsNuevoParametroCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroCompraParameterReturnGeneral parametrocompraReturnGeneral=new ParametroCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocompras,parametrocompra,parametrocompraParameterGeneral,parametrocompraReturnGeneral,isEsNuevoParametroCompra,clases);
			
			return parametrocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroCompraParameterReturnGeneral procesarEventosParametroComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroCompra> parametrocompras,ParametroCompra parametrocompra,ParametroCompraParameterReturnGeneral parametrocompraParameterGeneral,Boolean isEsNuevoParametroCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-procesarEventosParametroComprasWithConnection");connexion.begin();			
			
			ParametroCompraParameterReturnGeneral parametrocompraReturnGeneral=new ParametroCompraParameterReturnGeneral();
	
			parametrocompraReturnGeneral.setParametroCompra(parametrocompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocompras,parametrocompra,parametrocompraParameterGeneral,parametrocompraReturnGeneral,isEsNuevoParametroCompra,clases);
			
			this.connexion.commit();
			
			return parametrocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroCompraParameterReturnGeneral procesarImportacionParametroComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroCompraParameterReturnGeneral parametrocompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-procesarImportacionParametroComprasWithConnection");connexion.begin();			
			
			ParametroCompraParameterReturnGeneral parametrocompraReturnGeneral=new ParametroCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrocompras=new ArrayList<ParametroCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrocompra=new ParametroCompra();
				
				
				if(conColumnasBase) {this.parametrocompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrocompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrocompra.setsecuencial_pedido(arrColumnas[iColumn++]);
				this.parametrocompra.setsecuencial_cotizacion(arrColumnas[iColumn++]);
				this.parametrocompra.setsecuencial_produccion(arrColumnas[iColumn++]);
				this.parametrocompra.setcon_centro_costo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrocompra.settexto_mail(arrColumnas[iColumn++]);
				this.parametrocompra.setdescripcion(arrColumnas[iColumn++]);
				
				this.parametrocompras.add(this.parametrocompra);
			}
			
			this.saveParametroCompras();
			
			this.connexion.commit();
			
			parametrocompraReturnGeneral.setConRetornoEstaProcesado(true);
			parametrocompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrocompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroComprasEliminados() throws Exception {				
		
		List<ParametroCompra> parametrocomprasAux= new ArrayList<ParametroCompra>();
		
		for(ParametroCompra parametrocompra:parametrocompras) {
			if(!parametrocompra.getIsDeleted()) {
				parametrocomprasAux.add(parametrocompra);
			}
		}
		
		parametrocompras=parametrocomprasAux;
	}
	
	public void quitarParametroComprasNulos() throws Exception {				
		
		List<ParametroCompra> parametrocomprasAux= new ArrayList<ParametroCompra>();
		
		for(ParametroCompra parametrocompra : this.parametrocompras) {
			if(parametrocompra==null) {
				parametrocomprasAux.add(parametrocompra);
			}
		}
		
		//this.parametrocompras=parametrocomprasAux;
		
		this.parametrocompras.removeAll(parametrocomprasAux);
	}
	
	public void getSetVersionRowParametroCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrocompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrocompra.getIsDeleted() || (parametrocompra.getIsChanged()&&!parametrocompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrocompraDataAccess.getSetVersionRowParametroCompra(connexion,parametrocompra.getId());
				
				if(!parametrocompra.getVersionRow().equals(timestamp)) {	
					parametrocompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrocompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroCompra()throws Exception {	
		
		if(parametrocompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrocompra.getIsDeleted() || (parametrocompra.getIsChanged()&&!parametrocompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrocompraDataAccess.getSetVersionRowParametroCompra(connexion,parametrocompra.getId());
			
			try {							
				if(!parametrocompra.getVersionRow().equals(timestamp)) {	
					parametrocompra.setVersionRow(timestamp);
				}
				
				parametrocompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroComprasWithConnection()throws Exception {	
		if(parametrocompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroCompra parametrocompraAux:parametrocompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrocompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocompraAux.getIsDeleted() || (parametrocompraAux.getIsChanged()&&!parametrocompraAux.getIsNew())) {
						
						timestamp=parametrocompraDataAccess.getSetVersionRowParametroCompra(connexion,parametrocompraAux.getId());
						
						if(!parametrocompra.getVersionRow().equals(timestamp)) {	
							parametrocompraAux.setVersionRow(timestamp);
						}
								
						parametrocompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroCompras()throws Exception {	
		if(parametrocompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroCompra parametrocompraAux:parametrocompras) {
					if(parametrocompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocompraAux.getIsDeleted() || (parametrocompraAux.getIsChanged()&&!parametrocompraAux.getIsNew())) {
						
						timestamp=parametrocompraDataAccess.getSetVersionRowParametroCompra(connexion,parametrocompraAux.getId());
						
						if(!parametrocompraAux.getVersionRow().equals(timestamp)) {	
							parametrocompraAux.setVersionRow(timestamp);
						}
						
													
						parametrocompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroCompraParameterReturnGeneral cargarCombosLoteForeignKeyParametroCompraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoDocumento,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalBodega,String finalQueryGlobalBodegaReserva,String finalQueryGlobalEmpleado,String finalQueryGlobalEmbarcador,String finalQueryGlobalModulo,String finalQueryGlobalTipoMovimientoModulo,String finalQueryGlobalFormatoPedido,String finalQueryGlobalEstadoPedidoPendiente,String finalQueryGlobalFormatoCotizacion,String finalQueryGlobalEstadoPedidoCotizado,String finalQueryGlobalFormatoAutorizacion,String finalQueryGlobalEstadoPedidoAutorizado,String finalQueryGlobalFormatoItem,String finalQueryGlobalEstadoPedidoAnulado,String finalQueryGlobalPrioridadPedido,String finalQueryGlobalEstadoPedidoSuspendido,String finalQueryGlobalEstadoPedidoRegularizado) throws Exception {
		ParametroCompraParameterReturnGeneral  parametrocompraReturnGeneral =new ParametroCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroCompraWithConnection");connexion.begin();
			
			parametrocompraReturnGeneral =new ParametroCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrocompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			parametrocompraReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			parametrocompraReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametrocompraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Bodega> bodegareservasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegareservaLogic=new BodegaLogic();
			bodegareservaLogic.setConnexion(this.connexion);
			bodegareservaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaReserva.equals("NONE")) {
				bodegareservaLogic.getTodosBodegas(finalQueryGlobalBodegaReserva,new Pagination());
				bodegareservasForeignKey=bodegareservaLogic.getBodegas();
			}

			parametrocompraReturnGeneral.setbodegareservasForeignKey(bodegareservasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			parametrocompraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Embarcador> embarcadorsForeignKey=new ArrayList<Embarcador>();
			EmbarcadorLogic embarcadorLogic=new EmbarcadorLogic();
			embarcadorLogic.setConnexion(this.connexion);
			embarcadorLogic.getEmbarcadorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmbarcador.equals("NONE")) {
				embarcadorLogic.getTodosEmbarcadors(finalQueryGlobalEmbarcador,new Pagination());
				embarcadorsForeignKey=embarcadorLogic.getEmbarcadors();
			}

			parametrocompraReturnGeneral.setembarcadorsForeignKey(embarcadorsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			parametrocompraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			parametrocompraReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);


			List<Formato> formatopedidosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatopedidoLogic=new FormatoLogic();
			formatopedidoLogic.setConnexion(this.connexion);
			formatopedidoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoPedido.equals("NONE")) {
				formatopedidoLogic.getTodosFormatos(finalQueryGlobalFormatoPedido,new Pagination());
				formatopedidosForeignKey=formatopedidoLogic.getFormatos();
			}

			parametrocompraReturnGeneral.setformatopedidosForeignKey(formatopedidosForeignKey);


			List<EstadoPedido> estadopedidopendientesForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidopendienteLogic=new EstadoPedidoLogic();
			estadopedidopendienteLogic.setConnexion(this.connexion);
			estadopedidopendienteLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoPendiente.equals("NONE")) {
				estadopedidopendienteLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoPendiente,new Pagination());
				estadopedidopendientesForeignKey=estadopedidopendienteLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidopendientesForeignKey(estadopedidopendientesForeignKey);


			List<Formato> formatocotizacionsForeignKey=new ArrayList<Formato>();
			FormatoLogic formatocotizacionLogic=new FormatoLogic();
			formatocotizacionLogic.setConnexion(this.connexion);
			formatocotizacionLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoCotizacion.equals("NONE")) {
				formatocotizacionLogic.getTodosFormatos(finalQueryGlobalFormatoCotizacion,new Pagination());
				formatocotizacionsForeignKey=formatocotizacionLogic.getFormatos();
			}

			parametrocompraReturnGeneral.setformatocotizacionsForeignKey(formatocotizacionsForeignKey);


			List<EstadoPedido> estadopedidocotizadosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidocotizadoLogic=new EstadoPedidoLogic();
			estadopedidocotizadoLogic.setConnexion(this.connexion);
			estadopedidocotizadoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoCotizado.equals("NONE")) {
				estadopedidocotizadoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoCotizado,new Pagination());
				estadopedidocotizadosForeignKey=estadopedidocotizadoLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidocotizadosForeignKey(estadopedidocotizadosForeignKey);


			List<Formato> formatoautorizacionsForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoautorizacionLogic=new FormatoLogic();
			formatoautorizacionLogic.setConnexion(this.connexion);
			formatoautorizacionLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoAutorizacion.equals("NONE")) {
				formatoautorizacionLogic.getTodosFormatos(finalQueryGlobalFormatoAutorizacion,new Pagination());
				formatoautorizacionsForeignKey=formatoautorizacionLogic.getFormatos();
			}

			parametrocompraReturnGeneral.setformatoautorizacionsForeignKey(formatoautorizacionsForeignKey);


			List<EstadoPedido> estadopedidoautorizadosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoautorizadoLogic=new EstadoPedidoLogic();
			estadopedidoautorizadoLogic.setConnexion(this.connexion);
			estadopedidoautorizadoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoAutorizado.equals("NONE")) {
				estadopedidoautorizadoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoAutorizado,new Pagination());
				estadopedidoautorizadosForeignKey=estadopedidoautorizadoLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidoautorizadosForeignKey(estadopedidoautorizadosForeignKey);


			List<Formato> formatoitemsForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoitemLogic=new FormatoLogic();
			formatoitemLogic.setConnexion(this.connexion);
			formatoitemLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoItem.equals("NONE")) {
				formatoitemLogic.getTodosFormatos(finalQueryGlobalFormatoItem,new Pagination());
				formatoitemsForeignKey=formatoitemLogic.getFormatos();
			}

			parametrocompraReturnGeneral.setformatoitemsForeignKey(formatoitemsForeignKey);


			List<EstadoPedido> estadopedidoanuladosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoanuladoLogic=new EstadoPedidoLogic();
			estadopedidoanuladoLogic.setConnexion(this.connexion);
			estadopedidoanuladoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoAnulado.equals("NONE")) {
				estadopedidoanuladoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoAnulado,new Pagination());
				estadopedidoanuladosForeignKey=estadopedidoanuladoLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidoanuladosForeignKey(estadopedidoanuladosForeignKey);


			List<PrioridadPedido> prioridadpedidosForeignKey=new ArrayList<PrioridadPedido>();
			PrioridadPedidoLogic prioridadpedidoLogic=new PrioridadPedidoLogic();
			prioridadpedidoLogic.setConnexion(this.connexion);
			prioridadpedidoLogic.getPrioridadPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPrioridadPedido.equals("NONE")) {
				prioridadpedidoLogic.getTodosPrioridadPedidos(finalQueryGlobalPrioridadPedido,new Pagination());
				prioridadpedidosForeignKey=prioridadpedidoLogic.getPrioridadPedidos();
			}

			parametrocompraReturnGeneral.setprioridadpedidosForeignKey(prioridadpedidosForeignKey);


			List<EstadoPedido> estadopedidosuspendidosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidosuspendidoLogic=new EstadoPedidoLogic();
			estadopedidosuspendidoLogic.setConnexion(this.connexion);
			estadopedidosuspendidoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoSuspendido.equals("NONE")) {
				estadopedidosuspendidoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoSuspendido,new Pagination());
				estadopedidosuspendidosForeignKey=estadopedidosuspendidoLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidosuspendidosForeignKey(estadopedidosuspendidosForeignKey);


			List<EstadoPedido> estadopedidoregularizadosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoregularizadoLogic=new EstadoPedidoLogic();
			estadopedidoregularizadoLogic.setConnexion(this.connexion);
			estadopedidoregularizadoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoRegularizado.equals("NONE")) {
				estadopedidoregularizadoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoRegularizado,new Pagination());
				estadopedidoregularizadosForeignKey=estadopedidoregularizadoLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidoregularizadosForeignKey(estadopedidoregularizadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrocompraReturnGeneral;
	}
	
	public ParametroCompraParameterReturnGeneral cargarCombosLoteForeignKeyParametroCompra(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoDocumento,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalBodega,String finalQueryGlobalBodegaReserva,String finalQueryGlobalEmpleado,String finalQueryGlobalEmbarcador,String finalQueryGlobalModulo,String finalQueryGlobalTipoMovimientoModulo,String finalQueryGlobalFormatoPedido,String finalQueryGlobalEstadoPedidoPendiente,String finalQueryGlobalFormatoCotizacion,String finalQueryGlobalEstadoPedidoCotizado,String finalQueryGlobalFormatoAutorizacion,String finalQueryGlobalEstadoPedidoAutorizado,String finalQueryGlobalFormatoItem,String finalQueryGlobalEstadoPedidoAnulado,String finalQueryGlobalPrioridadPedido,String finalQueryGlobalEstadoPedidoSuspendido,String finalQueryGlobalEstadoPedidoRegularizado) throws Exception {
		ParametroCompraParameterReturnGeneral  parametrocompraReturnGeneral =new ParametroCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrocompraReturnGeneral =new ParametroCompraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrocompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			parametrocompraReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			parametrocompraReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			parametrocompraReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Bodega> bodegareservasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegareservaLogic=new BodegaLogic();
			bodegareservaLogic.setConnexion(this.connexion);
			bodegareservaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaReserva.equals("NONE")) {
				bodegareservaLogic.getTodosBodegas(finalQueryGlobalBodegaReserva,new Pagination());
				bodegareservasForeignKey=bodegareservaLogic.getBodegas();
			}

			parametrocompraReturnGeneral.setbodegareservasForeignKey(bodegareservasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			parametrocompraReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Embarcador> embarcadorsForeignKey=new ArrayList<Embarcador>();
			EmbarcadorLogic embarcadorLogic=new EmbarcadorLogic();
			embarcadorLogic.setConnexion(this.connexion);
			embarcadorLogic.getEmbarcadorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmbarcador.equals("NONE")) {
				embarcadorLogic.getTodosEmbarcadors(finalQueryGlobalEmbarcador,new Pagination());
				embarcadorsForeignKey=embarcadorLogic.getEmbarcadors();
			}

			parametrocompraReturnGeneral.setembarcadorsForeignKey(embarcadorsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			parametrocompraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			parametrocompraReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);


			List<Formato> formatopedidosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatopedidoLogic=new FormatoLogic();
			formatopedidoLogic.setConnexion(this.connexion);
			formatopedidoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoPedido.equals("NONE")) {
				formatopedidoLogic.getTodosFormatos(finalQueryGlobalFormatoPedido,new Pagination());
				formatopedidosForeignKey=formatopedidoLogic.getFormatos();
			}

			parametrocompraReturnGeneral.setformatopedidosForeignKey(formatopedidosForeignKey);


			List<EstadoPedido> estadopedidopendientesForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidopendienteLogic=new EstadoPedidoLogic();
			estadopedidopendienteLogic.setConnexion(this.connexion);
			estadopedidopendienteLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoPendiente.equals("NONE")) {
				estadopedidopendienteLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoPendiente,new Pagination());
				estadopedidopendientesForeignKey=estadopedidopendienteLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidopendientesForeignKey(estadopedidopendientesForeignKey);


			List<Formato> formatocotizacionsForeignKey=new ArrayList<Formato>();
			FormatoLogic formatocotizacionLogic=new FormatoLogic();
			formatocotizacionLogic.setConnexion(this.connexion);
			formatocotizacionLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoCotizacion.equals("NONE")) {
				formatocotizacionLogic.getTodosFormatos(finalQueryGlobalFormatoCotizacion,new Pagination());
				formatocotizacionsForeignKey=formatocotizacionLogic.getFormatos();
			}

			parametrocompraReturnGeneral.setformatocotizacionsForeignKey(formatocotizacionsForeignKey);


			List<EstadoPedido> estadopedidocotizadosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidocotizadoLogic=new EstadoPedidoLogic();
			estadopedidocotizadoLogic.setConnexion(this.connexion);
			estadopedidocotizadoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoCotizado.equals("NONE")) {
				estadopedidocotizadoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoCotizado,new Pagination());
				estadopedidocotizadosForeignKey=estadopedidocotizadoLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidocotizadosForeignKey(estadopedidocotizadosForeignKey);


			List<Formato> formatoautorizacionsForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoautorizacionLogic=new FormatoLogic();
			formatoautorizacionLogic.setConnexion(this.connexion);
			formatoautorizacionLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoAutorizacion.equals("NONE")) {
				formatoautorizacionLogic.getTodosFormatos(finalQueryGlobalFormatoAutorizacion,new Pagination());
				formatoautorizacionsForeignKey=formatoautorizacionLogic.getFormatos();
			}

			parametrocompraReturnGeneral.setformatoautorizacionsForeignKey(formatoautorizacionsForeignKey);


			List<EstadoPedido> estadopedidoautorizadosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoautorizadoLogic=new EstadoPedidoLogic();
			estadopedidoautorizadoLogic.setConnexion(this.connexion);
			estadopedidoautorizadoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoAutorizado.equals("NONE")) {
				estadopedidoautorizadoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoAutorizado,new Pagination());
				estadopedidoautorizadosForeignKey=estadopedidoautorizadoLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidoautorizadosForeignKey(estadopedidoautorizadosForeignKey);


			List<Formato> formatoitemsForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoitemLogic=new FormatoLogic();
			formatoitemLogic.setConnexion(this.connexion);
			formatoitemLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoItem.equals("NONE")) {
				formatoitemLogic.getTodosFormatos(finalQueryGlobalFormatoItem,new Pagination());
				formatoitemsForeignKey=formatoitemLogic.getFormatos();
			}

			parametrocompraReturnGeneral.setformatoitemsForeignKey(formatoitemsForeignKey);


			List<EstadoPedido> estadopedidoanuladosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoanuladoLogic=new EstadoPedidoLogic();
			estadopedidoanuladoLogic.setConnexion(this.connexion);
			estadopedidoanuladoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoAnulado.equals("NONE")) {
				estadopedidoanuladoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoAnulado,new Pagination());
				estadopedidoanuladosForeignKey=estadopedidoanuladoLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidoanuladosForeignKey(estadopedidoanuladosForeignKey);


			List<PrioridadPedido> prioridadpedidosForeignKey=new ArrayList<PrioridadPedido>();
			PrioridadPedidoLogic prioridadpedidoLogic=new PrioridadPedidoLogic();
			prioridadpedidoLogic.setConnexion(this.connexion);
			prioridadpedidoLogic.getPrioridadPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPrioridadPedido.equals("NONE")) {
				prioridadpedidoLogic.getTodosPrioridadPedidos(finalQueryGlobalPrioridadPedido,new Pagination());
				prioridadpedidosForeignKey=prioridadpedidoLogic.getPrioridadPedidos();
			}

			parametrocompraReturnGeneral.setprioridadpedidosForeignKey(prioridadpedidosForeignKey);


			List<EstadoPedido> estadopedidosuspendidosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidosuspendidoLogic=new EstadoPedidoLogic();
			estadopedidosuspendidoLogic.setConnexion(this.connexion);
			estadopedidosuspendidoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoSuspendido.equals("NONE")) {
				estadopedidosuspendidoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoSuspendido,new Pagination());
				estadopedidosuspendidosForeignKey=estadopedidosuspendidoLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidosuspendidosForeignKey(estadopedidosuspendidosForeignKey);


			List<EstadoPedido> estadopedidoregularizadosForeignKey=new ArrayList<EstadoPedido>();
			EstadoPedidoLogic estadopedidoregularizadoLogic=new EstadoPedidoLogic();
			estadopedidoregularizadoLogic.setConnexion(this.connexion);
			estadopedidoregularizadoLogic.getEstadoPedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPedidoRegularizado.equals("NONE")) {
				estadopedidoregularizadoLogic.getTodosEstadoPedidos(finalQueryGlobalEstadoPedidoRegularizado,new Pagination());
				estadopedidoregularizadosForeignKey=estadopedidoregularizadoLogic.getEstadoPedidos();
			}

			parametrocompraReturnGeneral.setestadopedidoregularizadosForeignKey(estadopedidoregularizadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrocompraReturnGeneral;
	}
	
	
	public void deepLoad(ParametroCompra parametrocompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroCompraLogicAdditional.updateParametroCompraToGet(parametrocompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrocompra.setEmpresa(parametrocompraDataAccess.getEmpresa(connexion,parametrocompra));
		parametrocompra.setTipoDocumento(parametrocompraDataAccess.getTipoDocumento(connexion,parametrocompra));
		parametrocompra.setTipoMovimiento(parametrocompraDataAccess.getTipoMovimiento(connexion,parametrocompra));
		parametrocompra.setBodega(parametrocompraDataAccess.getBodega(connexion,parametrocompra));
		parametrocompra.setBodegaReserva(parametrocompraDataAccess.getBodegaReserva(connexion,parametrocompra));
		parametrocompra.setEmpleado(parametrocompraDataAccess.getEmpleado(connexion,parametrocompra));
		parametrocompra.setEmbarcador(parametrocompraDataAccess.getEmbarcador(connexion,parametrocompra));
		parametrocompra.setModulo(parametrocompraDataAccess.getModulo(connexion,parametrocompra));
		parametrocompra.setTipoMovimientoModulo(parametrocompraDataAccess.getTipoMovimientoModulo(connexion,parametrocompra));
		parametrocompra.setFormatoPedido(parametrocompraDataAccess.getFormatoPedido(connexion,parametrocompra));
		parametrocompra.setEstadoPedidoPendiente(parametrocompraDataAccess.getEstadoPedidoPendiente(connexion,parametrocompra));
		parametrocompra.setFormatoCotizacion(parametrocompraDataAccess.getFormatoCotizacion(connexion,parametrocompra));
		parametrocompra.setEstadoPedidoCotizado(parametrocompraDataAccess.getEstadoPedidoCotizado(connexion,parametrocompra));
		parametrocompra.setFormatoAutorizacion(parametrocompraDataAccess.getFormatoAutorizacion(connexion,parametrocompra));
		parametrocompra.setEstadoPedidoAutorizado(parametrocompraDataAccess.getEstadoPedidoAutorizado(connexion,parametrocompra));
		parametrocompra.setFormatoItem(parametrocompraDataAccess.getFormatoItem(connexion,parametrocompra));
		parametrocompra.setEstadoPedidoAnulado(parametrocompraDataAccess.getEstadoPedidoAnulado(connexion,parametrocompra));
		parametrocompra.setPrioridadPedido(parametrocompraDataAccess.getPrioridadPedido(connexion,parametrocompra));
		parametrocompra.setEstadoPedidoSuspendido(parametrocompraDataAccess.getEstadoPedidoSuspendido(connexion,parametrocompra));
		parametrocompra.setEstadoPedidoRegularizado(parametrocompraDataAccess.getEstadoPedidoRegularizado(connexion,parametrocompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrocompra.setEmpresa(parametrocompraDataAccess.getEmpresa(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				parametrocompra.setTipoDocumento(parametrocompraDataAccess.getTipoDocumento(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				parametrocompra.setTipoMovimiento(parametrocompraDataAccess.getTipoMovimiento(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrocompra.setBodega(parametrocompraDataAccess.getBodega(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrocompra.setBodegaReserva(parametrocompraDataAccess.getBodegaReserva(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				parametrocompra.setEmpleado(parametrocompraDataAccess.getEmpleado(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(Embarcador.class)) {
				parametrocompra.setEmbarcador(parametrocompraDataAccess.getEmbarcador(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				parametrocompra.setModulo(parametrocompraDataAccess.getModulo(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				parametrocompra.setTipoMovimientoModulo(parametrocompraDataAccess.getTipoMovimientoModulo(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrocompra.setFormatoPedido(parametrocompraDataAccess.getFormatoPedido(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoPendiente(parametrocompraDataAccess.getEstadoPedidoPendiente(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrocompra.setFormatoCotizacion(parametrocompraDataAccess.getFormatoCotizacion(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoCotizado(parametrocompraDataAccess.getEstadoPedidoCotizado(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrocompra.setFormatoAutorizacion(parametrocompraDataAccess.getFormatoAutorizacion(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoAutorizado(parametrocompraDataAccess.getEstadoPedidoAutorizado(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrocompra.setFormatoItem(parametrocompraDataAccess.getFormatoItem(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoAnulado(parametrocompraDataAccess.getEstadoPedidoAnulado(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(PrioridadPedido.class)) {
				parametrocompra.setPrioridadPedido(parametrocompraDataAccess.getPrioridadPedido(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoSuspendido(parametrocompraDataAccess.getEstadoPedidoSuspendido(connexion,parametrocompra));
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoRegularizado(parametrocompraDataAccess.getEstadoPedidoRegularizado(connexion,parametrocompra));
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
			parametrocompra.setEmpresa(parametrocompraDataAccess.getEmpresa(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setTipoDocumento(parametrocompraDataAccess.getTipoDocumento(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setTipoMovimiento(parametrocompraDataAccess.getTipoMovimiento(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setBodega(parametrocompraDataAccess.getBodega(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setBodegaReserva(parametrocompraDataAccess.getBodegaReserva(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEmpleado(parametrocompraDataAccess.getEmpleado(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Embarcador.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEmbarcador(parametrocompraDataAccess.getEmbarcador(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setModulo(parametrocompraDataAccess.getModulo(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setTipoMovimientoModulo(parametrocompraDataAccess.getTipoMovimientoModulo(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setFormatoPedido(parametrocompraDataAccess.getFormatoPedido(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoPendiente(parametrocompraDataAccess.getEstadoPedidoPendiente(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setFormatoCotizacion(parametrocompraDataAccess.getFormatoCotizacion(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoCotizado(parametrocompraDataAccess.getEstadoPedidoCotizado(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setFormatoAutorizacion(parametrocompraDataAccess.getFormatoAutorizacion(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoAutorizado(parametrocompraDataAccess.getEstadoPedidoAutorizado(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setFormatoItem(parametrocompraDataAccess.getFormatoItem(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoAnulado(parametrocompraDataAccess.getEstadoPedidoAnulado(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PrioridadPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setPrioridadPedido(parametrocompraDataAccess.getPrioridadPedido(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoSuspendido(parametrocompraDataAccess.getEstadoPedidoSuspendido(connexion,parametrocompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoRegularizado(parametrocompraDataAccess.getEstadoPedidoRegularizado(connexion,parametrocompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrocompra.setEmpresa(parametrocompraDataAccess.getEmpresa(connexion,parametrocompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrocompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrocompra.setTipoDocumento(parametrocompraDataAccess.getTipoDocumento(connexion,parametrocompra));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(parametrocompra.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		parametrocompra.setTipoMovimiento(parametrocompraDataAccess.getTipoMovimiento(connexion,parametrocompra));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(parametrocompra.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		parametrocompra.setBodega(parametrocompraDataAccess.getBodega(connexion,parametrocompra));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametrocompra.getBodega(),isDeep,deepLoadType,clases);
				
		parametrocompra.setBodegaReserva(parametrocompraDataAccess.getBodegaReserva(connexion,parametrocompra));
		BodegaLogic bodegareservaLogic= new BodegaLogic(connexion);
		bodegareservaLogic.deepLoad(parametrocompra.getBodegaReserva(),isDeep,deepLoadType,clases);
				
		parametrocompra.setEmpleado(parametrocompraDataAccess.getEmpleado(connexion,parametrocompra));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(parametrocompra.getEmpleado(),isDeep,deepLoadType,clases);
				
		parametrocompra.setEmbarcador(parametrocompraDataAccess.getEmbarcador(connexion,parametrocompra));
		EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
		embarcadorLogic.deepLoad(parametrocompra.getEmbarcador(),isDeep,deepLoadType,clases);
				
		parametrocompra.setModulo(parametrocompraDataAccess.getModulo(connexion,parametrocompra));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(parametrocompra.getModulo(),isDeep,deepLoadType,clases);
				
		parametrocompra.setTipoMovimientoModulo(parametrocompraDataAccess.getTipoMovimientoModulo(connexion,parametrocompra));
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(parametrocompra.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		parametrocompra.setFormatoPedido(parametrocompraDataAccess.getFormatoPedido(connexion,parametrocompra));
		FormatoLogic formatopedidoLogic= new FormatoLogic(connexion);
		formatopedidoLogic.deepLoad(parametrocompra.getFormatoPedido(),isDeep,deepLoadType,clases);
				
		parametrocompra.setEstadoPedidoPendiente(parametrocompraDataAccess.getEstadoPedidoPendiente(connexion,parametrocompra));
		EstadoPedidoLogic estadopedidopendienteLogic= new EstadoPedidoLogic(connexion);
		estadopedidopendienteLogic.deepLoad(parametrocompra.getEstadoPedidoPendiente(),isDeep,deepLoadType,clases);
				
		parametrocompra.setFormatoCotizacion(parametrocompraDataAccess.getFormatoCotizacion(connexion,parametrocompra));
		FormatoLogic formatocotizacionLogic= new FormatoLogic(connexion);
		formatocotizacionLogic.deepLoad(parametrocompra.getFormatoCotizacion(),isDeep,deepLoadType,clases);
				
		parametrocompra.setEstadoPedidoCotizado(parametrocompraDataAccess.getEstadoPedidoCotizado(connexion,parametrocompra));
		EstadoPedidoLogic estadopedidocotizadoLogic= new EstadoPedidoLogic(connexion);
		estadopedidocotizadoLogic.deepLoad(parametrocompra.getEstadoPedidoCotizado(),isDeep,deepLoadType,clases);
				
		parametrocompra.setFormatoAutorizacion(parametrocompraDataAccess.getFormatoAutorizacion(connexion,parametrocompra));
		FormatoLogic formatoautorizacionLogic= new FormatoLogic(connexion);
		formatoautorizacionLogic.deepLoad(parametrocompra.getFormatoAutorizacion(),isDeep,deepLoadType,clases);
				
		parametrocompra.setEstadoPedidoAutorizado(parametrocompraDataAccess.getEstadoPedidoAutorizado(connexion,parametrocompra));
		EstadoPedidoLogic estadopedidoautorizadoLogic= new EstadoPedidoLogic(connexion);
		estadopedidoautorizadoLogic.deepLoad(parametrocompra.getEstadoPedidoAutorizado(),isDeep,deepLoadType,clases);
				
		parametrocompra.setFormatoItem(parametrocompraDataAccess.getFormatoItem(connexion,parametrocompra));
		FormatoLogic formatoitemLogic= new FormatoLogic(connexion);
		formatoitemLogic.deepLoad(parametrocompra.getFormatoItem(),isDeep,deepLoadType,clases);
				
		parametrocompra.setEstadoPedidoAnulado(parametrocompraDataAccess.getEstadoPedidoAnulado(connexion,parametrocompra));
		EstadoPedidoLogic estadopedidoanuladoLogic= new EstadoPedidoLogic(connexion);
		estadopedidoanuladoLogic.deepLoad(parametrocompra.getEstadoPedidoAnulado(),isDeep,deepLoadType,clases);
				
		parametrocompra.setPrioridadPedido(parametrocompraDataAccess.getPrioridadPedido(connexion,parametrocompra));
		PrioridadPedidoLogic prioridadpedidoLogic= new PrioridadPedidoLogic(connexion);
		prioridadpedidoLogic.deepLoad(parametrocompra.getPrioridadPedido(),isDeep,deepLoadType,clases);
				
		parametrocompra.setEstadoPedidoSuspendido(parametrocompraDataAccess.getEstadoPedidoSuspendido(connexion,parametrocompra));
		EstadoPedidoLogic estadopedidosuspendidoLogic= new EstadoPedidoLogic(connexion);
		estadopedidosuspendidoLogic.deepLoad(parametrocompra.getEstadoPedidoSuspendido(),isDeep,deepLoadType,clases);
				
		parametrocompra.setEstadoPedidoRegularizado(parametrocompraDataAccess.getEstadoPedidoRegularizado(connexion,parametrocompra));
		EstadoPedidoLogic estadopedidoregularizadoLogic= new EstadoPedidoLogic(connexion);
		estadopedidoregularizadoLogic.deepLoad(parametrocompra.getEstadoPedidoRegularizado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrocompra.setEmpresa(parametrocompraDataAccess.getEmpresa(connexion,parametrocompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrocompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				parametrocompra.setTipoDocumento(parametrocompraDataAccess.getTipoDocumento(connexion,parametrocompra));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(parametrocompra.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				parametrocompra.setTipoMovimiento(parametrocompraDataAccess.getTipoMovimiento(connexion,parametrocompra));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(parametrocompra.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrocompra.setBodega(parametrocompraDataAccess.getBodega(connexion,parametrocompra));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametrocompra.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				parametrocompra.setBodegaReserva(parametrocompraDataAccess.getBodegaReserva(connexion,parametrocompra));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(parametrocompra.getBodegaReserva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				parametrocompra.setEmpleado(parametrocompraDataAccess.getEmpleado(connexion,parametrocompra));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(parametrocompra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Embarcador.class)) {
				parametrocompra.setEmbarcador(parametrocompraDataAccess.getEmbarcador(connexion,parametrocompra));
				EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
				embarcadorLogic.deepLoad(parametrocompra.getEmbarcador(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				parametrocompra.setModulo(parametrocompraDataAccess.getModulo(connexion,parametrocompra));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(parametrocompra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				parametrocompra.setTipoMovimientoModulo(parametrocompraDataAccess.getTipoMovimientoModulo(connexion,parametrocompra));
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepLoad(parametrocompra.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrocompra.setFormatoPedido(parametrocompraDataAccess.getFormatoPedido(connexion,parametrocompra));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrocompra.getFormatoPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoPendiente(parametrocompraDataAccess.getEstadoPedidoPendiente(connexion,parametrocompra));
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoPendiente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrocompra.setFormatoCotizacion(parametrocompraDataAccess.getFormatoCotizacion(connexion,parametrocompra));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrocompra.getFormatoCotizacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoCotizado(parametrocompraDataAccess.getEstadoPedidoCotizado(connexion,parametrocompra));
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoCotizado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrocompra.setFormatoAutorizacion(parametrocompraDataAccess.getFormatoAutorizacion(connexion,parametrocompra));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrocompra.getFormatoAutorizacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoAutorizado(parametrocompraDataAccess.getEstadoPedidoAutorizado(connexion,parametrocompra));
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoAutorizado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				parametrocompra.setFormatoItem(parametrocompraDataAccess.getFormatoItem(connexion,parametrocompra));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(parametrocompra.getFormatoItem(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoAnulado(parametrocompraDataAccess.getEstadoPedidoAnulado(connexion,parametrocompra));
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoAnulado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PrioridadPedido.class)) {
				parametrocompra.setPrioridadPedido(parametrocompraDataAccess.getPrioridadPedido(connexion,parametrocompra));
				PrioridadPedidoLogic prioridadpedidoLogic= new PrioridadPedidoLogic(connexion);
				prioridadpedidoLogic.deepLoad(parametrocompra.getPrioridadPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoSuspendido(parametrocompraDataAccess.getEstadoPedidoSuspendido(connexion,parametrocompra));
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoSuspendido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				parametrocompra.setEstadoPedidoRegularizado(parametrocompraDataAccess.getEstadoPedidoRegularizado(connexion,parametrocompra));
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoRegularizado(),isDeep,deepLoadType,clases);				
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
			parametrocompra.setEmpresa(parametrocompraDataAccess.getEmpresa(connexion,parametrocompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrocompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setTipoDocumento(parametrocompraDataAccess.getTipoDocumento(connexion,parametrocompra));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(parametrocompra.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setTipoMovimiento(parametrocompraDataAccess.getTipoMovimiento(connexion,parametrocompra));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(parametrocompra.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setBodega(parametrocompraDataAccess.getBodega(connexion,parametrocompra));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametrocompra.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setBodegaReserva(parametrocompraDataAccess.getBodegaReserva(connexion,parametrocompra));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(parametrocompra.getBodegaReserva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEmpleado(parametrocompraDataAccess.getEmpleado(connexion,parametrocompra));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(parametrocompra.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Embarcador.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEmbarcador(parametrocompraDataAccess.getEmbarcador(connexion,parametrocompra));
			EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
			embarcadorLogic.deepLoad(parametrocompra.getEmbarcador(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setModulo(parametrocompraDataAccess.getModulo(connexion,parametrocompra));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(parametrocompra.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setTipoMovimientoModulo(parametrocompraDataAccess.getTipoMovimientoModulo(connexion,parametrocompra));
			TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
			tipomovimientomoduloLogic.deepLoad(parametrocompra.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setFormatoPedido(parametrocompraDataAccess.getFormatoPedido(connexion,parametrocompra));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrocompra.getFormatoPedido(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoPendiente(parametrocompraDataAccess.getEstadoPedidoPendiente(connexion,parametrocompra));
			EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
			estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoPendiente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setFormatoCotizacion(parametrocompraDataAccess.getFormatoCotizacion(connexion,parametrocompra));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrocompra.getFormatoCotizacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoCotizado(parametrocompraDataAccess.getEstadoPedidoCotizado(connexion,parametrocompra));
			EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
			estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoCotizado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setFormatoAutorizacion(parametrocompraDataAccess.getFormatoAutorizacion(connexion,parametrocompra));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrocompra.getFormatoAutorizacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoAutorizado(parametrocompraDataAccess.getEstadoPedidoAutorizado(connexion,parametrocompra));
			EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
			estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoAutorizado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setFormatoItem(parametrocompraDataAccess.getFormatoItem(connexion,parametrocompra));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(parametrocompra.getFormatoItem(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoAnulado(parametrocompraDataAccess.getEstadoPedidoAnulado(connexion,parametrocompra));
			EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
			estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoAnulado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PrioridadPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setPrioridadPedido(parametrocompraDataAccess.getPrioridadPedido(connexion,parametrocompra));
			PrioridadPedidoLogic prioridadpedidoLogic= new PrioridadPedidoLogic(connexion);
			prioridadpedidoLogic.deepLoad(parametrocompra.getPrioridadPedido(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoSuspendido(parametrocompraDataAccess.getEstadoPedidoSuspendido(connexion,parametrocompra));
			EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
			estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoSuspendido(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrocompra.setEstadoPedidoRegularizado(parametrocompraDataAccess.getEstadoPedidoRegularizado(connexion,parametrocompra));
			EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
			estadopedidoLogic.deepLoad(parametrocompra.getEstadoPedidoRegularizado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroCompra parametrocompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroCompraLogicAdditional.updateParametroCompraToSave(parametrocompra,this.arrDatoGeneral);
			
ParametroCompraDataAccess.save(parametrocompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrocompra.getEmpresa(),connexion);

		TipoDocumentoDataAccess.save(parametrocompra.getTipoDocumento(),connexion);

		TipoMovimientoDataAccess.save(parametrocompra.getTipoMovimiento(),connexion);

		BodegaDataAccess.save(parametrocompra.getBodega(),connexion);

		BodegaDataAccess.save(parametrocompra.getBodegaReserva(),connexion);

		EmpleadoDataAccess.save(parametrocompra.getEmpleado(),connexion);

		EmbarcadorDataAccess.save(parametrocompra.getEmbarcador(),connexion);

		ModuloDataAccess.save(parametrocompra.getModulo(),connexion);

		TipoMovimientoModuloDataAccess.save(parametrocompra.getTipoMovimientoModulo(),connexion);

		FormatoDataAccess.save(parametrocompra.getFormatoPedido(),connexion);

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoPendiente(),connexion);

		FormatoDataAccess.save(parametrocompra.getFormatoCotizacion(),connexion);

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoCotizado(),connexion);

		FormatoDataAccess.save(parametrocompra.getFormatoAutorizacion(),connexion);

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoAutorizado(),connexion);

		FormatoDataAccess.save(parametrocompra.getFormatoItem(),connexion);

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoAnulado(),connexion);

		PrioridadPedidoDataAccess.save(parametrocompra.getPrioridadPedido(),connexion);

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoSuspendido(),connexion);

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoRegularizado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrocompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(parametrocompra.getTipoDocumento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(parametrocompra.getTipoMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrocompra.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrocompra.getBodegaReserva(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(parametrocompra.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Embarcador.class)) {
				EmbarcadorDataAccess.save(parametrocompra.getEmbarcador(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(parametrocompra.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(parametrocompra.getTipoMovimientoModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrocompra.getFormatoPedido(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoPendiente(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrocompra.getFormatoCotizacion(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoCotizado(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrocompra.getFormatoAutorizacion(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoAutorizado(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrocompra.getFormatoItem(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoAnulado(),connexion);
				continue;
			}

			if(clas.clas.equals(PrioridadPedido.class)) {
				PrioridadPedidoDataAccess.save(parametrocompra.getPrioridadPedido(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoSuspendido(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoRegularizado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrocompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrocompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(parametrocompra.getTipoDocumento(),connexion);
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(parametrocompra.getTipoDocumento(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(parametrocompra.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(parametrocompra.getTipoMovimiento(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametrocompra.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(parametrocompra.getBodega(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(parametrocompra.getBodegaReserva(),connexion);
		BodegaLogic bodegareservaLogic= new BodegaLogic(connexion);
		bodegareservaLogic.deepLoad(parametrocompra.getBodegaReserva(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(parametrocompra.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(parametrocompra.getEmpleado(),isDeep,deepLoadType,clases);
				

		EmbarcadorDataAccess.save(parametrocompra.getEmbarcador(),connexion);
		EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
		embarcadorLogic.deepLoad(parametrocompra.getEmbarcador(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(parametrocompra.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(parametrocompra.getModulo(),isDeep,deepLoadType,clases);
				

		TipoMovimientoModuloDataAccess.save(parametrocompra.getTipoMovimientoModulo(),connexion);
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(parametrocompra.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrocompra.getFormatoPedido(),connexion);
		FormatoLogic formatopedidoLogic= new FormatoLogic(connexion);
		formatopedidoLogic.deepLoad(parametrocompra.getFormatoPedido(),isDeep,deepLoadType,clases);
				

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoPendiente(),connexion);
		EstadoPedidoLogic estadopedidopendienteLogic= new EstadoPedidoLogic(connexion);
		estadopedidopendienteLogic.deepLoad(parametrocompra.getEstadoPedidoPendiente(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrocompra.getFormatoCotizacion(),connexion);
		FormatoLogic formatocotizacionLogic= new FormatoLogic(connexion);
		formatocotizacionLogic.deepLoad(parametrocompra.getFormatoCotizacion(),isDeep,deepLoadType,clases);
				

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoCotizado(),connexion);
		EstadoPedidoLogic estadopedidocotizadoLogic= new EstadoPedidoLogic(connexion);
		estadopedidocotizadoLogic.deepLoad(parametrocompra.getEstadoPedidoCotizado(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrocompra.getFormatoAutorizacion(),connexion);
		FormatoLogic formatoautorizacionLogic= new FormatoLogic(connexion);
		formatoautorizacionLogic.deepLoad(parametrocompra.getFormatoAutorizacion(),isDeep,deepLoadType,clases);
				

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoAutorizado(),connexion);
		EstadoPedidoLogic estadopedidoautorizadoLogic= new EstadoPedidoLogic(connexion);
		estadopedidoautorizadoLogic.deepLoad(parametrocompra.getEstadoPedidoAutorizado(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(parametrocompra.getFormatoItem(),connexion);
		FormatoLogic formatoitemLogic= new FormatoLogic(connexion);
		formatoitemLogic.deepLoad(parametrocompra.getFormatoItem(),isDeep,deepLoadType,clases);
				

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoAnulado(),connexion);
		EstadoPedidoLogic estadopedidoanuladoLogic= new EstadoPedidoLogic(connexion);
		estadopedidoanuladoLogic.deepLoad(parametrocompra.getEstadoPedidoAnulado(),isDeep,deepLoadType,clases);
				

		PrioridadPedidoDataAccess.save(parametrocompra.getPrioridadPedido(),connexion);
		PrioridadPedidoLogic prioridadpedidoLogic= new PrioridadPedidoLogic(connexion);
		prioridadpedidoLogic.deepLoad(parametrocompra.getPrioridadPedido(),isDeep,deepLoadType,clases);
				

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoSuspendido(),connexion);
		EstadoPedidoLogic estadopedidosuspendidoLogic= new EstadoPedidoLogic(connexion);
		estadopedidosuspendidoLogic.deepLoad(parametrocompra.getEstadoPedidoSuspendido(),isDeep,deepLoadType,clases);
				

		EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoRegularizado(),connexion);
		EstadoPedidoLogic estadopedidoregularizadoLogic= new EstadoPedidoLogic(connexion);
		estadopedidoregularizadoLogic.deepLoad(parametrocompra.getEstadoPedidoRegularizado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrocompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrocompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(parametrocompra.getTipoDocumento(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(parametrocompra.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(parametrocompra.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(parametrocompra.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrocompra.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametrocompra.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(parametrocompra.getBodegaReserva(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(parametrocompra.getBodegaReserva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(parametrocompra.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(parametrocompra.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Embarcador.class)) {
				EmbarcadorDataAccess.save(parametrocompra.getEmbarcador(),connexion);
				EmbarcadorLogic embarcadorLogic= new EmbarcadorLogic(connexion);
				embarcadorLogic.deepSave(parametrocompra.getEmbarcador(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(parametrocompra.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(parametrocompra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(parametrocompra.getTipoMovimientoModulo(),connexion);
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepSave(parametrocompra.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrocompra.getFormatoPedido(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrocompra.getFormatoPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoPendiente(),connexion);
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepSave(parametrocompra.getEstadoPedidoPendiente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrocompra.getFormatoCotizacion(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrocompra.getFormatoCotizacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoCotizado(),connexion);
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepSave(parametrocompra.getEstadoPedidoCotizado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrocompra.getFormatoAutorizacion(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrocompra.getFormatoAutorizacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoAutorizado(),connexion);
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepSave(parametrocompra.getEstadoPedidoAutorizado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(parametrocompra.getFormatoItem(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(parametrocompra.getFormatoItem(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoAnulado(),connexion);
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepSave(parametrocompra.getEstadoPedidoAnulado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PrioridadPedido.class)) {
				PrioridadPedidoDataAccess.save(parametrocompra.getPrioridadPedido(),connexion);
				PrioridadPedidoLogic prioridadpedidoLogic= new PrioridadPedidoLogic(connexion);
				prioridadpedidoLogic.deepSave(parametrocompra.getPrioridadPedido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoSuspendido(),connexion);
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepSave(parametrocompra.getEstadoPedidoSuspendido(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPedido.class)) {
				EstadoPedidoDataAccess.save(parametrocompra.getEstadoPedidoRegularizado(),connexion);
				EstadoPedidoLogic estadopedidoLogic= new EstadoPedidoLogic(connexion);
				estadopedidoLogic.deepSave(parametrocompra.getEstadoPedidoRegularizado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrocompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(parametrocompra);
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
			this.deepLoad(this.parametrocompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrocompras!=null) {
				for(ParametroCompra parametrocompra:parametrocompras) {
					this.deepLoad(parametrocompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(parametrocompras);
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
			if(parametrocompras!=null) {
				for(ParametroCompra parametrocompra:parametrocompras) {
					this.deepLoad(parametrocompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(parametrocompras);
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
			this.getNewConnexionToDeep(ParametroCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrocompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrocompras!=null) {
				for(ParametroCompra parametrocompra:parametrocompras) {
					this.deepSave(parametrocompra,isDeep,deepLoadType,clases);
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
			if(parametrocompras!=null) {
				for(ParametroCompra parametrocompra:parametrocompras) {
					this.deepSave(parametrocompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroComprasFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroCompraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,ParametroCompraConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdBodegaReservaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_reserva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaReserva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaReserva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_reserva,ParametroCompraConstantesFunciones.IDBODEGARESERVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaReserva);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaReserva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdBodegaReserva(String sFinalQuery,Pagination pagination,Long id_bodega_reserva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaReserva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaReserva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_reserva,ParametroCompraConstantesFunciones.IDBODEGARESERVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaReserva);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaReserva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdEmbarcadorWithConnection(String sFinalQuery,Pagination pagination,Long id_embarcador)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmbarcador= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmbarcador.setParameterSelectionGeneralEqual(ParameterType.LONG,id_embarcador,ParametroCompraConstantesFunciones.IDEMBARCADOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmbarcador);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmbarcador","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdEmbarcador(String sFinalQuery,Pagination pagination,Long id_embarcador)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmbarcador= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmbarcador.setParameterSelectionGeneralEqual(ParameterType.LONG,id_embarcador,ParametroCompraConstantesFunciones.IDEMBARCADOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmbarcador);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmbarcador","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ParametroCompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ParametroCompraConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoAnuladoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido_anulado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoAnulado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoAnulado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_anulado,ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoAnulado);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoAnulado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoAnulado(String sFinalQuery,Pagination pagination,Long id_estado_pedido_anulado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoAnulado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoAnulado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_anulado,ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoAnulado);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoAnulado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoAutorizadoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido_autorizado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoAutorizado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoAutorizado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_autorizado,ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoAutorizado);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoAutorizado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoAutorizado(String sFinalQuery,Pagination pagination,Long id_estado_pedido_autorizado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoAutorizado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoAutorizado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_autorizado,ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoAutorizado);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoAutorizado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoCotizadoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido_cotizado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoCotizado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoCotizado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_cotizado,ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoCotizado);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoCotizado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoCotizado(String sFinalQuery,Pagination pagination,Long id_estado_pedido_cotizado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoCotizado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoCotizado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_cotizado,ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoCotizado);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoCotizado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoPendienteWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido_pendiente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoPendiente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoPendiente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_pendiente,ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoPendiente);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoPendiente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoPendiente(String sFinalQuery,Pagination pagination,Long id_estado_pedido_pendiente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoPendiente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoPendiente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_pendiente,ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoPendiente);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoPendiente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoRegularizadoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido_regularizado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoRegularizado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoRegularizado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_regularizado,ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoRegularizado);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoRegularizado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoRegularizado(String sFinalQuery,Pagination pagination,Long id_estado_pedido_regularizado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoRegularizado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoRegularizado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_regularizado,ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoRegularizado);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoRegularizado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoSuspendoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_pedido_suspendido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoSuspendido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoSuspendido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_suspendido,ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoSuspendido);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoSuspendo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdEstadoPedidoSuspendo(String sFinalQuery,Pagination pagination,Long id_estado_pedido_suspendido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPedidoSuspendido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPedidoSuspendido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_pedido_suspendido,ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPedidoSuspendido);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPedidoSuspendo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdFormatoAutorizacionWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_autorizacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoAutorizacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoAutorizacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_autorizacion,ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoAutorizacion);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoAutorizacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdFormatoAutorizacion(String sFinalQuery,Pagination pagination,Long id_formato_autorizacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoAutorizacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoAutorizacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_autorizacion,ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoAutorizacion);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoAutorizacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdFormatoCotizacionWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_cotizacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoCotizacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoCotizacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_cotizacion,ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoCotizacion);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoCotizacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdFormatoCotizacion(String sFinalQuery,Pagination pagination,Long id_formato_cotizacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoCotizacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoCotizacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_cotizacion,ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoCotizacion);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoCotizacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdFormatoItemWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_item)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoItem= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoItem.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_item,ParametroCompraConstantesFunciones.IDFORMATOITEM,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoItem);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoItem","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdFormatoItem(String sFinalQuery,Pagination pagination,Long id_formato_item)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoItem= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoItem.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_item,ParametroCompraConstantesFunciones.IDFORMATOITEM,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoItem);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoItem","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdFormatoPedidoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_pedido,ParametroCompraConstantesFunciones.IDFORMATOPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoPedido);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdFormatoPedido(String sFinalQuery,Pagination pagination,Long id_formato_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_pedido,ParametroCompraConstantesFunciones.IDFORMATOPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoPedido);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,ParametroCompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,ParametroCompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdPrioridadPedidoWithConnection(String sFinalQuery,Pagination pagination,Long id_prioridad_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPrioridadPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPrioridadPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_prioridad_pedido,ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPrioridadPedido);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPrioridadPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdPrioridadPedido(String sFinalQuery,Pagination pagination,Long id_prioridad_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPrioridadPedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPrioridadPedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_prioridad_pedido,ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPrioridadPedido);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPrioridadPedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdTipoDocumentoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,ParametroCompraConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdTipoDocumento(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,ParametroCompraConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroComprasFK_IdTipoMovimientoModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroComprasFK_IdTipoMovimientoModulo(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			ParametroCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroCompraConstantesFunciones.refrescarForeignKeysDescripcionesParametroCompra(this.parametrocompras);
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
			if(ParametroCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroCompra parametrocompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroCompraConstantesFunciones.ISCONAUDITORIA) {
				if(parametrocompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCompraDataAccess.TABLENAME, parametrocompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroCompraLogic.registrarAuditoriaDetallesParametroCompra(connexion,parametrocompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrocompra.getIsDeleted()) {
					/*if(!parametrocompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroCompraDataAccess.TABLENAME, parametrocompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroCompraLogic.registrarAuditoriaDetallesParametroCompra(connexion,parametrocompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCompraDataAccess.TABLENAME, parametrocompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrocompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroCompraDataAccess.TABLENAME, parametrocompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroCompraLogic.registrarAuditoriaDetallesParametroCompra(connexion,parametrocompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroCompra(Connexion connexion,ParametroCompra parametrocompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_empresa().equals(parametrocompra.getParametroCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_empresa().toString();
				}
				if(parametrocompra.getid_empresa()!=null)
				{
					strValorNuevo=parametrocompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getsecuencial_pedido().equals(parametrocompra.getParametroCompraOriginal().getsecuencial_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getsecuencial_pedido()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getsecuencial_pedido();
				}
				if(parametrocompra.getsecuencial_pedido()!=null)
				{
					strValorNuevo=parametrocompra.getsecuencial_pedido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.SECUENCIALPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getsecuencial_cotizacion().equals(parametrocompra.getParametroCompraOriginal().getsecuencial_cotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getsecuencial_cotizacion()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getsecuencial_cotizacion();
				}
				if(parametrocompra.getsecuencial_cotizacion()!=null)
				{
					strValorNuevo=parametrocompra.getsecuencial_cotizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getsecuencial_produccion().equals(parametrocompra.getParametroCompraOriginal().getsecuencial_produccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getsecuencial_produccion()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getsecuencial_produccion();
				}
				if(parametrocompra.getsecuencial_produccion()!=null)
				{
					strValorNuevo=parametrocompra.getsecuencial_produccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.SECUENCIALPRODUCCION,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_tipo_documento().equals(parametrocompra.getParametroCompraOriginal().getid_tipo_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_tipo_documento()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_tipo_documento().toString();
				}
				if(parametrocompra.getid_tipo_documento()!=null)
				{
					strValorNuevo=parametrocompra.getid_tipo_documento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDTIPODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_tipo_movimiento().equals(parametrocompra.getParametroCompraOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_tipo_movimiento().toString();
				}
				if(parametrocompra.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=parametrocompra.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_bodega().equals(parametrocompra.getParametroCompraOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_bodega()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_bodega().toString();
				}
				if(parametrocompra.getid_bodega()!=null)
				{
					strValorNuevo=parametrocompra.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_bodega_reserva().equals(parametrocompra.getParametroCompraOriginal().getid_bodega_reserva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_bodega_reserva()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_bodega_reserva().toString();
				}
				if(parametrocompra.getid_bodega_reserva()!=null)
				{
					strValorNuevo=parametrocompra.getid_bodega_reserva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDBODEGARESERVA,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_empleado().equals(parametrocompra.getParametroCompraOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_empleado()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_empleado().toString();
				}
				if(parametrocompra.getid_empleado()!=null)
				{
					strValorNuevo=parametrocompra.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_embarcador().equals(parametrocompra.getParametroCompraOriginal().getid_embarcador()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_embarcador()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_embarcador().toString();
				}
				if(parametrocompra.getid_embarcador()!=null)
				{
					strValorNuevo=parametrocompra.getid_embarcador().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDEMBARCADOR,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getcon_centro_costo().equals(parametrocompra.getParametroCompraOriginal().getcon_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getcon_centro_costo()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getcon_centro_costo().toString();
				}
				if(parametrocompra.getcon_centro_costo()!=null)
				{
					strValorNuevo=parametrocompra.getcon_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.CONCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.gettexto_mail().equals(parametrocompra.getParametroCompraOriginal().gettexto_mail()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().gettexto_mail()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().gettexto_mail();
				}
				if(parametrocompra.gettexto_mail()!=null)
				{
					strValorNuevo=parametrocompra.gettexto_mail() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.TEXTOMAIL,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_modulo().equals(parametrocompra.getParametroCompraOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_modulo()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_modulo().toString();
				}
				if(parametrocompra.getid_modulo()!=null)
				{
					strValorNuevo=parametrocompra.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_tipo_movimiento_modulo().equals(parametrocompra.getParametroCompraOriginal().getid_tipo_movimiento_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_tipo_movimiento_modulo()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_tipo_movimiento_modulo().toString();
				}
				if(parametrocompra.getid_tipo_movimiento_modulo()!=null)
				{
					strValorNuevo=parametrocompra.getid_tipo_movimiento_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getdescripcion().equals(parametrocompra.getParametroCompraOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getdescripcion()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getdescripcion();
				}
				if(parametrocompra.getdescripcion()!=null)
				{
					strValorNuevo=parametrocompra.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_formato_pedido().equals(parametrocompra.getParametroCompraOriginal().getid_formato_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_formato_pedido()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_formato_pedido().toString();
				}
				if(parametrocompra.getid_formato_pedido()!=null)
				{
					strValorNuevo=parametrocompra.getid_formato_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDFORMATOPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_estado_pedido_pendiente().equals(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_pendiente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_pendiente()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_estado_pedido_pendiente().toString();
				}
				if(parametrocompra.getid_estado_pedido_pendiente()!=null)
				{
					strValorNuevo=parametrocompra.getid_estado_pedido_pendiente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_formato_cotizacion().equals(parametrocompra.getParametroCompraOriginal().getid_formato_cotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_formato_cotizacion()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_formato_cotizacion().toString();
				}
				if(parametrocompra.getid_formato_cotizacion()!=null)
				{
					strValorNuevo=parametrocompra.getid_formato_cotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_estado_pedido_cotizado().equals(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_cotizado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_cotizado()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_estado_pedido_cotizado().toString();
				}
				if(parametrocompra.getid_estado_pedido_cotizado()!=null)
				{
					strValorNuevo=parametrocompra.getid_estado_pedido_cotizado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_formato_autorizacion().equals(parametrocompra.getParametroCompraOriginal().getid_formato_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_formato_autorizacion()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_formato_autorizacion().toString();
				}
				if(parametrocompra.getid_formato_autorizacion()!=null)
				{
					strValorNuevo=parametrocompra.getid_formato_autorizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_estado_pedido_autorizado().equals(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_autorizado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_autorizado()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_estado_pedido_autorizado().toString();
				}
				if(parametrocompra.getid_estado_pedido_autorizado()!=null)
				{
					strValorNuevo=parametrocompra.getid_estado_pedido_autorizado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_formato_item().equals(parametrocompra.getParametroCompraOriginal().getid_formato_item()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_formato_item()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_formato_item().toString();
				}
				if(parametrocompra.getid_formato_item()!=null)
				{
					strValorNuevo=parametrocompra.getid_formato_item().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDFORMATOITEM,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_estado_pedido_anulado().equals(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_anulado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_anulado()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_estado_pedido_anulado().toString();
				}
				if(parametrocompra.getid_estado_pedido_anulado()!=null)
				{
					strValorNuevo=parametrocompra.getid_estado_pedido_anulado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_prioridad_pedido().equals(parametrocompra.getParametroCompraOriginal().getid_prioridad_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_prioridad_pedido()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_prioridad_pedido().toString();
				}
				if(parametrocompra.getid_prioridad_pedido()!=null)
				{
					strValorNuevo=parametrocompra.getid_prioridad_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_estado_pedido_suspendido().equals(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_suspendido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_suspendido()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_estado_pedido_suspendido().toString();
				}
				if(parametrocompra.getid_estado_pedido_suspendido()!=null)
				{
					strValorNuevo=parametrocompra.getid_estado_pedido_suspendido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO,strValorActual,strValorNuevo);
			}	
			
			if(parametrocompra.getIsNew()||!parametrocompra.getid_estado_pedido_regularizado().equals(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_regularizado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrocompra.getParametroCompraOriginal().getid_estado_pedido_regularizado()!=null)
				{
					strValorActual=parametrocompra.getParametroCompraOriginal().getid_estado_pedido_regularizado().toString();
				}
				if(parametrocompra.getid_estado_pedido_regularizado()!=null)
				{
					strValorNuevo=parametrocompra.getid_estado_pedido_regularizado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroCompraRelacionesWithConnection(ParametroCompra parametrocompra) throws Exception {

		if(!parametrocompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroCompraRelacionesBase(parametrocompra,true);
		}
	}

	public void saveParametroCompraRelaciones(ParametroCompra parametrocompra)throws Exception {

		if(!parametrocompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroCompraRelacionesBase(parametrocompra,false);
		}
	}

	public void saveParametroCompraRelacionesBase(ParametroCompra parametrocompra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroCompra-saveRelacionesWithConnection");}
	

			this.setParametroCompra(parametrocompra);

			if(ParametroCompraLogicAdditional.validarSaveRelaciones(parametrocompra,this)) {

				ParametroCompraLogicAdditional.updateRelacionesToSave(parametrocompra,this);

				if((parametrocompra.getIsNew()||parametrocompra.getIsChanged())&&!parametrocompra.getIsDeleted()) {
					this.saveParametroCompra();
					this.saveParametroCompraRelacionesDetalles();

				} else if(parametrocompra.getIsDeleted()) {
					this.saveParametroCompraRelacionesDetalles();
					this.saveParametroCompra();
				}

				ParametroCompraLogicAdditional.updateRelacionesToSaveAfter(parametrocompra,this);

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
	
	
	private void saveParametroCompraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroCompraConstantesFunciones.getClassesForeignKeysOfParametroCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroCompraConstantesFunciones.getClassesRelationshipsOfParametroCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
