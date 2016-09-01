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
import com.bydan.erp.inventario.util.SegmentoProductoConstantesFunciones;
import com.bydan.erp.inventario.util.SegmentoProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.SegmentoProductoParameterGeneral;
import com.bydan.erp.inventario.business.entity.SegmentoProducto;
import com.bydan.erp.inventario.business.logic.SegmentoProductoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class SegmentoProductoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SegmentoProductoLogic.class);
	
	protected SegmentoProductoDataAccess segmentoproductoDataAccess; 	
	protected SegmentoProducto segmentoproducto;
	protected List<SegmentoProducto> segmentoproductos;
	protected Object segmentoproductoObject;	
	protected List<Object> segmentoproductosObject;
	
	public static ClassValidator<SegmentoProducto> segmentoproductoValidator = new ClassValidator<SegmentoProducto>(SegmentoProducto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SegmentoProductoLogicAdditional segmentoproductoLogicAdditional=null;
	
	public SegmentoProductoLogicAdditional getSegmentoProductoLogicAdditional() {
		return this.segmentoproductoLogicAdditional;
	}
	
	public void setSegmentoProductoLogicAdditional(SegmentoProductoLogicAdditional segmentoproductoLogicAdditional) {
		try {
			this.segmentoproductoLogicAdditional=segmentoproductoLogicAdditional;
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
	
	
	
	
	public  SegmentoProductoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.segmentoproductoDataAccess = new SegmentoProductoDataAccess();
			
			this.segmentoproductos= new ArrayList<SegmentoProducto>();
			this.segmentoproducto= new SegmentoProducto();
			
			this.segmentoproductoObject=new Object();
			this.segmentoproductosObject=new ArrayList<Object>();
				
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
			
			this.segmentoproductoDataAccess.setConnexionType(this.connexionType);
			this.segmentoproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SegmentoProductoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.segmentoproductoDataAccess = new SegmentoProductoDataAccess();
			this.segmentoproductos= new ArrayList<SegmentoProducto>();
			this.segmentoproducto= new SegmentoProducto();
			this.segmentoproductoObject=new Object();
			this.segmentoproductosObject=new ArrayList<Object>();
			
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
			
			this.segmentoproductoDataAccess.setConnexionType(this.connexionType);
			this.segmentoproductoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SegmentoProducto getSegmentoProducto() throws Exception {	
		SegmentoProductoLogicAdditional.checkSegmentoProductoToGet(segmentoproducto,this.datosCliente,this.arrDatoGeneral);
		SegmentoProductoLogicAdditional.updateSegmentoProductoToGet(segmentoproducto,this.arrDatoGeneral);
		
		return segmentoproducto;
	}
		
	public void setSegmentoProducto(SegmentoProducto newSegmentoProducto) {
		this.segmentoproducto = newSegmentoProducto;
	}
	
	public SegmentoProductoDataAccess getSegmentoProductoDataAccess() {
		return segmentoproductoDataAccess;
	}
	
	public void setSegmentoProductoDataAccess(SegmentoProductoDataAccess newsegmentoproductoDataAccess) {
		this.segmentoproductoDataAccess = newsegmentoproductoDataAccess;
	}
	
	public List<SegmentoProducto> getSegmentoProductos() throws Exception {		
		this.quitarSegmentoProductosNulos();
		
		SegmentoProductoLogicAdditional.checkSegmentoProductoToGets(segmentoproductos,this.datosCliente,this.arrDatoGeneral);
		
		for (SegmentoProducto segmentoproductoLocal: segmentoproductos ) {
			SegmentoProductoLogicAdditional.updateSegmentoProductoToGet(segmentoproductoLocal,this.arrDatoGeneral);
		}
		
		return segmentoproductos;
	}
	
	public void setSegmentoProductos(List<SegmentoProducto> newSegmentoProductos) {
		this.segmentoproductos = newSegmentoProductos;
	}
	
	public Object getSegmentoProductoObject() {	
		this.segmentoproductoObject=this.segmentoproductoDataAccess.getEntityObject();
		return this.segmentoproductoObject;
	}
		
	public void setSegmentoProductoObject(Object newSegmentoProductoObject) {
		this.segmentoproductoObject = newSegmentoProductoObject;
	}
	
	public List<Object> getSegmentoProductosObject() {		
		this.segmentoproductosObject=this.segmentoproductoDataAccess.getEntitiesObject();
		return this.segmentoproductosObject;
	}
		
	public void setSegmentoProductosObject(List<Object> newSegmentoProductosObject) {
		this.segmentoproductosObject = newSegmentoProductosObject;
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
		
		if(this.segmentoproductoDataAccess!=null) {
			this.segmentoproductoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			segmentoproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			segmentoproductoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		segmentoproducto = new  SegmentoProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			segmentoproducto=segmentoproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.segmentoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproducto);
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
		segmentoproducto = new  SegmentoProducto();
		  		  
        try {
			
			segmentoproducto=segmentoproductoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.segmentoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		segmentoproducto = new  SegmentoProducto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			segmentoproducto=segmentoproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.segmentoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproducto);
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
		segmentoproducto = new  SegmentoProducto();
		  		  
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
		segmentoproducto = new  SegmentoProducto();
		  		  
        try {
			
			segmentoproducto=segmentoproductoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.segmentoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		segmentoproducto = new  SegmentoProducto();
		  		  
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
		segmentoproducto = new  SegmentoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =segmentoproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		segmentoproducto = new  SegmentoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=segmentoproductoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		segmentoproducto = new  SegmentoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =segmentoproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		segmentoproducto = new  SegmentoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=segmentoproductoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		segmentoproducto = new  SegmentoProducto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =segmentoproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		segmentoproducto = new  SegmentoProducto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=segmentoproductoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSegmentoProducto(segmentoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
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
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		  		  
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
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		  		  
        try {			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSegmentoProducto(segmentoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		  		  
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
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSegmentoProducto(segmentoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
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
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		  		  
        try {
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSegmentoProducto(segmentoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
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
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSegmentoProducto(segmentoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
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
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSegmentoProducto(segmentoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		segmentoproducto = new  SegmentoProducto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproducto=segmentoproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSegmentoProducto(segmentoproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproducto);
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
		segmentoproducto = new  SegmentoProducto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproducto=segmentoproductoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSegmentoProducto(segmentoproducto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproductos=segmentoproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSegmentoProducto(segmentoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
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
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		  		  
        try {
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproductos=segmentoproductoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSegmentoProducto(segmentoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSegmentoProductosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getTodosSegmentoProductosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSegmentoProducto(segmentoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
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
	
	public  void  getTodosSegmentoProductos(String sFinalQuery,Pagination pagination)throws Exception {
		segmentoproductos = new  ArrayList<SegmentoProducto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSegmentoProducto(segmentoproductos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSegmentoProducto(SegmentoProducto segmentoproducto) throws Exception {
		Boolean estaValidado=false;
		
		if(segmentoproducto.getIsNew() || segmentoproducto.getIsChanged()) { 
			this.invalidValues = segmentoproductoValidator.getInvalidValues(segmentoproducto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(segmentoproducto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSegmentoProducto(List<SegmentoProducto> SegmentoProductos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SegmentoProducto segmentoproductoLocal:segmentoproductos) {				
			estaValidadoObjeto=this.validarGuardarSegmentoProducto(segmentoproductoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSegmentoProducto(List<SegmentoProducto> SegmentoProductos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSegmentoProducto(segmentoproductos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSegmentoProducto(SegmentoProducto SegmentoProducto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSegmentoProducto(segmentoproducto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SegmentoProducto segmentoproducto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+segmentoproducto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SegmentoProductoConstantesFunciones.getSegmentoProductoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"segmentoproducto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SegmentoProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SegmentoProductoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSegmentoProductoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-saveSegmentoProductoWithConnection");connexion.begin();			
			
			SegmentoProductoLogicAdditional.checkSegmentoProductoToSave(this.segmentoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SegmentoProductoLogicAdditional.updateSegmentoProductoToSave(this.segmentoproducto,this.arrDatoGeneral);
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.segmentoproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSegmentoProducto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSegmentoProducto(this.segmentoproducto)) {
				SegmentoProductoDataAccess.save(this.segmentoproducto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.segmentoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SegmentoProductoLogicAdditional.checkSegmentoProductoToSaveAfter(this.segmentoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSegmentoProducto();
			
			connexion.commit();			
			
			if(this.segmentoproducto.getIsDeleted()) {
				this.segmentoproducto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSegmentoProducto()throws Exception {	
		try {	
			
			SegmentoProductoLogicAdditional.checkSegmentoProductoToSave(this.segmentoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SegmentoProductoLogicAdditional.updateSegmentoProductoToSave(this.segmentoproducto,this.arrDatoGeneral);
			
			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.segmentoproducto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSegmentoProducto(this.segmentoproducto)) {			
				SegmentoProductoDataAccess.save(this.segmentoproducto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.segmentoproducto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SegmentoProductoLogicAdditional.checkSegmentoProductoToSaveAfter(this.segmentoproducto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.segmentoproducto.getIsDeleted()) {
				this.segmentoproducto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSegmentoProductosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-saveSegmentoProductosWithConnection");connexion.begin();			
			
			SegmentoProductoLogicAdditional.checkSegmentoProductoToSaves(segmentoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSegmentoProductos();
			
			Boolean validadoTodosSegmentoProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SegmentoProducto segmentoproductoLocal:segmentoproductos) {		
				if(segmentoproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SegmentoProductoLogicAdditional.updateSegmentoProductoToSave(segmentoproductoLocal,this.arrDatoGeneral);
	        	
				SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),segmentoproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSegmentoProducto(segmentoproductoLocal)) {
					SegmentoProductoDataAccess.save(segmentoproductoLocal, connexion);				
				} else {
					validadoTodosSegmentoProducto=false;
				}
			}
			
			if(!validadoTodosSegmentoProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SegmentoProductoLogicAdditional.checkSegmentoProductoToSavesAfter(segmentoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSegmentoProductos();
			
			connexion.commit();		
			
			this.quitarSegmentoProductosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSegmentoProductos()throws Exception {				
		 try {	
			SegmentoProductoLogicAdditional.checkSegmentoProductoToSaves(segmentoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSegmentoProducto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SegmentoProducto segmentoproductoLocal:segmentoproductos) {				
				if(segmentoproductoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SegmentoProductoLogicAdditional.updateSegmentoProductoToSave(segmentoproductoLocal,this.arrDatoGeneral);
	        	
				SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),segmentoproductoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSegmentoProducto(segmentoproductoLocal)) {				
					SegmentoProductoDataAccess.save(segmentoproductoLocal, connexion);				
				} else {
					validadoTodosSegmentoProducto=false;
				}
			}
			
			if(!validadoTodosSegmentoProducto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SegmentoProductoLogicAdditional.checkSegmentoProductoToSavesAfter(segmentoproductos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSegmentoProductosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SegmentoProductoParameterReturnGeneral procesarAccionSegmentoProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SegmentoProducto> segmentoproductos,SegmentoProductoParameterReturnGeneral segmentoproductoParameterGeneral)throws Exception {
		 try {	
			SegmentoProductoParameterReturnGeneral segmentoproductoReturnGeneral=new SegmentoProductoParameterReturnGeneral();
	
			SegmentoProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,segmentoproductos,segmentoproductoParameterGeneral,segmentoproductoReturnGeneral);
			
			return segmentoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SegmentoProductoParameterReturnGeneral procesarAccionSegmentoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SegmentoProducto> segmentoproductos,SegmentoProductoParameterReturnGeneral segmentoproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-procesarAccionSegmentoProductosWithConnection");connexion.begin();			
			
			SegmentoProductoParameterReturnGeneral segmentoproductoReturnGeneral=new SegmentoProductoParameterReturnGeneral();
	
			SegmentoProductoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,segmentoproductos,segmentoproductoParameterGeneral,segmentoproductoReturnGeneral);
			
			this.connexion.commit();
			
			return segmentoproductoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SegmentoProductoParameterReturnGeneral procesarEventosSegmentoProductos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SegmentoProducto> segmentoproductos,SegmentoProducto segmentoproducto,SegmentoProductoParameterReturnGeneral segmentoproductoParameterGeneral,Boolean isEsNuevoSegmentoProducto,ArrayList<Classe> clases)throws Exception {
		 try {	
			SegmentoProductoParameterReturnGeneral segmentoproductoReturnGeneral=new SegmentoProductoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				segmentoproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SegmentoProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,segmentoproductos,segmentoproducto,segmentoproductoParameterGeneral,segmentoproductoReturnGeneral,isEsNuevoSegmentoProducto,clases);
			
			return segmentoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SegmentoProductoParameterReturnGeneral procesarEventosSegmentoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SegmentoProducto> segmentoproductos,SegmentoProducto segmentoproducto,SegmentoProductoParameterReturnGeneral segmentoproductoParameterGeneral,Boolean isEsNuevoSegmentoProducto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-procesarEventosSegmentoProductosWithConnection");connexion.begin();			
			
			SegmentoProductoParameterReturnGeneral segmentoproductoReturnGeneral=new SegmentoProductoParameterReturnGeneral();
	
			segmentoproductoReturnGeneral.setSegmentoProducto(segmentoproducto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				segmentoproductoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SegmentoProductoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,segmentoproductos,segmentoproducto,segmentoproductoParameterGeneral,segmentoproductoReturnGeneral,isEsNuevoSegmentoProducto,clases);
			
			this.connexion.commit();
			
			return segmentoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SegmentoProductoParameterReturnGeneral procesarImportacionSegmentoProductosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SegmentoProductoParameterReturnGeneral segmentoproductoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-procesarImportacionSegmentoProductosWithConnection");connexion.begin();			
			
			SegmentoProductoParameterReturnGeneral segmentoproductoReturnGeneral=new SegmentoProductoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.segmentoproductos=new ArrayList<SegmentoProducto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.segmentoproducto=new SegmentoProducto();
				
				
				if(conColumnasBase) {this.segmentoproducto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.segmentoproducto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.segmentoproducto.setcodigo(arrColumnas[iColumn++]);
				this.segmentoproducto.setnombre(arrColumnas[iColumn++]);
				
				this.segmentoproductos.add(this.segmentoproducto);
			}
			
			this.saveSegmentoProductos();
			
			this.connexion.commit();
			
			segmentoproductoReturnGeneral.setConRetornoEstaProcesado(true);
			segmentoproductoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return segmentoproductoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSegmentoProductosEliminados() throws Exception {				
		
		List<SegmentoProducto> segmentoproductosAux= new ArrayList<SegmentoProducto>();
		
		for(SegmentoProducto segmentoproducto:segmentoproductos) {
			if(!segmentoproducto.getIsDeleted()) {
				segmentoproductosAux.add(segmentoproducto);
			}
		}
		
		segmentoproductos=segmentoproductosAux;
	}
	
	public void quitarSegmentoProductosNulos() throws Exception {				
		
		List<SegmentoProducto> segmentoproductosAux= new ArrayList<SegmentoProducto>();
		
		for(SegmentoProducto segmentoproducto : this.segmentoproductos) {
			if(segmentoproducto==null) {
				segmentoproductosAux.add(segmentoproducto);
			}
		}
		
		//this.segmentoproductos=segmentoproductosAux;
		
		this.segmentoproductos.removeAll(segmentoproductosAux);
	}
	
	public void getSetVersionRowSegmentoProductoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(segmentoproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((segmentoproducto.getIsDeleted() || (segmentoproducto.getIsChanged()&&!segmentoproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=segmentoproductoDataAccess.getSetVersionRowSegmentoProducto(connexion,segmentoproducto.getId());
				
				if(!segmentoproducto.getVersionRow().equals(timestamp)) {	
					segmentoproducto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				segmentoproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSegmentoProducto()throws Exception {	
		
		if(segmentoproducto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((segmentoproducto.getIsDeleted() || (segmentoproducto.getIsChanged()&&!segmentoproducto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=segmentoproductoDataAccess.getSetVersionRowSegmentoProducto(connexion,segmentoproducto.getId());
			
			try {							
				if(!segmentoproducto.getVersionRow().equals(timestamp)) {	
					segmentoproducto.setVersionRow(timestamp);
				}
				
				segmentoproducto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSegmentoProductosWithConnection()throws Exception {	
		if(segmentoproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SegmentoProducto segmentoproductoAux:segmentoproductos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(segmentoproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(segmentoproductoAux.getIsDeleted() || (segmentoproductoAux.getIsChanged()&&!segmentoproductoAux.getIsNew())) {
						
						timestamp=segmentoproductoDataAccess.getSetVersionRowSegmentoProducto(connexion,segmentoproductoAux.getId());
						
						if(!segmentoproducto.getVersionRow().equals(timestamp)) {	
							segmentoproductoAux.setVersionRow(timestamp);
						}
								
						segmentoproductoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSegmentoProductos()throws Exception {	
		if(segmentoproductos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SegmentoProducto segmentoproductoAux:segmentoproductos) {
					if(segmentoproductoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(segmentoproductoAux.getIsDeleted() || (segmentoproductoAux.getIsChanged()&&!segmentoproductoAux.getIsNew())) {
						
						timestamp=segmentoproductoDataAccess.getSetVersionRowSegmentoProducto(connexion,segmentoproductoAux.getId());
						
						if(!segmentoproductoAux.getVersionRow().equals(timestamp)) {	
							segmentoproductoAux.setVersionRow(timestamp);
						}
						
													
						segmentoproductoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SegmentoProductoParameterReturnGeneral cargarCombosLoteForeignKeySegmentoProductoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoProducto) throws Exception {
		SegmentoProductoParameterReturnGeneral  segmentoproductoReturnGeneral =new SegmentoProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-cargarCombosLoteForeignKeySegmentoProductoWithConnection");connexion.begin();
			
			segmentoproductoReturnGeneral =new SegmentoProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			segmentoproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoProducto> tipoproductosForeignKey=new ArrayList<TipoProducto>();
			TipoProductoLogic tipoproductoLogic=new TipoProductoLogic();
			tipoproductoLogic.setConnexion(this.connexion);
			tipoproductoLogic.getTipoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProducto.equals("NONE")) {
				tipoproductoLogic.getTodosTipoProductos(finalQueryGlobalTipoProducto,new Pagination());
				tipoproductosForeignKey=tipoproductoLogic.getTipoProductos();
			}

			segmentoproductoReturnGeneral.settipoproductosForeignKey(tipoproductosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return segmentoproductoReturnGeneral;
	}
	
	public SegmentoProductoParameterReturnGeneral cargarCombosLoteForeignKeySegmentoProducto(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoProducto) throws Exception {
		SegmentoProductoParameterReturnGeneral  segmentoproductoReturnGeneral =new SegmentoProductoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			segmentoproductoReturnGeneral =new SegmentoProductoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			segmentoproductoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoProducto> tipoproductosForeignKey=new ArrayList<TipoProducto>();
			TipoProductoLogic tipoproductoLogic=new TipoProductoLogic();
			tipoproductoLogic.setConnexion(this.connexion);
			tipoproductoLogic.getTipoProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProducto.equals("NONE")) {
				tipoproductoLogic.getTodosTipoProductos(finalQueryGlobalTipoProducto,new Pagination());
				tipoproductosForeignKey=tipoproductoLogic.getTipoProductos();
			}

			segmentoproductoReturnGeneral.settipoproductosForeignKey(tipoproductosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return segmentoproductoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeySegmentoProductoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoLogic productoLogic=new ProductoLogic();
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic=new ParametroInventarioDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeySegmentoProductoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Producto.class));
			classes.add(new Classe(ParametroInventarioDefecto.class));
											
			

			productoLogic.setConnexion(this.getConnexion());
			productoLogic.setDatosCliente(this.datosCliente);
			productoLogic.setIsConRefrescarForeignKeys(true);

			parametroinventariodefectoLogic.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic.setDatosCliente(this.datosCliente);
			parametroinventariodefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(SegmentoProducto segmentoproducto:this.segmentoproductos) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoLogic.setProductos(segmentoproducto.productos);
				productoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroinventariodefectoLogic.setParametroInventarioDefectos(segmentoproducto.parametroinventariodefectos);
				parametroinventariodefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(SegmentoProducto segmentoproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SegmentoProductoLogicAdditional.updateSegmentoProductoToGet(segmentoproducto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		segmentoproducto.setEmpresa(segmentoproductoDataAccess.getEmpresa(connexion,segmentoproducto));
		segmentoproducto.setTipoProducto(segmentoproductoDataAccess.getTipoProducto(connexion,segmentoproducto));
		segmentoproducto.setProductos(segmentoproductoDataAccess.getProductos(connexion,segmentoproducto));
		segmentoproducto.setParametroInventarioDefectos(segmentoproductoDataAccess.getParametroInventarioDefectos(connexion,segmentoproducto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				segmentoproducto.setEmpresa(segmentoproductoDataAccess.getEmpresa(connexion,segmentoproducto));
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				segmentoproducto.setTipoProducto(segmentoproductoDataAccess.getTipoProducto(connexion,segmentoproducto));
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				segmentoproducto.setProductos(segmentoproductoDataAccess.getProductos(connexion,segmentoproducto));

				if(this.isConDeep) {
					ProductoLogic productoLogic= new ProductoLogic(this.connexion);
					productoLogic.setProductos(segmentoproducto.getProductos());
					ArrayList<Classe> classesLocal=ProductoConstantesFunciones.getClassesForeignKeysOfProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoConstantesFunciones.refrescarForeignKeysDescripcionesProducto(productoLogic.getProductos());
					segmentoproducto.setProductos(productoLogic.getProductos());
				}

				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				segmentoproducto.setParametroInventarioDefectos(segmentoproductoDataAccess.getParametroInventarioDefectos(connexion,segmentoproducto));

				if(this.isConDeep) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(this.connexion);
					parametroinventariodefectoLogic.setParametroInventarioDefectos(segmentoproducto.getParametroInventarioDefectos());
					ArrayList<Classe> classesLocal=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroinventariodefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectoLogic.getParametroInventarioDefectos());
					segmentoproducto.setParametroInventarioDefectos(parametroinventariodefectoLogic.getParametroInventarioDefectos());
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
			segmentoproducto.setEmpresa(segmentoproductoDataAccess.getEmpresa(connexion,segmentoproducto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			segmentoproducto.setTipoProducto(segmentoproductoDataAccess.getTipoProducto(connexion,segmentoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Producto.class));
			segmentoproducto.setProductos(segmentoproductoDataAccess.getProductos(connexion,segmentoproducto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			segmentoproducto.setParametroInventarioDefectos(segmentoproductoDataAccess.getParametroInventarioDefectos(connexion,segmentoproducto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		segmentoproducto.setEmpresa(segmentoproductoDataAccess.getEmpresa(connexion,segmentoproducto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(segmentoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		segmentoproducto.setTipoProducto(segmentoproductoDataAccess.getTipoProducto(connexion,segmentoproducto));
		TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
		tipoproductoLogic.deepLoad(segmentoproducto.getTipoProducto(),isDeep,deepLoadType,clases);
				

		segmentoproducto.setProductos(segmentoproductoDataAccess.getProductos(connexion,segmentoproducto));

		for(Producto producto:segmentoproducto.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
		}

		segmentoproducto.setParametroInventarioDefectos(segmentoproductoDataAccess.getParametroInventarioDefectos(connexion,segmentoproducto));

		for(ParametroInventarioDefecto parametroinventariodefecto:segmentoproducto.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				segmentoproducto.setEmpresa(segmentoproductoDataAccess.getEmpresa(connexion,segmentoproducto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(segmentoproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				segmentoproducto.setTipoProducto(segmentoproductoDataAccess.getTipoProducto(connexion,segmentoproducto));
				TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
				tipoproductoLogic.deepLoad(segmentoproducto.getTipoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				segmentoproducto.setProductos(segmentoproductoDataAccess.getProductos(connexion,segmentoproducto));

				for(Producto producto:segmentoproducto.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				segmentoproducto.setParametroInventarioDefectos(segmentoproductoDataAccess.getParametroInventarioDefectos(connexion,segmentoproducto));

				for(ParametroInventarioDefecto parametroinventariodefecto:segmentoproducto.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
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
			segmentoproducto.setEmpresa(segmentoproductoDataAccess.getEmpresa(connexion,segmentoproducto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(segmentoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProducto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			segmentoproducto.setTipoProducto(segmentoproductoDataAccess.getTipoProducto(connexion,segmentoproducto));
			TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
			tipoproductoLogic.deepLoad(segmentoproducto.getTipoProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Producto.class));
			segmentoproducto.setProductos(segmentoproductoDataAccess.getProductos(connexion,segmentoproducto));

			for(Producto producto:segmentoproducto.getProductos()) {
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(producto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			segmentoproducto.setParametroInventarioDefectos(segmentoproductoDataAccess.getParametroInventarioDefectos(connexion,segmentoproducto));

			for(ParametroInventarioDefecto parametroinventariodefecto:segmentoproducto.getParametroInventarioDefectos()) {
				ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
				parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SegmentoProducto segmentoproducto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SegmentoProductoLogicAdditional.updateSegmentoProductoToSave(segmentoproducto,this.arrDatoGeneral);
			
SegmentoProductoDataAccess.save(segmentoproducto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(segmentoproducto.getEmpresa(),connexion);

		TipoProductoDataAccess.save(segmentoproducto.getTipoProducto(),connexion);

		for(Producto producto:segmentoproducto.getProductos()) {
			producto.setid_segmento_producto(segmentoproducto.getId());
			ProductoDataAccess.save(producto,connexion);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:segmentoproducto.getParametroInventarioDefectos()) {
			parametroinventariodefecto.setid_segmento_producto(segmentoproducto.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(segmentoproducto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				TipoProductoDataAccess.save(segmentoproducto.getTipoProducto(),connexion);
				continue;
			}


			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:segmentoproducto.getProductos()) {
					producto.setid_segmento_producto(segmentoproducto.getId());
					ProductoDataAccess.save(producto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:segmentoproducto.getParametroInventarioDefectos()) {
					parametroinventariodefecto.setid_segmento_producto(segmentoproducto.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(segmentoproducto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(segmentoproducto.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoProductoDataAccess.save(segmentoproducto.getTipoProducto(),connexion);
		TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
		tipoproductoLogic.deepLoad(segmentoproducto.getTipoProducto(),isDeep,deepLoadType,clases);
				

		for(Producto producto:segmentoproducto.getProductos()) {
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			producto.setid_segmento_producto(segmentoproducto.getId());
			ProductoDataAccess.save(producto,connexion);
			productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
		}

		for(ParametroInventarioDefecto parametroinventariodefecto:segmentoproducto.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefecto.setid_segmento_producto(segmentoproducto.getId());
			ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
			parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(segmentoproducto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(segmentoproducto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProducto.class)) {
				TipoProductoDataAccess.save(segmentoproducto.getTipoProducto(),connexion);
				TipoProductoLogic tipoproductoLogic= new TipoProductoLogic(connexion);
				tipoproductoLogic.deepSave(segmentoproducto.getTipoProducto(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Producto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Producto producto:segmentoproducto.getProductos()) {
					ProductoLogic productoLogic= new ProductoLogic(connexion);
					producto.setid_segmento_producto(segmentoproducto.getId());
					ProductoDataAccess.save(producto,connexion);
					productoLogic.deepSave(producto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroInventarioDefecto parametroinventariodefecto:segmentoproducto.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefecto.setid_segmento_producto(segmentoproducto.getId());
					ParametroInventarioDefectoDataAccess.save(parametroinventariodefecto,connexion);
					parametroinventariodefectoLogic.deepSave(parametroinventariodefecto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(SegmentoProducto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(segmentoproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(segmentoproducto);
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
			this.deepLoad(this.segmentoproducto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproducto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SegmentoProducto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(segmentoproductos!=null) {
				for(SegmentoProducto segmentoproducto:segmentoproductos) {
					this.deepLoad(segmentoproducto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(segmentoproductos);
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
			if(segmentoproductos!=null) {
				for(SegmentoProducto segmentoproducto:segmentoproductos) {
					this.deepLoad(segmentoproducto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(segmentoproductos);
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
			this.getNewConnexionToDeep(SegmentoProducto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(segmentoproducto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SegmentoProducto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(segmentoproductos!=null) {
				for(SegmentoProducto segmentoproducto:segmentoproductos) {
					this.deepSave(segmentoproducto,isDeep,deepLoadType,clases);
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
			if(segmentoproductos!=null) {
				for(SegmentoProducto segmentoproducto:segmentoproductos) {
					this.deepSave(segmentoproducto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSegmentoProductosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",SegmentoProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSegmentoProductosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",SegmentoProductoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSegmentoProductosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",SegmentoProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSegmentoProductosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",SegmentoProductoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSegmentoProductosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SegmentoProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSegmentoProductosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SegmentoProductoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSegmentoProductosFK_IdTipoProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SegmentoProducto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto,SegmentoProductoConstantesFunciones.IDTIPOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProducto);

			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSegmentoProductosFK_IdTipoProducto(String sFinalQuery,Pagination pagination,Long id_tipo_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto,SegmentoProductoConstantesFunciones.IDTIPOPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProducto);

			SegmentoProductoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SegmentoProductoConstantesFunciones.refrescarForeignKeysDescripcionesSegmentoProducto(this.segmentoproductos);
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
			if(SegmentoProductoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SegmentoProductoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SegmentoProducto segmentoproducto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SegmentoProductoConstantesFunciones.ISCONAUDITORIA) {
				if(segmentoproducto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SegmentoProductoDataAccess.TABLENAME, segmentoproducto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SegmentoProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SegmentoProductoLogic.registrarAuditoriaDetallesSegmentoProducto(connexion,segmentoproducto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(segmentoproducto.getIsDeleted()) {
					/*if(!segmentoproducto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SegmentoProductoDataAccess.TABLENAME, segmentoproducto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SegmentoProductoLogic.registrarAuditoriaDetallesSegmentoProducto(connexion,segmentoproducto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SegmentoProductoDataAccess.TABLENAME, segmentoproducto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(segmentoproducto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SegmentoProductoDataAccess.TABLENAME, segmentoproducto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SegmentoProductoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SegmentoProductoLogic.registrarAuditoriaDetallesSegmentoProducto(connexion,segmentoproducto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSegmentoProducto(Connexion connexion,SegmentoProducto segmentoproducto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(segmentoproducto.getIsNew()||!segmentoproducto.getid_empresa().equals(segmentoproducto.getSegmentoProductoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(segmentoproducto.getSegmentoProductoOriginal().getid_empresa()!=null)
				{
					strValorActual=segmentoproducto.getSegmentoProductoOriginal().getid_empresa().toString();
				}
				if(segmentoproducto.getid_empresa()!=null)
				{
					strValorNuevo=segmentoproducto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SegmentoProductoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(segmentoproducto.getIsNew()||!segmentoproducto.getid_tipo_producto().equals(segmentoproducto.getSegmentoProductoOriginal().getid_tipo_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(segmentoproducto.getSegmentoProductoOriginal().getid_tipo_producto()!=null)
				{
					strValorActual=segmentoproducto.getSegmentoProductoOriginal().getid_tipo_producto().toString();
				}
				if(segmentoproducto.getid_tipo_producto()!=null)
				{
					strValorNuevo=segmentoproducto.getid_tipo_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SegmentoProductoConstantesFunciones.IDTIPOPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(segmentoproducto.getIsNew()||!segmentoproducto.getcodigo().equals(segmentoproducto.getSegmentoProductoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(segmentoproducto.getSegmentoProductoOriginal().getcodigo()!=null)
				{
					strValorActual=segmentoproducto.getSegmentoProductoOriginal().getcodigo();
				}
				if(segmentoproducto.getcodigo()!=null)
				{
					strValorNuevo=segmentoproducto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SegmentoProductoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(segmentoproducto.getIsNew()||!segmentoproducto.getnombre().equals(segmentoproducto.getSegmentoProductoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(segmentoproducto.getSegmentoProductoOriginal().getnombre()!=null)
				{
					strValorActual=segmentoproducto.getSegmentoProductoOriginal().getnombre();
				}
				if(segmentoproducto.getnombre()!=null)
				{
					strValorNuevo=segmentoproducto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SegmentoProductoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSegmentoProductoRelacionesWithConnection(SegmentoProducto segmentoproducto,List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos) throws Exception {

		if(!segmentoproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSegmentoProductoRelacionesBase(segmentoproducto,productos,parametroinventariodefectos,true);
		}
	}

	public void saveSegmentoProductoRelaciones(SegmentoProducto segmentoproducto,List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {

		if(!segmentoproducto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSegmentoProductoRelacionesBase(segmentoproducto,productos,parametroinventariodefectos,false);
		}
	}

	public void saveSegmentoProductoRelacionesBase(SegmentoProducto segmentoproducto,List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SegmentoProducto-saveRelacionesWithConnection");}
	
			segmentoproducto.setProductos(productos);
			segmentoproducto.setParametroInventarioDefectos(parametroinventariodefectos);

			this.setSegmentoProducto(segmentoproducto);

			if(SegmentoProductoLogicAdditional.validarSaveRelaciones(segmentoproducto,this)) {

				SegmentoProductoLogicAdditional.updateRelacionesToSave(segmentoproducto,this);

				if((segmentoproducto.getIsNew()||segmentoproducto.getIsChanged())&&!segmentoproducto.getIsDeleted()) {
					this.saveSegmentoProducto();
					this.saveSegmentoProductoRelacionesDetalles(productos,parametroinventariodefectos);

				} else if(segmentoproducto.getIsDeleted()) {
					this.saveSegmentoProductoRelacionesDetalles(productos,parametroinventariodefectos);
					this.saveSegmentoProducto();
				}

				SegmentoProductoLogicAdditional.updateRelacionesToSaveAfter(segmentoproducto,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductos(productos,true,true);
			ParametroInventarioDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroInventarioDefectos(parametroinventariodefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveSegmentoProductoRelacionesDetalles(List<Producto> productos,List<ParametroInventarioDefecto> parametroinventariodefectos)throws Exception {
		try {
	

			Long idSegmentoProductoActual=this.getSegmentoProducto().getId();

			ProductoLogic productoLogic_Desde_SegmentoProducto=new ProductoLogic();
			productoLogic_Desde_SegmentoProducto.setProductos(productos);

			productoLogic_Desde_SegmentoProducto.setConnexion(this.getConnexion());
			productoLogic_Desde_SegmentoProducto.setDatosCliente(this.datosCliente);

			for(Producto producto_Desde_SegmentoProducto:productoLogic_Desde_SegmentoProducto.getProductos()) {
				producto_Desde_SegmentoProducto.setid_segmento_producto(idSegmentoProductoActual);

				productoLogic_Desde_SegmentoProducto.setProducto(producto_Desde_SegmentoProducto);
				productoLogic_Desde_SegmentoProducto.saveProducto();
			}


			ParametroInventarioDefectoLogic parametroinventariodefectoLogic_Desde_SegmentoProducto=new ParametroInventarioDefectoLogic();
			parametroinventariodefectoLogic_Desde_SegmentoProducto.setParametroInventarioDefectos(parametroinventariodefectos);

			parametroinventariodefectoLogic_Desde_SegmentoProducto.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic_Desde_SegmentoProducto.setDatosCliente(this.datosCliente);

			for(ParametroInventarioDefecto parametroinventariodefecto_Desde_SegmentoProducto:parametroinventariodefectoLogic_Desde_SegmentoProducto.getParametroInventarioDefectos()) {
				parametroinventariodefecto_Desde_SegmentoProducto.setid_segmento_producto(idSegmentoProductoActual);
			}

			parametroinventariodefectoLogic_Desde_SegmentoProducto.saveParametroInventarioDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSegmentoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SegmentoProductoConstantesFunciones.getClassesForeignKeysOfSegmentoProducto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSegmentoProducto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SegmentoProductoConstantesFunciones.getClassesRelationshipsOfSegmentoProducto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
