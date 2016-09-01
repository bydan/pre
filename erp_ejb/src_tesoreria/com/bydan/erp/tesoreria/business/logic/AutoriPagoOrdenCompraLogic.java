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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.AutoriPagoOrdenCompraConstantesFunciones;
import com.bydan.erp.tesoreria.util.AutoriPagoOrdenCompraParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.AutoriPagoOrdenCompraParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.AutoriPagoOrdenCompra;
import com.bydan.erp.tesoreria.business.logic.AutoriPagoOrdenCompraLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class AutoriPagoOrdenCompraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AutoriPagoOrdenCompraLogic.class);
	
	protected AutoriPagoOrdenCompraDataAccess autoripagoordencompraDataAccess; 	
	protected AutoriPagoOrdenCompra autoripagoordencompra;
	protected List<AutoriPagoOrdenCompra> autoripagoordencompras;
	protected Object autoripagoordencompraObject;	
	protected List<Object> autoripagoordencomprasObject;
	
	public static ClassValidator<AutoriPagoOrdenCompra> autoripagoordencompraValidator = new ClassValidator<AutoriPagoOrdenCompra>(AutoriPagoOrdenCompra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AutoriPagoOrdenCompraLogicAdditional autoripagoordencompraLogicAdditional=null;
	
	public AutoriPagoOrdenCompraLogicAdditional getAutoriPagoOrdenCompraLogicAdditional() {
		return this.autoripagoordencompraLogicAdditional;
	}
	
	public void setAutoriPagoOrdenCompraLogicAdditional(AutoriPagoOrdenCompraLogicAdditional autoripagoordencompraLogicAdditional) {
		try {
			this.autoripagoordencompraLogicAdditional=autoripagoordencompraLogicAdditional;
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
	
	
	
	
	public  AutoriPagoOrdenCompraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.autoripagoordencompraDataAccess = new AutoriPagoOrdenCompraDataAccess();
			
			this.autoripagoordencompras= new ArrayList<AutoriPagoOrdenCompra>();
			this.autoripagoordencompra= new AutoriPagoOrdenCompra();
			
			this.autoripagoordencompraObject=new Object();
			this.autoripagoordencomprasObject=new ArrayList<Object>();
				
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
			
			this.autoripagoordencompraDataAccess.setConnexionType(this.connexionType);
			this.autoripagoordencompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AutoriPagoOrdenCompraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.autoripagoordencompraDataAccess = new AutoriPagoOrdenCompraDataAccess();
			this.autoripagoordencompras= new ArrayList<AutoriPagoOrdenCompra>();
			this.autoripagoordencompra= new AutoriPagoOrdenCompra();
			this.autoripagoordencompraObject=new Object();
			this.autoripagoordencomprasObject=new ArrayList<Object>();
			
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
			
			this.autoripagoordencompraDataAccess.setConnexionType(this.connexionType);
			this.autoripagoordencompraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AutoriPagoOrdenCompra getAutoriPagoOrdenCompra() throws Exception {	
		AutoriPagoOrdenCompraLogicAdditional.checkAutoriPagoOrdenCompraToGet(autoripagoordencompra,this.datosCliente,this.arrDatoGeneral);
		AutoriPagoOrdenCompraLogicAdditional.updateAutoriPagoOrdenCompraToGet(autoripagoordencompra,this.arrDatoGeneral);
		
		return autoripagoordencompra;
	}
		
	public void setAutoriPagoOrdenCompra(AutoriPagoOrdenCompra newAutoriPagoOrdenCompra) {
		this.autoripagoordencompra = newAutoriPagoOrdenCompra;
	}
	
	public AutoriPagoOrdenCompraDataAccess getAutoriPagoOrdenCompraDataAccess() {
		return autoripagoordencompraDataAccess;
	}
	
	public void setAutoriPagoOrdenCompraDataAccess(AutoriPagoOrdenCompraDataAccess newautoripagoordencompraDataAccess) {
		this.autoripagoordencompraDataAccess = newautoripagoordencompraDataAccess;
	}
	
	public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras() throws Exception {		
		this.quitarAutoriPagoOrdenComprasNulos();
		
		AutoriPagoOrdenCompraLogicAdditional.checkAutoriPagoOrdenCompraToGets(autoripagoordencompras,this.datosCliente,this.arrDatoGeneral);
		
		for (AutoriPagoOrdenCompra autoripagoordencompraLocal: autoripagoordencompras ) {
			AutoriPagoOrdenCompraLogicAdditional.updateAutoriPagoOrdenCompraToGet(autoripagoordencompraLocal,this.arrDatoGeneral);
		}
		
		return autoripagoordencompras;
	}
	
	public void setAutoriPagoOrdenCompras(List<AutoriPagoOrdenCompra> newAutoriPagoOrdenCompras) {
		this.autoripagoordencompras = newAutoriPagoOrdenCompras;
	}
	
	public Object getAutoriPagoOrdenCompraObject() {	
		this.autoripagoordencompraObject=this.autoripagoordencompraDataAccess.getEntityObject();
		return this.autoripagoordencompraObject;
	}
		
	public void setAutoriPagoOrdenCompraObject(Object newAutoriPagoOrdenCompraObject) {
		this.autoripagoordencompraObject = newAutoriPagoOrdenCompraObject;
	}
	
	public List<Object> getAutoriPagoOrdenComprasObject() {		
		this.autoripagoordencomprasObject=this.autoripagoordencompraDataAccess.getEntitiesObject();
		return this.autoripagoordencomprasObject;
	}
		
	public void setAutoriPagoOrdenComprasObject(List<Object> newAutoriPagoOrdenComprasObject) {
		this.autoripagoordencomprasObject = newAutoriPagoOrdenComprasObject;
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
		
		if(this.autoripagoordencompraDataAccess!=null) {
			this.autoripagoordencompraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			autoripagoordencompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			autoripagoordencompraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			autoripagoordencompra=autoripagoordencompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoripagoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompra);
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
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		  		  
        try {
			
			autoripagoordencompra=autoripagoordencompraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoripagoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			autoripagoordencompra=autoripagoordencompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoripagoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompra);
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
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		  		  
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
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		  		  
        try {
			
			autoripagoordencompra=autoripagoordencompraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoripagoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		  		  
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
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =autoripagoordencompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=autoripagoordencompraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =autoripagoordencompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=autoripagoordencompraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =autoripagoordencompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=autoripagoordencompraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
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
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		  		  
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
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		  		  
        try {			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		  		  
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
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
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
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		  		  
        try {
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
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
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
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
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompra=autoripagoordencompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompra);
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
		autoripagoordencompra = new  AutoriPagoOrdenCompra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompra=autoripagoordencompraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
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
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		  		  
        try {
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAutoriPagoOrdenComprasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getTodosAutoriPagoOrdenComprasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
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
	
	public  void  getTodosAutoriPagoOrdenCompras(String sFinalQuery,Pagination pagination)throws Exception {
		autoripagoordencompras = new  ArrayList<AutoriPagoOrdenCompra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAutoriPagoOrdenCompra(autoripagoordencompras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAutoriPagoOrdenCompra(AutoriPagoOrdenCompra autoripagoordencompra) throws Exception {
		Boolean estaValidado=false;
		
		if(autoripagoordencompra.getIsNew() || autoripagoordencompra.getIsChanged()) { 
			this.invalidValues = autoripagoordencompraValidator.getInvalidValues(autoripagoordencompra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(autoripagoordencompra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAutoriPagoOrdenCompra(List<AutoriPagoOrdenCompra> AutoriPagoOrdenCompras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AutoriPagoOrdenCompra autoripagoordencompraLocal:autoripagoordencompras) {				
			estaValidadoObjeto=this.validarGuardarAutoriPagoOrdenCompra(autoripagoordencompraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAutoriPagoOrdenCompra(List<AutoriPagoOrdenCompra> AutoriPagoOrdenCompras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAutoriPagoOrdenCompra(autoripagoordencompras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAutoriPagoOrdenCompra(AutoriPagoOrdenCompra AutoriPagoOrdenCompra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAutoriPagoOrdenCompra(autoripagoordencompra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AutoriPagoOrdenCompra autoripagoordencompra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+autoripagoordencompra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AutoriPagoOrdenCompraConstantesFunciones.getAutoriPagoOrdenCompraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"autoripagoordencompra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AutoriPagoOrdenCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AutoriPagoOrdenCompraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAutoriPagoOrdenCompraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-saveAutoriPagoOrdenCompraWithConnection");connexion.begin();			
			
			AutoriPagoOrdenCompraLogicAdditional.checkAutoriPagoOrdenCompraToSave(this.autoripagoordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AutoriPagoOrdenCompraLogicAdditional.updateAutoriPagoOrdenCompraToSave(this.autoripagoordencompra,this.arrDatoGeneral);
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.autoripagoordencompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAutoriPagoOrdenCompra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAutoriPagoOrdenCompra(this.autoripagoordencompra)) {
				AutoriPagoOrdenCompraDataAccess.save(this.autoripagoordencompra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.autoripagoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AutoriPagoOrdenCompraLogicAdditional.checkAutoriPagoOrdenCompraToSaveAfter(this.autoripagoordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAutoriPagoOrdenCompra();
			
			connexion.commit();			
			
			if(this.autoripagoordencompra.getIsDeleted()) {
				this.autoripagoordencompra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAutoriPagoOrdenCompra()throws Exception {	
		try {	
			
			AutoriPagoOrdenCompraLogicAdditional.checkAutoriPagoOrdenCompraToSave(this.autoripagoordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AutoriPagoOrdenCompraLogicAdditional.updateAutoriPagoOrdenCompraToSave(this.autoripagoordencompra,this.arrDatoGeneral);
			
			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.autoripagoordencompra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAutoriPagoOrdenCompra(this.autoripagoordencompra)) {			
				AutoriPagoOrdenCompraDataAccess.save(this.autoripagoordencompra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.autoripagoordencompra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AutoriPagoOrdenCompraLogicAdditional.checkAutoriPagoOrdenCompraToSaveAfter(this.autoripagoordencompra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.autoripagoordencompra.getIsDeleted()) {
				this.autoripagoordencompra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAutoriPagoOrdenComprasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-saveAutoriPagoOrdenComprasWithConnection");connexion.begin();			
			
			AutoriPagoOrdenCompraLogicAdditional.checkAutoriPagoOrdenCompraToSaves(autoripagoordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAutoriPagoOrdenCompras();
			
			Boolean validadoTodosAutoriPagoOrdenCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AutoriPagoOrdenCompra autoripagoordencompraLocal:autoripagoordencompras) {		
				if(autoripagoordencompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AutoriPagoOrdenCompraLogicAdditional.updateAutoriPagoOrdenCompraToSave(autoripagoordencompraLocal,this.arrDatoGeneral);
	        	
				AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),autoripagoordencompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAutoriPagoOrdenCompra(autoripagoordencompraLocal)) {
					AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompraLocal, connexion);				
				} else {
					validadoTodosAutoriPagoOrdenCompra=false;
				}
			}
			
			if(!validadoTodosAutoriPagoOrdenCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AutoriPagoOrdenCompraLogicAdditional.checkAutoriPagoOrdenCompraToSavesAfter(autoripagoordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAutoriPagoOrdenCompras();
			
			connexion.commit();		
			
			this.quitarAutoriPagoOrdenComprasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAutoriPagoOrdenCompras()throws Exception {				
		 try {	
			AutoriPagoOrdenCompraLogicAdditional.checkAutoriPagoOrdenCompraToSaves(autoripagoordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAutoriPagoOrdenCompra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AutoriPagoOrdenCompra autoripagoordencompraLocal:autoripagoordencompras) {				
				if(autoripagoordencompraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AutoriPagoOrdenCompraLogicAdditional.updateAutoriPagoOrdenCompraToSave(autoripagoordencompraLocal,this.arrDatoGeneral);
	        	
				AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),autoripagoordencompraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAutoriPagoOrdenCompra(autoripagoordencompraLocal)) {				
					AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompraLocal, connexion);				
				} else {
					validadoTodosAutoriPagoOrdenCompra=false;
				}
			}
			
			if(!validadoTodosAutoriPagoOrdenCompra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AutoriPagoOrdenCompraLogicAdditional.checkAutoriPagoOrdenCompraToSavesAfter(autoripagoordencompras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAutoriPagoOrdenComprasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutoriPagoOrdenCompraParameterReturnGeneral procesarAccionAutoriPagoOrdenCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutoriPagoOrdenCompra> autoripagoordencompras,AutoriPagoOrdenCompraParameterReturnGeneral autoripagoordencompraParameterGeneral)throws Exception {
		 try {	
			AutoriPagoOrdenCompraParameterReturnGeneral autoripagoordencompraReturnGeneral=new AutoriPagoOrdenCompraParameterReturnGeneral();
	
			AutoriPagoOrdenCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autoripagoordencompras,autoripagoordencompraParameterGeneral,autoripagoordencompraReturnGeneral);
			
			return autoripagoordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutoriPagoOrdenCompraParameterReturnGeneral procesarAccionAutoriPagoOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutoriPagoOrdenCompra> autoripagoordencompras,AutoriPagoOrdenCompraParameterReturnGeneral autoripagoordencompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-procesarAccionAutoriPagoOrdenComprasWithConnection");connexion.begin();			
			
			AutoriPagoOrdenCompraParameterReturnGeneral autoripagoordencompraReturnGeneral=new AutoriPagoOrdenCompraParameterReturnGeneral();
	
			AutoriPagoOrdenCompraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autoripagoordencompras,autoripagoordencompraParameterGeneral,autoripagoordencompraReturnGeneral);
			
			this.connexion.commit();
			
			return autoripagoordencompraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AutoriPagoOrdenCompraParameterReturnGeneral procesarEventosAutoriPagoOrdenCompras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AutoriPagoOrdenCompra> autoripagoordencompras,AutoriPagoOrdenCompra autoripagoordencompra,AutoriPagoOrdenCompraParameterReturnGeneral autoripagoordencompraParameterGeneral,Boolean isEsNuevoAutoriPagoOrdenCompra,ArrayList<Classe> clases)throws Exception {
		 try {	
			AutoriPagoOrdenCompraParameterReturnGeneral autoripagoordencompraReturnGeneral=new AutoriPagoOrdenCompraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				autoripagoordencompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AutoriPagoOrdenCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,autoripagoordencompras,autoripagoordencompra,autoripagoordencompraParameterGeneral,autoripagoordencompraReturnGeneral,isEsNuevoAutoriPagoOrdenCompra,clases);
			
			return autoripagoordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AutoriPagoOrdenCompraParameterReturnGeneral procesarEventosAutoriPagoOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AutoriPagoOrdenCompra> autoripagoordencompras,AutoriPagoOrdenCompra autoripagoordencompra,AutoriPagoOrdenCompraParameterReturnGeneral autoripagoordencompraParameterGeneral,Boolean isEsNuevoAutoriPagoOrdenCompra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-procesarEventosAutoriPagoOrdenComprasWithConnection");connexion.begin();			
			
			AutoriPagoOrdenCompraParameterReturnGeneral autoripagoordencompraReturnGeneral=new AutoriPagoOrdenCompraParameterReturnGeneral();
	
			autoripagoordencompraReturnGeneral.setAutoriPagoOrdenCompra(autoripagoordencompra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				autoripagoordencompraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AutoriPagoOrdenCompraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,autoripagoordencompras,autoripagoordencompra,autoripagoordencompraParameterGeneral,autoripagoordencompraReturnGeneral,isEsNuevoAutoriPagoOrdenCompra,clases);
			
			this.connexion.commit();
			
			return autoripagoordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AutoriPagoOrdenCompraParameterReturnGeneral procesarImportacionAutoriPagoOrdenComprasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AutoriPagoOrdenCompraParameterReturnGeneral autoripagoordencompraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-procesarImportacionAutoriPagoOrdenComprasWithConnection");connexion.begin();			
			
			AutoriPagoOrdenCompraParameterReturnGeneral autoripagoordencompraReturnGeneral=new AutoriPagoOrdenCompraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.autoripagoordencompras=new ArrayList<AutoriPagoOrdenCompra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.autoripagoordencompra=new AutoriPagoOrdenCompra();
				
				
				if(conColumnasBase) {this.autoripagoordencompra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.autoripagoordencompra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.autoripagoordencompra.setnumero_comprobante(arrColumnas[iColumn++]);
				this.autoripagoordencompra.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoripagoordencompra.setfecha_autori(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoripagoordencompra.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.autoripagoordencompra.setfecha_servidor(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoripagoordencompra.setcodigo_asiento(arrColumnas[iColumn++]);
				this.autoripagoordencompra.setfecha_asiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoripagoordencompra.setvalor_asiento(Double.parseDouble(arrColumnas[iColumn++]));
				this.autoripagoordencompra.settotal_saldo(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.autoripagoordencompras.add(this.autoripagoordencompra);
			}
			
			this.saveAutoriPagoOrdenCompras();
			
			this.connexion.commit();
			
			autoripagoordencompraReturnGeneral.setConRetornoEstaProcesado(true);
			autoripagoordencompraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return autoripagoordencompraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAutoriPagoOrdenComprasEliminados() throws Exception {				
		
		List<AutoriPagoOrdenCompra> autoripagoordencomprasAux= new ArrayList<AutoriPagoOrdenCompra>();
		
		for(AutoriPagoOrdenCompra autoripagoordencompra:autoripagoordencompras) {
			if(!autoripagoordencompra.getIsDeleted()) {
				autoripagoordencomprasAux.add(autoripagoordencompra);
			}
		}
		
		autoripagoordencompras=autoripagoordencomprasAux;
	}
	
	public void quitarAutoriPagoOrdenComprasNulos() throws Exception {				
		
		List<AutoriPagoOrdenCompra> autoripagoordencomprasAux= new ArrayList<AutoriPagoOrdenCompra>();
		
		for(AutoriPagoOrdenCompra autoripagoordencompra : this.autoripagoordencompras) {
			if(autoripagoordencompra==null) {
				autoripagoordencomprasAux.add(autoripagoordencompra);
			}
		}
		
		//this.autoripagoordencompras=autoripagoordencomprasAux;
		
		this.autoripagoordencompras.removeAll(autoripagoordencomprasAux);
	}
	
	public void getSetVersionRowAutoriPagoOrdenCompraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(autoripagoordencompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((autoripagoordencompra.getIsDeleted() || (autoripagoordencompra.getIsChanged()&&!autoripagoordencompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=autoripagoordencompraDataAccess.getSetVersionRowAutoriPagoOrdenCompra(connexion,autoripagoordencompra.getId());
				
				if(!autoripagoordencompra.getVersionRow().equals(timestamp)) {	
					autoripagoordencompra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				autoripagoordencompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAutoriPagoOrdenCompra()throws Exception {	
		
		if(autoripagoordencompra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((autoripagoordencompra.getIsDeleted() || (autoripagoordencompra.getIsChanged()&&!autoripagoordencompra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=autoripagoordencompraDataAccess.getSetVersionRowAutoriPagoOrdenCompra(connexion,autoripagoordencompra.getId());
			
			try {							
				if(!autoripagoordencompra.getVersionRow().equals(timestamp)) {	
					autoripagoordencompra.setVersionRow(timestamp);
				}
				
				autoripagoordencompra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAutoriPagoOrdenComprasWithConnection()throws Exception {	
		if(autoripagoordencompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AutoriPagoOrdenCompra autoripagoordencompraAux:autoripagoordencompras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(autoripagoordencompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(autoripagoordencompraAux.getIsDeleted() || (autoripagoordencompraAux.getIsChanged()&&!autoripagoordencompraAux.getIsNew())) {
						
						timestamp=autoripagoordencompraDataAccess.getSetVersionRowAutoriPagoOrdenCompra(connexion,autoripagoordencompraAux.getId());
						
						if(!autoripagoordencompra.getVersionRow().equals(timestamp)) {	
							autoripagoordencompraAux.setVersionRow(timestamp);
						}
								
						autoripagoordencompraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAutoriPagoOrdenCompras()throws Exception {	
		if(autoripagoordencompras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AutoriPagoOrdenCompra autoripagoordencompraAux:autoripagoordencompras) {
					if(autoripagoordencompraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(autoripagoordencompraAux.getIsDeleted() || (autoripagoordencompraAux.getIsChanged()&&!autoripagoordencompraAux.getIsNew())) {
						
						timestamp=autoripagoordencompraDataAccess.getSetVersionRowAutoriPagoOrdenCompra(connexion,autoripagoordencompraAux.getId());
						
						if(!autoripagoordencompraAux.getVersionRow().equals(timestamp)) {	
							autoripagoordencompraAux.setVersionRow(timestamp);
						}
						
													
						autoripagoordencompraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AutoriPagoOrdenCompraParameterReturnGeneral cargarCombosLoteForeignKeyAutoriPagoOrdenCompraWithConnection(String finalQueryGlobalTipoCambio,String finalQueryGlobalMoneda,String finalQueryGlobalCliente,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalOrdenCompra,String finalQueryGlobalTransaccion,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalUsuario,String finalQueryGlobalAsientoContable,String finalQueryGlobalBanco,String finalQueryGlobalCuentaBanco) throws Exception {
		AutoriPagoOrdenCompraParameterReturnGeneral  autoripagoordencompraReturnGeneral =new AutoriPagoOrdenCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-cargarCombosLoteForeignKeyAutoriPagoOrdenCompraWithConnection");connexion.begin();
			
			autoripagoordencompraReturnGeneral =new AutoriPagoOrdenCompraParameterReturnGeneral();
			
			

			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			autoripagoordencompraReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			autoripagoordencompraReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			autoripagoordencompraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			autoripagoordencompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			autoripagoordencompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<OrdenCompra> ordencomprasForeignKey=new ArrayList<OrdenCompra>();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			ordencompraLogic.setConnexion(this.connexion);
			ordencompraLogic.getOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenCompra.equals("NONE")) {
				ordencompraLogic.getTodosOrdenCompras(finalQueryGlobalOrdenCompra,new Pagination());
				ordencomprasForeignKey=ordencompraLogic.getOrdenCompras();
			}

			autoripagoordencompraReturnGeneral.setordencomprasForeignKey(ordencomprasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			autoripagoordencompraReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			autoripagoordencompraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			autoripagoordencompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			autoripagoordencompraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			autoripagoordencompraReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			autoripagoordencompraReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<CuentaBanco> cuentabancosForeignKey=new ArrayList<CuentaBanco>();
			CuentaBancoLogic cuentabancoLogic=new CuentaBancoLogic();
			cuentabancoLogic.setConnexion(this.connexion);
			cuentabancoLogic.getCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaBanco.equals("NONE")) {
				cuentabancoLogic.getTodosCuentaBancos(finalQueryGlobalCuentaBanco,new Pagination());
				cuentabancosForeignKey=cuentabancoLogic.getCuentaBancos();
			}

			autoripagoordencompraReturnGeneral.setcuentabancosForeignKey(cuentabancosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return autoripagoordencompraReturnGeneral;
	}
	
	public AutoriPagoOrdenCompraParameterReturnGeneral cargarCombosLoteForeignKeyAutoriPagoOrdenCompra(String finalQueryGlobalTipoCambio,String finalQueryGlobalMoneda,String finalQueryGlobalCliente,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalOrdenCompra,String finalQueryGlobalTransaccion,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalUsuario,String finalQueryGlobalAsientoContable,String finalQueryGlobalBanco,String finalQueryGlobalCuentaBanco) throws Exception {
		AutoriPagoOrdenCompraParameterReturnGeneral  autoripagoordencompraReturnGeneral =new AutoriPagoOrdenCompraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			autoripagoordencompraReturnGeneral =new AutoriPagoOrdenCompraParameterReturnGeneral();
			
			

			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			autoripagoordencompraReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			autoripagoordencompraReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			autoripagoordencompraReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			autoripagoordencompraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			autoripagoordencompraReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<OrdenCompra> ordencomprasForeignKey=new ArrayList<OrdenCompra>();
			OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
			ordencompraLogic.setConnexion(this.connexion);
			ordencompraLogic.getOrdenCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOrdenCompra.equals("NONE")) {
				ordencompraLogic.getTodosOrdenCompras(finalQueryGlobalOrdenCompra,new Pagination());
				ordencomprasForeignKey=ordencompraLogic.getOrdenCompras();
			}

			autoripagoordencompraReturnGeneral.setordencomprasForeignKey(ordencomprasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			autoripagoordencompraReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			autoripagoordencompraReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			autoripagoordencompraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			autoripagoordencompraReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			autoripagoordencompraReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			autoripagoordencompraReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<CuentaBanco> cuentabancosForeignKey=new ArrayList<CuentaBanco>();
			CuentaBancoLogic cuentabancoLogic=new CuentaBancoLogic();
			cuentabancoLogic.setConnexion(this.connexion);
			cuentabancoLogic.getCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaBanco.equals("NONE")) {
				cuentabancoLogic.getTodosCuentaBancos(finalQueryGlobalCuentaBanco,new Pagination());
				cuentabancosForeignKey=cuentabancoLogic.getCuentaBancos();
			}

			autoripagoordencompraReturnGeneral.setcuentabancosForeignKey(cuentabancosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return autoripagoordencompraReturnGeneral;
	}
	
	
	public void deepLoad(AutoriPagoOrdenCompra autoripagoordencompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AutoriPagoOrdenCompraLogicAdditional.updateAutoriPagoOrdenCompraToGet(autoripagoordencompra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autoripagoordencompra.setTipoCambio(autoripagoordencompraDataAccess.getTipoCambio(connexion,autoripagoordencompra));
		autoripagoordencompra.setMoneda(autoripagoordencompraDataAccess.getMoneda(connexion,autoripagoordencompra));
		autoripagoordencompra.setCliente(autoripagoordencompraDataAccess.getCliente(connexion,autoripagoordencompra));
		autoripagoordencompra.setEmpresa(autoripagoordencompraDataAccess.getEmpresa(connexion,autoripagoordencompra));
		autoripagoordencompra.setSucursal(autoripagoordencompraDataAccess.getSucursal(connexion,autoripagoordencompra));
		autoripagoordencompra.setOrdenCompra(autoripagoordencompraDataAccess.getOrdenCompra(connexion,autoripagoordencompra));
		autoripagoordencompra.setTransaccion(autoripagoordencompraDataAccess.getTransaccion(connexion,autoripagoordencompra));
		autoripagoordencompra.setModulo(autoripagoordencompraDataAccess.getModulo(connexion,autoripagoordencompra));
		autoripagoordencompra.setEjercicio(autoripagoordencompraDataAccess.getEjercicio(connexion,autoripagoordencompra));
		autoripagoordencompra.setUsuario(autoripagoordencompraDataAccess.getUsuario(connexion,autoripagoordencompra));
		autoripagoordencompra.setAsientoContable(autoripagoordencompraDataAccess.getAsientoContable(connexion,autoripagoordencompra));
		autoripagoordencompra.setBanco(autoripagoordencompraDataAccess.getBanco(connexion,autoripagoordencompra));
		autoripagoordencompra.setCuentaBanco(autoripagoordencompraDataAccess.getCuentaBanco(connexion,autoripagoordencompra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				autoripagoordencompra.setTipoCambio(autoripagoordencompraDataAccess.getTipoCambio(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				autoripagoordencompra.setMoneda(autoripagoordencompraDataAccess.getMoneda(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				autoripagoordencompra.setCliente(autoripagoordencompraDataAccess.getCliente(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				autoripagoordencompra.setEmpresa(autoripagoordencompraDataAccess.getEmpresa(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				autoripagoordencompra.setSucursal(autoripagoordencompraDataAccess.getSucursal(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				autoripagoordencompra.setOrdenCompra(autoripagoordencompraDataAccess.getOrdenCompra(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				autoripagoordencompra.setTransaccion(autoripagoordencompraDataAccess.getTransaccion(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				autoripagoordencompra.setModulo(autoripagoordencompraDataAccess.getModulo(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				autoripagoordencompra.setEjercicio(autoripagoordencompraDataAccess.getEjercicio(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				autoripagoordencompra.setUsuario(autoripagoordencompraDataAccess.getUsuario(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				autoripagoordencompra.setAsientoContable(autoripagoordencompraDataAccess.getAsientoContable(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				autoripagoordencompra.setBanco(autoripagoordencompraDataAccess.getBanco(connexion,autoripagoordencompra));
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				autoripagoordencompra.setCuentaBanco(autoripagoordencompraDataAccess.getCuentaBanco(connexion,autoripagoordencompra));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setTipoCambio(autoripagoordencompraDataAccess.getTipoCambio(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setMoneda(autoripagoordencompraDataAccess.getMoneda(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setCliente(autoripagoordencompraDataAccess.getCliente(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setEmpresa(autoripagoordencompraDataAccess.getEmpresa(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setSucursal(autoripagoordencompraDataAccess.getSucursal(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setOrdenCompra(autoripagoordencompraDataAccess.getOrdenCompra(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setTransaccion(autoripagoordencompraDataAccess.getTransaccion(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setModulo(autoripagoordencompraDataAccess.getModulo(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setEjercicio(autoripagoordencompraDataAccess.getEjercicio(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setUsuario(autoripagoordencompraDataAccess.getUsuario(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setAsientoContable(autoripagoordencompraDataAccess.getAsientoContable(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setBanco(autoripagoordencompraDataAccess.getBanco(connexion,autoripagoordencompra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setCuentaBanco(autoripagoordencompraDataAccess.getCuentaBanco(connexion,autoripagoordencompra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autoripagoordencompra.setTipoCambio(autoripagoordencompraDataAccess.getTipoCambio(connexion,autoripagoordencompra));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(autoripagoordencompra.getTipoCambio(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setMoneda(autoripagoordencompraDataAccess.getMoneda(connexion,autoripagoordencompra));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(autoripagoordencompra.getMoneda(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setCliente(autoripagoordencompraDataAccess.getCliente(connexion,autoripagoordencompra));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(autoripagoordencompra.getCliente(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setEmpresa(autoripagoordencompraDataAccess.getEmpresa(connexion,autoripagoordencompra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autoripagoordencompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setSucursal(autoripagoordencompraDataAccess.getSucursal(connexion,autoripagoordencompra));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(autoripagoordencompra.getSucursal(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setOrdenCompra(autoripagoordencompraDataAccess.getOrdenCompra(connexion,autoripagoordencompra));
		OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
		ordencompraLogic.deepLoad(autoripagoordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setTransaccion(autoripagoordencompraDataAccess.getTransaccion(connexion,autoripagoordencompra));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(autoripagoordencompra.getTransaccion(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setModulo(autoripagoordencompraDataAccess.getModulo(connexion,autoripagoordencompra));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(autoripagoordencompra.getModulo(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setEjercicio(autoripagoordencompraDataAccess.getEjercicio(connexion,autoripagoordencompra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(autoripagoordencompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setUsuario(autoripagoordencompraDataAccess.getUsuario(connexion,autoripagoordencompra));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(autoripagoordencompra.getUsuario(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setAsientoContable(autoripagoordencompraDataAccess.getAsientoContable(connexion,autoripagoordencompra));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(autoripagoordencompra.getAsientoContable(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setBanco(autoripagoordencompraDataAccess.getBanco(connexion,autoripagoordencompra));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(autoripagoordencompra.getBanco(),isDeep,deepLoadType,clases);
				
		autoripagoordencompra.setCuentaBanco(autoripagoordencompraDataAccess.getCuentaBanco(connexion,autoripagoordencompra));
		CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
		cuentabancoLogic.deepLoad(autoripagoordencompra.getCuentaBanco(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				autoripagoordencompra.setTipoCambio(autoripagoordencompraDataAccess.getTipoCambio(connexion,autoripagoordencompra));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(autoripagoordencompra.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				autoripagoordencompra.setMoneda(autoripagoordencompraDataAccess.getMoneda(connexion,autoripagoordencompra));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(autoripagoordencompra.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				autoripagoordencompra.setCliente(autoripagoordencompraDataAccess.getCliente(connexion,autoripagoordencompra));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(autoripagoordencompra.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				autoripagoordencompra.setEmpresa(autoripagoordencompraDataAccess.getEmpresa(connexion,autoripagoordencompra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(autoripagoordencompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				autoripagoordencompra.setSucursal(autoripagoordencompraDataAccess.getSucursal(connexion,autoripagoordencompra));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(autoripagoordencompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				autoripagoordencompra.setOrdenCompra(autoripagoordencompraDataAccess.getOrdenCompra(connexion,autoripagoordencompra));
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepLoad(autoripagoordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				autoripagoordencompra.setTransaccion(autoripagoordencompraDataAccess.getTransaccion(connexion,autoripagoordencompra));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(autoripagoordencompra.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				autoripagoordencompra.setModulo(autoripagoordencompraDataAccess.getModulo(connexion,autoripagoordencompra));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(autoripagoordencompra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				autoripagoordencompra.setEjercicio(autoripagoordencompraDataAccess.getEjercicio(connexion,autoripagoordencompra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(autoripagoordencompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				autoripagoordencompra.setUsuario(autoripagoordencompraDataAccess.getUsuario(connexion,autoripagoordencompra));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(autoripagoordencompra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				autoripagoordencompra.setAsientoContable(autoripagoordencompraDataAccess.getAsientoContable(connexion,autoripagoordencompra));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(autoripagoordencompra.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				autoripagoordencompra.setBanco(autoripagoordencompraDataAccess.getBanco(connexion,autoripagoordencompra));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(autoripagoordencompra.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				autoripagoordencompra.setCuentaBanco(autoripagoordencompraDataAccess.getCuentaBanco(connexion,autoripagoordencompra));
				CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
				cuentabancoLogic.deepLoad(autoripagoordencompra.getCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setTipoCambio(autoripagoordencompraDataAccess.getTipoCambio(connexion,autoripagoordencompra));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(autoripagoordencompra.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setMoneda(autoripagoordencompraDataAccess.getMoneda(connexion,autoripagoordencompra));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(autoripagoordencompra.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setCliente(autoripagoordencompraDataAccess.getCliente(connexion,autoripagoordencompra));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(autoripagoordencompra.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setEmpresa(autoripagoordencompraDataAccess.getEmpresa(connexion,autoripagoordencompra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(autoripagoordencompra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setSucursal(autoripagoordencompraDataAccess.getSucursal(connexion,autoripagoordencompra));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(autoripagoordencompra.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(OrdenCompra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setOrdenCompra(autoripagoordencompraDataAccess.getOrdenCompra(connexion,autoripagoordencompra));
			OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
			ordencompraLogic.deepLoad(autoripagoordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setTransaccion(autoripagoordencompraDataAccess.getTransaccion(connexion,autoripagoordencompra));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(autoripagoordencompra.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setModulo(autoripagoordencompraDataAccess.getModulo(connexion,autoripagoordencompra));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(autoripagoordencompra.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setEjercicio(autoripagoordencompraDataAccess.getEjercicio(connexion,autoripagoordencompra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(autoripagoordencompra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setUsuario(autoripagoordencompraDataAccess.getUsuario(connexion,autoripagoordencompra));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(autoripagoordencompra.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setAsientoContable(autoripagoordencompraDataAccess.getAsientoContable(connexion,autoripagoordencompra));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(autoripagoordencompra.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setBanco(autoripagoordencompraDataAccess.getBanco(connexion,autoripagoordencompra));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(autoripagoordencompra.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoripagoordencompra.setCuentaBanco(autoripagoordencompraDataAccess.getCuentaBanco(connexion,autoripagoordencompra));
			CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
			cuentabancoLogic.deepLoad(autoripagoordencompra.getCuentaBanco(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AutoriPagoOrdenCompra autoripagoordencompra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AutoriPagoOrdenCompraLogicAdditional.updateAutoriPagoOrdenCompraToSave(autoripagoordencompra,this.arrDatoGeneral);
			
AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TipoCambioDataAccess.save(autoripagoordencompra.getTipoCambio(),connexion);

		MonedaDataAccess.save(autoripagoordencompra.getMoneda(),connexion);

		ClienteDataAccess.save(autoripagoordencompra.getCliente(),connexion);

		EmpresaDataAccess.save(autoripagoordencompra.getEmpresa(),connexion);

		SucursalDataAccess.save(autoripagoordencompra.getSucursal(),connexion);

		OrdenCompraDataAccess.save(autoripagoordencompra.getOrdenCompra(),connexion);

		TransaccionDataAccess.save(autoripagoordencompra.getTransaccion(),connexion);

		ModuloDataAccess.save(autoripagoordencompra.getModulo(),connexion);

		EjercicioDataAccess.save(autoripagoordencompra.getEjercicio(),connexion);

		UsuarioDataAccess.save(autoripagoordencompra.getUsuario(),connexion);

		AsientoContableDataAccess.save(autoripagoordencompra.getAsientoContable(),connexion);

		BancoDataAccess.save(autoripagoordencompra.getBanco(),connexion);

		CuentaBancoDataAccess.save(autoripagoordencompra.getCuentaBanco(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(autoripagoordencompra.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(autoripagoordencompra.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(autoripagoordencompra.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(autoripagoordencompra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(autoripagoordencompra.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				OrdenCompraDataAccess.save(autoripagoordencompra.getOrdenCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(autoripagoordencompra.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(autoripagoordencompra.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(autoripagoordencompra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(autoripagoordencompra.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(autoripagoordencompra.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(autoripagoordencompra.getBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				CuentaBancoDataAccess.save(autoripagoordencompra.getCuentaBanco(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		TipoCambioDataAccess.save(autoripagoordencompra.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(autoripagoordencompra.getTipoCambio(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(autoripagoordencompra.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(autoripagoordencompra.getMoneda(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(autoripagoordencompra.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(autoripagoordencompra.getCliente(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(autoripagoordencompra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autoripagoordencompra.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(autoripagoordencompra.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(autoripagoordencompra.getSucursal(),isDeep,deepLoadType,clases);
				

		OrdenCompraDataAccess.save(autoripagoordencompra.getOrdenCompra(),connexion);
		OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
		ordencompraLogic.deepLoad(autoripagoordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(autoripagoordencompra.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(autoripagoordencompra.getTransaccion(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(autoripagoordencompra.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(autoripagoordencompra.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(autoripagoordencompra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(autoripagoordencompra.getEjercicio(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(autoripagoordencompra.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(autoripagoordencompra.getUsuario(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(autoripagoordencompra.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(autoripagoordencompra.getAsientoContable(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(autoripagoordencompra.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(autoripagoordencompra.getBanco(),isDeep,deepLoadType,clases);
				

		CuentaBancoDataAccess.save(autoripagoordencompra.getCuentaBanco(),connexion);
		CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
		cuentabancoLogic.deepLoad(autoripagoordencompra.getCuentaBanco(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(autoripagoordencompra.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(autoripagoordencompra.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(autoripagoordencompra.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(autoripagoordencompra.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(autoripagoordencompra.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(autoripagoordencompra.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(autoripagoordencompra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(autoripagoordencompra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(autoripagoordencompra.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(autoripagoordencompra.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(OrdenCompra.class)) {
				OrdenCompraDataAccess.save(autoripagoordencompra.getOrdenCompra(),connexion);
				OrdenCompraLogic ordencompraLogic= new OrdenCompraLogic(connexion);
				ordencompraLogic.deepSave(autoripagoordencompra.getOrdenCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(autoripagoordencompra.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(autoripagoordencompra.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(autoripagoordencompra.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(autoripagoordencompra.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(autoripagoordencompra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(autoripagoordencompra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(autoripagoordencompra.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(autoripagoordencompra.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(autoripagoordencompra.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(autoripagoordencompra.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(autoripagoordencompra.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(autoripagoordencompra.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaBanco.class)) {
				CuentaBancoDataAccess.save(autoripagoordencompra.getCuentaBanco(),connexion);
				CuentaBancoLogic cuentabancoLogic= new CuentaBancoLogic(connexion);
				cuentabancoLogic.deepSave(autoripagoordencompra.getCuentaBanco(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AutoriPagoOrdenCompra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(autoripagoordencompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(autoripagoordencompra);
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
			this.deepLoad(this.autoripagoordencompra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AutoriPagoOrdenCompra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(autoripagoordencompras!=null) {
				for(AutoriPagoOrdenCompra autoripagoordencompra:autoripagoordencompras) {
					this.deepLoad(autoripagoordencompra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(autoripagoordencompras);
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
			if(autoripagoordencompras!=null) {
				for(AutoriPagoOrdenCompra autoripagoordencompra:autoripagoordencompras) {
					this.deepLoad(autoripagoordencompra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(autoripagoordencompras);
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
			this.getNewConnexionToDeep(AutoriPagoOrdenCompra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(autoripagoordencompra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AutoriPagoOrdenCompra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(autoripagoordencompras!=null) {
				for(AutoriPagoOrdenCompra autoripagoordencompra:autoripagoordencompras) {
					this.deepSave(autoripagoordencompra,isDeep,deepLoadType,clases);
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
			if(autoripagoordencompras!=null) {
				for(AutoriPagoOrdenCompra autoripagoordencompra:autoripagoordencompras) {
					this.deepSave(autoripagoordencompra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAutoriPagoOrdenComprasFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,AutoriPagoOrdenCompraConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,AutoriPagoOrdenCompraConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdCuentaBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_banco,AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaBanco);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdCuentaBanco(String sFinalQuery,Pagination pagination,Long id_cuenta_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_banco,AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaBanco);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,AutoriPagoOrdenCompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,AutoriPagoOrdenCompraConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdOrdenCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_orden_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_compra,AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenCompra);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdOrdenCompra(String sFinalQuery,Pagination pagination,Long id_orden_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOrdenCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOrdenCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_orden_compra,AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOrdenCompra);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOrdenCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriPagoOrdenCompra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriPagoOrdenComprasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AutoriPagoOrdenCompraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(this.autoripagoordencompras);
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
			if(AutoriPagoOrdenCompraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriPagoOrdenCompraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AutoriPagoOrdenCompra autoripagoordencompra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AutoriPagoOrdenCompraConstantesFunciones.ISCONAUDITORIA) {
				if(autoripagoordencompra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriPagoOrdenCompraDataAccess.TABLENAME, autoripagoordencompra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AutoriPagoOrdenCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AutoriPagoOrdenCompraLogic.registrarAuditoriaDetallesAutoriPagoOrdenCompra(connexion,autoripagoordencompra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(autoripagoordencompra.getIsDeleted()) {
					/*if(!autoripagoordencompra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AutoriPagoOrdenCompraDataAccess.TABLENAME, autoripagoordencompra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AutoriPagoOrdenCompraLogic.registrarAuditoriaDetallesAutoriPagoOrdenCompra(connexion,autoripagoordencompra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriPagoOrdenCompraDataAccess.TABLENAME, autoripagoordencompra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(autoripagoordencompra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriPagoOrdenCompraDataAccess.TABLENAME, autoripagoordencompra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AutoriPagoOrdenCompraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AutoriPagoOrdenCompraLogic.registrarAuditoriaDetallesAutoriPagoOrdenCompra(connexion,autoripagoordencompra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAutoriPagoOrdenCompra(Connexion connexion,AutoriPagoOrdenCompra autoripagoordencompra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_tipo_cambio().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_tipo_cambio().toString();
				}
				if(autoripagoordencompra.getid_tipo_cambio()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_moneda().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_moneda()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_moneda().toString();
				}
				if(autoripagoordencompra.getid_moneda()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_cliente().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_cliente()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_cliente().toString();
				}
				if(autoripagoordencompra.getid_cliente()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_empresa().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_empresa()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_empresa().toString();
				}
				if(autoripagoordencompra.getid_empresa()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_sucursal().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_sucursal()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_sucursal().toString();
				}
				if(autoripagoordencompra.getid_sucursal()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_orden_compra().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_orden_compra()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_orden_compra().toString();
				}
				if(autoripagoordencompra.getid_orden_compra()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_transaccion().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_transaccion()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_transaccion().toString();
				}
				if(autoripagoordencompra.getid_transaccion()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_modulo().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_modulo()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_modulo().toString();
				}
				if(autoripagoordencompra.getid_modulo()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_ejercicio().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_ejercicio().toString();
				}
				if(autoripagoordencompra.getid_ejercicio()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_usuario().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_usuario()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_usuario().toString();
				}
				if(autoripagoordencompra.getid_usuario()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_asiento_contable().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_asiento_contable().toString();
				}
				if(autoripagoordencompra.getid_asiento_contable()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_banco().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_banco()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_banco().toString();
				}
				if(autoripagoordencompra.getid_banco()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getid_cuenta_banco().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_cuenta_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_cuenta_banco()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getid_cuenta_banco().toString();
				}
				if(autoripagoordencompra.getid_cuenta_banco()!=null)
				{
					strValorNuevo=autoripagoordencompra.getid_cuenta_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.IDCUENTABANCO,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getnumero_comprobante().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getnumero_comprobante();
				}
				if(autoripagoordencompra.getnumero_comprobante()!=null)
				{
					strValorNuevo=autoripagoordencompra.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getfecha().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha().toString();
				}
				if(autoripagoordencompra.getfecha()!=null)
				{
					strValorNuevo=autoripagoordencompra.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getfecha_autori().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha_autori()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha_autori()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha_autori().toString();
				}
				if(autoripagoordencompra.getfecha_autori()!=null)
				{
					strValorNuevo=autoripagoordencompra.getfecha_autori().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.FECHAAUTORI,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.gettotal().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().gettotal()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().gettotal().toString();
				}
				if(autoripagoordencompra.gettotal()!=null)
				{
					strValorNuevo=autoripagoordencompra.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getfecha_servidor().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha_servidor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha_servidor()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha_servidor().toString();
				}
				if(autoripagoordencompra.getfecha_servidor()!=null)
				{
					strValorNuevo=autoripagoordencompra.getfecha_servidor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.FECHASERVIDOR,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getcodigo_asiento().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getcodigo_asiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getcodigo_asiento()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getcodigo_asiento();
				}
				if(autoripagoordencompra.getcodigo_asiento()!=null)
				{
					strValorNuevo=autoripagoordencompra.getcodigo_asiento() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.CODIGOASIENTO,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getfecha_asiento().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha_asiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha_asiento()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getfecha_asiento().toString();
				}
				if(autoripagoordencompra.getfecha_asiento()!=null)
				{
					strValorNuevo=autoripagoordencompra.getfecha_asiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.FECHAASIENTO,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.getvalor_asiento().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getvalor_asiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getvalor_asiento()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().getvalor_asiento().toString();
				}
				if(autoripagoordencompra.getvalor_asiento()!=null)
				{
					strValorNuevo=autoripagoordencompra.getvalor_asiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.VALORASIENTO,strValorActual,strValorNuevo);
			}	
			
			if(autoripagoordencompra.getIsNew()||!autoripagoordencompra.gettotal_saldo().equals(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().gettotal_saldo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().gettotal_saldo()!=null)
				{
					strValorActual=autoripagoordencompra.getAutoriPagoOrdenCompraOriginal().gettotal_saldo().toString();
				}
				if(autoripagoordencompra.gettotal_saldo()!=null)
				{
					strValorNuevo=autoripagoordencompra.gettotal_saldo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriPagoOrdenCompraConstantesFunciones.TOTALSALDO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAutoriPagoOrdenCompraRelacionesWithConnection(AutoriPagoOrdenCompra autoripagoordencompra) throws Exception {

		if(!autoripagoordencompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAutoriPagoOrdenCompraRelacionesBase(autoripagoordencompra,true);
		}
	}

	public void saveAutoriPagoOrdenCompraRelaciones(AutoriPagoOrdenCompra autoripagoordencompra)throws Exception {

		if(!autoripagoordencompra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAutoriPagoOrdenCompraRelacionesBase(autoripagoordencompra,false);
		}
	}

	public void saveAutoriPagoOrdenCompraRelacionesBase(AutoriPagoOrdenCompra autoripagoordencompra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AutoriPagoOrdenCompra-saveRelacionesWithConnection");}
	

			this.setAutoriPagoOrdenCompra(autoripagoordencompra);

			if(AutoriPagoOrdenCompraLogicAdditional.validarSaveRelaciones(autoripagoordencompra,this)) {

				AutoriPagoOrdenCompraLogicAdditional.updateRelacionesToSave(autoripagoordencompra,this);

				if((autoripagoordencompra.getIsNew()||autoripagoordencompra.getIsChanged())&&!autoripagoordencompra.getIsDeleted()) {
					this.saveAutoriPagoOrdenCompra();
					this.saveAutoriPagoOrdenCompraRelacionesDetalles();

				} else if(autoripagoordencompra.getIsDeleted()) {
					this.saveAutoriPagoOrdenCompraRelacionesDetalles();
					this.saveAutoriPagoOrdenCompra();
				}

				AutoriPagoOrdenCompraLogicAdditional.updateRelacionesToSaveAfter(autoripagoordencompra,this);

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
	
	
	private void saveAutoriPagoOrdenCompraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAutoriPagoOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AutoriPagoOrdenCompraConstantesFunciones.getClassesForeignKeysOfAutoriPagoOrdenCompra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriPagoOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AutoriPagoOrdenCompraConstantesFunciones.getClassesRelationshipsOfAutoriPagoOrdenCompra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
