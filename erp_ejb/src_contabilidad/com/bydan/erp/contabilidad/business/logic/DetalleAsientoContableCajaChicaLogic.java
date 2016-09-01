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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.DetalleAsientoContableCajaChicaConstantesFunciones;
import com.bydan.erp.contabilidad.util.DetalleAsientoContableCajaChicaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DetalleAsientoContableCajaChicaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.DetalleAsientoContableCajaChica;
import com.bydan.erp.contabilidad.business.logic.DetalleAsientoContableCajaChicaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleAsientoContableCajaChicaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleAsientoContableCajaChicaLogic.class);
	
	protected DetalleAsientoContableCajaChicaDataAccess detalleasientocontablecajachicaDataAccess; 	
	protected DetalleAsientoContableCajaChica detalleasientocontablecajachica;
	protected List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas;
	protected Object detalleasientocontablecajachicaObject;	
	protected List<Object> detalleasientocontablecajachicasObject;
	
	public static ClassValidator<DetalleAsientoContableCajaChica> detalleasientocontablecajachicaValidator = new ClassValidator<DetalleAsientoContableCajaChica>(DetalleAsientoContableCajaChica.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleAsientoContableCajaChicaLogicAdditional detalleasientocontablecajachicaLogicAdditional=null;
	
	public DetalleAsientoContableCajaChicaLogicAdditional getDetalleAsientoContableCajaChicaLogicAdditional() {
		return this.detalleasientocontablecajachicaLogicAdditional;
	}
	
	public void setDetalleAsientoContableCajaChicaLogicAdditional(DetalleAsientoContableCajaChicaLogicAdditional detalleasientocontablecajachicaLogicAdditional) {
		try {
			this.detalleasientocontablecajachicaLogicAdditional=detalleasientocontablecajachicaLogicAdditional;
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
	
	
	
	
	public  DetalleAsientoContableCajaChicaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleasientocontablecajachicaDataAccess = new DetalleAsientoContableCajaChicaDataAccess();
			
			this.detalleasientocontablecajachicas= new ArrayList<DetalleAsientoContableCajaChica>();
			this.detalleasientocontablecajachica= new DetalleAsientoContableCajaChica();
			
			this.detalleasientocontablecajachicaObject=new Object();
			this.detalleasientocontablecajachicasObject=new ArrayList<Object>();
				
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
			
			this.detalleasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			this.detalleasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleAsientoContableCajaChicaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleasientocontablecajachicaDataAccess = new DetalleAsientoContableCajaChicaDataAccess();
			this.detalleasientocontablecajachicas= new ArrayList<DetalleAsientoContableCajaChica>();
			this.detalleasientocontablecajachica= new DetalleAsientoContableCajaChica();
			this.detalleasientocontablecajachicaObject=new Object();
			this.detalleasientocontablecajachicasObject=new ArrayList<Object>();
			
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
			
			this.detalleasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			this.detalleasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleAsientoContableCajaChica getDetalleAsientoContableCajaChica() throws Exception {	
		DetalleAsientoContableCajaChicaLogicAdditional.checkDetalleAsientoContableCajaChicaToGet(detalleasientocontablecajachica,this.datosCliente,this.arrDatoGeneral);
		DetalleAsientoContableCajaChicaLogicAdditional.updateDetalleAsientoContableCajaChicaToGet(detalleasientocontablecajachica,this.arrDatoGeneral);
		
		return detalleasientocontablecajachica;
	}
		
	public void setDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica newDetalleAsientoContableCajaChica) {
		this.detalleasientocontablecajachica = newDetalleAsientoContableCajaChica;
	}
	
	public DetalleAsientoContableCajaChicaDataAccess getDetalleAsientoContableCajaChicaDataAccess() {
		return detalleasientocontablecajachicaDataAccess;
	}
	
	public void setDetalleAsientoContableCajaChicaDataAccess(DetalleAsientoContableCajaChicaDataAccess newdetalleasientocontablecajachicaDataAccess) {
		this.detalleasientocontablecajachicaDataAccess = newdetalleasientocontablecajachicaDataAccess;
	}
	
	public List<DetalleAsientoContableCajaChica> getDetalleAsientoContableCajaChicas() throws Exception {		
		this.quitarDetalleAsientoContableCajaChicasNulos();
		
		DetalleAsientoContableCajaChicaLogicAdditional.checkDetalleAsientoContableCajaChicaToGets(detalleasientocontablecajachicas,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleAsientoContableCajaChica detalleasientocontablecajachicaLocal: detalleasientocontablecajachicas ) {
			DetalleAsientoContableCajaChicaLogicAdditional.updateDetalleAsientoContableCajaChicaToGet(detalleasientocontablecajachicaLocal,this.arrDatoGeneral);
		}
		
		return detalleasientocontablecajachicas;
	}
	
	public void setDetalleAsientoContableCajaChicas(List<DetalleAsientoContableCajaChica> newDetalleAsientoContableCajaChicas) {
		this.detalleasientocontablecajachicas = newDetalleAsientoContableCajaChicas;
	}
	
	public Object getDetalleAsientoContableCajaChicaObject() {	
		this.detalleasientocontablecajachicaObject=this.detalleasientocontablecajachicaDataAccess.getEntityObject();
		return this.detalleasientocontablecajachicaObject;
	}
		
	public void setDetalleAsientoContableCajaChicaObject(Object newDetalleAsientoContableCajaChicaObject) {
		this.detalleasientocontablecajachicaObject = newDetalleAsientoContableCajaChicaObject;
	}
	
	public List<Object> getDetalleAsientoContableCajaChicasObject() {		
		this.detalleasientocontablecajachicasObject=this.detalleasientocontablecajachicaDataAccess.getEntitiesObject();
		return this.detalleasientocontablecajachicasObject;
	}
		
	public void setDetalleAsientoContableCajaChicasObject(List<Object> newDetalleAsientoContableCajaChicasObject) {
		this.detalleasientocontablecajachicasObject = newDetalleAsientoContableCajaChicasObject;
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
		
		if(this.detalleasientocontablecajachicaDataAccess!=null) {
			this.detalleasientocontablecajachicaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleasientocontablecajachicaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleasientocontablecajachicaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleasientocontablecajachica=detalleasientocontablecajachicaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachica);
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
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		  		  
        try {
			
			detalleasientocontablecajachica=detalleasientocontablecajachicaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleasientocontablecajachica=detalleasientocontablecajachicaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachica);
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
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		  		  
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
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		  		  
        try {
			
			detalleasientocontablecajachica=detalleasientocontablecajachicaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		  		  
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
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleasientocontablecajachicaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleasientocontablecajachicaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleasientocontablecajachicaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleasientocontablecajachicaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleasientocontablecajachicaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleasientocontablecajachicaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
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
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		  		  
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
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		  		  
        try {			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		  		  
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
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
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
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		  		  
        try {
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
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
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
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
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachica=detalleasientocontablecajachicaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachica);
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
		detalleasientocontablecajachica = new  DetalleAsientoContableCajaChica();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachica=detalleasientocontablecajachicaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
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
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		  		  
        try {
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleAsientoContableCajaChicasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getTodosDetalleAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
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
	
	public  void  getTodosDetalleAsientoContableCajaChicas(String sFinalQuery,Pagination pagination)throws Exception {
		detalleasientocontablecajachicas = new  ArrayList<DetalleAsientoContableCajaChica>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica detalleasientocontablecajachica) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleasientocontablecajachica.getIsNew() || detalleasientocontablecajachica.getIsChanged()) { 
			this.invalidValues = detalleasientocontablecajachicaValidator.getInvalidValues(detalleasientocontablecajachica);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleasientocontablecajachica);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleAsientoContableCajaChica(List<DetalleAsientoContableCajaChica> DetalleAsientoContableCajaChicas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachicaLocal:detalleasientocontablecajachicas) {				
			estaValidadoObjeto=this.validarGuardarDetalleAsientoContableCajaChica(detalleasientocontablecajachicaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleAsientoContableCajaChica(List<DetalleAsientoContableCajaChica> DetalleAsientoContableCajaChicas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleAsientoContableCajaChica(detalleasientocontablecajachicas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica DetalleAsientoContableCajaChica) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleAsientoContableCajaChica(detalleasientocontablecajachica)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleAsientoContableCajaChica detalleasientocontablecajachica) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleasientocontablecajachica.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleAsientoContableCajaChicaConstantesFunciones.getDetalleAsientoContableCajaChicaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleasientocontablecajachica","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleAsientoContableCajaChicaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleAsientoContableCajaChicaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleAsientoContableCajaChicaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-saveDetalleAsientoContableCajaChicaWithConnection");connexion.begin();			
			
			DetalleAsientoContableCajaChicaLogicAdditional.checkDetalleAsientoContableCajaChicaToSave(this.detalleasientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleAsientoContableCajaChicaLogicAdditional.updateDetalleAsientoContableCajaChicaToSave(this.detalleasientocontablecajachica,this.arrDatoGeneral);
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleasientocontablecajachica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleAsientoContableCajaChica();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleAsientoContableCajaChica(this.detalleasientocontablecajachica)) {
				DetalleAsientoContableCajaChicaDataAccess.save(this.detalleasientocontablecajachica, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleAsientoContableCajaChicaLogicAdditional.checkDetalleAsientoContableCajaChicaToSaveAfter(this.detalleasientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleAsientoContableCajaChica();
			
			connexion.commit();			
			
			if(this.detalleasientocontablecajachica.getIsDeleted()) {
				this.detalleasientocontablecajachica=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleAsientoContableCajaChica()throws Exception {	
		try {	
			
			DetalleAsientoContableCajaChicaLogicAdditional.checkDetalleAsientoContableCajaChicaToSave(this.detalleasientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleAsientoContableCajaChicaLogicAdditional.updateDetalleAsientoContableCajaChicaToSave(this.detalleasientocontablecajachica,this.arrDatoGeneral);
			
			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleasientocontablecajachica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleAsientoContableCajaChica(this.detalleasientocontablecajachica)) {			
				DetalleAsientoContableCajaChicaDataAccess.save(this.detalleasientocontablecajachica, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleAsientoContableCajaChicaLogicAdditional.checkDetalleAsientoContableCajaChicaToSaveAfter(this.detalleasientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleasientocontablecajachica.getIsDeleted()) {
				this.detalleasientocontablecajachica=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleAsientoContableCajaChicasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-saveDetalleAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			DetalleAsientoContableCajaChicaLogicAdditional.checkDetalleAsientoContableCajaChicaToSaves(detalleasientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleAsientoContableCajaChicas();
			
			Boolean validadoTodosDetalleAsientoContableCajaChica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleAsientoContableCajaChica detalleasientocontablecajachicaLocal:detalleasientocontablecajachicas) {		
				if(detalleasientocontablecajachicaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleAsientoContableCajaChicaLogicAdditional.updateDetalleAsientoContableCajaChicaToSave(detalleasientocontablecajachicaLocal,this.arrDatoGeneral);
	        	
				DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleasientocontablecajachicaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleAsientoContableCajaChica(detalleasientocontablecajachicaLocal)) {
					DetalleAsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachicaLocal, connexion);				
				} else {
					validadoTodosDetalleAsientoContableCajaChica=false;
				}
			}
			
			if(!validadoTodosDetalleAsientoContableCajaChica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleAsientoContableCajaChicaLogicAdditional.checkDetalleAsientoContableCajaChicaToSavesAfter(detalleasientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleAsientoContableCajaChicas();
			
			connexion.commit();		
			
			this.quitarDetalleAsientoContableCajaChicasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleAsientoContableCajaChicas()throws Exception {				
		 try {	
			DetalleAsientoContableCajaChicaLogicAdditional.checkDetalleAsientoContableCajaChicaToSaves(detalleasientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleAsientoContableCajaChica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleAsientoContableCajaChica detalleasientocontablecajachicaLocal:detalleasientocontablecajachicas) {				
				if(detalleasientocontablecajachicaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleAsientoContableCajaChicaLogicAdditional.updateDetalleAsientoContableCajaChicaToSave(detalleasientocontablecajachicaLocal,this.arrDatoGeneral);
	        	
				DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleasientocontablecajachicaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleAsientoContableCajaChica(detalleasientocontablecajachicaLocal)) {				
					DetalleAsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachicaLocal, connexion);				
				} else {
					validadoTodosDetalleAsientoContableCajaChica=false;
				}
			}
			
			if(!validadoTodosDetalleAsientoContableCajaChica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleAsientoContableCajaChicaLogicAdditional.checkDetalleAsientoContableCajaChicaToSavesAfter(detalleasientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleAsientoContableCajaChicasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleAsientoContableCajaChicaParameterReturnGeneral procesarAccionDetalleAsientoContableCajaChicas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,DetalleAsientoContableCajaChicaParameterReturnGeneral detalleasientocontablecajachicaParameterGeneral)throws Exception {
		 try {	
			DetalleAsientoContableCajaChicaParameterReturnGeneral detalleasientocontablecajachicaReturnGeneral=new DetalleAsientoContableCajaChicaParameterReturnGeneral();
	
			DetalleAsientoContableCajaChicaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleasientocontablecajachicas,detalleasientocontablecajachicaParameterGeneral,detalleasientocontablecajachicaReturnGeneral);
			
			return detalleasientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleAsientoContableCajaChicaParameterReturnGeneral procesarAccionDetalleAsientoContableCajaChicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,DetalleAsientoContableCajaChicaParameterReturnGeneral detalleasientocontablecajachicaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-procesarAccionDetalleAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			DetalleAsientoContableCajaChicaParameterReturnGeneral detalleasientocontablecajachicaReturnGeneral=new DetalleAsientoContableCajaChicaParameterReturnGeneral();
	
			DetalleAsientoContableCajaChicaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleasientocontablecajachicas,detalleasientocontablecajachicaParameterGeneral,detalleasientocontablecajachicaReturnGeneral);
			
			this.connexion.commit();
			
			return detalleasientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleAsientoContableCajaChicaParameterReturnGeneral procesarEventosDetalleAsientoContableCajaChicas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,DetalleAsientoContableCajaChica detalleasientocontablecajachica,DetalleAsientoContableCajaChicaParameterReturnGeneral detalleasientocontablecajachicaParameterGeneral,Boolean isEsNuevoDetalleAsientoContableCajaChica,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleAsientoContableCajaChicaParameterReturnGeneral detalleasientocontablecajachicaReturnGeneral=new DetalleAsientoContableCajaChicaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleasientocontablecajachicaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleAsientoContableCajaChicaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleasientocontablecajachicas,detalleasientocontablecajachica,detalleasientocontablecajachicaParameterGeneral,detalleasientocontablecajachicaReturnGeneral,isEsNuevoDetalleAsientoContableCajaChica,clases);
			
			return detalleasientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleAsientoContableCajaChicaParameterReturnGeneral procesarEventosDetalleAsientoContableCajaChicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,DetalleAsientoContableCajaChica detalleasientocontablecajachica,DetalleAsientoContableCajaChicaParameterReturnGeneral detalleasientocontablecajachicaParameterGeneral,Boolean isEsNuevoDetalleAsientoContableCajaChica,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-procesarEventosDetalleAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			DetalleAsientoContableCajaChicaParameterReturnGeneral detalleasientocontablecajachicaReturnGeneral=new DetalleAsientoContableCajaChicaParameterReturnGeneral();
	
			detalleasientocontablecajachicaReturnGeneral.setDetalleAsientoContableCajaChica(detalleasientocontablecajachica);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleasientocontablecajachicaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleAsientoContableCajaChicaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleasientocontablecajachicas,detalleasientocontablecajachica,detalleasientocontablecajachicaParameterGeneral,detalleasientocontablecajachicaReturnGeneral,isEsNuevoDetalleAsientoContableCajaChica,clases);
			
			this.connexion.commit();
			
			return detalleasientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleAsientoContableCajaChicaParameterReturnGeneral procesarImportacionDetalleAsientoContableCajaChicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleAsientoContableCajaChicaParameterReturnGeneral detalleasientocontablecajachicaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-procesarImportacionDetalleAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			DetalleAsientoContableCajaChicaParameterReturnGeneral detalleasientocontablecajachicaReturnGeneral=new DetalleAsientoContableCajaChicaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleasientocontablecajachicas=new ArrayList<DetalleAsientoContableCajaChica>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleasientocontablecajachica=new DetalleAsientoContableCajaChica();
				
				
				if(conColumnasBase) {this.detalleasientocontablecajachica.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleasientocontablecajachica.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleasientocontablecajachica.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detalleasientocontablecajachica.setes_proveedor(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.detalleasientocontablecajachica.setdetalle(arrColumnas[iColumn++]);
				this.detalleasientocontablecajachica.setvalor_bien_tarifa12(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontablecajachica.setvalor_servicio_tarifa12(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontablecajachica.setporcentaje_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontablecajachica.setvalor_bien_tarifa0(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontablecajachica.setvalor_servicio_tarifa0(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontablecajachica.setvalor_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontablecajachica.setvalor_bien_ice(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontablecajachica.setvalor_servicio_ice(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detalleasientocontablecajachicas.add(this.detalleasientocontablecajachica);
			}
			
			this.saveDetalleAsientoContableCajaChicas();
			
			this.connexion.commit();
			
			detalleasientocontablecajachicaReturnGeneral.setConRetornoEstaProcesado(true);
			detalleasientocontablecajachicaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleasientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleAsientoContableCajaChicasEliminados() throws Exception {				
		
		List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicasAux= new ArrayList<DetalleAsientoContableCajaChica>();
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:detalleasientocontablecajachicas) {
			if(!detalleasientocontablecajachica.getIsDeleted()) {
				detalleasientocontablecajachicasAux.add(detalleasientocontablecajachica);
			}
		}
		
		detalleasientocontablecajachicas=detalleasientocontablecajachicasAux;
	}
	
	public void quitarDetalleAsientoContableCajaChicasNulos() throws Exception {				
		
		List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicasAux= new ArrayList<DetalleAsientoContableCajaChica>();
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica : this.detalleasientocontablecajachicas) {
			if(detalleasientocontablecajachica==null) {
				detalleasientocontablecajachicasAux.add(detalleasientocontablecajachica);
			}
		}
		
		//this.detalleasientocontablecajachicas=detalleasientocontablecajachicasAux;
		
		this.detalleasientocontablecajachicas.removeAll(detalleasientocontablecajachicasAux);
	}
	
	public void getSetVersionRowDetalleAsientoContableCajaChicaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleasientocontablecajachica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleasientocontablecajachica.getIsDeleted() || (detalleasientocontablecajachica.getIsChanged()&&!detalleasientocontablecajachica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleasientocontablecajachicaDataAccess.getSetVersionRowDetalleAsientoContableCajaChica(connexion,detalleasientocontablecajachica.getId());
				
				if(!detalleasientocontablecajachica.getVersionRow().equals(timestamp)) {	
					detalleasientocontablecajachica.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleasientocontablecajachica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleAsientoContableCajaChica()throws Exception {	
		
		if(detalleasientocontablecajachica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleasientocontablecajachica.getIsDeleted() || (detalleasientocontablecajachica.getIsChanged()&&!detalleasientocontablecajachica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleasientocontablecajachicaDataAccess.getSetVersionRowDetalleAsientoContableCajaChica(connexion,detalleasientocontablecajachica.getId());
			
			try {							
				if(!detalleasientocontablecajachica.getVersionRow().equals(timestamp)) {	
					detalleasientocontablecajachica.setVersionRow(timestamp);
				}
				
				detalleasientocontablecajachica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleAsientoContableCajaChicasWithConnection()throws Exception {	
		if(detalleasientocontablecajachicas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleAsientoContableCajaChica detalleasientocontablecajachicaAux:detalleasientocontablecajachicas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleasientocontablecajachicaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleasientocontablecajachicaAux.getIsDeleted() || (detalleasientocontablecajachicaAux.getIsChanged()&&!detalleasientocontablecajachicaAux.getIsNew())) {
						
						timestamp=detalleasientocontablecajachicaDataAccess.getSetVersionRowDetalleAsientoContableCajaChica(connexion,detalleasientocontablecajachicaAux.getId());
						
						if(!detalleasientocontablecajachica.getVersionRow().equals(timestamp)) {	
							detalleasientocontablecajachicaAux.setVersionRow(timestamp);
						}
								
						detalleasientocontablecajachicaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleAsientoContableCajaChicas()throws Exception {	
		if(detalleasientocontablecajachicas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleAsientoContableCajaChica detalleasientocontablecajachicaAux:detalleasientocontablecajachicas) {
					if(detalleasientocontablecajachicaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleasientocontablecajachicaAux.getIsDeleted() || (detalleasientocontablecajachicaAux.getIsChanged()&&!detalleasientocontablecajachicaAux.getIsNew())) {
						
						timestamp=detalleasientocontablecajachicaDataAccess.getSetVersionRowDetalleAsientoContableCajaChica(connexion,detalleasientocontablecajachicaAux.getId());
						
						if(!detalleasientocontablecajachicaAux.getVersionRow().equals(timestamp)) {	
							detalleasientocontablecajachicaAux.setVersionRow(timestamp);
						}
						
													
						detalleasientocontablecajachicaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleAsientoContableCajaChicaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleAsientoContableCajaChicaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalAsientoContableCajaChica,String finalQueryGlobalTipoGastoEmpresa,String finalQueryGlobalTransaccion,String finalQueryGlobalFactura,String finalQueryGlobalAsientoContable,String finalQueryGlobalCentroCosto,String finalQueryGlobalTipoCambio,String finalQueryGlobalTipoTransaccionModulo) throws Exception {
		DetalleAsientoContableCajaChicaParameterReturnGeneral  detalleasientocontablecajachicaReturnGeneral =new DetalleAsientoContableCajaChicaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleAsientoContableCajaChicaWithConnection");connexion.begin();
			
			detalleasientocontablecajachicaReturnGeneral =new DetalleAsientoContableCajaChicaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleasientocontablecajachicaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleasientocontablecajachicaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detalleasientocontablecajachicaReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleasientocontablecajachicaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleasientocontablecajachicaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleasientocontablecajachicaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleasientocontablecajachicaReturnGeneral.setmessForeignKey(messForeignKey);


			List<AsientoContableCajaChica> asientocontablecajachicasForeignKey=new ArrayList<AsientoContableCajaChica>();
			AsientoContableCajaChicaLogic asientocontablecajachicaLogic=new AsientoContableCajaChicaLogic();
			asientocontablecajachicaLogic.setConnexion(this.connexion);
			asientocontablecajachicaLogic.getAsientoContableCajaChicaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContableCajaChica.equals("NONE")) {
				asientocontablecajachicaLogic.getTodosAsientoContableCajaChicas(finalQueryGlobalAsientoContableCajaChica,new Pagination());
				asientocontablecajachicasForeignKey=asientocontablecajachicaLogic.getAsientoContableCajaChicas();
			}

			detalleasientocontablecajachicaReturnGeneral.setasientocontablecajachicasForeignKey(asientocontablecajachicasForeignKey);


			List<TipoGastoEmpresa> tipogastoempresasForeignKey=new ArrayList<TipoGastoEmpresa>();
			TipoGastoEmpresaLogic tipogastoempresaLogic=new TipoGastoEmpresaLogic();
			tipogastoempresaLogic.setConnexion(this.connexion);
			tipogastoempresaLogic.getTipoGastoEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGastoEmpresa.equals("NONE")) {
				tipogastoempresaLogic.getTodosTipoGastoEmpresas(finalQueryGlobalTipoGastoEmpresa,new Pagination());
				tipogastoempresasForeignKey=tipogastoempresaLogic.getTipoGastoEmpresas();
			}

			detalleasientocontablecajachicaReturnGeneral.settipogastoempresasForeignKey(tipogastoempresasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			detalleasientocontablecajachicaReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			detalleasientocontablecajachicaReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detalleasientocontablecajachicaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleasientocontablecajachicaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			detalleasientocontablecajachicaReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			detalleasientocontablecajachicaReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleasientocontablecajachicaReturnGeneral;
	}
	
	public DetalleAsientoContableCajaChicaParameterReturnGeneral cargarCombosLoteForeignKeyDetalleAsientoContableCajaChica(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalAsientoContableCajaChica,String finalQueryGlobalTipoGastoEmpresa,String finalQueryGlobalTransaccion,String finalQueryGlobalFactura,String finalQueryGlobalAsientoContable,String finalQueryGlobalCentroCosto,String finalQueryGlobalTipoCambio,String finalQueryGlobalTipoTransaccionModulo) throws Exception {
		DetalleAsientoContableCajaChicaParameterReturnGeneral  detalleasientocontablecajachicaReturnGeneral =new DetalleAsientoContableCajaChicaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleasientocontablecajachicaReturnGeneral =new DetalleAsientoContableCajaChicaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleasientocontablecajachicaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleasientocontablecajachicaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detalleasientocontablecajachicaReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleasientocontablecajachicaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleasientocontablecajachicaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleasientocontablecajachicaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleasientocontablecajachicaReturnGeneral.setmessForeignKey(messForeignKey);


			List<AsientoContableCajaChica> asientocontablecajachicasForeignKey=new ArrayList<AsientoContableCajaChica>();
			AsientoContableCajaChicaLogic asientocontablecajachicaLogic=new AsientoContableCajaChicaLogic();
			asientocontablecajachicaLogic.setConnexion(this.connexion);
			asientocontablecajachicaLogic.getAsientoContableCajaChicaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContableCajaChica.equals("NONE")) {
				asientocontablecajachicaLogic.getTodosAsientoContableCajaChicas(finalQueryGlobalAsientoContableCajaChica,new Pagination());
				asientocontablecajachicasForeignKey=asientocontablecajachicaLogic.getAsientoContableCajaChicas();
			}

			detalleasientocontablecajachicaReturnGeneral.setasientocontablecajachicasForeignKey(asientocontablecajachicasForeignKey);


			List<TipoGastoEmpresa> tipogastoempresasForeignKey=new ArrayList<TipoGastoEmpresa>();
			TipoGastoEmpresaLogic tipogastoempresaLogic=new TipoGastoEmpresaLogic();
			tipogastoempresaLogic.setConnexion(this.connexion);
			tipogastoempresaLogic.getTipoGastoEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGastoEmpresa.equals("NONE")) {
				tipogastoempresaLogic.getTodosTipoGastoEmpresas(finalQueryGlobalTipoGastoEmpresa,new Pagination());
				tipogastoempresasForeignKey=tipogastoempresaLogic.getTipoGastoEmpresas();
			}

			detalleasientocontablecajachicaReturnGeneral.settipogastoempresasForeignKey(tipogastoempresasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			detalleasientocontablecajachicaReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			detalleasientocontablecajachicaReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detalleasientocontablecajachicaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleasientocontablecajachicaReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			detalleasientocontablecajachicaReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			detalleasientocontablecajachicaReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleasientocontablecajachicaReturnGeneral;
	}
	
	
	public void deepLoad(DetalleAsientoContableCajaChica detalleasientocontablecajachica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleAsientoContableCajaChicaLogicAdditional.updateDetalleAsientoContableCajaChicaToGet(detalleasientocontablecajachica,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleasientocontablecajachica.setEmpresa(detalleasientocontablecajachicaDataAccess.getEmpresa(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setSucursal(detalleasientocontablecajachicaDataAccess.getSucursal(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setModulo(detalleasientocontablecajachicaDataAccess.getModulo(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setEjercicio(detalleasientocontablecajachicaDataAccess.getEjercicio(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setPeriodo(detalleasientocontablecajachicaDataAccess.getPeriodo(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setAnio(detalleasientocontablecajachicaDataAccess.getAnio(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setMes(detalleasientocontablecajachicaDataAccess.getMes(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setAsientoContableCajaChica(detalleasientocontablecajachicaDataAccess.getAsientoContableCajaChica(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setTipoGastoEmpresa(detalleasientocontablecajachicaDataAccess.getTipoGastoEmpresa(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setTransaccion(detalleasientocontablecajachicaDataAccess.getTransaccion(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setFactura(detalleasientocontablecajachicaDataAccess.getFactura(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setAsientoContable(detalleasientocontablecajachicaDataAccess.getAsientoContable(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setCentroCosto(detalleasientocontablecajachicaDataAccess.getCentroCosto(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setTipoCambio(detalleasientocontablecajachicaDataAccess.getTipoCambio(connexion,detalleasientocontablecajachica));
		detalleasientocontablecajachica.setTipoTransaccionModulo(detalleasientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,detalleasientocontablecajachica));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleasientocontablecajachica.setEmpresa(detalleasientocontablecajachicaDataAccess.getEmpresa(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleasientocontablecajachica.setSucursal(detalleasientocontablecajachicaDataAccess.getSucursal(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detalleasientocontablecajachica.setModulo(detalleasientocontablecajachicaDataAccess.getModulo(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleasientocontablecajachica.setEjercicio(detalleasientocontablecajachicaDataAccess.getEjercicio(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleasientocontablecajachica.setPeriodo(detalleasientocontablecajachicaDataAccess.getPeriodo(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleasientocontablecajachica.setAnio(detalleasientocontablecajachicaDataAccess.getAnio(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleasientocontablecajachica.setMes(detalleasientocontablecajachicaDataAccess.getMes(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(AsientoContableCajaChica.class)) {
				detalleasientocontablecajachica.setAsientoContableCajaChica(detalleasientocontablecajachicaDataAccess.getAsientoContableCajaChica(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(TipoGastoEmpresa.class)) {
				detalleasientocontablecajachica.setTipoGastoEmpresa(detalleasientocontablecajachicaDataAccess.getTipoGastoEmpresa(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				detalleasientocontablecajachica.setTransaccion(detalleasientocontablecajachicaDataAccess.getTransaccion(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				detalleasientocontablecajachica.setFactura(detalleasientocontablecajachicaDataAccess.getFactura(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detalleasientocontablecajachica.setAsientoContable(detalleasientocontablecajachicaDataAccess.getAsientoContable(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleasientocontablecajachica.setCentroCosto(detalleasientocontablecajachicaDataAccess.getCentroCosto(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				detalleasientocontablecajachica.setTipoCambio(detalleasientocontablecajachicaDataAccess.getTipoCambio(connexion,detalleasientocontablecajachica));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				detalleasientocontablecajachica.setTipoTransaccionModulo(detalleasientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,detalleasientocontablecajachica));
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
			detalleasientocontablecajachica.setEmpresa(detalleasientocontablecajachicaDataAccess.getEmpresa(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setSucursal(detalleasientocontablecajachicaDataAccess.getSucursal(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setModulo(detalleasientocontablecajachicaDataAccess.getModulo(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setEjercicio(detalleasientocontablecajachicaDataAccess.getEjercicio(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setPeriodo(detalleasientocontablecajachicaDataAccess.getPeriodo(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setAnio(detalleasientocontablecajachicaDataAccess.getAnio(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setMes(detalleasientocontablecajachicaDataAccess.getMes(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContableCajaChica.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setAsientoContableCajaChica(detalleasientocontablecajachicaDataAccess.getAsientoContableCajaChica(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGastoEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setTipoGastoEmpresa(detalleasientocontablecajachicaDataAccess.getTipoGastoEmpresa(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setTransaccion(detalleasientocontablecajachicaDataAccess.getTransaccion(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setFactura(detalleasientocontablecajachicaDataAccess.getFactura(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setAsientoContable(detalleasientocontablecajachicaDataAccess.getAsientoContable(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setCentroCosto(detalleasientocontablecajachicaDataAccess.getCentroCosto(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setTipoCambio(detalleasientocontablecajachicaDataAccess.getTipoCambio(connexion,detalleasientocontablecajachica));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setTipoTransaccionModulo(detalleasientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,detalleasientocontablecajachica));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleasientocontablecajachica.setEmpresa(detalleasientocontablecajachicaDataAccess.getEmpresa(connexion,detalleasientocontablecajachica));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleasientocontablecajachica.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setSucursal(detalleasientocontablecajachicaDataAccess.getSucursal(connexion,detalleasientocontablecajachica));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleasientocontablecajachica.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setModulo(detalleasientocontablecajachicaDataAccess.getModulo(connexion,detalleasientocontablecajachica));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detalleasientocontablecajachica.getModulo(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setEjercicio(detalleasientocontablecajachicaDataAccess.getEjercicio(connexion,detalleasientocontablecajachica));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleasientocontablecajachica.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setPeriodo(detalleasientocontablecajachicaDataAccess.getPeriodo(connexion,detalleasientocontablecajachica));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleasientocontablecajachica.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setAnio(detalleasientocontablecajachicaDataAccess.getAnio(connexion,detalleasientocontablecajachica));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleasientocontablecajachica.getAnio(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setMes(detalleasientocontablecajachicaDataAccess.getMes(connexion,detalleasientocontablecajachica));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleasientocontablecajachica.getMes(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setAsientoContableCajaChica(detalleasientocontablecajachicaDataAccess.getAsientoContableCajaChica(connexion,detalleasientocontablecajachica));
		AsientoContableCajaChicaLogic asientocontablecajachicaLogic= new AsientoContableCajaChicaLogic(connexion);
		asientocontablecajachicaLogic.deepLoad(detalleasientocontablecajachica.getAsientoContableCajaChica(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setTipoGastoEmpresa(detalleasientocontablecajachicaDataAccess.getTipoGastoEmpresa(connexion,detalleasientocontablecajachica));
		TipoGastoEmpresaLogic tipogastoempresaLogic= new TipoGastoEmpresaLogic(connexion);
		tipogastoempresaLogic.deepLoad(detalleasientocontablecajachica.getTipoGastoEmpresa(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setTransaccion(detalleasientocontablecajachicaDataAccess.getTransaccion(connexion,detalleasientocontablecajachica));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(detalleasientocontablecajachica.getTransaccion(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setFactura(detalleasientocontablecajachicaDataAccess.getFactura(connexion,detalleasientocontablecajachica));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(detalleasientocontablecajachica.getFactura(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setAsientoContable(detalleasientocontablecajachicaDataAccess.getAsientoContable(connexion,detalleasientocontablecajachica));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detalleasientocontablecajachica.getAsientoContable(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setCentroCosto(detalleasientocontablecajachicaDataAccess.getCentroCosto(connexion,detalleasientocontablecajachica));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleasientocontablecajachica.getCentroCosto(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setTipoCambio(detalleasientocontablecajachicaDataAccess.getTipoCambio(connexion,detalleasientocontablecajachica));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(detalleasientocontablecajachica.getTipoCambio(),isDeep,deepLoadType,clases);
				
		detalleasientocontablecajachica.setTipoTransaccionModulo(detalleasientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,detalleasientocontablecajachica));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(detalleasientocontablecajachica.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleasientocontablecajachica.setEmpresa(detalleasientocontablecajachicaDataAccess.getEmpresa(connexion,detalleasientocontablecajachica));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleasientocontablecajachica.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleasientocontablecajachica.setSucursal(detalleasientocontablecajachicaDataAccess.getSucursal(connexion,detalleasientocontablecajachica));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleasientocontablecajachica.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detalleasientocontablecajachica.setModulo(detalleasientocontablecajachicaDataAccess.getModulo(connexion,detalleasientocontablecajachica));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(detalleasientocontablecajachica.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleasientocontablecajachica.setEjercicio(detalleasientocontablecajachicaDataAccess.getEjercicio(connexion,detalleasientocontablecajachica));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleasientocontablecajachica.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleasientocontablecajachica.setPeriodo(detalleasientocontablecajachicaDataAccess.getPeriodo(connexion,detalleasientocontablecajachica));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalleasientocontablecajachica.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleasientocontablecajachica.setAnio(detalleasientocontablecajachicaDataAccess.getAnio(connexion,detalleasientocontablecajachica));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detalleasientocontablecajachica.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleasientocontablecajachica.setMes(detalleasientocontablecajachicaDataAccess.getMes(connexion,detalleasientocontablecajachica));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detalleasientocontablecajachica.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContableCajaChica.class)) {
				detalleasientocontablecajachica.setAsientoContableCajaChica(detalleasientocontablecajachicaDataAccess.getAsientoContableCajaChica(connexion,detalleasientocontablecajachica));
				AsientoContableCajaChicaLogic asientocontablecajachicaLogic= new AsientoContableCajaChicaLogic(connexion);
				asientocontablecajachicaLogic.deepLoad(detalleasientocontablecajachica.getAsientoContableCajaChica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGastoEmpresa.class)) {
				detalleasientocontablecajachica.setTipoGastoEmpresa(detalleasientocontablecajachicaDataAccess.getTipoGastoEmpresa(connexion,detalleasientocontablecajachica));
				TipoGastoEmpresaLogic tipogastoempresaLogic= new TipoGastoEmpresaLogic(connexion);
				tipogastoempresaLogic.deepLoad(detalleasientocontablecajachica.getTipoGastoEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				detalleasientocontablecajachica.setTransaccion(detalleasientocontablecajachicaDataAccess.getTransaccion(connexion,detalleasientocontablecajachica));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(detalleasientocontablecajachica.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				detalleasientocontablecajachica.setFactura(detalleasientocontablecajachicaDataAccess.getFactura(connexion,detalleasientocontablecajachica));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(detalleasientocontablecajachica.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detalleasientocontablecajachica.setAsientoContable(detalleasientocontablecajachicaDataAccess.getAsientoContable(connexion,detalleasientocontablecajachica));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(detalleasientocontablecajachica.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleasientocontablecajachica.setCentroCosto(detalleasientocontablecajachicaDataAccess.getCentroCosto(connexion,detalleasientocontablecajachica));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detalleasientocontablecajachica.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				detalleasientocontablecajachica.setTipoCambio(detalleasientocontablecajachicaDataAccess.getTipoCambio(connexion,detalleasientocontablecajachica));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(detalleasientocontablecajachica.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				detalleasientocontablecajachica.setTipoTransaccionModulo(detalleasientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,detalleasientocontablecajachica));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(detalleasientocontablecajachica.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
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
			detalleasientocontablecajachica.setEmpresa(detalleasientocontablecajachicaDataAccess.getEmpresa(connexion,detalleasientocontablecajachica));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleasientocontablecajachica.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setSucursal(detalleasientocontablecajachicaDataAccess.getSucursal(connexion,detalleasientocontablecajachica));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleasientocontablecajachica.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setModulo(detalleasientocontablecajachicaDataAccess.getModulo(connexion,detalleasientocontablecajachica));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(detalleasientocontablecajachica.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setEjercicio(detalleasientocontablecajachicaDataAccess.getEjercicio(connexion,detalleasientocontablecajachica));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleasientocontablecajachica.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setPeriodo(detalleasientocontablecajachicaDataAccess.getPeriodo(connexion,detalleasientocontablecajachica));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalleasientocontablecajachica.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setAnio(detalleasientocontablecajachicaDataAccess.getAnio(connexion,detalleasientocontablecajachica));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detalleasientocontablecajachica.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setMes(detalleasientocontablecajachicaDataAccess.getMes(connexion,detalleasientocontablecajachica));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detalleasientocontablecajachica.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContableCajaChica.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setAsientoContableCajaChica(detalleasientocontablecajachicaDataAccess.getAsientoContableCajaChica(connexion,detalleasientocontablecajachica));
			AsientoContableCajaChicaLogic asientocontablecajachicaLogic= new AsientoContableCajaChicaLogic(connexion);
			asientocontablecajachicaLogic.deepLoad(detalleasientocontablecajachica.getAsientoContableCajaChica(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGastoEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setTipoGastoEmpresa(detalleasientocontablecajachicaDataAccess.getTipoGastoEmpresa(connexion,detalleasientocontablecajachica));
			TipoGastoEmpresaLogic tipogastoempresaLogic= new TipoGastoEmpresaLogic(connexion);
			tipogastoempresaLogic.deepLoad(detalleasientocontablecajachica.getTipoGastoEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setTransaccion(detalleasientocontablecajachicaDataAccess.getTransaccion(connexion,detalleasientocontablecajachica));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(detalleasientocontablecajachica.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setFactura(detalleasientocontablecajachicaDataAccess.getFactura(connexion,detalleasientocontablecajachica));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(detalleasientocontablecajachica.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setAsientoContable(detalleasientocontablecajachicaDataAccess.getAsientoContable(connexion,detalleasientocontablecajachica));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(detalleasientocontablecajachica.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setCentroCosto(detalleasientocontablecajachicaDataAccess.getCentroCosto(connexion,detalleasientocontablecajachica));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detalleasientocontablecajachica.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setTipoCambio(detalleasientocontablecajachicaDataAccess.getTipoCambio(connexion,detalleasientocontablecajachica));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(detalleasientocontablecajachica.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontablecajachica.setTipoTransaccionModulo(detalleasientocontablecajachicaDataAccess.getTipoTransaccionModulo(connexion,detalleasientocontablecajachica));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(detalleasientocontablecajachica.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleAsientoContableCajaChica detalleasientocontablecajachica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleAsientoContableCajaChicaLogicAdditional.updateDetalleAsientoContableCajaChicaToSave(detalleasientocontablecajachica,this.arrDatoGeneral);
			
DetalleAsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachica, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleasientocontablecajachica.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleasientocontablecajachica.getSucursal(),connexion);

		ModuloDataAccess.save(detalleasientocontablecajachica.getModulo(),connexion);

		EjercicioDataAccess.save(detalleasientocontablecajachica.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalleasientocontablecajachica.getPeriodo(),connexion);

		AnioDataAccess.save(detalleasientocontablecajachica.getAnio(),connexion);

		MesDataAccess.save(detalleasientocontablecajachica.getMes(),connexion);

		AsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachica.getAsientoContableCajaChica(),connexion);

		TipoGastoEmpresaDataAccess.save(detalleasientocontablecajachica.getTipoGastoEmpresa(),connexion);

		TransaccionDataAccess.save(detalleasientocontablecajachica.getTransaccion(),connexion);

		FacturaDataAccess.save(detalleasientocontablecajachica.getFactura(),connexion);

		AsientoContableDataAccess.save(detalleasientocontablecajachica.getAsientoContable(),connexion);

		CentroCostoDataAccess.save(detalleasientocontablecajachica.getCentroCosto(),connexion);

		TipoCambioDataAccess.save(detalleasientocontablecajachica.getTipoCambio(),connexion);

		TipoTransaccionModuloDataAccess.save(detalleasientocontablecajachica.getTipoTransaccionModulo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleasientocontablecajachica.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleasientocontablecajachica.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detalleasientocontablecajachica.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleasientocontablecajachica.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleasientocontablecajachica.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleasientocontablecajachica.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleasientocontablecajachica.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContableCajaChica.class)) {
				AsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachica.getAsientoContableCajaChica(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGastoEmpresa.class)) {
				TipoGastoEmpresaDataAccess.save(detalleasientocontablecajachica.getTipoGastoEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(detalleasientocontablecajachica.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(detalleasientocontablecajachica.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detalleasientocontablecajachica.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleasientocontablecajachica.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(detalleasientocontablecajachica.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(detalleasientocontablecajachica.getTipoTransaccionModulo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleasientocontablecajachica.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleasientocontablecajachica.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleasientocontablecajachica.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleasientocontablecajachica.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(detalleasientocontablecajachica.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detalleasientocontablecajachica.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleasientocontablecajachica.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleasientocontablecajachica.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalleasientocontablecajachica.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleasientocontablecajachica.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detalleasientocontablecajachica.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleasientocontablecajachica.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detalleasientocontablecajachica.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleasientocontablecajachica.getMes(),isDeep,deepLoadType,clases);
				

		AsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachica.getAsientoContableCajaChica(),connexion);
		AsientoContableCajaChicaLogic asientocontablecajachicaLogic= new AsientoContableCajaChicaLogic(connexion);
		asientocontablecajachicaLogic.deepLoad(detalleasientocontablecajachica.getAsientoContableCajaChica(),isDeep,deepLoadType,clases);
				

		TipoGastoEmpresaDataAccess.save(detalleasientocontablecajachica.getTipoGastoEmpresa(),connexion);
		TipoGastoEmpresaLogic tipogastoempresaLogic= new TipoGastoEmpresaLogic(connexion);
		tipogastoempresaLogic.deepLoad(detalleasientocontablecajachica.getTipoGastoEmpresa(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(detalleasientocontablecajachica.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(detalleasientocontablecajachica.getTransaccion(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(detalleasientocontablecajachica.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(detalleasientocontablecajachica.getFactura(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(detalleasientocontablecajachica.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detalleasientocontablecajachica.getAsientoContable(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detalleasientocontablecajachica.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleasientocontablecajachica.getCentroCosto(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(detalleasientocontablecajachica.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(detalleasientocontablecajachica.getTipoCambio(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(detalleasientocontablecajachica.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(detalleasientocontablecajachica.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleasientocontablecajachica.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleasientocontablecajachica.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleasientocontablecajachica.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleasientocontablecajachica.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detalleasientocontablecajachica.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(detalleasientocontablecajachica.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleasientocontablecajachica.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleasientocontablecajachica.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleasientocontablecajachica.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalleasientocontablecajachica.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleasientocontablecajachica.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detalleasientocontablecajachica.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleasientocontablecajachica.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detalleasientocontablecajachica.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContableCajaChica.class)) {
				AsientoContableCajaChicaDataAccess.save(detalleasientocontablecajachica.getAsientoContableCajaChica(),connexion);
				AsientoContableCajaChicaLogic asientocontablecajachicaLogic= new AsientoContableCajaChicaLogic(connexion);
				asientocontablecajachicaLogic.deepSave(detalleasientocontablecajachica.getAsientoContableCajaChica(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGastoEmpresa.class)) {
				TipoGastoEmpresaDataAccess.save(detalleasientocontablecajachica.getTipoGastoEmpresa(),connexion);
				TipoGastoEmpresaLogic tipogastoempresaLogic= new TipoGastoEmpresaLogic(connexion);
				tipogastoempresaLogic.deepSave(detalleasientocontablecajachica.getTipoGastoEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(detalleasientocontablecajachica.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(detalleasientocontablecajachica.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(detalleasientocontablecajachica.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(detalleasientocontablecajachica.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detalleasientocontablecajachica.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(detalleasientocontablecajachica.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleasientocontablecajachica.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detalleasientocontablecajachica.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(detalleasientocontablecajachica.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(detalleasientocontablecajachica.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(detalleasientocontablecajachica.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(detalleasientocontablecajachica.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleAsientoContableCajaChica.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleasientocontablecajachica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(detalleasientocontablecajachica);
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
			this.deepLoad(this.detalleasientocontablecajachica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleAsientoContableCajaChica.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleasientocontablecajachicas!=null) {
				for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:detalleasientocontablecajachicas) {
					this.deepLoad(detalleasientocontablecajachica,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
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
			if(detalleasientocontablecajachicas!=null) {
				for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:detalleasientocontablecajachicas) {
					this.deepLoad(detalleasientocontablecajachica,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(detalleasientocontablecajachicas);
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
			this.getNewConnexionToDeep(DetalleAsientoContableCajaChica.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleasientocontablecajachica,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleAsientoContableCajaChica.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleasientocontablecajachicas!=null) {
				for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:detalleasientocontablecajachicas) {
					this.deepSave(detalleasientocontablecajachica,isDeep,deepLoadType,clases);
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
			if(detalleasientocontablecajachicas!=null) {
				for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:detalleasientocontablecajachicas) {
					this.deepSave(detalleasientocontablecajachica,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleAsientoContableCajaChicasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdAsientoContableCajaChicaWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable_caja_chica)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContableCajaChica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContableCajaChica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable_caja_chica,DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContableCajaChica);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContableCajaChica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdAsientoContableCajaChica(String sFinalQuery,Pagination pagination,Long id_asiento_contable_caja_chica)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContableCajaChica= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContableCajaChica.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable_caja_chica,DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContableCajaChica);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContableCajaChica","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleAsientoContableCajaChicaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleAsientoContableCajaChicaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdTipoGastoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_gasto_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGastoEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGastoEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_gasto_empresa,DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGastoEmpresa);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGasto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdTipoGasto(String sFinalQuery,Pagination pagination,Long id_tipo_gasto_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGastoEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGastoEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_gasto_empresa,DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGastoEmpresa);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGasto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContableCajaChicasFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			DetalleAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(this.detalleasientocontablecajachicas);
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
			if(DetalleAsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAsientoContableCajaChicaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleAsientoContableCajaChica detalleasientocontablecajachica,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleAsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIA) {
				if(detalleasientocontablecajachica.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAsientoContableCajaChicaDataAccess.TABLENAME, detalleasientocontablecajachica.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleAsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleAsientoContableCajaChicaLogic.registrarAuditoriaDetallesDetalleAsientoContableCajaChica(connexion,detalleasientocontablecajachica,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleasientocontablecajachica.getIsDeleted()) {
					/*if(!detalleasientocontablecajachica.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleAsientoContableCajaChicaDataAccess.TABLENAME, detalleasientocontablecajachica.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleAsientoContableCajaChicaLogic.registrarAuditoriaDetallesDetalleAsientoContableCajaChica(connexion,detalleasientocontablecajachica,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAsientoContableCajaChicaDataAccess.TABLENAME, detalleasientocontablecajachica.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleasientocontablecajachica.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAsientoContableCajaChicaDataAccess.TABLENAME, detalleasientocontablecajachica.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleAsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleAsientoContableCajaChicaLogic.registrarAuditoriaDetallesDetalleAsientoContableCajaChica(connexion,detalleasientocontablecajachica,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleAsientoContableCajaChica(Connexion connexion,DetalleAsientoContableCajaChica detalleasientocontablecajachica)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_empresa().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_empresa().toString();
				}
				if(detalleasientocontablecajachica.getid_empresa()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_sucursal().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_sucursal().toString();
				}
				if(detalleasientocontablecajachica.getid_sucursal()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_modulo().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_modulo()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_modulo().toString();
				}
				if(detalleasientocontablecajachica.getid_modulo()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_ejercicio().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_ejercicio().toString();
				}
				if(detalleasientocontablecajachica.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_periodo().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_periodo()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_periodo().toString();
				}
				if(detalleasientocontablecajachica.getid_periodo()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_anio().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_anio()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_anio().toString();
				}
				if(detalleasientocontablecajachica.getid_anio()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_mes().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_mes()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_mes().toString();
				}
				if(detalleasientocontablecajachica.getid_mes()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_asiento_contable_caja_chica().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_asiento_contable_caja_chica()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_asiento_contable_caja_chica()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_asiento_contable_caja_chica().toString();
				}
				if(detalleasientocontablecajachica.getid_asiento_contable_caja_chica()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_asiento_contable_caja_chica().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_tipo_gasto_empresa().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_tipo_gasto_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_tipo_gasto_empresa()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_tipo_gasto_empresa().toString();
				}
				if(detalleasientocontablecajachica.getid_tipo_gasto_empresa()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_tipo_gasto_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getfecha_emision().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getfecha_emision()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getfecha_emision().toString();
				}
				if(detalleasientocontablecajachica.getfecha_emision()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_transaccion().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_transaccion()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_transaccion().toString();
				}
				if(detalleasientocontablecajachica.getid_transaccion()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_factura().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_factura()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_factura().toString();
				}
				if(detalleasientocontablecajachica.getid_factura()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getes_proveedor().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getes_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getes_proveedor()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getes_proveedor().toString();
				}
				if(detalleasientocontablecajachica.getes_proveedor()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getes_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_asiento_contable().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_asiento_contable().toString();
				}
				if(detalleasientocontablecajachica.getid_asiento_contable()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getdetalle().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getdetalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getdetalle()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getdetalle();
				}
				if(detalleasientocontablecajachica.getdetalle()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getdetalle() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.DETALLE,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getvalor_bien_tarifa12().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_bien_tarifa12()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_bien_tarifa12()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_bien_tarifa12().toString();
				}
				if(detalleasientocontablecajachica.getvalor_bien_tarifa12()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getvalor_bien_tarifa12().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getvalor_servicio_tarifa12().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_servicio_tarifa12()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_servicio_tarifa12()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_servicio_tarifa12().toString();
				}
				if(detalleasientocontablecajachica.getvalor_servicio_tarifa12()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getvalor_servicio_tarifa12().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getporcentaje_iva().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getporcentaje_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getporcentaje_iva()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getporcentaje_iva().toString();
				}
				if(detalleasientocontablecajachica.getporcentaje_iva()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getporcentaje_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getvalor_bien_tarifa0().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_bien_tarifa0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_bien_tarifa0()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_bien_tarifa0().toString();
				}
				if(detalleasientocontablecajachica.getvalor_bien_tarifa0()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getvalor_bien_tarifa0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getvalor_servicio_tarifa0().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_servicio_tarifa0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_servicio_tarifa0()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_servicio_tarifa0().toString();
				}
				if(detalleasientocontablecajachica.getvalor_servicio_tarifa0()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getvalor_servicio_tarifa0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getvalor_iva().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_iva()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_iva().toString();
				}
				if(detalleasientocontablecajachica.getvalor_iva()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getvalor_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getvalor_bien_ice().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_bien_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_bien_ice()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_bien_ice().toString();
				}
				if(detalleasientocontablecajachica.getvalor_bien_ice()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getvalor_bien_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getvalor_servicio_ice().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_servicio_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_servicio_ice()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getvalor_servicio_ice().toString();
				}
				if(detalleasientocontablecajachica.getvalor_servicio_ice()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getvalor_servicio_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_centro_costo().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_centro_costo().toString();
				}
				if(detalleasientocontablecajachica.getid_centro_costo()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_tipo_cambio().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_tipo_cambio().toString();
				}
				if(detalleasientocontablecajachica.getid_tipo_cambio()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getid_tipo_transaccion_modulo().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(detalleasientocontablecajachica.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontablecajachica.getIsNew()||!detalleasientocontablecajachica.getfecha().equals(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getfecha()!=null)
				{
					strValorActual=detalleasientocontablecajachica.getDetalleAsientoContableCajaChicaOriginal().getfecha().toString();
				}
				if(detalleasientocontablecajachica.getfecha()!=null)
				{
					strValorNuevo=detalleasientocontablecajachica.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableCajaChicaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleAsientoContableCajaChicaRelacionesWithConnection(DetalleAsientoContableCajaChica detalleasientocontablecajachica) throws Exception {

		if(!detalleasientocontablecajachica.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleAsientoContableCajaChicaRelacionesBase(detalleasientocontablecajachica,true);
		}
	}

	public void saveDetalleAsientoContableCajaChicaRelaciones(DetalleAsientoContableCajaChica detalleasientocontablecajachica)throws Exception {

		if(!detalleasientocontablecajachica.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleAsientoContableCajaChicaRelacionesBase(detalleasientocontablecajachica,false);
		}
	}

	public void saveDetalleAsientoContableCajaChicaRelacionesBase(DetalleAsientoContableCajaChica detalleasientocontablecajachica,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleAsientoContableCajaChica-saveRelacionesWithConnection");}
	

			this.setDetalleAsientoContableCajaChica(detalleasientocontablecajachica);

			if(DetalleAsientoContableCajaChicaLogicAdditional.validarSaveRelaciones(detalleasientocontablecajachica,this)) {

				DetalleAsientoContableCajaChicaLogicAdditional.updateRelacionesToSave(detalleasientocontablecajachica,this);

				if((detalleasientocontablecajachica.getIsNew()||detalleasientocontablecajachica.getIsChanged())&&!detalleasientocontablecajachica.getIsDeleted()) {
					this.saveDetalleAsientoContableCajaChica();
					this.saveDetalleAsientoContableCajaChicaRelacionesDetalles();

				} else if(detalleasientocontablecajachica.getIsDeleted()) {
					this.saveDetalleAsientoContableCajaChicaRelacionesDetalles();
					this.saveDetalleAsientoContableCajaChica();
				}

				DetalleAsientoContableCajaChicaLogicAdditional.updateRelacionesToSaveAfter(detalleasientocontablecajachica,this);

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
	
	
	private void saveDetalleAsientoContableCajaChicaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleAsientoContableCajaChicaConstantesFunciones.getClassesForeignKeysOfDetalleAsientoContableCajaChica(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleAsientoContableCajaChicaConstantesFunciones.getClassesRelationshipsOfDetalleAsientoContableCajaChica(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
