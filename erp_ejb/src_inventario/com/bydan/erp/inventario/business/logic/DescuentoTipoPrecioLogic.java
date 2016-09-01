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
import com.bydan.erp.inventario.util.DescuentoTipoPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.DescuentoTipoPrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DescuentoTipoPrecioParameterGeneral;
import com.bydan.erp.inventario.business.entity.DescuentoTipoPrecio;
import com.bydan.erp.inventario.business.logic.DescuentoTipoPrecioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DescuentoTipoPrecioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DescuentoTipoPrecioLogic.class);
	
	protected DescuentoTipoPrecioDataAccess descuentotipoprecioDataAccess; 	
	protected DescuentoTipoPrecio descuentotipoprecio;
	protected List<DescuentoTipoPrecio> descuentotipoprecios;
	protected Object descuentotipoprecioObject;	
	protected List<Object> descuentotipopreciosObject;
	
	public static ClassValidator<DescuentoTipoPrecio> descuentotipoprecioValidator = new ClassValidator<DescuentoTipoPrecio>(DescuentoTipoPrecio.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DescuentoTipoPrecioLogicAdditional descuentotipoprecioLogicAdditional=null;
	
	public DescuentoTipoPrecioLogicAdditional getDescuentoTipoPrecioLogicAdditional() {
		return this.descuentotipoprecioLogicAdditional;
	}
	
	public void setDescuentoTipoPrecioLogicAdditional(DescuentoTipoPrecioLogicAdditional descuentotipoprecioLogicAdditional) {
		try {
			this.descuentotipoprecioLogicAdditional=descuentotipoprecioLogicAdditional;
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
	
	
	
	
	public  DescuentoTipoPrecioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.descuentotipoprecioDataAccess = new DescuentoTipoPrecioDataAccess();
			
			this.descuentotipoprecios= new ArrayList<DescuentoTipoPrecio>();
			this.descuentotipoprecio= new DescuentoTipoPrecio();
			
			this.descuentotipoprecioObject=new Object();
			this.descuentotipopreciosObject=new ArrayList<Object>();
				
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
			
			this.descuentotipoprecioDataAccess.setConnexionType(this.connexionType);
			this.descuentotipoprecioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DescuentoTipoPrecioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.descuentotipoprecioDataAccess = new DescuentoTipoPrecioDataAccess();
			this.descuentotipoprecios= new ArrayList<DescuentoTipoPrecio>();
			this.descuentotipoprecio= new DescuentoTipoPrecio();
			this.descuentotipoprecioObject=new Object();
			this.descuentotipopreciosObject=new ArrayList<Object>();
			
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
			
			this.descuentotipoprecioDataAccess.setConnexionType(this.connexionType);
			this.descuentotipoprecioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DescuentoTipoPrecio getDescuentoTipoPrecio() throws Exception {	
		DescuentoTipoPrecioLogicAdditional.checkDescuentoTipoPrecioToGet(descuentotipoprecio,this.datosCliente,this.arrDatoGeneral);
		DescuentoTipoPrecioLogicAdditional.updateDescuentoTipoPrecioToGet(descuentotipoprecio,this.arrDatoGeneral);
		
		return descuentotipoprecio;
	}
		
	public void setDescuentoTipoPrecio(DescuentoTipoPrecio newDescuentoTipoPrecio) {
		this.descuentotipoprecio = newDescuentoTipoPrecio;
	}
	
	public DescuentoTipoPrecioDataAccess getDescuentoTipoPrecioDataAccess() {
		return descuentotipoprecioDataAccess;
	}
	
	public void setDescuentoTipoPrecioDataAccess(DescuentoTipoPrecioDataAccess newdescuentotipoprecioDataAccess) {
		this.descuentotipoprecioDataAccess = newdescuentotipoprecioDataAccess;
	}
	
	public List<DescuentoTipoPrecio> getDescuentoTipoPrecios() throws Exception {		
		this.quitarDescuentoTipoPreciosNulos();
		
		DescuentoTipoPrecioLogicAdditional.checkDescuentoTipoPrecioToGets(descuentotipoprecios,this.datosCliente,this.arrDatoGeneral);
		
		for (DescuentoTipoPrecio descuentotipoprecioLocal: descuentotipoprecios ) {
			DescuentoTipoPrecioLogicAdditional.updateDescuentoTipoPrecioToGet(descuentotipoprecioLocal,this.arrDatoGeneral);
		}
		
		return descuentotipoprecios;
	}
	
	public void setDescuentoTipoPrecios(List<DescuentoTipoPrecio> newDescuentoTipoPrecios) {
		this.descuentotipoprecios = newDescuentoTipoPrecios;
	}
	
	public Object getDescuentoTipoPrecioObject() {	
		this.descuentotipoprecioObject=this.descuentotipoprecioDataAccess.getEntityObject();
		return this.descuentotipoprecioObject;
	}
		
	public void setDescuentoTipoPrecioObject(Object newDescuentoTipoPrecioObject) {
		this.descuentotipoprecioObject = newDescuentoTipoPrecioObject;
	}
	
	public List<Object> getDescuentoTipoPreciosObject() {		
		this.descuentotipopreciosObject=this.descuentotipoprecioDataAccess.getEntitiesObject();
		return this.descuentotipopreciosObject;
	}
		
	public void setDescuentoTipoPreciosObject(List<Object> newDescuentoTipoPreciosObject) {
		this.descuentotipopreciosObject = newDescuentoTipoPreciosObject;
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
		
		if(this.descuentotipoprecioDataAccess!=null) {
			this.descuentotipoprecioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			descuentotipoprecioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			descuentotipoprecioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		descuentotipoprecio = new  DescuentoTipoPrecio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			descuentotipoprecio=descuentotipoprecioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.descuentotipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecio);
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
		descuentotipoprecio = new  DescuentoTipoPrecio();
		  		  
        try {
			
			descuentotipoprecio=descuentotipoprecioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.descuentotipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		descuentotipoprecio = new  DescuentoTipoPrecio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			descuentotipoprecio=descuentotipoprecioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.descuentotipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecio);
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
		descuentotipoprecio = new  DescuentoTipoPrecio();
		  		  
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
		descuentotipoprecio = new  DescuentoTipoPrecio();
		  		  
        try {
			
			descuentotipoprecio=descuentotipoprecioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.descuentotipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		descuentotipoprecio = new  DescuentoTipoPrecio();
		  		  
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
		descuentotipoprecio = new  DescuentoTipoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =descuentotipoprecioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		descuentotipoprecio = new  DescuentoTipoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=descuentotipoprecioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		descuentotipoprecio = new  DescuentoTipoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =descuentotipoprecioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		descuentotipoprecio = new  DescuentoTipoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=descuentotipoprecioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		descuentotipoprecio = new  DescuentoTipoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =descuentotipoprecioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		descuentotipoprecio = new  DescuentoTipoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=descuentotipoprecioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
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
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		  		  
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
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		  		  
        try {			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		  		  
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
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
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
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		  		  
        try {
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
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
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
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
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		descuentotipoprecio = new  DescuentoTipoPrecio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecio=descuentotipoprecioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecio);
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
		descuentotipoprecio = new  DescuentoTipoPrecio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecio=descuentotipoprecioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
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
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		  		  
        try {
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDescuentoTipoPreciosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getTodosDescuentoTipoPreciosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
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
	
	public  void  getTodosDescuentoTipoPrecios(String sFinalQuery,Pagination pagination)throws Exception {
		descuentotipoprecios = new  ArrayList<DescuentoTipoPrecio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDescuentoTipoPrecio(descuentotipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDescuentoTipoPrecio(DescuentoTipoPrecio descuentotipoprecio) throws Exception {
		Boolean estaValidado=false;
		
		if(descuentotipoprecio.getIsNew() || descuentotipoprecio.getIsChanged()) { 
			this.invalidValues = descuentotipoprecioValidator.getInvalidValues(descuentotipoprecio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(descuentotipoprecio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDescuentoTipoPrecio(List<DescuentoTipoPrecio> DescuentoTipoPrecios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DescuentoTipoPrecio descuentotipoprecioLocal:descuentotipoprecios) {				
			estaValidadoObjeto=this.validarGuardarDescuentoTipoPrecio(descuentotipoprecioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDescuentoTipoPrecio(List<DescuentoTipoPrecio> DescuentoTipoPrecios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDescuentoTipoPrecio(descuentotipoprecios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDescuentoTipoPrecio(DescuentoTipoPrecio DescuentoTipoPrecio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDescuentoTipoPrecio(descuentotipoprecio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DescuentoTipoPrecio descuentotipoprecio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+descuentotipoprecio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DescuentoTipoPrecioConstantesFunciones.getDescuentoTipoPrecioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"descuentotipoprecio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DescuentoTipoPrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DescuentoTipoPrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDescuentoTipoPrecioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-saveDescuentoTipoPrecioWithConnection");connexion.begin();			
			
			DescuentoTipoPrecioLogicAdditional.checkDescuentoTipoPrecioToSave(this.descuentotipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DescuentoTipoPrecioLogicAdditional.updateDescuentoTipoPrecioToSave(this.descuentotipoprecio,this.arrDatoGeneral);
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.descuentotipoprecio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDescuentoTipoPrecio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDescuentoTipoPrecio(this.descuentotipoprecio)) {
				DescuentoTipoPrecioDataAccess.save(this.descuentotipoprecio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.descuentotipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DescuentoTipoPrecioLogicAdditional.checkDescuentoTipoPrecioToSaveAfter(this.descuentotipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDescuentoTipoPrecio();
			
			connexion.commit();			
			
			if(this.descuentotipoprecio.getIsDeleted()) {
				this.descuentotipoprecio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDescuentoTipoPrecio()throws Exception {	
		try {	
			
			DescuentoTipoPrecioLogicAdditional.checkDescuentoTipoPrecioToSave(this.descuentotipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DescuentoTipoPrecioLogicAdditional.updateDescuentoTipoPrecioToSave(this.descuentotipoprecio,this.arrDatoGeneral);
			
			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.descuentotipoprecio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDescuentoTipoPrecio(this.descuentotipoprecio)) {			
				DescuentoTipoPrecioDataAccess.save(this.descuentotipoprecio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.descuentotipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DescuentoTipoPrecioLogicAdditional.checkDescuentoTipoPrecioToSaveAfter(this.descuentotipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.descuentotipoprecio.getIsDeleted()) {
				this.descuentotipoprecio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDescuentoTipoPreciosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-saveDescuentoTipoPreciosWithConnection");connexion.begin();			
			
			DescuentoTipoPrecioLogicAdditional.checkDescuentoTipoPrecioToSaves(descuentotipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDescuentoTipoPrecios();
			
			Boolean validadoTodosDescuentoTipoPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DescuentoTipoPrecio descuentotipoprecioLocal:descuentotipoprecios) {		
				if(descuentotipoprecioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DescuentoTipoPrecioLogicAdditional.updateDescuentoTipoPrecioToSave(descuentotipoprecioLocal,this.arrDatoGeneral);
	        	
				DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),descuentotipoprecioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDescuentoTipoPrecio(descuentotipoprecioLocal)) {
					DescuentoTipoPrecioDataAccess.save(descuentotipoprecioLocal, connexion);				
				} else {
					validadoTodosDescuentoTipoPrecio=false;
				}
			}
			
			if(!validadoTodosDescuentoTipoPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DescuentoTipoPrecioLogicAdditional.checkDescuentoTipoPrecioToSavesAfter(descuentotipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDescuentoTipoPrecios();
			
			connexion.commit();		
			
			this.quitarDescuentoTipoPreciosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDescuentoTipoPrecios()throws Exception {				
		 try {	
			DescuentoTipoPrecioLogicAdditional.checkDescuentoTipoPrecioToSaves(descuentotipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDescuentoTipoPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DescuentoTipoPrecio descuentotipoprecioLocal:descuentotipoprecios) {				
				if(descuentotipoprecioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DescuentoTipoPrecioLogicAdditional.updateDescuentoTipoPrecioToSave(descuentotipoprecioLocal,this.arrDatoGeneral);
	        	
				DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),descuentotipoprecioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDescuentoTipoPrecio(descuentotipoprecioLocal)) {				
					DescuentoTipoPrecioDataAccess.save(descuentotipoprecioLocal, connexion);				
				} else {
					validadoTodosDescuentoTipoPrecio=false;
				}
			}
			
			if(!validadoTodosDescuentoTipoPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DescuentoTipoPrecioLogicAdditional.checkDescuentoTipoPrecioToSavesAfter(descuentotipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDescuentoTipoPreciosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DescuentoTipoPrecioParameterReturnGeneral procesarAccionDescuentoTipoPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DescuentoTipoPrecio> descuentotipoprecios,DescuentoTipoPrecioParameterReturnGeneral descuentotipoprecioParameterGeneral)throws Exception {
		 try {	
			DescuentoTipoPrecioParameterReturnGeneral descuentotipoprecioReturnGeneral=new DescuentoTipoPrecioParameterReturnGeneral();
	
			DescuentoTipoPrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,descuentotipoprecios,descuentotipoprecioParameterGeneral,descuentotipoprecioReturnGeneral);
			
			return descuentotipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DescuentoTipoPrecioParameterReturnGeneral procesarAccionDescuentoTipoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DescuentoTipoPrecio> descuentotipoprecios,DescuentoTipoPrecioParameterReturnGeneral descuentotipoprecioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-procesarAccionDescuentoTipoPreciosWithConnection");connexion.begin();			
			
			DescuentoTipoPrecioParameterReturnGeneral descuentotipoprecioReturnGeneral=new DescuentoTipoPrecioParameterReturnGeneral();
	
			DescuentoTipoPrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,descuentotipoprecios,descuentotipoprecioParameterGeneral,descuentotipoprecioReturnGeneral);
			
			this.connexion.commit();
			
			return descuentotipoprecioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DescuentoTipoPrecioParameterReturnGeneral procesarEventosDescuentoTipoPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DescuentoTipoPrecio> descuentotipoprecios,DescuentoTipoPrecio descuentotipoprecio,DescuentoTipoPrecioParameterReturnGeneral descuentotipoprecioParameterGeneral,Boolean isEsNuevoDescuentoTipoPrecio,ArrayList<Classe> clases)throws Exception {
		 try {	
			DescuentoTipoPrecioParameterReturnGeneral descuentotipoprecioReturnGeneral=new DescuentoTipoPrecioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				descuentotipoprecioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DescuentoTipoPrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,descuentotipoprecios,descuentotipoprecio,descuentotipoprecioParameterGeneral,descuentotipoprecioReturnGeneral,isEsNuevoDescuentoTipoPrecio,clases);
			
			return descuentotipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DescuentoTipoPrecioParameterReturnGeneral procesarEventosDescuentoTipoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DescuentoTipoPrecio> descuentotipoprecios,DescuentoTipoPrecio descuentotipoprecio,DescuentoTipoPrecioParameterReturnGeneral descuentotipoprecioParameterGeneral,Boolean isEsNuevoDescuentoTipoPrecio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-procesarEventosDescuentoTipoPreciosWithConnection");connexion.begin();			
			
			DescuentoTipoPrecioParameterReturnGeneral descuentotipoprecioReturnGeneral=new DescuentoTipoPrecioParameterReturnGeneral();
	
			descuentotipoprecioReturnGeneral.setDescuentoTipoPrecio(descuentotipoprecio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				descuentotipoprecioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DescuentoTipoPrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,descuentotipoprecios,descuentotipoprecio,descuentotipoprecioParameterGeneral,descuentotipoprecioReturnGeneral,isEsNuevoDescuentoTipoPrecio,clases);
			
			this.connexion.commit();
			
			return descuentotipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DescuentoTipoPrecioParameterReturnGeneral procesarImportacionDescuentoTipoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DescuentoTipoPrecioParameterReturnGeneral descuentotipoprecioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-procesarImportacionDescuentoTipoPreciosWithConnection");connexion.begin();			
			
			DescuentoTipoPrecioParameterReturnGeneral descuentotipoprecioReturnGeneral=new DescuentoTipoPrecioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.descuentotipoprecios=new ArrayList<DescuentoTipoPrecio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.descuentotipoprecio=new DescuentoTipoPrecio();
				
				
				if(conColumnasBase) {this.descuentotipoprecio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.descuentotipoprecio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.descuentotipoprecio.setdescripcion(arrColumnas[iColumn++]);
				this.descuentotipoprecio.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.descuentotipoprecio.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.descuentotipoprecio.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.descuentotipoprecio.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.descuentotipoprecios.add(this.descuentotipoprecio);
			}
			
			this.saveDescuentoTipoPrecios();
			
			this.connexion.commit();
			
			descuentotipoprecioReturnGeneral.setConRetornoEstaProcesado(true);
			descuentotipoprecioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return descuentotipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDescuentoTipoPreciosEliminados() throws Exception {				
		
		List<DescuentoTipoPrecio> descuentotipopreciosAux= new ArrayList<DescuentoTipoPrecio>();
		
		for(DescuentoTipoPrecio descuentotipoprecio:descuentotipoprecios) {
			if(!descuentotipoprecio.getIsDeleted()) {
				descuentotipopreciosAux.add(descuentotipoprecio);
			}
		}
		
		descuentotipoprecios=descuentotipopreciosAux;
	}
	
	public void quitarDescuentoTipoPreciosNulos() throws Exception {				
		
		List<DescuentoTipoPrecio> descuentotipopreciosAux= new ArrayList<DescuentoTipoPrecio>();
		
		for(DescuentoTipoPrecio descuentotipoprecio : this.descuentotipoprecios) {
			if(descuentotipoprecio==null) {
				descuentotipopreciosAux.add(descuentotipoprecio);
			}
		}
		
		//this.descuentotipoprecios=descuentotipopreciosAux;
		
		this.descuentotipoprecios.removeAll(descuentotipopreciosAux);
	}
	
	public void getSetVersionRowDescuentoTipoPrecioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(descuentotipoprecio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((descuentotipoprecio.getIsDeleted() || (descuentotipoprecio.getIsChanged()&&!descuentotipoprecio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=descuentotipoprecioDataAccess.getSetVersionRowDescuentoTipoPrecio(connexion,descuentotipoprecio.getId());
				
				if(!descuentotipoprecio.getVersionRow().equals(timestamp)) {	
					descuentotipoprecio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				descuentotipoprecio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDescuentoTipoPrecio()throws Exception {	
		
		if(descuentotipoprecio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((descuentotipoprecio.getIsDeleted() || (descuentotipoprecio.getIsChanged()&&!descuentotipoprecio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=descuentotipoprecioDataAccess.getSetVersionRowDescuentoTipoPrecio(connexion,descuentotipoprecio.getId());
			
			try {							
				if(!descuentotipoprecio.getVersionRow().equals(timestamp)) {	
					descuentotipoprecio.setVersionRow(timestamp);
				}
				
				descuentotipoprecio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDescuentoTipoPreciosWithConnection()throws Exception {	
		if(descuentotipoprecios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DescuentoTipoPrecio descuentotipoprecioAux:descuentotipoprecios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(descuentotipoprecioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(descuentotipoprecioAux.getIsDeleted() || (descuentotipoprecioAux.getIsChanged()&&!descuentotipoprecioAux.getIsNew())) {
						
						timestamp=descuentotipoprecioDataAccess.getSetVersionRowDescuentoTipoPrecio(connexion,descuentotipoprecioAux.getId());
						
						if(!descuentotipoprecio.getVersionRow().equals(timestamp)) {	
							descuentotipoprecioAux.setVersionRow(timestamp);
						}
								
						descuentotipoprecioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDescuentoTipoPrecios()throws Exception {	
		if(descuentotipoprecios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DescuentoTipoPrecio descuentotipoprecioAux:descuentotipoprecios) {
					if(descuentotipoprecioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(descuentotipoprecioAux.getIsDeleted() || (descuentotipoprecioAux.getIsChanged()&&!descuentotipoprecioAux.getIsNew())) {
						
						timestamp=descuentotipoprecioDataAccess.getSetVersionRowDescuentoTipoPrecio(connexion,descuentotipoprecioAux.getId());
						
						if(!descuentotipoprecioAux.getVersionRow().equals(timestamp)) {	
							descuentotipoprecioAux.setVersionRow(timestamp);
						}
						
													
						descuentotipoprecioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DescuentoTipoPrecioParameterReturnGeneral cargarCombosLoteForeignKeyDescuentoTipoPrecioWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalBodega,String finalQueryGlobalTipoPrecio) throws Exception {
		DescuentoTipoPrecioParameterReturnGeneral  descuentotipoprecioReturnGeneral =new DescuentoTipoPrecioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-cargarCombosLoteForeignKeyDescuentoTipoPrecioWithConnection");connexion.begin();
			
			descuentotipoprecioReturnGeneral =new DescuentoTipoPrecioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			descuentotipoprecioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			descuentotipoprecioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			descuentotipoprecioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			descuentotipoprecioReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			descuentotipoprecioReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return descuentotipoprecioReturnGeneral;
	}
	
	public DescuentoTipoPrecioParameterReturnGeneral cargarCombosLoteForeignKeyDescuentoTipoPrecio(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalBodega,String finalQueryGlobalTipoPrecio) throws Exception {
		DescuentoTipoPrecioParameterReturnGeneral  descuentotipoprecioReturnGeneral =new DescuentoTipoPrecioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			descuentotipoprecioReturnGeneral =new DescuentoTipoPrecioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			descuentotipoprecioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			descuentotipoprecioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			descuentotipoprecioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			descuentotipoprecioReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			descuentotipoprecioReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return descuentotipoprecioReturnGeneral;
	}
	
	
	public void deepLoad(DescuentoTipoPrecio descuentotipoprecio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DescuentoTipoPrecioLogicAdditional.updateDescuentoTipoPrecioToGet(descuentotipoprecio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		descuentotipoprecio.setEmpresa(descuentotipoprecioDataAccess.getEmpresa(connexion,descuentotipoprecio));
		descuentotipoprecio.setSucursal(descuentotipoprecioDataAccess.getSucursal(connexion,descuentotipoprecio));
		descuentotipoprecio.setUsuario(descuentotipoprecioDataAccess.getUsuario(connexion,descuentotipoprecio));
		descuentotipoprecio.setBodega(descuentotipoprecioDataAccess.getBodega(connexion,descuentotipoprecio));
		descuentotipoprecio.setTipoPrecio(descuentotipoprecioDataAccess.getTipoPrecio(connexion,descuentotipoprecio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				descuentotipoprecio.setEmpresa(descuentotipoprecioDataAccess.getEmpresa(connexion,descuentotipoprecio));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				descuentotipoprecio.setSucursal(descuentotipoprecioDataAccess.getSucursal(connexion,descuentotipoprecio));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				descuentotipoprecio.setUsuario(descuentotipoprecioDataAccess.getUsuario(connexion,descuentotipoprecio));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				descuentotipoprecio.setBodega(descuentotipoprecioDataAccess.getBodega(connexion,descuentotipoprecio));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				descuentotipoprecio.setTipoPrecio(descuentotipoprecioDataAccess.getTipoPrecio(connexion,descuentotipoprecio));
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
			descuentotipoprecio.setEmpresa(descuentotipoprecioDataAccess.getEmpresa(connexion,descuentotipoprecio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentotipoprecio.setSucursal(descuentotipoprecioDataAccess.getSucursal(connexion,descuentotipoprecio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentotipoprecio.setUsuario(descuentotipoprecioDataAccess.getUsuario(connexion,descuentotipoprecio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentotipoprecio.setBodega(descuentotipoprecioDataAccess.getBodega(connexion,descuentotipoprecio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentotipoprecio.setTipoPrecio(descuentotipoprecioDataAccess.getTipoPrecio(connexion,descuentotipoprecio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		descuentotipoprecio.setEmpresa(descuentotipoprecioDataAccess.getEmpresa(connexion,descuentotipoprecio));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(descuentotipoprecio.getEmpresa(),isDeep,deepLoadType,clases);
				
		descuentotipoprecio.setSucursal(descuentotipoprecioDataAccess.getSucursal(connexion,descuentotipoprecio));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(descuentotipoprecio.getSucursal(),isDeep,deepLoadType,clases);
				
		descuentotipoprecio.setUsuario(descuentotipoprecioDataAccess.getUsuario(connexion,descuentotipoprecio));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(descuentotipoprecio.getUsuario(),isDeep,deepLoadType,clases);
				
		descuentotipoprecio.setBodega(descuentotipoprecioDataAccess.getBodega(connexion,descuentotipoprecio));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(descuentotipoprecio.getBodega(),isDeep,deepLoadType,clases);
				
		descuentotipoprecio.setTipoPrecio(descuentotipoprecioDataAccess.getTipoPrecio(connexion,descuentotipoprecio));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(descuentotipoprecio.getTipoPrecio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				descuentotipoprecio.setEmpresa(descuentotipoprecioDataAccess.getEmpresa(connexion,descuentotipoprecio));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(descuentotipoprecio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				descuentotipoprecio.setSucursal(descuentotipoprecioDataAccess.getSucursal(connexion,descuentotipoprecio));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(descuentotipoprecio.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				descuentotipoprecio.setUsuario(descuentotipoprecioDataAccess.getUsuario(connexion,descuentotipoprecio));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(descuentotipoprecio.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				descuentotipoprecio.setBodega(descuentotipoprecioDataAccess.getBodega(connexion,descuentotipoprecio));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(descuentotipoprecio.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				descuentotipoprecio.setTipoPrecio(descuentotipoprecioDataAccess.getTipoPrecio(connexion,descuentotipoprecio));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(descuentotipoprecio.getTipoPrecio(),isDeep,deepLoadType,clases);				
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
			descuentotipoprecio.setEmpresa(descuentotipoprecioDataAccess.getEmpresa(connexion,descuentotipoprecio));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(descuentotipoprecio.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentotipoprecio.setSucursal(descuentotipoprecioDataAccess.getSucursal(connexion,descuentotipoprecio));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(descuentotipoprecio.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentotipoprecio.setUsuario(descuentotipoprecioDataAccess.getUsuario(connexion,descuentotipoprecio));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(descuentotipoprecio.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentotipoprecio.setBodega(descuentotipoprecioDataAccess.getBodega(connexion,descuentotipoprecio));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(descuentotipoprecio.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			descuentotipoprecio.setTipoPrecio(descuentotipoprecioDataAccess.getTipoPrecio(connexion,descuentotipoprecio));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(descuentotipoprecio.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DescuentoTipoPrecio descuentotipoprecio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DescuentoTipoPrecioLogicAdditional.updateDescuentoTipoPrecioToSave(descuentotipoprecio,this.arrDatoGeneral);
			
DescuentoTipoPrecioDataAccess.save(descuentotipoprecio, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(descuentotipoprecio.getEmpresa(),connexion);

		SucursalDataAccess.save(descuentotipoprecio.getSucursal(),connexion);

		UsuarioDataAccess.save(descuentotipoprecio.getUsuario(),connexion);

		BodegaDataAccess.save(descuentotipoprecio.getBodega(),connexion);

		TipoPrecioDataAccess.save(descuentotipoprecio.getTipoPrecio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(descuentotipoprecio.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(descuentotipoprecio.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(descuentotipoprecio.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(descuentotipoprecio.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(descuentotipoprecio.getTipoPrecio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(descuentotipoprecio.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(descuentotipoprecio.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(descuentotipoprecio.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(descuentotipoprecio.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(descuentotipoprecio.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(descuentotipoprecio.getUsuario(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(descuentotipoprecio.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(descuentotipoprecio.getBodega(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(descuentotipoprecio.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(descuentotipoprecio.getTipoPrecio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(descuentotipoprecio.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(descuentotipoprecio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(descuentotipoprecio.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(descuentotipoprecio.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(descuentotipoprecio.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(descuentotipoprecio.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(descuentotipoprecio.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(descuentotipoprecio.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(descuentotipoprecio.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(descuentotipoprecio.getTipoPrecio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DescuentoTipoPrecio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(descuentotipoprecio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(descuentotipoprecio);
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
			this.deepLoad(this.descuentotipoprecio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DescuentoTipoPrecio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(descuentotipoprecios!=null) {
				for(DescuentoTipoPrecio descuentotipoprecio:descuentotipoprecios) {
					this.deepLoad(descuentotipoprecio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(descuentotipoprecios);
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
			if(descuentotipoprecios!=null) {
				for(DescuentoTipoPrecio descuentotipoprecio:descuentotipoprecios) {
					this.deepLoad(descuentotipoprecio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(descuentotipoprecios);
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
			this.getNewConnexionToDeep(DescuentoTipoPrecio.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(descuentotipoprecio,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DescuentoTipoPrecio.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(descuentotipoprecios!=null) {
				for(DescuentoTipoPrecio descuentotipoprecio:descuentotipoprecios) {
					this.deepSave(descuentotipoprecio,isDeep,deepLoadType,clases);
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
			if(descuentotipoprecios!=null) {
				for(DescuentoTipoPrecio descuentotipoprecio:descuentotipoprecios) {
					this.deepSave(descuentotipoprecio,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDescuentoTipoPreciosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DescuentoTipoPrecioConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDescuentoTipoPreciosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DescuentoTipoPrecioConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDescuentoTipoPreciosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DescuentoTipoPrecioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDescuentoTipoPreciosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DescuentoTipoPrecioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDescuentoTipoPreciosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDescuentoTipoPreciosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDescuentoTipoPreciosFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDescuentoTipoPreciosFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDescuentoTipoPreciosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DescuentoTipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,DescuentoTipoPrecioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDescuentoTipoPreciosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,DescuentoTipoPrecioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			DescuentoTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DescuentoTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesDescuentoTipoPrecio(this.descuentotipoprecios);
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
			if(DescuentoTipoPrecioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DescuentoTipoPrecioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DescuentoTipoPrecio descuentotipoprecio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DescuentoTipoPrecioConstantesFunciones.ISCONAUDITORIA) {
				if(descuentotipoprecio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DescuentoTipoPrecioDataAccess.TABLENAME, descuentotipoprecio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DescuentoTipoPrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DescuentoTipoPrecioLogic.registrarAuditoriaDetallesDescuentoTipoPrecio(connexion,descuentotipoprecio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(descuentotipoprecio.getIsDeleted()) {
					/*if(!descuentotipoprecio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DescuentoTipoPrecioDataAccess.TABLENAME, descuentotipoprecio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DescuentoTipoPrecioLogic.registrarAuditoriaDetallesDescuentoTipoPrecio(connexion,descuentotipoprecio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DescuentoTipoPrecioDataAccess.TABLENAME, descuentotipoprecio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(descuentotipoprecio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DescuentoTipoPrecioDataAccess.TABLENAME, descuentotipoprecio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DescuentoTipoPrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DescuentoTipoPrecioLogic.registrarAuditoriaDetallesDescuentoTipoPrecio(connexion,descuentotipoprecio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDescuentoTipoPrecio(Connexion connexion,DescuentoTipoPrecio descuentotipoprecio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(descuentotipoprecio.getIsNew()||!descuentotipoprecio.getid_empresa().equals(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_empresa()!=null)
				{
					strValorActual=descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_empresa().toString();
				}
				if(descuentotipoprecio.getid_empresa()!=null)
				{
					strValorNuevo=descuentotipoprecio.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoTipoPrecioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(descuentotipoprecio.getIsNew()||!descuentotipoprecio.getid_sucursal().equals(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_sucursal()!=null)
				{
					strValorActual=descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_sucursal().toString();
				}
				if(descuentotipoprecio.getid_sucursal()!=null)
				{
					strValorNuevo=descuentotipoprecio.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoTipoPrecioConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(descuentotipoprecio.getIsNew()||!descuentotipoprecio.getid_usuario().equals(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_usuario()!=null)
				{
					strValorActual=descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_usuario().toString();
				}
				if(descuentotipoprecio.getid_usuario()!=null)
				{
					strValorNuevo=descuentotipoprecio.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoTipoPrecioConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(descuentotipoprecio.getIsNew()||!descuentotipoprecio.getid_bodega().equals(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_bodega()!=null)
				{
					strValorActual=descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_bodega().toString();
				}
				if(descuentotipoprecio.getid_bodega()!=null)
				{
					strValorNuevo=descuentotipoprecio.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoTipoPrecioConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(descuentotipoprecio.getIsNew()||!descuentotipoprecio.getid_tipo_precio().equals(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=descuentotipoprecio.getDescuentoTipoPrecioOriginal().getid_tipo_precio().toString();
				}
				if(descuentotipoprecio.getid_tipo_precio()!=null)
				{
					strValorNuevo=descuentotipoprecio.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoTipoPrecioConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(descuentotipoprecio.getIsNew()||!descuentotipoprecio.getdescripcion().equals(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getdescripcion()!=null)
				{
					strValorActual=descuentotipoprecio.getDescuentoTipoPrecioOriginal().getdescripcion();
				}
				if(descuentotipoprecio.getdescripcion()!=null)
				{
					strValorNuevo=descuentotipoprecio.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoTipoPrecioConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(descuentotipoprecio.getIsNew()||!descuentotipoprecio.getporcentaje().equals(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getporcentaje()!=null)
				{
					strValorActual=descuentotipoprecio.getDescuentoTipoPrecioOriginal().getporcentaje().toString();
				}
				if(descuentotipoprecio.getporcentaje()!=null)
				{
					strValorNuevo=descuentotipoprecio.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoTipoPrecioConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(descuentotipoprecio.getIsNew()||!descuentotipoprecio.getfecha_inicio().equals(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getfecha_inicio()!=null)
				{
					strValorActual=descuentotipoprecio.getDescuentoTipoPrecioOriginal().getfecha_inicio().toString();
				}
				if(descuentotipoprecio.getfecha_inicio()!=null)
				{
					strValorNuevo=descuentotipoprecio.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoTipoPrecioConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(descuentotipoprecio.getIsNew()||!descuentotipoprecio.getfecha_fin().equals(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getfecha_fin()!=null)
				{
					strValorActual=descuentotipoprecio.getDescuentoTipoPrecioOriginal().getfecha_fin().toString();
				}
				if(descuentotipoprecio.getfecha_fin()!=null)
				{
					strValorNuevo=descuentotipoprecio.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoTipoPrecioConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(descuentotipoprecio.getIsNew()||!descuentotipoprecio.getesta_activo().equals(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(descuentotipoprecio.getDescuentoTipoPrecioOriginal().getesta_activo()!=null)
				{
					strValorActual=descuentotipoprecio.getDescuentoTipoPrecioOriginal().getesta_activo().toString();
				}
				if(descuentotipoprecio.getesta_activo()!=null)
				{
					strValorNuevo=descuentotipoprecio.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DescuentoTipoPrecioConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDescuentoTipoPrecioRelacionesWithConnection(DescuentoTipoPrecio descuentotipoprecio) throws Exception {

		if(!descuentotipoprecio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDescuentoTipoPrecioRelacionesBase(descuentotipoprecio,true);
		}
	}

	public void saveDescuentoTipoPrecioRelaciones(DescuentoTipoPrecio descuentotipoprecio)throws Exception {

		if(!descuentotipoprecio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDescuentoTipoPrecioRelacionesBase(descuentotipoprecio,false);
		}
	}

	public void saveDescuentoTipoPrecioRelacionesBase(DescuentoTipoPrecio descuentotipoprecio,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DescuentoTipoPrecio-saveRelacionesWithConnection");}
	

			this.setDescuentoTipoPrecio(descuentotipoprecio);

			if(DescuentoTipoPrecioLogicAdditional.validarSaveRelaciones(descuentotipoprecio,this)) {

				DescuentoTipoPrecioLogicAdditional.updateRelacionesToSave(descuentotipoprecio,this);

				if((descuentotipoprecio.getIsNew()||descuentotipoprecio.getIsChanged())&&!descuentotipoprecio.getIsDeleted()) {
					this.saveDescuentoTipoPrecio();
					this.saveDescuentoTipoPrecioRelacionesDetalles();

				} else if(descuentotipoprecio.getIsDeleted()) {
					this.saveDescuentoTipoPrecioRelacionesDetalles();
					this.saveDescuentoTipoPrecio();
				}

				DescuentoTipoPrecioLogicAdditional.updateRelacionesToSaveAfter(descuentotipoprecio,this);

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
	
	
	private void saveDescuentoTipoPrecioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDescuentoTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DescuentoTipoPrecioConstantesFunciones.getClassesForeignKeysOfDescuentoTipoPrecio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDescuentoTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DescuentoTipoPrecioConstantesFunciones.getClassesRelationshipsOfDescuentoTipoPrecio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
