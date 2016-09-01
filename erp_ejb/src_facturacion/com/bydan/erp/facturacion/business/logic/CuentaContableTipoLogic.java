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
import com.bydan.erp.facturacion.util.CuentaContableTipoConstantesFunciones;
import com.bydan.erp.facturacion.util.CuentaContableTipoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.CuentaContableTipoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.CuentaContableTipo;
import com.bydan.erp.facturacion.business.logic.CuentaContableTipoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

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
public class CuentaContableTipoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuentaContableTipoLogic.class);
	
	protected CuentaContableTipoDataAccess cuentacontabletipoDataAccess; 	
	protected CuentaContableTipo cuentacontabletipo;
	protected List<CuentaContableTipo> cuentacontabletipos;
	protected Object cuentacontabletipoObject;	
	protected List<Object> cuentacontabletiposObject;
	
	public static ClassValidator<CuentaContableTipo> cuentacontabletipoValidator = new ClassValidator<CuentaContableTipo>(CuentaContableTipo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuentaContableTipoLogicAdditional cuentacontabletipoLogicAdditional=null;
	
	public CuentaContableTipoLogicAdditional getCuentaContableTipoLogicAdditional() {
		return this.cuentacontabletipoLogicAdditional;
	}
	
	public void setCuentaContableTipoLogicAdditional(CuentaContableTipoLogicAdditional cuentacontabletipoLogicAdditional) {
		try {
			this.cuentacontabletipoLogicAdditional=cuentacontabletipoLogicAdditional;
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
	
	
	
	
	public  CuentaContableTipoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuentacontabletipoDataAccess = new CuentaContableTipoDataAccess();
			
			this.cuentacontabletipos= new ArrayList<CuentaContableTipo>();
			this.cuentacontabletipo= new CuentaContableTipo();
			
			this.cuentacontabletipoObject=new Object();
			this.cuentacontabletiposObject=new ArrayList<Object>();
				
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
			
			this.cuentacontabletipoDataAccess.setConnexionType(this.connexionType);
			this.cuentacontabletipoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuentaContableTipoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuentacontabletipoDataAccess = new CuentaContableTipoDataAccess();
			this.cuentacontabletipos= new ArrayList<CuentaContableTipo>();
			this.cuentacontabletipo= new CuentaContableTipo();
			this.cuentacontabletipoObject=new Object();
			this.cuentacontabletiposObject=new ArrayList<Object>();
			
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
			
			this.cuentacontabletipoDataAccess.setConnexionType(this.connexionType);
			this.cuentacontabletipoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CuentaContableTipo getCuentaContableTipo() throws Exception {	
		CuentaContableTipoLogicAdditional.checkCuentaContableTipoToGet(cuentacontabletipo,this.datosCliente,this.arrDatoGeneral);
		CuentaContableTipoLogicAdditional.updateCuentaContableTipoToGet(cuentacontabletipo,this.arrDatoGeneral);
		
		return cuentacontabletipo;
	}
		
	public void setCuentaContableTipo(CuentaContableTipo newCuentaContableTipo) {
		this.cuentacontabletipo = newCuentaContableTipo;
	}
	
	public CuentaContableTipoDataAccess getCuentaContableTipoDataAccess() {
		return cuentacontabletipoDataAccess;
	}
	
	public void setCuentaContableTipoDataAccess(CuentaContableTipoDataAccess newcuentacontabletipoDataAccess) {
		this.cuentacontabletipoDataAccess = newcuentacontabletipoDataAccess;
	}
	
	public List<CuentaContableTipo> getCuentaContableTipos() throws Exception {		
		this.quitarCuentaContableTiposNulos();
		
		CuentaContableTipoLogicAdditional.checkCuentaContableTipoToGets(cuentacontabletipos,this.datosCliente,this.arrDatoGeneral);
		
		for (CuentaContableTipo cuentacontabletipoLocal: cuentacontabletipos ) {
			CuentaContableTipoLogicAdditional.updateCuentaContableTipoToGet(cuentacontabletipoLocal,this.arrDatoGeneral);
		}
		
		return cuentacontabletipos;
	}
	
	public void setCuentaContableTipos(List<CuentaContableTipo> newCuentaContableTipos) {
		this.cuentacontabletipos = newCuentaContableTipos;
	}
	
	public Object getCuentaContableTipoObject() {	
		this.cuentacontabletipoObject=this.cuentacontabletipoDataAccess.getEntityObject();
		return this.cuentacontabletipoObject;
	}
		
	public void setCuentaContableTipoObject(Object newCuentaContableTipoObject) {
		this.cuentacontabletipoObject = newCuentaContableTipoObject;
	}
	
	public List<Object> getCuentaContableTiposObject() {		
		this.cuentacontabletiposObject=this.cuentacontabletipoDataAccess.getEntitiesObject();
		return this.cuentacontabletiposObject;
	}
		
	public void setCuentaContableTiposObject(List<Object> newCuentaContableTiposObject) {
		this.cuentacontabletiposObject = newCuentaContableTiposObject;
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
		
		if(this.cuentacontabletipoDataAccess!=null) {
			this.cuentacontabletipoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuentacontabletipoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuentacontabletipoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuentacontabletipo = new  CuentaContableTipo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentacontabletipo=cuentacontabletipoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipo);
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
		cuentacontabletipo = new  CuentaContableTipo();
		  		  
        try {
			
			cuentacontabletipo=cuentacontabletipoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuentacontabletipo = new  CuentaContableTipo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentacontabletipo=cuentacontabletipoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipo);
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
		cuentacontabletipo = new  CuentaContableTipo();
		  		  
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
		cuentacontabletipo = new  CuentaContableTipo();
		  		  
        try {
			
			cuentacontabletipo=cuentacontabletipoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuentacontabletipo = new  CuentaContableTipo();
		  		  
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
		cuentacontabletipo = new  CuentaContableTipo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuentacontabletipoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontabletipo = new  CuentaContableTipo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuentacontabletipoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentacontabletipo = new  CuentaContableTipo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuentacontabletipoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontabletipo = new  CuentaContableTipo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuentacontabletipoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentacontabletipo = new  CuentaContableTipo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuentacontabletipoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontabletipo = new  CuentaContableTipo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuentacontabletipoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
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
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		  		  
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
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		  		  
        try {			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		  		  
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
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
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
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		  		  
        try {
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
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
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
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
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuentacontabletipo = new  CuentaContableTipo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipo=cuentacontabletipoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipo);
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
		cuentacontabletipo = new  CuentaContableTipo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipo=cuentacontabletipoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
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
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		  		  
        try {
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuentaContableTiposWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getTodosCuentaContableTiposWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
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
	
	public  void  getTodosCuentaContableTipos(String sFinalQuery,Pagination pagination)throws Exception {
		cuentacontabletipos = new  ArrayList<CuentaContableTipo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaContableTipo(cuentacontabletipos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuentaContableTipo(CuentaContableTipo cuentacontabletipo) throws Exception {
		Boolean estaValidado=false;
		
		if(cuentacontabletipo.getIsNew() || cuentacontabletipo.getIsChanged()) { 
			this.invalidValues = cuentacontabletipoValidator.getInvalidValues(cuentacontabletipo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuentacontabletipo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuentaContableTipo(List<CuentaContableTipo> CuentaContableTipos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CuentaContableTipo cuentacontabletipoLocal:cuentacontabletipos) {				
			estaValidadoObjeto=this.validarGuardarCuentaContableTipo(cuentacontabletipoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuentaContableTipo(List<CuentaContableTipo> CuentaContableTipos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaContableTipo(cuentacontabletipos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuentaContableTipo(CuentaContableTipo CuentaContableTipo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaContableTipo(cuentacontabletipo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CuentaContableTipo cuentacontabletipo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuentacontabletipo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuentaContableTipoConstantesFunciones.getCuentaContableTipoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuentacontabletipo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuentaContableTipoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuentaContableTipoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuentaContableTipoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-saveCuentaContableTipoWithConnection");connexion.begin();			
			
			CuentaContableTipoLogicAdditional.checkCuentaContableTipoToSave(this.cuentacontabletipo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaContableTipoLogicAdditional.updateCuentaContableTipoToSave(this.cuentacontabletipo,this.arrDatoGeneral);
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentacontabletipo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuentaContableTipo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaContableTipo(this.cuentacontabletipo)) {
				CuentaContableTipoDataAccess.save(this.cuentacontabletipo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaContableTipoLogicAdditional.checkCuentaContableTipoToSaveAfter(this.cuentacontabletipo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaContableTipo();
			
			connexion.commit();			
			
			if(this.cuentacontabletipo.getIsDeleted()) {
				this.cuentacontabletipo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuentaContableTipo()throws Exception {	
		try {	
			
			CuentaContableTipoLogicAdditional.checkCuentaContableTipoToSave(this.cuentacontabletipo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaContableTipoLogicAdditional.updateCuentaContableTipoToSave(this.cuentacontabletipo,this.arrDatoGeneral);
			
			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentacontabletipo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaContableTipo(this.cuentacontabletipo)) {			
				CuentaContableTipoDataAccess.save(this.cuentacontabletipo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaContableTipoLogicAdditional.checkCuentaContableTipoToSaveAfter(this.cuentacontabletipo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuentacontabletipo.getIsDeleted()) {
				this.cuentacontabletipo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuentaContableTiposWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-saveCuentaContableTiposWithConnection");connexion.begin();			
			
			CuentaContableTipoLogicAdditional.checkCuentaContableTipoToSaves(cuentacontabletipos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuentaContableTipos();
			
			Boolean validadoTodosCuentaContableTipo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaContableTipo cuentacontabletipoLocal:cuentacontabletipos) {		
				if(cuentacontabletipoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaContableTipoLogicAdditional.updateCuentaContableTipoToSave(cuentacontabletipoLocal,this.arrDatoGeneral);
	        	
				CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentacontabletipoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaContableTipo(cuentacontabletipoLocal)) {
					CuentaContableTipoDataAccess.save(cuentacontabletipoLocal, connexion);				
				} else {
					validadoTodosCuentaContableTipo=false;
				}
			}
			
			if(!validadoTodosCuentaContableTipo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaContableTipoLogicAdditional.checkCuentaContableTipoToSavesAfter(cuentacontabletipos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaContableTipos();
			
			connexion.commit();		
			
			this.quitarCuentaContableTiposEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuentaContableTipos()throws Exception {				
		 try {	
			CuentaContableTipoLogicAdditional.checkCuentaContableTipoToSaves(cuentacontabletipos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuentaContableTipo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaContableTipo cuentacontabletipoLocal:cuentacontabletipos) {				
				if(cuentacontabletipoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaContableTipoLogicAdditional.updateCuentaContableTipoToSave(cuentacontabletipoLocal,this.arrDatoGeneral);
	        	
				CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentacontabletipoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaContableTipo(cuentacontabletipoLocal)) {				
					CuentaContableTipoDataAccess.save(cuentacontabletipoLocal, connexion);				
				} else {
					validadoTodosCuentaContableTipo=false;
				}
			}
			
			if(!validadoTodosCuentaContableTipo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaContableTipoLogicAdditional.checkCuentaContableTipoToSavesAfter(cuentacontabletipos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuentaContableTiposEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaContableTipoParameterReturnGeneral procesarAccionCuentaContableTipos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaContableTipo> cuentacontabletipos,CuentaContableTipoParameterReturnGeneral cuentacontabletipoParameterGeneral)throws Exception {
		 try {	
			CuentaContableTipoParameterReturnGeneral cuentacontabletipoReturnGeneral=new CuentaContableTipoParameterReturnGeneral();
	
			CuentaContableTipoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentacontabletipos,cuentacontabletipoParameterGeneral,cuentacontabletipoReturnGeneral);
			
			return cuentacontabletipoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaContableTipoParameterReturnGeneral procesarAccionCuentaContableTiposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaContableTipo> cuentacontabletipos,CuentaContableTipoParameterReturnGeneral cuentacontabletipoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-procesarAccionCuentaContableTiposWithConnection");connexion.begin();			
			
			CuentaContableTipoParameterReturnGeneral cuentacontabletipoReturnGeneral=new CuentaContableTipoParameterReturnGeneral();
	
			CuentaContableTipoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentacontabletipos,cuentacontabletipoParameterGeneral,cuentacontabletipoReturnGeneral);
			
			this.connexion.commit();
			
			return cuentacontabletipoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaContableTipoParameterReturnGeneral procesarEventosCuentaContableTipos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaContableTipo> cuentacontabletipos,CuentaContableTipo cuentacontabletipo,CuentaContableTipoParameterReturnGeneral cuentacontabletipoParameterGeneral,Boolean isEsNuevoCuentaContableTipo,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuentaContableTipoParameterReturnGeneral cuentacontabletipoReturnGeneral=new CuentaContableTipoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentacontabletipoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaContableTipoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentacontabletipos,cuentacontabletipo,cuentacontabletipoParameterGeneral,cuentacontabletipoReturnGeneral,isEsNuevoCuentaContableTipo,clases);
			
			return cuentacontabletipoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuentaContableTipoParameterReturnGeneral procesarEventosCuentaContableTiposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaContableTipo> cuentacontabletipos,CuentaContableTipo cuentacontabletipo,CuentaContableTipoParameterReturnGeneral cuentacontabletipoParameterGeneral,Boolean isEsNuevoCuentaContableTipo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-procesarEventosCuentaContableTiposWithConnection");connexion.begin();			
			
			CuentaContableTipoParameterReturnGeneral cuentacontabletipoReturnGeneral=new CuentaContableTipoParameterReturnGeneral();
	
			cuentacontabletipoReturnGeneral.setCuentaContableTipo(cuentacontabletipo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentacontabletipoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaContableTipoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentacontabletipos,cuentacontabletipo,cuentacontabletipoParameterGeneral,cuentacontabletipoReturnGeneral,isEsNuevoCuentaContableTipo,clases);
			
			this.connexion.commit();
			
			return cuentacontabletipoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaContableTipoParameterReturnGeneral procesarImportacionCuentaContableTiposWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuentaContableTipoParameterReturnGeneral cuentacontabletipoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-procesarImportacionCuentaContableTiposWithConnection");connexion.begin();			
			
			CuentaContableTipoParameterReturnGeneral cuentacontabletipoReturnGeneral=new CuentaContableTipoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuentacontabletipos=new ArrayList<CuentaContableTipo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuentacontabletipo=new CuentaContableTipo();
				
				
				if(conColumnasBase) {this.cuentacontabletipo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuentacontabletipo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cuentacontabletipo.setnombre(arrColumnas[iColumn++]);
				this.cuentacontabletipo.setdigito_verificador(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.cuentacontabletipos.add(this.cuentacontabletipo);
			}
			
			this.saveCuentaContableTipos();
			
			this.connexion.commit();
			
			cuentacontabletipoReturnGeneral.setConRetornoEstaProcesado(true);
			cuentacontabletipoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuentacontabletipoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuentaContableTiposEliminados() throws Exception {				
		
		List<CuentaContableTipo> cuentacontabletiposAux= new ArrayList<CuentaContableTipo>();
		
		for(CuentaContableTipo cuentacontabletipo:cuentacontabletipos) {
			if(!cuentacontabletipo.getIsDeleted()) {
				cuentacontabletiposAux.add(cuentacontabletipo);
			}
		}
		
		cuentacontabletipos=cuentacontabletiposAux;
	}
	
	public void quitarCuentaContableTiposNulos() throws Exception {				
		
		List<CuentaContableTipo> cuentacontabletiposAux= new ArrayList<CuentaContableTipo>();
		
		for(CuentaContableTipo cuentacontabletipo : this.cuentacontabletipos) {
			if(cuentacontabletipo==null) {
				cuentacontabletiposAux.add(cuentacontabletipo);
			}
		}
		
		//this.cuentacontabletipos=cuentacontabletiposAux;
		
		this.cuentacontabletipos.removeAll(cuentacontabletiposAux);
	}
	
	public void getSetVersionRowCuentaContableTipoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuentacontabletipo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuentacontabletipo.getIsDeleted() || (cuentacontabletipo.getIsChanged()&&!cuentacontabletipo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuentacontabletipoDataAccess.getSetVersionRowCuentaContableTipo(connexion,cuentacontabletipo.getId());
				
				if(!cuentacontabletipo.getVersionRow().equals(timestamp)) {	
					cuentacontabletipo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuentacontabletipo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuentaContableTipo()throws Exception {	
		
		if(cuentacontabletipo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuentacontabletipo.getIsDeleted() || (cuentacontabletipo.getIsChanged()&&!cuentacontabletipo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuentacontabletipoDataAccess.getSetVersionRowCuentaContableTipo(connexion,cuentacontabletipo.getId());
			
			try {							
				if(!cuentacontabletipo.getVersionRow().equals(timestamp)) {	
					cuentacontabletipo.setVersionRow(timestamp);
				}
				
				cuentacontabletipo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuentaContableTiposWithConnection()throws Exception {	
		if(cuentacontabletipos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CuentaContableTipo cuentacontabletipoAux:cuentacontabletipos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuentacontabletipoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentacontabletipoAux.getIsDeleted() || (cuentacontabletipoAux.getIsChanged()&&!cuentacontabletipoAux.getIsNew())) {
						
						timestamp=cuentacontabletipoDataAccess.getSetVersionRowCuentaContableTipo(connexion,cuentacontabletipoAux.getId());
						
						if(!cuentacontabletipo.getVersionRow().equals(timestamp)) {	
							cuentacontabletipoAux.setVersionRow(timestamp);
						}
								
						cuentacontabletipoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuentaContableTipos()throws Exception {	
		if(cuentacontabletipos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CuentaContableTipo cuentacontabletipoAux:cuentacontabletipos) {
					if(cuentacontabletipoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentacontabletipoAux.getIsDeleted() || (cuentacontabletipoAux.getIsChanged()&&!cuentacontabletipoAux.getIsNew())) {
						
						timestamp=cuentacontabletipoDataAccess.getSetVersionRowCuentaContableTipo(connexion,cuentacontabletipoAux.getId());
						
						if(!cuentacontabletipoAux.getVersionRow().equals(timestamp)) {	
							cuentacontabletipoAux.setVersionRow(timestamp);
						}
						
													
						cuentacontabletipoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuentaContableTipoParameterReturnGeneral cargarCombosLoteForeignKeyCuentaContableTipoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoCuentaContableTipo,String finalQueryGlobalTipoProductoServicio,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableCosto) throws Exception {
		CuentaContableTipoParameterReturnGeneral  cuentacontabletipoReturnGeneral =new CuentaContableTipoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuentaContableTipoWithConnection");connexion.begin();
			
			cuentacontabletipoReturnGeneral =new CuentaContableTipoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentacontabletipoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoCuentaContableTipo> tipocuentacontabletiposForeignKey=new ArrayList<TipoCuentaContableTipo>();
			TipoCuentaContableTipoLogic tipocuentacontabletipoLogic=new TipoCuentaContableTipoLogic();
			tipocuentacontabletipoLogic.setConnexion(this.connexion);
			tipocuentacontabletipoLogic.getTipoCuentaContableTipoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaContableTipo.equals("NONE")) {
				tipocuentacontabletipoLogic.getTodosTipoCuentaContableTipos(finalQueryGlobalTipoCuentaContableTipo,new Pagination());
				tipocuentacontabletiposForeignKey=tipocuentacontabletipoLogic.getTipoCuentaContableTipos();
			}

			cuentacontabletipoReturnGeneral.settipocuentacontabletiposForeignKey(tipocuentacontabletiposForeignKey);


			List<TipoProductoServicio> tipoproductoserviciosForeignKey=new ArrayList<TipoProductoServicio>();
			TipoProductoServicioLogic tipoproductoservicioLogic=new TipoProductoServicioLogic();
			tipoproductoservicioLogic.setConnexion(this.connexion);
			tipoproductoservicioLogic.getTipoProductoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProductoServicio.equals("NONE")) {
				tipoproductoservicioLogic.getTodosTipoProductoServicios(finalQueryGlobalTipoProductoServicio,new Pagination());
				tipoproductoserviciosForeignKey=tipoproductoservicioLogic.getTipoProductoServicios();
			}

			cuentacontabletipoReturnGeneral.settipoproductoserviciosForeignKey(tipoproductoserviciosForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			cuentacontabletipoReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			cuentacontabletipoReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			cuentacontabletipoReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			cuentacontabletipoReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuentacontabletipoReturnGeneral;
	}
	
	public CuentaContableTipoParameterReturnGeneral cargarCombosLoteForeignKeyCuentaContableTipo(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoCuentaContableTipo,String finalQueryGlobalTipoProductoServicio,String finalQueryGlobalCuentaContableVenta,String finalQueryGlobalCuentaContableDescuento,String finalQueryGlobalCuentaContableDevolucion,String finalQueryGlobalCuentaContableCosto) throws Exception {
		CuentaContableTipoParameterReturnGeneral  cuentacontabletipoReturnGeneral =new CuentaContableTipoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuentacontabletipoReturnGeneral =new CuentaContableTipoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentacontabletipoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoCuentaContableTipo> tipocuentacontabletiposForeignKey=new ArrayList<TipoCuentaContableTipo>();
			TipoCuentaContableTipoLogic tipocuentacontabletipoLogic=new TipoCuentaContableTipoLogic();
			tipocuentacontabletipoLogic.setConnexion(this.connexion);
			tipocuentacontabletipoLogic.getTipoCuentaContableTipoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaContableTipo.equals("NONE")) {
				tipocuentacontabletipoLogic.getTodosTipoCuentaContableTipos(finalQueryGlobalTipoCuentaContableTipo,new Pagination());
				tipocuentacontabletiposForeignKey=tipocuentacontabletipoLogic.getTipoCuentaContableTipos();
			}

			cuentacontabletipoReturnGeneral.settipocuentacontabletiposForeignKey(tipocuentacontabletiposForeignKey);


			List<TipoProductoServicio> tipoproductoserviciosForeignKey=new ArrayList<TipoProductoServicio>();
			TipoProductoServicioLogic tipoproductoservicioLogic=new TipoProductoServicioLogic();
			tipoproductoservicioLogic.setConnexion(this.connexion);
			tipoproductoservicioLogic.getTipoProductoServicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProductoServicio.equals("NONE")) {
				tipoproductoservicioLogic.getTodosTipoProductoServicios(finalQueryGlobalTipoProductoServicio,new Pagination());
				tipoproductoserviciosForeignKey=tipoproductoservicioLogic.getTipoProductoServicios();
			}

			cuentacontabletipoReturnGeneral.settipoproductoserviciosForeignKey(tipoproductoserviciosForeignKey);


			List<CuentaContable> cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableventaLogic=new CuentaContableLogic();
			cuentacontableventaLogic.setConnexion(this.connexion);
			cuentacontableventaLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableVenta.equals("NONE")) {
				cuentacontableventaLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableVenta,new Pagination());
				cuentacontableventasForeignKey=cuentacontableventaLogic.getCuentaContables();
			}

			cuentacontabletipoReturnGeneral.setcuentacontableventasForeignKey(cuentacontableventasForeignKey);


			List<CuentaContable> cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledescuentoLogic=new CuentaContableLogic();
			cuentacontabledescuentoLogic.setConnexion(this.connexion);
			cuentacontabledescuentoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDescuento.equals("NONE")) {
				cuentacontabledescuentoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDescuento,new Pagination());
				cuentacontabledescuentosForeignKey=cuentacontabledescuentoLogic.getCuentaContables();
			}

			cuentacontabletipoReturnGeneral.setcuentacontabledescuentosForeignKey(cuentacontabledescuentosForeignKey);


			List<CuentaContable> cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledevolucionLogic=new CuentaContableLogic();
			cuentacontabledevolucionLogic.setConnexion(this.connexion);
			cuentacontabledevolucionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDevolucion.equals("NONE")) {
				cuentacontabledevolucionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDevolucion,new Pagination());
				cuentacontabledevolucionsForeignKey=cuentacontabledevolucionLogic.getCuentaContables();
			}

			cuentacontabletipoReturnGeneral.setcuentacontabledevolucionsForeignKey(cuentacontabledevolucionsForeignKey);


			List<CuentaContable> cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecostoLogic=new CuentaContableLogic();
			cuentacontablecostoLogic.setConnexion(this.connexion);
			cuentacontablecostoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCosto.equals("NONE")) {
				cuentacontablecostoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCosto,new Pagination());
				cuentacontablecostosForeignKey=cuentacontablecostoLogic.getCuentaContables();
			}

			cuentacontabletipoReturnGeneral.setcuentacontablecostosForeignKey(cuentacontablecostosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuentacontabletipoReturnGeneral;
	}
	
	
	public void deepLoad(CuentaContableTipo cuentacontabletipo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuentaContableTipoLogicAdditional.updateCuentaContableTipoToGet(cuentacontabletipo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentacontabletipo.setEmpresa(cuentacontabletipoDataAccess.getEmpresa(connexion,cuentacontabletipo));
		cuentacontabletipo.setTipoCuentaContableTipo(cuentacontabletipoDataAccess.getTipoCuentaContableTipo(connexion,cuentacontabletipo));
		cuentacontabletipo.setTipoProductoServicio(cuentacontabletipoDataAccess.getTipoProductoServicio(connexion,cuentacontabletipo));
		cuentacontabletipo.setCuentaContableVenta(cuentacontabletipoDataAccess.getCuentaContableVenta(connexion,cuentacontabletipo));
		cuentacontabletipo.setCuentaContableDescuento(cuentacontabletipoDataAccess.getCuentaContableDescuento(connexion,cuentacontabletipo));
		cuentacontabletipo.setCuentaContableDevolucion(cuentacontabletipoDataAccess.getCuentaContableDevolucion(connexion,cuentacontabletipo));
		cuentacontabletipo.setCuentaContableCosto(cuentacontabletipoDataAccess.getCuentaContableCosto(connexion,cuentacontabletipo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentacontabletipo.setEmpresa(cuentacontabletipoDataAccess.getEmpresa(connexion,cuentacontabletipo));
				continue;
			}

			if(clas.clas.equals(TipoCuentaContableTipo.class)) {
				cuentacontabletipo.setTipoCuentaContableTipo(cuentacontabletipoDataAccess.getTipoCuentaContableTipo(connexion,cuentacontabletipo));
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				cuentacontabletipo.setTipoProductoServicio(cuentacontabletipoDataAccess.getTipoProductoServicio(connexion,cuentacontabletipo));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontabletipo.setCuentaContableVenta(cuentacontabletipoDataAccess.getCuentaContableVenta(connexion,cuentacontabletipo));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontabletipo.setCuentaContableDescuento(cuentacontabletipoDataAccess.getCuentaContableDescuento(connexion,cuentacontabletipo));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontabletipo.setCuentaContableDevolucion(cuentacontabletipoDataAccess.getCuentaContableDevolucion(connexion,cuentacontabletipo));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontabletipo.setCuentaContableCosto(cuentacontabletipoDataAccess.getCuentaContableCosto(connexion,cuentacontabletipo));
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
			cuentacontabletipo.setEmpresa(cuentacontabletipoDataAccess.getEmpresa(connexion,cuentacontabletipo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaContableTipo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setTipoCuentaContableTipo(cuentacontabletipoDataAccess.getTipoCuentaContableTipo(connexion,cuentacontabletipo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setTipoProductoServicio(cuentacontabletipoDataAccess.getTipoProductoServicio(connexion,cuentacontabletipo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setCuentaContableVenta(cuentacontabletipoDataAccess.getCuentaContableVenta(connexion,cuentacontabletipo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setCuentaContableDescuento(cuentacontabletipoDataAccess.getCuentaContableDescuento(connexion,cuentacontabletipo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setCuentaContableDevolucion(cuentacontabletipoDataAccess.getCuentaContableDevolucion(connexion,cuentacontabletipo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setCuentaContableCosto(cuentacontabletipoDataAccess.getCuentaContableCosto(connexion,cuentacontabletipo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentacontabletipo.setEmpresa(cuentacontabletipoDataAccess.getEmpresa(connexion,cuentacontabletipo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentacontabletipo.getEmpresa(),isDeep,deepLoadType,clases);
				
		cuentacontabletipo.setTipoCuentaContableTipo(cuentacontabletipoDataAccess.getTipoCuentaContableTipo(connexion,cuentacontabletipo));
		TipoCuentaContableTipoLogic tipocuentacontabletipoLogic= new TipoCuentaContableTipoLogic(connexion);
		tipocuentacontabletipoLogic.deepLoad(cuentacontabletipo.getTipoCuentaContableTipo(),isDeep,deepLoadType,clases);
				
		cuentacontabletipo.setTipoProductoServicio(cuentacontabletipoDataAccess.getTipoProductoServicio(connexion,cuentacontabletipo));
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(cuentacontabletipo.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
		cuentacontabletipo.setCuentaContableVenta(cuentacontabletipoDataAccess.getCuentaContableVenta(connexion,cuentacontabletipo));
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(cuentacontabletipo.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		cuentacontabletipo.setCuentaContableDescuento(cuentacontabletipoDataAccess.getCuentaContableDescuento(connexion,cuentacontabletipo));
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(cuentacontabletipo.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		cuentacontabletipo.setCuentaContableDevolucion(cuentacontabletipoDataAccess.getCuentaContableDevolucion(connexion,cuentacontabletipo));
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(cuentacontabletipo.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		cuentacontabletipo.setCuentaContableCosto(cuentacontabletipoDataAccess.getCuentaContableCosto(connexion,cuentacontabletipo));
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(cuentacontabletipo.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentacontabletipo.setEmpresa(cuentacontabletipoDataAccess.getEmpresa(connexion,cuentacontabletipo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cuentacontabletipo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaContableTipo.class)) {
				cuentacontabletipo.setTipoCuentaContableTipo(cuentacontabletipoDataAccess.getTipoCuentaContableTipo(connexion,cuentacontabletipo));
				TipoCuentaContableTipoLogic tipocuentacontabletipoLogic= new TipoCuentaContableTipoLogic(connexion);
				tipocuentacontabletipoLogic.deepLoad(cuentacontabletipo.getTipoCuentaContableTipo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				cuentacontabletipo.setTipoProductoServicio(cuentacontabletipoDataAccess.getTipoProductoServicio(connexion,cuentacontabletipo));
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepLoad(cuentacontabletipo.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontabletipo.setCuentaContableVenta(cuentacontabletipoDataAccess.getCuentaContableVenta(connexion,cuentacontabletipo));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontabletipo.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontabletipo.setCuentaContableDescuento(cuentacontabletipoDataAccess.getCuentaContableDescuento(connexion,cuentacontabletipo));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontabletipo.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontabletipo.setCuentaContableDevolucion(cuentacontabletipoDataAccess.getCuentaContableDevolucion(connexion,cuentacontabletipo));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontabletipo.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontabletipo.setCuentaContableCosto(cuentacontabletipoDataAccess.getCuentaContableCosto(connexion,cuentacontabletipo));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontabletipo.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
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
			cuentacontabletipo.setEmpresa(cuentacontabletipoDataAccess.getEmpresa(connexion,cuentacontabletipo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cuentacontabletipo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaContableTipo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setTipoCuentaContableTipo(cuentacontabletipoDataAccess.getTipoCuentaContableTipo(connexion,cuentacontabletipo));
			TipoCuentaContableTipoLogic tipocuentacontabletipoLogic= new TipoCuentaContableTipoLogic(connexion);
			tipocuentacontabletipoLogic.deepLoad(cuentacontabletipo.getTipoCuentaContableTipo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProductoServicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setTipoProductoServicio(cuentacontabletipoDataAccess.getTipoProductoServicio(connexion,cuentacontabletipo));
			TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
			tipoproductoservicioLogic.deepLoad(cuentacontabletipo.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setCuentaContableVenta(cuentacontabletipoDataAccess.getCuentaContableVenta(connexion,cuentacontabletipo));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontabletipo.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setCuentaContableDescuento(cuentacontabletipoDataAccess.getCuentaContableDescuento(connexion,cuentacontabletipo));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontabletipo.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setCuentaContableDevolucion(cuentacontabletipoDataAccess.getCuentaContableDevolucion(connexion,cuentacontabletipo));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontabletipo.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontabletipo.setCuentaContableCosto(cuentacontabletipoDataAccess.getCuentaContableCosto(connexion,cuentacontabletipo));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontabletipo.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CuentaContableTipo cuentacontabletipo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuentaContableTipoLogicAdditional.updateCuentaContableTipoToSave(cuentacontabletipo,this.arrDatoGeneral);
			
CuentaContableTipoDataAccess.save(cuentacontabletipo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentacontabletipo.getEmpresa(),connexion);

		TipoCuentaContableTipoDataAccess.save(cuentacontabletipo.getTipoCuentaContableTipo(),connexion);

		TipoProductoServicioDataAccess.save(cuentacontabletipo.getTipoProductoServicio(),connexion);

		CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableVenta(),connexion);

		CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableDescuento(),connexion);

		CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableDevolucion(),connexion);

		CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableCosto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentacontabletipo.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCuentaContableTipo.class)) {
				TipoCuentaContableTipoDataAccess.save(cuentacontabletipo.getTipoCuentaContableTipo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				TipoProductoServicioDataAccess.save(cuentacontabletipo.getTipoProductoServicio(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableDescuento(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableDevolucion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableCosto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentacontabletipo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentacontabletipo.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoCuentaContableTipoDataAccess.save(cuentacontabletipo.getTipoCuentaContableTipo(),connexion);
		TipoCuentaContableTipoLogic tipocuentacontabletipoLogic= new TipoCuentaContableTipoLogic(connexion);
		tipocuentacontabletipoLogic.deepLoad(cuentacontabletipo.getTipoCuentaContableTipo(),isDeep,deepLoadType,clases);
				

		TipoProductoServicioDataAccess.save(cuentacontabletipo.getTipoProductoServicio(),connexion);
		TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
		tipoproductoservicioLogic.deepLoad(cuentacontabletipo.getTipoProductoServicio(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableVenta(),connexion);
		CuentaContableLogic cuentacontableventaLogic= new CuentaContableLogic(connexion);
		cuentacontableventaLogic.deepLoad(cuentacontabletipo.getCuentaContableVenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableDescuento(),connexion);
		CuentaContableLogic cuentacontabledescuentoLogic= new CuentaContableLogic(connexion);
		cuentacontabledescuentoLogic.deepLoad(cuentacontabletipo.getCuentaContableDescuento(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableDevolucion(),connexion);
		CuentaContableLogic cuentacontabledevolucionLogic= new CuentaContableLogic(connexion);
		cuentacontabledevolucionLogic.deepLoad(cuentacontabletipo.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableCosto(),connexion);
		CuentaContableLogic cuentacontablecostoLogic= new CuentaContableLogic(connexion);
		cuentacontablecostoLogic.deepLoad(cuentacontabletipo.getCuentaContableCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentacontabletipo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cuentacontabletipo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaContableTipo.class)) {
				TipoCuentaContableTipoDataAccess.save(cuentacontabletipo.getTipoCuentaContableTipo(),connexion);
				TipoCuentaContableTipoLogic tipocuentacontabletipoLogic= new TipoCuentaContableTipoLogic(connexion);
				tipocuentacontabletipoLogic.deepSave(cuentacontabletipo.getTipoCuentaContableTipo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProductoServicio.class)) {
				TipoProductoServicioDataAccess.save(cuentacontabletipo.getTipoProductoServicio(),connexion);
				TipoProductoServicioLogic tipoproductoservicioLogic= new TipoProductoServicioLogic(connexion);
				tipoproductoservicioLogic.deepSave(cuentacontabletipo.getTipoProductoServicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableVenta(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentacontabletipo.getCuentaContableVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableDescuento(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentacontabletipo.getCuentaContableDescuento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableDevolucion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentacontabletipo.getCuentaContableDevolucion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontabletipo.getCuentaContableCosto(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentacontabletipo.getCuentaContableCosto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CuentaContableTipo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuentacontabletipo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(cuentacontabletipo);
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
			this.deepLoad(this.cuentacontabletipo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CuentaContableTipo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuentacontabletipos!=null) {
				for(CuentaContableTipo cuentacontabletipo:cuentacontabletipos) {
					this.deepLoad(cuentacontabletipo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(cuentacontabletipos);
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
			if(cuentacontabletipos!=null) {
				for(CuentaContableTipo cuentacontabletipo:cuentacontabletipos) {
					this.deepLoad(cuentacontabletipo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(cuentacontabletipos);
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
			this.getNewConnexionToDeep(CuentaContableTipo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuentacontabletipo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CuentaContableTipo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuentacontabletipos!=null) {
				for(CuentaContableTipo cuentacontabletipo:cuentacontabletipos) {
					this.deepSave(cuentacontabletipo,isDeep,deepLoadType,clases);
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
			if(cuentacontabletipos!=null) {
				for(CuentaContableTipo cuentacontabletipo:cuentacontabletipos) {
					this.deepSave(cuentacontabletipo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuentaContableTiposBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CuentaContableTipoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContableTiposBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CuentaContableTipoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContableTiposFK_IdCuentaContableCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContableTiposFK_IdCuentaContableCosto(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_costo,CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCosto);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContableTiposFK_IdCuentaContableDescuentoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContableTiposFK_IdCuentaContableDescuento(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_descuento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDescuento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDescuento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_descuento,CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDescuento);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDescuento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContableTiposFK_IdCuentaContableDevolucionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContableTiposFK_IdCuentaContableDevolucion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_devolucion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDevolucion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDevolucion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_devolucion,CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDevolucion);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDevolucion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContableTiposFK_IdCuentaContableVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContableTiposFK_IdCuentaContableVenta(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_venta,CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableVenta);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContableTiposFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaContableTipoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContableTiposFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaContableTipoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContableTiposFK_IdTipoCuentaContableTipoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_contable_tipo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaContableTipo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaContableTipo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_contable_tipo,CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaContableTipo);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaContableTipo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContableTiposFK_IdTipoCuentaContableTipo(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_contable_tipo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaContableTipo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaContableTipo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_contable_tipo,CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaContableTipo);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaContableTipo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContableTiposFK_IdTipoProductoServicioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_producto_servicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio,CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicio);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContableTiposFK_IdTipoProductoServicio(String sFinalQuery,Pagination pagination,Long id_tipo_producto_servicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio,CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicio);

			CuentaContableTipoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProductoServicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContableTipoPorIdEmpresaPorIdTipoCuentaPorIdTipoProduWithConnection(Long id_empresa,Long id_tipo_cuenta_contable_tipo,Long id_tipo_producto_servicio)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContableTipo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaContableTipoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaContableTipo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaContableTipo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_contable_tipo,CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaContableTipo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio,CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicio);

			cuentacontabletipo=cuentacontabletipoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.cuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContableTipoPorIdEmpresaPorIdTipoCuentaPorIdTipoProdu(Long id_empresa,Long id_tipo_cuenta_contable_tipo,Long id_tipo_producto_servicio)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaContableTipoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaContableTipo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaContableTipo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_contable_tipo,CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaContableTipo);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProductoServicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProductoServicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_producto_servicio,CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProductoServicio);

			cuentacontabletipo=cuentacontabletipoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.cuentacontabletipo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(this.cuentacontabletipo);
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
			if(CuentaContableTipoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContableTipoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CuentaContableTipo cuentacontabletipo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuentaContableTipoConstantesFunciones.ISCONAUDITORIA) {
				if(cuentacontabletipo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContableTipoDataAccess.TABLENAME, cuentacontabletipo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaContableTipoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaContableTipoLogic.registrarAuditoriaDetallesCuentaContableTipo(connexion,cuentacontabletipo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuentacontabletipo.getIsDeleted()) {
					/*if(!cuentacontabletipo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuentaContableTipoDataAccess.TABLENAME, cuentacontabletipo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuentaContableTipoLogic.registrarAuditoriaDetallesCuentaContableTipo(connexion,cuentacontabletipo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContableTipoDataAccess.TABLENAME, cuentacontabletipo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuentacontabletipo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContableTipoDataAccess.TABLENAME, cuentacontabletipo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaContableTipoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaContableTipoLogic.registrarAuditoriaDetallesCuentaContableTipo(connexion,cuentacontabletipo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuentaContableTipo(Connexion connexion,CuentaContableTipo cuentacontabletipo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuentacontabletipo.getIsNew()||!cuentacontabletipo.getid_empresa().equals(cuentacontabletipo.getCuentaContableTipoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontabletipo.getCuentaContableTipoOriginal().getid_empresa()!=null)
				{
					strValorActual=cuentacontabletipo.getCuentaContableTipoOriginal().getid_empresa().toString();
				}
				if(cuentacontabletipo.getid_empresa()!=null)
				{
					strValorNuevo=cuentacontabletipo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableTipoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontabletipo.getIsNew()||!cuentacontabletipo.getnombre().equals(cuentacontabletipo.getCuentaContableTipoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontabletipo.getCuentaContableTipoOriginal().getnombre()!=null)
				{
					strValorActual=cuentacontabletipo.getCuentaContableTipoOriginal().getnombre();
				}
				if(cuentacontabletipo.getnombre()!=null)
				{
					strValorNuevo=cuentacontabletipo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableTipoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontabletipo.getIsNew()||!cuentacontabletipo.getdigito_verificador().equals(cuentacontabletipo.getCuentaContableTipoOriginal().getdigito_verificador()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontabletipo.getCuentaContableTipoOriginal().getdigito_verificador()!=null)
				{
					strValorActual=cuentacontabletipo.getCuentaContableTipoOriginal().getdigito_verificador().toString();
				}
				if(cuentacontabletipo.getdigito_verificador()!=null)
				{
					strValorNuevo=cuentacontabletipo.getdigito_verificador().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableTipoConstantesFunciones.DIGITOVERIFICADOR,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontabletipo.getIsNew()||!cuentacontabletipo.getid_tipo_cuenta_contable_tipo().equals(cuentacontabletipo.getCuentaContableTipoOriginal().getid_tipo_cuenta_contable_tipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontabletipo.getCuentaContableTipoOriginal().getid_tipo_cuenta_contable_tipo()!=null)
				{
					strValorActual=cuentacontabletipo.getCuentaContableTipoOriginal().getid_tipo_cuenta_contable_tipo().toString();
				}
				if(cuentacontabletipo.getid_tipo_cuenta_contable_tipo()!=null)
				{
					strValorNuevo=cuentacontabletipo.getid_tipo_cuenta_contable_tipo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableTipoConstantesFunciones.IDTIPOCUENTACONTABLETIPO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontabletipo.getIsNew()||!cuentacontabletipo.getid_tipo_producto_servicio().equals(cuentacontabletipo.getCuentaContableTipoOriginal().getid_tipo_producto_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontabletipo.getCuentaContableTipoOriginal().getid_tipo_producto_servicio()!=null)
				{
					strValorActual=cuentacontabletipo.getCuentaContableTipoOriginal().getid_tipo_producto_servicio().toString();
				}
				if(cuentacontabletipo.getid_tipo_producto_servicio()!=null)
				{
					strValorNuevo=cuentacontabletipo.getid_tipo_producto_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableTipoConstantesFunciones.IDTIPOPRODUCTOSERVICIO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontabletipo.getIsNew()||!cuentacontabletipo.getid_cuenta_contable_venta().equals(cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_venta()!=null)
				{
					strValorActual=cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_venta().toString();
				}
				if(cuentacontabletipo.getid_cuenta_contable_venta()!=null)
				{
					strValorNuevo=cuentacontabletipo.getid_cuenta_contable_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEVENTA,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontabletipo.getIsNew()||!cuentacontabletipo.getid_cuenta_contable_descuento().equals(cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_descuento()!=null)
				{
					strValorActual=cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_descuento().toString();
				}
				if(cuentacontabletipo.getid_cuenta_contable_descuento()!=null)
				{
					strValorNuevo=cuentacontabletipo.getid_cuenta_contable_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontabletipo.getIsNew()||!cuentacontabletipo.getid_cuenta_contable_devolucion().equals(cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_devolucion()!=null)
				{
					strValorActual=cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_devolucion().toString();
				}
				if(cuentacontabletipo.getid_cuenta_contable_devolucion()!=null)
				{
					strValorNuevo=cuentacontabletipo.getid_cuenta_contable_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableTipoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontabletipo.getIsNew()||!cuentacontabletipo.getid_cuenta_contable_costo().equals(cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_costo()!=null)
				{
					strValorActual=cuentacontabletipo.getCuentaContableTipoOriginal().getid_cuenta_contable_costo().toString();
				}
				if(cuentacontabletipo.getid_cuenta_contable_costo()!=null)
				{
					strValorNuevo=cuentacontabletipo.getid_cuenta_contable_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableTipoConstantesFunciones.IDCUENTACONTABLECOSTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuentaContableTipoRelacionesWithConnection(CuentaContableTipo cuentacontabletipo) throws Exception {

		if(!cuentacontabletipo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaContableTipoRelacionesBase(cuentacontabletipo,true);
		}
	}

	public void saveCuentaContableTipoRelaciones(CuentaContableTipo cuentacontabletipo)throws Exception {

		if(!cuentacontabletipo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaContableTipoRelacionesBase(cuentacontabletipo,false);
		}
	}

	public void saveCuentaContableTipoRelacionesBase(CuentaContableTipo cuentacontabletipo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CuentaContableTipo-saveRelacionesWithConnection");}
	

			this.setCuentaContableTipo(cuentacontabletipo);

			if(CuentaContableTipoLogicAdditional.validarSaveRelaciones(cuentacontabletipo,this)) {

				CuentaContableTipoLogicAdditional.updateRelacionesToSave(cuentacontabletipo,this);

				if((cuentacontabletipo.getIsNew()||cuentacontabletipo.getIsChanged())&&!cuentacontabletipo.getIsDeleted()) {
					this.saveCuentaContableTipo();
					this.saveCuentaContableTipoRelacionesDetalles();

				} else if(cuentacontabletipo.getIsDeleted()) {
					this.saveCuentaContableTipoRelacionesDetalles();
					this.saveCuentaContableTipo();
				}

				CuentaContableTipoLogicAdditional.updateRelacionesToSaveAfter(cuentacontabletipo,this);

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
	
	
	private void saveCuentaContableTipoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaContableTipo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaContableTipoConstantesFunciones.getClassesForeignKeysOfCuentaContableTipo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContableTipo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaContableTipoConstantesFunciones.getClassesRelationshipsOfCuentaContableTipo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
